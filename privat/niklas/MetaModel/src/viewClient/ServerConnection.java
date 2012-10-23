package viewClient;

import view.*;
import java.net.MalformedURLException;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;
import org.apache.xmlrpc.XmlRpcException;

public class ServerConnection extends ConnectionMaster {

	public ServerConnection (String url, ExceptionAndEventHandler handler, ClientReporter reporter) throws MalformedURLException {
		super(url, handler, reporter);
	}

	public ServerView getServerView(){
		return (ServerView)super.getServer();
	}

    public synchronized void createAspect(String name) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(name);
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "createAspect", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                throw new Error("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    public synchronized void createSumType(java.util.Vector<AbstractMetaTypeView> types) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            java.util.Vector<String> typesTrnsprt = new java.util.Vector<String>();
            java.util.Iterator<AbstractMetaTypeView> typesItrtr = types.iterator();
            while (typesItrtr.hasNext()){ 
                AbstractMetaTypeView current = typesItrtr.next();
                typesTrnsprt.add(((view.objects.ViewProxi)current).createProxiInformation());
            }
            parameters.add(typesTrnsprt);
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "createSumType", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                throw new Error("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    public synchronized void createType(String name, MetaAspectView aspect) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(name);
            parameters.add(((view.objects.ViewProxi)aspect).createProxiInformation());
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "createType", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                throw new Error("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    public synchronized void addSupertype(MetaTypeView type, MetaTypeView superType) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)type).createProxiInformation());
            parameters.add(((view.objects.ViewProxi)superType).createProxiInformation());
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "addSupertype", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                throw new Error("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    

}
