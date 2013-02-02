
package modelServer;

import persistence.*;

import model.UserException;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;
import java.util.Vector;

import org.apache.xmlrpc.XmlRpcRequest;
import org.apache.xmlrpc.XmlRpcRequestProcessor;
import org.apache.xmlrpc.XmlRpcResponseProcessor;

public abstract class RemoteServerMaster implements TDObserver {

	protected static Hashtable<String,Object> createOKResult(AbstractPersistentRoot object, int depth, TDObserver tdObserver){
		Hashtable<String,Object> result = new Hashtable<String,Object>();
		result.put(common.RPCConstantsAndServices.OKOrNotOKResultFieldName, new Boolean(true));
		if(object == null)result.put(common.RPCConstantsAndServices.ResultFieldName, 
									 common.RPCConstantsAndServices.createProxiRepresentation(common.RPCConstantsAndServices.NullClassID, 
																							  common.RPCConstantsAndServices.NullObjectID,
																							  common.RPCConstantsAndServices.NullIconInfo,
																							  common.RPCConstantsAndServices.NullLeafInfo,
																							  common.RPCConstantsAndServices.NullObjectToString));
		else
			try {
				result.put(common.RPCConstantsAndServices.ResultFieldName, object.toHashtable(depth, 0, false, tdObserver));
				result.put(common.RPCConstantsAndServices.RootFieldName, ((PersistentProxi)object).createProxiInformation(false));
			} catch (PersistenceException e) {
				return createExceptionResult(e);
			}
		return result;
	}

	protected static Hashtable<String,Object> createOKResult(Hashtable<String,Object> contents){
		Hashtable<String,Object> result = new Hashtable<String,Object>();
		result.put(common.RPCConstantsAndServices.OKOrNotOKResultFieldName, new Boolean(true));
		result.put(common.RPCConstantsAndServices.ResultFieldName, contents);
		return result;
	}
	protected static Hashtable<String,Object> createOKResult(Vector<?> list){
		Hashtable<String,Object> result = new Hashtable<String,Object>();
		result.put(common.RPCConstantsAndServices.OKOrNotOKResultFieldName, new Boolean(true));
		result.put(common.RPCConstantsAndServices.ResultListFieldName, list);
		return result;
	}
	protected static Hashtable<String,Object> createOKResult(long integer){
		Hashtable<String,Object> result = new Hashtable<String,Object>();
		result.put(common.RPCConstantsAndServices.OKOrNotOKResultFieldName, new Boolean(true));
		result.put(common.RPCConstantsAndServices.ResultFieldName, new Long(integer).toString());
		return result;
	}
	protected static Hashtable<String,Object> createOKResult(common.Fraction fraction){
		Hashtable<String,Object> result = new Hashtable<String,Object>();
		result.put(common.RPCConstantsAndServices.OKOrNotOKResultFieldName, new Boolean(true));
		result.put(common.RPCConstantsAndServices.ResultFieldName, fraction.toString());
		return result;
	}
	
	private Hashtable<String,Object> createOKResult(boolean b) {
		Hashtable<String,Object> result = new Hashtable<String,Object>();
		result.put(common.RPCConstantsAndServices.OKOrNotOKResultFieldName, new Boolean(true));
		result.put(common.RPCConstantsAndServices.ResultFieldName, new Boolean(b));
		return result;
	}
	protected static Hashtable<String,Object> createOKResult(java.util.Date date){
		Hashtable<String,Object> result = new Hashtable<String,Object>();
		result.put(common.RPCConstantsAndServices.OKOrNotOKResultFieldName, new Boolean(true));
		result.put(common.RPCConstantsAndServices.ResultFieldName, date);
		return result;
	}
	protected static Hashtable<String,Object> createOKResult(String string){
		Hashtable<String,Object> result = new Hashtable<String,Object>();
		result.put(common.RPCConstantsAndServices.OKOrNotOKResultFieldName, new Boolean(true));
		result.put(common.RPCConstantsAndServices.ResultFieldName, string);
		return result;
	}
	protected static Hashtable<String,Object> createOKResult(){
		Hashtable<String,Object> result = new Hashtable<String,Object>();
		result.put(common.RPCConstantsAndServices.OKOrNotOKResultFieldName, new Boolean(true));
		return result;
	}
	protected static Hashtable<String,Object> createExceptionResult(PersistenceException exception){
		Hashtable<String,Object> result = new Hashtable<String,Object>();
		result.put(common.RPCConstantsAndServices.OKOrNotOKResultFieldName, new Boolean(false));
		result.put(common.RPCConstantsAndServices.ErrorNumberFieldName, common.RPCConstantsAndServices.PersistenceExceptionNumber);
		result.put(common.RPCConstantsAndServices.ExceptionMessageFieldName, exception.getMessage());
		result.put(common.RPCConstantsAndServices.ExceptionNumberFieldName, new Integer(exception.getErrorNumber()));
		return result;
	}
	protected static Hashtable<String,Object> createExceptionResult(UserException exception, TDObserver tdObserver){
		Hashtable<String,Object> result = new Hashtable<String,Object>();
		result.put(common.RPCConstantsAndServices.OKOrNotOKResultFieldName, new Boolean(false));
		result.put(common.RPCConstantsAndServices.ErrorNumberFieldName, new Integer((int)exception.getClassId()));
		try {
			result.put(common.RPCConstantsAndServices.ResultFieldName, exception.toHashtable(null, 1, 0, false, true, tdObserver));
		}catch(PersistenceException pe){
			return createExceptionResult(pe);
		}
		return result;
	}

	protected Date lastUsedDate;
	private String connectionName;
	private String userName;

	

	public RemoteServerMaster(String connectionName, String userName){
		this.connectionName = connectionName;
		this.userName = userName;
		this.lastUsedDate = new Date();
		this.tdObserver = new java.util.Hashtable<persistence.AbstractPersistentRoot, java.util.Hashtable<String, Object>>();
	}

	private java.util.Hashtable<persistence.AbstractPersistentRoot, java.util.Hashtable<String, Object>> tdObserver;

	@Override
	public void updateTransientDerived(AbstractPersistentRoot objectIndex, String fieldIndex, Object object) throws PersistenceException {
		if (object == null || objectIndex == null || fieldIndex == null) return;
		java.util.Hashtable<String, Object> objectTable = this.tdObserver.get(objectIndex);
		if (objectTable == null) {
			objectTable = new java.util.Hashtable<String, Object>();
			this.tdObserver.put(objectIndex, objectTable);
		}
		objectTable.put(fieldIndex, object);
	}

	abstract protected Remote getServer();

	public String toString(){
		return "Connection: " +
				this.connectionName +
				" ;  Server class: " +
				this.getServer().getClassId() +
				" Server object: " +
				this.getServer().getId() +
				" User: " +
				this.getUserName();
	}

	protected String getConnectionName(){
		return this.connectionName;
	}
	protected String getUserName(){
		return this.userName;
	}
	protected long getServerId(){
		return this.getServer().getId();
	}
	protected long getServerClassId(){
		return this.getServer().getClassId();
	}
	protected boolean isNotUsed(Date date){
		if (date.getTime() - this.lastUsedDate.getTime() > ConnectionServer.RefreshInterval * 3)return true;
		return false;
	}
	public synchronized Hashtable<String,Object> hasChanged(){
		try{
			boolean result = this.getServer().hasChanged();
			return createOKResult(result);
		}catch(PersistenceException pe){
			return createExceptionResult(pe);
		}
	}
	@SuppressWarnings("unchecked")
	public synchronized Hashtable<String,Object> getObject(int depth, Vector<String> context, boolean forGUI, String proxiInfo){
		try {
			common.ProxiInformation proxiInformation = common.RPCConstantsAndServices.createProxiInformation(proxiInfo);
			PersistentProxi proxi = PersistentProxi.createProxi(proxiInformation);
			Hashtable<String, Object> result = proxi.toHashtable(depth, 0, forGUI, this);
			for (String currentContextInfo : context) {
				common.ProxiInformation currentProxiInformation = common.RPCConstantsAndServices.createProxiInformation(currentContextInfo);
				PersistentProxi currentProxi = PersistentProxi.createProxi(currentProxiInformation);
				currentProxi.toHashtable(result, new Integer(currentProxiInformation.getToString()), 0, forGUI, true, this);
			}
			if (common.RPCConstantsAndServices.test) System.out.println("Show: " + ((Hashtable<String,Object>)result.get(common.RPCConstantsAndServices.createHashtableKey(proxiInformation.getClassId(), proxiInformation.getObjectId()))).get(common.RPCConstantsAndServices.RPCToStringFieldName));
			if (result == null) return createExceptionResult(new PersistenceException(common.RPCConstantsAndServices.ObjectNotAvailableErrorMessage, common.RPCConstantsAndServices.ObjectNotAvailableErrorNo));
			this.removeNullEntries(result);
			return createOKResult(result);
		}catch(PersistenceException pe){
			return createExceptionResult(pe);
		}
	}
	
	private void removeNullEntries(Hashtable<String, Object> table) {
		java.util.Iterator<String> keys = table.keySet().iterator();
		while (keys.hasNext()){
			String current = keys.next();
			if (table.get(current) == null){
				System.out.println("Null entry removed: " + current);
				keys.remove();
			}
		}
	}
	
	protected XmlRpcRequest getRequest(byte[] request, XmlRpcRequestProcessor requestProcessor) throws PersistenceException{
		try {
			
			//remove salt
			int saltLength = common.CryptoConstants.SaltLength;
			ByteArrayInputStream input = new ByteArrayInputStream(request,saltLength,request.length - saltLength);
			return requestProcessor.processRequest(input);
		} catch (Exception e) {
			throw new PersistenceException(e.getMessage(),0);
		} 		
	}
	@SuppressWarnings("unchecked")
	protected Object invoke(XmlRpcRequest request) throws PersistenceException{
		try {
			String methodName = request.getMethodName();
			Vector<Object> parameters = request.getParameters();
			Class<?>[] argClasses = null;
			Object[] argValues = null;
			if (parameters != null) {
				argClasses = new Class[parameters.size()];
				argValues = new Object[parameters.size()];
				for (int i = 0; i < parameters.size(); i++) {
					argValues[i] = parameters.elementAt(i);
					if (argValues[i] instanceof Integer) {
						argClasses[i] = Integer.TYPE;
					} else if (argValues[i] instanceof Double) {
						argClasses[i] = Double.TYPE;
					} else if (argValues[i] instanceof Boolean) {
						argClasses[i] = Boolean.TYPE;
					} else {
						argClasses[i] = argValues[i].getClass();
					}
				}
			}
			// invoke
			Method method = this.getClass().getMethod(methodName, argClasses);
			if (method.getDeclaringClass() == Object.class) {
				throw new PersistenceException("Invoker can't call methods defined in java.lang.Object",0);
			}
			return method.invoke(this, argValues);
		} catch (Exception e) {
			throw new PersistenceException(e.getMessage(),0);
		} 		

	}
	private java.security.SecureRandom random = new java.security.SecureRandom();
	protected byte[] getResponse(Object invokeResult, XmlRpcRequestProcessor requestProcessor, XmlRpcResponseProcessor responseProcessor) throws PersistenceException{
		try {
			byte[] result = responseProcessor.processResponse(invokeResult, requestProcessor.getEncoding());
			int saltLength = common.CryptoConstants.SaltLength;
			byte[] salt = new byte[saltLength];
			this.random.nextBytes(salt);
			byte[] finalResult = new byte [salt.length + result.length];
			for (int i = 0; i < saltLength; i++)finalResult[i] = salt[i];
			for (int i = saltLength; i < finalResult.length; i++)finalResult[i] = result[i - saltLength];
			
			if (common.RPCConstantsAndServices.test) System.out.println("Sent: " + finalResult.length/1000 + "," + (finalResult.length % 1000)/100 + " KByte");
			return finalResult;
		} catch (Exception e) {
			throw new PersistenceException(e.getMessage(),0);
		} 		
	}
	public synchronized byte[] execute(byte[] command) throws PersistenceException {
			XmlRpcResponseProcessor responseProcessor = new XmlRpcResponseProcessor();
			XmlRpcRequestProcessor requestProcessor = new XmlRpcRequestProcessor();
			XmlRpcRequest request = this.getRequest(command, requestProcessor);
			Object invokeResult = this.invoke(request);
			this.lastUsedDate = new Date();
			return this.getResponse(invokeResult, requestProcessor, responseProcessor);
	}

}