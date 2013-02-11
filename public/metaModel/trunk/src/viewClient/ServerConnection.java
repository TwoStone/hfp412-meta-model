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

    public synchronized void createHierarchy(AssociationManagerView manager, AssociationView a, String name) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)manager).createProxiInformation());
            parameters.add(((view.objects.ViewProxi)a).createProxiInformation());
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
    
    public synchronized void createHierarchy(AssociationView a, String name) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)a).createProxiInformation());
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
    
    public synchronized void createCompUnitType(UnitTypeManagerView manager, String name) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)manager).createProxiInformation());
            parameters.add(name);
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "createCompUnitType", parameters);
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
    
    @SuppressWarnings("unchecked")
    public synchronized AbsQuantityView mul(AbsQuantityView factor1, AbsQuantityView factor2) throws ModelException, NotComputableException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)factor1).createProxiInformation());
            parameters.add(((view.objects.ViewProxi)factor2).createProxiInformation());
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "mul", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
                    throw NotComputableException.fromHashtableToNotComputableException((Hashtable)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new Error("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
            }else{
                java.util.Hashtable<String, Object> allResults = (java.util.Hashtable<String, Object>) success.get(common.RPCConstantsAndServices.ResultFieldName);
                view.objects.ViewProxi.resolveReferences(allResults, this.getHandler());
                common.ProxiInformation proxiInformation = common.RPCConstantsAndServices.createProxiInformation((String) success.get(common.RPCConstantsAndServices.RootFieldName));
                AbsQuantityView result = (AbsQuantityView) view.objects.ViewProxi.createProxi(proxiInformation, this.getHandler());
                if (result != null) ((view.objects.ViewRoot)result).setToString(proxiInformation.getToString());
                view.objects.ViewObject root = (view.objects.ViewObject) allResults.get(proxiInformation.getHashKey());
                if (root != null) ((view.objects.ViewProxi)result).setObject(root);
                return result;
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    public synchronized void createLink(LinkManagerView link, AssociationView type, MObjectView source, MObjectView target) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)link).createProxiInformation());
            parameters.add(((view.objects.ViewProxi)type).createProxiInformation());
            parameters.add(((view.objects.ViewProxi)source).createProxiInformation());
            parameters.add(((view.objects.ViewProxi)target).createProxiInformation());
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "createLink", parameters);
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
    
    public synchronized void addFp(OperationView op, FormalParameterView fp) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)op).createProxiInformation());
            parameters.add(((view.objects.ViewProxi)fp).createProxiInformation());
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "addFp", parameters);
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
    
    public synchronized void addToHierarchy(AssociationView association, HierarchyView theHierarchy) throws ModelException{
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
    
    public synchronized void createFp(OperationManagerView operationManager, String name, MTypeView ofType) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)operationManager).createProxiInformation());
            parameters.add(name);
            parameters.add(((view.objects.ViewProxi)ofType).createProxiInformation());
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "createFp", parameters);
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
    
    public synchronized void createCompUnit(CompUnitTypeView compUnitType, String name) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)compUnitType).createProxiInformation());
            parameters.add(name);
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "createCompUnit", parameters);
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
    
    public synchronized void createStaticMessage(MessageManagerView manager, OperationView type, String name, MObjectView target, java.util.Vector<ActualParameterView> ap) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)manager).createProxiInformation());
            parameters.add(((view.objects.ViewProxi)type).createProxiInformation());
            parameters.add(name);
            parameters.add(((view.objects.ViewProxi)target).createProxiInformation());
            java.util.Vector<String> apTrnsprt = new java.util.Vector<String>();
            java.util.Iterator<ActualParameterView> apItrtr = ap.iterator();
            while (apItrtr.hasNext()){ 
                ActualParameterView current = apItrtr.next();
                apTrnsprt.add(((view.objects.ViewProxi)current).createProxiInformation());
            }
            parameters.add(apTrnsprt);
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "createStaticMessage", parameters);
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
    
    public synchronized void replaceType(MObjectView object, MAtomicTypeView oldType, MAtomicTypeView newType) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)object).createProxiInformation());
            parameters.add(((view.objects.ViewProxi)oldType).createProxiInformation());
            parameters.add(((view.objects.ViewProxi)newType).createProxiInformation());
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "replaceType", parameters);
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
    
    public synchronized void createAtomicSubType(MAtomicTypeView superType, String typeName, String singletonType, String abstractType) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)superType).createProxiInformation());
            parameters.add(typeName);
            parameters.add(singletonType);
            parameters.add(abstractType);
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "createAtomicSubType", parameters);
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
    
    @SuppressWarnings("unchecked")
    public synchronized AbsQuantityView div(AbsQuantityView dividend, AbsQuantityView divisor) throws ModelException, NotComputableException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)dividend).createProxiInformation());
            parameters.add(((view.objects.ViewProxi)divisor).createProxiInformation());
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "div", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
                    throw NotComputableException.fromHashtableToNotComputableException((Hashtable)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new Error("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
            }else{
                java.util.Hashtable<String, Object> allResults = (java.util.Hashtable<String, Object>) success.get(common.RPCConstantsAndServices.ResultFieldName);
                view.objects.ViewProxi.resolveReferences(allResults, this.getHandler());
                common.ProxiInformation proxiInformation = common.RPCConstantsAndServices.createProxiInformation((String) success.get(common.RPCConstantsAndServices.RootFieldName));
                AbsQuantityView result = (AbsQuantityView) view.objects.ViewProxi.createProxi(proxiInformation, this.getHandler());
                if (result != null) ((view.objects.ViewRoot)result).setToString(proxiInformation.getToString());
                view.objects.ViewObject root = (view.objects.ViewObject) allResults.get(proxiInformation.getHashKey());
                if (root != null) ((view.objects.ViewProxi)result).setObject(root);
                return result;
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    public synchronized void createMeasurementType(MeasurementTypeManagerView measurementTypeManager, String name, MTypeView type, UnitTypeView unitType) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)measurementTypeManager).createProxiInformation());
            parameters.add(name);
            parameters.add(((view.objects.ViewProxi)type).createProxiInformation());
            parameters.add(((view.objects.ViewProxi)unitType).createProxiInformation());
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "createMeasurementType", parameters);
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
    
    public synchronized void removeUnitType(AbsUnitTypeView type) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)type).createProxiInformation());
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "removeUnitType", parameters);
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
    
    public synchronized void addSubAccountType(MAccountTypeView parent, MAccountTypeView child) throws ModelException, CycleException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)parent).createProxiInformation());
            parameters.add(((view.objects.ViewProxi)child).createProxiInformation());
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "addSubAccountType", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
                    throw CycleException.fromHashtableToCycleException((Hashtable)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new Error("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    public synchronized void removeOperation(OperationView op) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)op).createProxiInformation());
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "removeOperation", parameters);
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
    
    public synchronized void addAssociation(HierarchyView h, AssociationView a) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)h).createProxiInformation());
            parameters.add(((view.objects.ViewProxi)a).createProxiInformation());
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "addAssociation", parameters);
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
    
    public synchronized void createMessage(MessageManagerView manager, OperationView type, MObjectView source, MObjectView target, java.util.Vector<ActualParameterView> ap) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)manager).createProxiInformation());
            parameters.add(((view.objects.ViewProxi)type).createProxiInformation());
            parameters.add(((view.objects.ViewProxi)source).createProxiInformation());
            parameters.add(((view.objects.ViewProxi)target).createProxiInformation());
            java.util.Vector<String> apTrnsprt = new java.util.Vector<String>();
            java.util.Iterator<ActualParameterView> apItrtr = ap.iterator();
            while (apItrtr.hasNext()){ 
                ActualParameterView current = apItrtr.next();
                apTrnsprt.add(((view.objects.ViewProxi)current).createProxiInformation());
            }
            parameters.add(apTrnsprt);
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "createMessage", parameters);
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
    
    public synchronized void createConstant(OperationManagerView operationManager, String name, MTypeView target) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)operationManager).createProxiInformation());
            parameters.add(name);
            parameters.add(((view.objects.ViewProxi)target).createProxiInformation());
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "createConstant", parameters);
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
    
    public synchronized void createProductType(java.util.Vector<MTypeView> containees) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            java.util.Vector<String> containeesTrnsprt = new java.util.Vector<String>();
            java.util.Iterator<MTypeView> containeesItrtr = containees.iterator();
            while (containeesItrtr.hasNext()){ 
                MTypeView current = containeesItrtr.next();
                containeesTrnsprt.add(((view.objects.ViewProxi)current).createProxiInformation());
            }
            parameters.add(containeesTrnsprt);
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "createProductType", parameters);
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
    
    public synchronized void removeLink(LinkView link) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)link).createProxiInformation());
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "removeLink", parameters);
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
    
    public synchronized void createLink(MObjectView source, AssociationView type, MObjectView target) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)source).createProxiInformation());
            parameters.add(((view.objects.ViewProxi)type).createProxiInformation());
            parameters.add(((view.objects.ViewProxi)target).createProxiInformation());
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "createLink", parameters);
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
    
    public synchronized void addType(MObjectView object, MAtomicTypeView newType) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)object).createProxiInformation());
            parameters.add(((view.objects.ViewProxi)newType).createProxiInformation());
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "addType", parameters);
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
    
    public synchronized void createNameScheme(NameSchemeManagerView manager, String schemeName, String regExp, String isIterable) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)manager).createProxiInformation());
            parameters.add(schemeName);
            parameters.add(regExp);
            parameters.add(isIterable);
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "createNameScheme", parameters);
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
    
    public synchronized void removeFpFromOp(OperationView operation, FormalParameterView fp) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)operation).createProxiInformation());
            parameters.add(((view.objects.ViewProxi)fp).createProxiInformation());
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "removeFpFromOp", parameters);
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
    
    public synchronized void removeMessage(MessageView m) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)m).createProxiInformation());
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "removeMessage", parameters);
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
    
    public synchronized void createAssociation(AssociationManagerView manager, MTypeView source, MTypeView target, String name) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)manager).createProxiInformation());
            parameters.add(((view.objects.ViewProxi)source).createProxiInformation());
            parameters.add(((view.objects.ViewProxi)target).createProxiInformation());
            parameters.add(name);
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
    
    public synchronized void createSumType(java.util.Vector<MTypeView> containees) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            java.util.Vector<String> containeesTrnsprt = new java.util.Vector<String>();
            java.util.Iterator<MTypeView> containeesItrtr = containees.iterator();
            while (containeesItrtr.hasNext()){ 
                MTypeView current = containeesItrtr.next();
                containeesTrnsprt.add(((view.objects.ViewProxi)current).createProxiInformation());
            }
            parameters.add(containeesTrnsprt);
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
    
    public synchronized void removeFromHierarchy(HierarchyView h, AssociationView a) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)h).createProxiInformation());
            parameters.add(((view.objects.ViewProxi)a).createProxiInformation());
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "removeFromHierarchy", parameters);
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
    
    public synchronized void createVoidOperation(OperationManagerView operationManager, MTypeView source, String name, java.util.Vector<FormalParameterView> fp) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)operationManager).createProxiInformation());
            parameters.add(((view.objects.ViewProxi)source).createProxiInformation());
            parameters.add(name);
            java.util.Vector<String> fpTrnsprt = new java.util.Vector<String>();
            java.util.Iterator<FormalParameterView> fpItrtr = fp.iterator();
            while (fpItrtr.hasNext()){ 
                FormalParameterView current = fpItrtr.next();
                fpTrnsprt.add(((view.objects.ViewProxi)current).createProxiInformation());
            }
            parameters.add(fpTrnsprt);
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "createVoidOperation", parameters);
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
    
    public synchronized void createOperation(MTypeView source, MTypeView target, String name, java.util.Vector<FormalParameterView> fp) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)source).createProxiInformation());
            parameters.add(((view.objects.ViewProxi)target).createProxiInformation());
            parameters.add(name);
            java.util.Vector<String> fpTrnsprt = new java.util.Vector<String>();
            java.util.Iterator<FormalParameterView> fpItrtr = fp.iterator();
            while (fpItrtr.hasNext()){ 
                FormalParameterView current = fpItrtr.next();
                fpTrnsprt.add(((view.objects.ViewProxi)current).createProxiInformation());
            }
            parameters.add(fpTrnsprt);
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "createOperation", parameters);
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
    
    public synchronized void createVoidOperation(MTypeView source, String name, java.util.Vector<FormalParameterView> fp) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)source).createProxiInformation());
            parameters.add(name);
            java.util.Vector<String> fpTrnsprt = new java.util.Vector<String>();
            java.util.Iterator<FormalParameterView> fpItrtr = fp.iterator();
            while (fpItrtr.hasNext()){ 
                FormalParameterView current = fpItrtr.next();
                fpTrnsprt.add(((view.objects.ViewProxi)current).createProxiInformation());
            }
            parameters.add(fpTrnsprt);
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "createVoidOperation", parameters);
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
    
    public synchronized void createUnitType(UnitTypeManagerView manager, String name) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)manager).createProxiInformation());
            parameters.add(name);
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "createUnitType", parameters);
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
    
    public synchronized void createAccountType(AccountTypeManagerView accountTypeManager, String name, MTypeView type, UnitTypeView unitType) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)accountTypeManager).createProxiInformation());
            parameters.add(name);
            parameters.add(((view.objects.ViewProxi)type).createProxiInformation());
            parameters.add(((view.objects.ViewProxi)unitType).createProxiInformation());
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "createAccountType", parameters);
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
    
    public synchronized void createQuantity(QuantityManagerView manager, AbsUnitView unit, common.Fraction f) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)manager).createProxiInformation());
            parameters.add(((view.objects.ViewProxi)unit).createProxiInformation());
            parameters.add(f.toString());
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "createQuantity", parameters);
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
    
    public synchronized void removeUnit(AbsUnitView unit) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)unit).createProxiInformation());
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "removeUnit", parameters);
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
    
    public synchronized void createMessage(MObjectView source, OperationView type, MObjectView target, java.util.Vector<ActualParameterView> ap) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)source).createProxiInformation());
            parameters.add(((view.objects.ViewProxi)type).createProxiInformation());
            parameters.add(((view.objects.ViewProxi)target).createProxiInformation());
            java.util.Vector<String> apTrnsprt = new java.util.Vector<String>();
            java.util.Iterator<ActualParameterView> apItrtr = ap.iterator();
            while (apItrtr.hasNext()){ 
                ActualParameterView current = apItrtr.next();
                apTrnsprt.add(((view.objects.ViewProxi)current).createProxiInformation());
            }
            parameters.add(apTrnsprt);
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "createMessage", parameters);
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
    
    public synchronized void removeAssociation(AssociationView a) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)a).createProxiInformation());
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "removeAssociation", parameters);
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
    
    public synchronized void addReference(AbsUnitView unit, String name, UnitView referenceUnit, long exponent) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)unit).createProxiInformation());
            parameters.add(name);
            parameters.add(((view.objects.ViewProxi)referenceUnit).createProxiInformation());
            parameters.add(new Long(exponent).toString());
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "addReference", parameters);
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
    
    public synchronized void removeFp(FormalParameterView fp) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)fp).createProxiInformation());
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "removeFp", parameters);
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
    
    public synchronized void removeType(MObjectView object, MAtomicTypeView oldType) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)object).createProxiInformation());
            parameters.add(((view.objects.ViewProxi)oldType).createProxiInformation());
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "removeType", parameters);
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
    
    public synchronized void createMObject(MAtomicTypeView type, java.util.Vector<MAtomicTypeView> otherTypes) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)type).createProxiInformation());
            java.util.Vector<String> otherTypesTrnsprt = new java.util.Vector<String>();
            java.util.Iterator<MAtomicTypeView> otherTypesItrtr = otherTypes.iterator();
            while (otherTypesItrtr.hasNext()){ 
                MAtomicTypeView current = otherTypesItrtr.next();
                otherTypesTrnsprt.add(((view.objects.ViewProxi)current).createProxiInformation());
            }
            parameters.add(otherTypesTrnsprt);
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "createMObject", parameters);
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
    
    public synchronized void assignNameScheme(MAtomicTypeView type, NameSchemeView scheme) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)type).createProxiInformation());
            parameters.add(((view.objects.ViewProxi)scheme).createProxiInformation());
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "assignNameScheme", parameters);
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
    
    public synchronized void setDefaultUnit(UnitTypeView type, UnitView defaultUnit) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)type).createProxiInformation());
            parameters.add(((view.objects.ViewProxi)defaultUnit).createProxiInformation());
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "setDefaultUnit", parameters);
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
    
    public synchronized void createUnit(UnitTypeView type, String name) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)type).createProxiInformation());
            parameters.add(name);
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "createUnit", parameters);
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
    
    public synchronized void createAtomicRootType(MAspectView aspect, String typeName, String singletonType, String abstractType) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)aspect).createProxiInformation());
            parameters.add(typeName);
            parameters.add(singletonType);
            parameters.add(abstractType);
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "createAtomicRootType", parameters);
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
    
    public synchronized void addSubAccount(AccountView parent, AccountView child) throws ModelException, CycleException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)parent).createProxiInformation());
            parameters.add(((view.objects.ViewProxi)child).createProxiInformation());
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "addSubAccount", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
                    throw CycleException.fromHashtableToCycleException((Hashtable)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new Error("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized AbsQuantityView add(AbsQuantityView summand1, AbsQuantityView summand2) throws ModelException, NotComputableException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)summand1).createProxiInformation());
            parameters.add(((view.objects.ViewProxi)summand2).createProxiInformation());
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "add", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
                    throw NotComputableException.fromHashtableToNotComputableException((Hashtable)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new Error("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
            }else{
                java.util.Hashtable<String, Object> allResults = (java.util.Hashtable<String, Object>) success.get(common.RPCConstantsAndServices.ResultFieldName);
                view.objects.ViewProxi.resolveReferences(allResults, this.getHandler());
                common.ProxiInformation proxiInformation = common.RPCConstantsAndServices.createProxiInformation((String) success.get(common.RPCConstantsAndServices.RootFieldName));
                AbsQuantityView result = (AbsQuantityView) view.objects.ViewProxi.createProxi(proxiInformation, this.getHandler());
                if (result != null) ((view.objects.ViewRoot)result).setToString(proxiInformation.getToString());
                view.objects.ViewObject root = (view.objects.ViewObject) allResults.get(proxiInformation.getHashKey());
                if (root != null) ((view.objects.ViewProxi)result).setObject(root);
                return result;
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    public synchronized void createAspect(AspectManagerView aspectManager, String name) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)aspectManager).createProxiInformation());
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
    
    public synchronized void createVoidMessage(MObjectView source, OperationView type, java.util.Vector<ActualParameterView> ap) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)source).createProxiInformation());
            parameters.add(((view.objects.ViewProxi)type).createProxiInformation());
            java.util.Vector<String> apTrnsprt = new java.util.Vector<String>();
            java.util.Iterator<ActualParameterView> apItrtr = ap.iterator();
            while (apItrtr.hasNext()){ 
                ActualParameterView current = apItrtr.next();
                apTrnsprt.add(((view.objects.ViewProxi)current).createProxiInformation());
            }
            parameters.add(apTrnsprt);
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "createVoidMessage", parameters);
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
    
    public synchronized void createAccount(AccountManagerView accountManager, String name, MAccountTypeView type, MObjectView object) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)accountManager).createProxiInformation());
            parameters.add(name);
            parameters.add(((view.objects.ViewProxi)type).createProxiInformation());
            parameters.add(((view.objects.ViewProxi)object).createProxiInformation());
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "createAccount", parameters);
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
    
    public synchronized void createVoidMessage(MessageManagerView manager, OperationView type, MObjectView source, java.util.Vector<ActualParameterView> ap) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)manager).createProxiInformation());
            parameters.add(((view.objects.ViewProxi)type).createProxiInformation());
            parameters.add(((view.objects.ViewProxi)source).createProxiInformation());
            java.util.Vector<String> apTrnsprt = new java.util.Vector<String>();
            java.util.Iterator<ActualParameterView> apItrtr = ap.iterator();
            while (apItrtr.hasNext()){ 
                ActualParameterView current = apItrtr.next();
                apTrnsprt.add(((view.objects.ViewProxi)current).createProxiInformation());
            }
            parameters.add(apTrnsprt);
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "createVoidMessage", parameters);
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
    
    public synchronized void createStaticOp(OperationManagerView operationManager, String name, MTypeView target, java.util.Vector<FormalParameterView> fp) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)operationManager).createProxiInformation());
            parameters.add(name);
            parameters.add(((view.objects.ViewProxi)target).createProxiInformation());
            java.util.Vector<String> fpTrnsprt = new java.util.Vector<String>();
            java.util.Iterator<FormalParameterView> fpItrtr = fp.iterator();
            while (fpItrtr.hasNext()){ 
                FormalParameterView current = fpItrtr.next();
                fpTrnsprt.add(((view.objects.ViewProxi)current).createProxiInformation());
            }
            parameters.add(fpTrnsprt);
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "createStaticOp", parameters);
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
    
    public synchronized void setConversion(UnitView unit, common.Fraction factor, common.Fraction constant) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)unit).createProxiInformation());
            parameters.add(factor.toString());
            parameters.add(constant.toString());
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "setConversion", parameters);
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
    
    public synchronized void createOperation(OperationManagerView operationManager, MTypeView source, MTypeView target, String name, java.util.Vector<FormalParameterView> fp) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)operationManager).createProxiInformation());
            parameters.add(((view.objects.ViewProxi)source).createProxiInformation());
            parameters.add(((view.objects.ViewProxi)target).createProxiInformation());
            parameters.add(name);
            java.util.Vector<String> fpTrnsprt = new java.util.Vector<String>();
            java.util.Iterator<FormalParameterView> fpItrtr = fp.iterator();
            while (fpItrtr.hasNext()){ 
                FormalParameterView current = fpItrtr.next();
                fpTrnsprt.add(((view.objects.ViewProxi)current).createProxiInformation());
            }
            parameters.add(fpTrnsprt);
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "createOperation", parameters);
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
    
    public synchronized void addReferenceType(AbsUnitTypeView unitType, String name, UnitTypeView referenceUnitType, long exponent) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)unitType).createProxiInformation());
            parameters.add(name);
            parameters.add(((view.objects.ViewProxi)referenceUnitType).createProxiInformation());
            parameters.add(new Long(exponent).toString());
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "addReferenceType", parameters);
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
    
    public synchronized void createConst(MessageManagerView manager, OperationView type, String name, MObjectView target) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)manager).createProxiInformation());
            parameters.add(((view.objects.ViewProxi)type).createProxiInformation());
            parameters.add(name);
            parameters.add(((view.objects.ViewProxi)target).createProxiInformation());
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "createConst", parameters);
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
    
    public synchronized void assignName(MObjectView object, NameView scheme, String name) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)object).createProxiInformation());
            parameters.add(((view.objects.ViewProxi)scheme).createProxiInformation());
            parameters.add(name);
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "assignName", parameters);
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
    
    @SuppressWarnings("unchecked")
    public synchronized AbsQuantityView sub(AbsQuantityView minuend, AbsQuantityView subtrahend) throws ModelException, NotComputableException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)minuend).createProxiInformation());
            parameters.add(((view.objects.ViewProxi)subtrahend).createProxiInformation());
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "sub", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
                    throw NotComputableException.fromHashtableToNotComputableException((Hashtable)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new Error("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
            }else{
                java.util.Hashtable<String, Object> allResults = (java.util.Hashtable<String, Object>) success.get(common.RPCConstantsAndServices.ResultFieldName);
                view.objects.ViewProxi.resolveReferences(allResults, this.getHandler());
                common.ProxiInformation proxiInformation = common.RPCConstantsAndServices.createProxiInformation((String) success.get(common.RPCConstantsAndServices.RootFieldName));
                AbsQuantityView result = (AbsQuantityView) view.objects.ViewProxi.createProxi(proxiInformation, this.getHandler());
                if (result != null) ((view.objects.ViewRoot)result).setToString(proxiInformation.getToString());
                view.objects.ViewObject root = (view.objects.ViewObject) allResults.get(proxiInformation.getHashKey());
                if (root != null) ((view.objects.ViewProxi)result).setObject(root);
                return result;
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    public synchronized void assignType(NameSchemeView scheme, MAtomicTypeView type) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(((view.objects.ViewProxi)scheme).createProxiInformation());
            parameters.add(((view.objects.ViewProxi)type).createProxiInformation());
            Hashtable<?,?> success = (Hashtable<?,?>)this.execute(this.connectionName, "assignType", parameters);
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
