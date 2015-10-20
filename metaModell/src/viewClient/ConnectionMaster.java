package viewClient;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import java.net.MalformedURLException;
import java.util.Hashtable;
import java.util.Vector;

import org.apache.xmlrpc.XmlRpc;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.XmlWriter;


import view.objects.ViewProxi;
import view.*;


public abstract class ConnectionMaster extends org.apache.xmlrpc.XmlRpcClient {

	public static final int Port = common.RPCConstantsAndServices.ServerPort;
	public static final int RefreshInterval = common.RPCConstantsAndServices.ClientRefreshInterval;
	public static final String ConnectionHandlerName = common.RPCConstantsAndServices.ConnectionHandlerName;

	public static final String ConnectCommand = "connect";
	public static final String ForkCommand = "fork";
	public static final String HasChangedCommand = "hasChanged";
	public static final String GetObjectCommand = "getObject";

	private static final String ExecuteCommand = ".execute";


	protected String connectionName = ConnectionHandlerName;
	private String url;
	private Remote server;
	private Refresher refresher;
	private ExceptionAndEventHandler handler;
	private ClientReporter reporter;
	private boolean connected;
	private String user;

	private java.security.SecureRandom random;
	
	

	public ConnectionMaster(String url, ExceptionAndEventHandler handler, ClientReporter reporter) throws MalformedURLException {
		super(url + ":" + new Integer(Port).toString());
		this.random = new java.security.SecureRandom();
		this.url = url;
		this.handler = handler;
		if (reporter != null) this.reporter = reporter;
		else this.reporter = new NoClientReporter();
		this.connected = false;
	}
	public synchronized void setHandler(ExceptionAndEventHandler handler){
		this.handler = handler;
	}
	public void setServer(Remote remote) {
		this.remote = remote;
	}
	
	public ExceptionAndEventHandler getHandler(){
		return this.handler;
	}
	public ClientReporter getReporter(){
		return this.reporter;
	}
	public void reportLostClient(){
		this.reporter.reportLostClient(this);
	}
	public String toString(){
		return "Connection: " +
				this.connectionName +
				" ;  Server class: " +
				this.getServer().getClassId() +
				" Server object: " +
				this.getServer().getId() +
				" User: " +
				this.user;

	}
	
	ByteArrayOutputStream buffer;
	XmlWriter writer; 
	private byte[] callToByteArray(String method, Vector<Object> params) throws UnsupportedEncodingException, IOException, XmlRpcException, ModelException{
		if (this.buffer == null)this.buffer = new ByteArrayOutputStream();
		else this.buffer.reset();
		//produce and insert salt
		int saltLength = common.CryptoConstants.SaltLength;
		byte[] salt = new byte[saltLength];
		this.random.nextBytes(salt);
		this.buffer.write(salt, 0, saltLength);
		if (this.writer == null) this.writer = new XmlWriter(buffer,XmlWriter.ISO8859_1);
		this.writer.startElement("methodCall");
		this.writer.startElement("methodName");
		this.writer.write(method);
		this.writer.endElement("methodName");
		this.writer.startElement("params");
		int l = params.size();
		for (int i = 0; i < l; i++) {
			this.writer.startElement("param");
			this.writer.writeObject(params.elementAt(i));
			this.writer.endElement("param");
		}
		this.writer.endElement("params");
		this.writer.endElement("methodCall");
		this.writer.flush();
		byte[] result = this.buffer.toByteArray();
		
		return result;
	}
	XmlRpc responseParser;
	Hashtable<Object,Object> result = null;
	private Hashtable<Object,Object> resultToObject(Object invokeResult) throws Exception{
		if (this.responseParser == null) this.responseParser = new XmlRpc(){
			@SuppressWarnings("unchecked")
			protected void objectParsed(Object what) {
				result = (Hashtable<Object,Object>) what;
			}
		};
		if (invokeResult instanceof String)throw new ConnectionNotFoundException((String) invokeResult,0);
		byte[] invokeResultAsByteArray = (byte[]) invokeResult;
		
		int saltLength = common.CryptoConstants.SaltLength;
		InputStream resultStream = new ByteArrayInputStream(invokeResultAsByteArray,saltLength,invokeResultAsByteArray.length - saltLength);
		responseParser.parse(resultStream);
		return this.result;
	}
	
	public synchronized Hashtable<Object,Object> execute(String connection, String method, Vector<Object> params) throws ModelException, UnsupportedEncodingException, IOException, XmlRpcException {
		byte[] callAsByteArray = this.callToByteArray(method, params);
		params = new Vector<Object>();
		params.add(connection);
		params.add(callAsByteArray);
		try {
			Object invokeResult = super.execute(ConnectionHandlerName + ExecuteCommand, params);
			return this.resultToObject(invokeResult);
		} catch (ModelException me){
			throw me;
		} catch (Exception e) {
			throw new ModelException(e.getMessage(),0);
		}
	}
	
	public synchronized ConnectionMaster fork(ConnectionMaster master, Remote remote) throws ModelException {
		if (master.connected){
			this.url = master.url;
			String oldconnection = master.connectionName;
			Vector<Object> parameters = new Vector<Object>();
			parameters.add(master.user);
			parameters.add(oldconnection);
			parameters.add(new Long(remote.getId()).toString());
			parameters.add(new Long(remote.getClassId()).toString());
			parameters.add(new java.util.Date());
			String connectionResult;
			try {
				
				Hashtable<Object,Object> table = this.execute(ConnectionHandlerName, ForkCommand, parameters);
		        if(((Boolean)table.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue() == true) {
					connectionResult = (String) result.get(common.RPCConstantsAndServices.ResultFieldName);
		        }else{
		            throw new ModelException((String)table.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), 
		            						 ((Integer)table.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
		        }
			} catch (Exception e) {
				ModelException me = new ModelException(e.getMessage(), 0);
				this.handler.handleException(me);
				throw me;
			}
			
			this.processConnectionResult(connectionResult, master.user);
			return this;
		}
		this.handler.handleException(new ModelException("Connect master first!",0));
		return null;
	}
	public synchronized void connect(String user, String password, boolean createUserIfNotPresent) throws ModelException {
		if (this.server == null && !this.connected){
			Vector<Object> parameters = new Vector<Object>();
			parameters.add(user);
			parameters.add(password);
			parameters.add(new Boolean(createUserIfNotPresent));
			javax.crypto.SecretKey communicationKey = null;
			
			if (communicationKey == null)parameters.add(new byte[0]);
			parameters.add(new java.util.Date());
			parameters.add(common.RPCConstantsAndServices.CurrentVersion);
			String connectionResult;
			try {
				Hashtable<Object,Object> table = this.execute(ConnectionHandlerName, ConnectCommand, parameters);
		        if(((Boolean)table.get("?OK?")).booleanValue() == true) {
					connectionResult = (String) result.get("?Result?");
		        }else{
		            throw new ModelException((String)table.get("?Message?"), ((Integer)table.get("?ExceptionNumber?")).intValue());
		        }
				
				this.processConnectionResult(connectionResult, user);
			} catch (Exception e) {
				throw new ModelException(e.getMessage(), 0);
			}
		}else {
			this.handler.handleOKMessage("Already connected to server: " + this.connectionName);
		}
	}
	private void processConnectionResult(String result, String user) throws ModelException{
		try {
			String connectionName = result.substring(0,result.indexOf(common.RPCConstantsAndServices.ConnectSeparator));
			this.connectionName = connectionName;
			result = result.substring(result.indexOf(common.RPCConstantsAndServices.ConnectSeparator) + 1, result.length());
			common.ProxiInformation info = common.RPCConstantsAndServices.createProxiInformation(result);
			this.server = (Remote)ViewProxi.createProxi(info.getObjectId(), info.getClassId(), this.getHandler());
			((view.objects.ViewRoot)this.server).setToString(info.getToString());
			this.refresher = new Refresher(this);
			this.connected = true;
			new Thread(this.refresher).start();
			this.user = user;
			this.handler.handleOKMessage("Client connected to server: " + this.connectionName + " | " + info.getObjectId());
			this.reporter.reportNewClient(this);
		}catch (Exception e){
			throw new ModelException(result,0);
		}
	}

	private Remote remote;

	protected Remote getServer() {
		try {
			if (this.remote == null) {
				this.remote =  (Remote)ViewProxi.createProxi(this.server.getId(), this.server.getClassId(), this.getHandler());
				((view.objects.ViewRoot) this.remote).setToString(this.server.toString());
			}
			return this.remote;
		} catch (ModelException e) {
			this.handler.handleException(e);
			return null;
		}
	}
	protected synchronized boolean refresh() {
		try {
			Boolean refreshNecessary;
			Hashtable<Object,Object> result = (Hashtable<Object,Object>)this.execute(this.connectionName, HasChangedCommand, new Vector<Object>());
            if(!((Boolean)result.get("?OK?")).booleanValue()){
                if (((Integer)result.get("?ErrorNumber?")).intValue() == 0)
                    throw new ModelException((String)result.get("?Message?"), ((Integer)result.get("?ExceptionNumber?")).intValue());
                throw new Error("Fatal error (unknown exception code:" + (Integer)result.get("?ErrorNumber?") + ")");
            }else{
            	refreshNecessary = (Boolean) result.get("?Result?");
            }
			if (refreshNecessary.booleanValue()){
				this.server = (Remote)ViewProxi.createProxi(this.server.getId(), this.server.getClassId(), this.getHandler());
				this.handler.handleRefresh();
			}
			return refreshNecessary;
		} catch (org.apache.xmlrpc.XmlRpcException xe){
			this.handler.handleException(new ModelException(xe.getMessage(), 0));
			return false;
		}catch (IOException ioe){
			this.handler.handleException(new ModelException(ioe.getMessage(), 0));
			return false;
		}catch (ModelException me){
			this.handler.handleException(me);
			return false;
		}
	}
	public void setEagerRefresh(){
		this.refresher.setEagerRefresh();
	}
	public void setWeb(){
		this.refresher.setWebRefresher();
	}
	public void refresherStop(){
		this.refresher.stop();
	}
	public synchronized Hashtable<Object,Object> getObject(int depth, java.util.Vector<view.objects.ViewRoot> context, boolean forTreeView, ViewProxi proxi) throws ModelException{
		try {
			Vector<Object> params = new Vector<Object>();
			params.add(new Integer(depth));
			Vector<String> contextInfos = new Vector<String>();
			for (view.objects.ViewRoot current : context) {
				contextInfos.add(((view.objects.ViewProxi)current).createProxiInformation());
			}
			params.add(contextInfos);
			params.add(forTreeView);
			params.add(proxi.createProxiInformation());
			return (Hashtable<Object,Object>)this.execute(this.connectionName, GetObjectCommand, params);
		} catch (ModelException me){
			throw me;
		} catch (Exception xe){
			ModelException exception = new ModelException(xe.getMessage(), 0);
			this.handler.handleException(exception);
			throw exception;
		}
	}

	public String getUrlString() {
		return this.url;
	}
}


class Refresher implements Runnable {

	private ConnectionMaster client;
	private boolean stopped = false;
	private long refreshInterval;
	private boolean eagerRequestWaiting;
	private boolean longLife;
	private static final long EagerMinimalRefreshIntervalLocal = 1500;
	private static final long EagerMinimalRefreshIntervalWeb = 2500;
	private static final long StoppedRefreshInterval = 5000;

	private long eagerMinimalRefreshInterval;
	
	public Refresher(ConnectionMaster client){
		this.client = client;
		this.refreshInterval = ConnectionMaster.RefreshInterval; 
		this.eagerRequestWaiting = false;
		eagerMinimalRefreshInterval = EagerMinimalRefreshIntervalLocal;
		this.longLife = true;
	}
	public void setWebRefresher(){
		eagerMinimalRefreshInterval = EagerMinimalRefreshIntervalWeb;
		this.longLife = false;
	}
	public void setStandardRefresh() {
		if(this.refreshInterval > ConnectionMaster.RefreshInterval)this.refreshInterval = ConnectionMaster.RefreshInterval;
	}
	protected void stop(){
		this.stopped = true;
	}
	protected void setEagerRefresh(){
		if (this.stopped){
			new Thread(new Runnable(){
				public void run() {
					try {
						synchronized(Refresher.this){Refresher.this.wait(StoppedRefreshInterval);}
					} catch (InterruptedException e) {
						return;
					}
					Refresher.this.client.refresh();
				}
			}).start();
		}else{
			new Thread(new Runnable(){
				public void run() {
					synchronized(Refresher.this){
						if(!Refresher.this.eagerRequestWaiting){
							Refresher.this.eagerRequestWaiting = true;
							Refresher.this.refreshInterval = eagerMinimalRefreshInterval;
							try{
								Refresher.this.wait(eagerMinimalRefreshInterval);
							}catch (InterruptedException ie){
								return;
							}
							Refresher.this.notify();
							Refresher.this.eagerRequestWaiting = false;
						}
					}
				}
			}).start();
		}
	}

	public void run(){
		while(!this.stopped){
			synchronized(this){
				try {
					this.wait(this.refreshInterval);
					if (!this.longLife || this.refreshInterval < ConnectionMaster.RefreshInterval) this.refreshInterval = this.refreshInterval * 5 / 3;
					if(this.refreshInterval > ConnectionMaster.RefreshInterval * 5) this.stop();
				}catch (InterruptedException ie){
					return;
				}
				if (!this.stopped) {
					this.client.refresh();
				}
			}
		}
		this.client.reportLostClient();
	}
}
class NoClientReporter implements ClientReporter {
	public void reportLostClient(ConnectionMaster master) {
	}
	public void reportNewClient(ConnectionMaster master) {
	}
}