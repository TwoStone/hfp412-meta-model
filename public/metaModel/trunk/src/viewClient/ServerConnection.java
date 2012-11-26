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

    public synchronized void addSubType(MAtomicTypeView superType, MAtomicTypeView subType) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)superType).createProxiInformation());
            parameters.add(((view.objects.ViewProxi)subType).createProxiInformation());
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "addSubType", parameters);
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
    
    public synchronized void createAssociationFrom(MType source, String name, MType target) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)source).createProxiInformation());
            parameters.add(name);
            parameters.add(((view.objects.ViewProxi)target).createProxiInformation());
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "createAssociationFrom", parameters);
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
    
    public synchronized void createAssociationTo(MType target, String name, MType source) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)target).createProxiInformation());
            parameters.add(name);
            parameters.add(((view.objects.ViewProxi)source).createProxiInformation());
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "createAssociationTo", parameters);
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
    
    public synchronized void createAspect(AspectManagerView aspectManager, String aspectName) throws ModelException, DoubleDefinitionException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)aspectManager).createProxiInformation());
            parameters.add(aspectName);
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "createAspect", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -124)
                    throw DoubleDefinitionException.fromHashtableToDoubleDefinitionException((Hashtable)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new Error("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    public synchronized void createAtomicType(MAspectView parent, String typeName, MBooleanView singletonType, MBooleanView abstractType) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)parent).createProxiInformation());
            parameters.add(typeName);
            parameters.add(((view.objects.ViewProxi)singletonType).createProxiInformation());
            parameters.add(((view.objects.ViewProxi)abstractType).createProxiInformation());
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "createAtomicType", parameters);
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
    
    public synchronized void createHierarchy(String name) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(name);
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "createHierarchy", parameters);
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
    
    public synchronized void createAssociation(AssociationManagerView manager, String name, MType source, MType target) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)manager).createProxiInformation());
            parameters.add(name);
            parameters.add(((view.objects.ViewProxi)source).createProxiInformation());
            parameters.add(((view.objects.ViewProxi)target).createProxiInformation());
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "createAssociation", parameters);
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
    
    public synchronized void createSubType(MAtomicTypeView superType, String typeName, MBooleanView singletonType, MBooleanView abstractType) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)superType).createProxiInformation());
            parameters.add(typeName);
            parameters.add(((view.objects.ViewProxi)singletonType).createProxiInformation());
            parameters.add(((view.objects.ViewProxi)abstractType).createProxiInformation());
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "createSubType", parameters);
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
    
    public synchronized void addToHierarchy(MAssociationView association, MAHierarchyView theHierarchy) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)association).createProxiInformation());
            parameters.add(((view.objects.ViewProxi)theHierarchy).createProxiInformation());
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "addToHierarchy", parameters);
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
    
    public synchronized void addAssociations(MAHierarchyView theHierarchy, MAssociationView association) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)theHierarchy).createProxiInformation());
            parameters.add(((view.objects.ViewProxi)association).createProxiInformation());
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "addAssociations", parameters);
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
