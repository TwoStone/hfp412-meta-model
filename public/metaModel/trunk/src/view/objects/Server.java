
package view.objects;

import view.*;
import viewClient.*;
import view.visitor.*;


/* Additional import section end */

public class Server extends ViewObject implements ServerView{
    
    protected AspectManagerView aspectManager;
    protected TypeManagerView typeManager;
    protected QuantityManagerView quantityManager;
    protected UnitTypeManagerView unitTypeManager;
    protected ConversionManagerView conversionManager;
    protected FractionManagerView fractionManager;
    protected MeasurementTypeManagerView measurementTypeManager;
    protected AccountTypeManagerView accountTypeManager;
    protected AccountManagerView accountManager;
    protected AssociationManagerView associationManager;
    protected OperationManagerView operationManager;
    protected MessageManagerView messageManager;
    protected LinkManagerView linkManager;
    protected java.util.Vector<ErrorDisplayView> errors;
    protected String user;
    
    public Server(AspectManagerView aspectManager,TypeManagerView typeManager,QuantityManagerView quantityManager,UnitTypeManagerView unitTypeManager,ConversionManagerView conversionManager,FractionManagerView fractionManager,MeasurementTypeManagerView measurementTypeManager,AccountTypeManagerView accountTypeManager,AccountManagerView accountManager,AssociationManagerView associationManager,OperationManagerView operationManager,MessageManagerView messageManager,LinkManagerView linkManager,java.util.Vector<ErrorDisplayView> errors,String user,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.aspectManager = aspectManager;
        this.typeManager = typeManager;
        this.quantityManager = quantityManager;
        this.unitTypeManager = unitTypeManager;
        this.conversionManager = conversionManager;
        this.fractionManager = fractionManager;
        this.measurementTypeManager = measurementTypeManager;
        this.accountTypeManager = accountTypeManager;
        this.accountManager = accountManager;
        this.associationManager = associationManager;
        this.operationManager = operationManager;
        this.messageManager = messageManager;
        this.linkManager = linkManager;
        this.errors = errors;
        this.user = user;        
    }
    
    static public long getTypeId() {
        return -111;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public AspectManagerView getAspectManager() throws ModelException {
        return this.aspectManager;
    }
    public TypeManagerView getTypeManager() throws ModelException {
        return this.typeManager;
    }
    public QuantityManagerView getQuantityManager() throws ModelException {
        return this.quantityManager;
    }
    public UnitTypeManagerView getUnitTypeManager() throws ModelException {
        return this.unitTypeManager;
    }
    public ConversionManagerView getConversionManager() throws ModelException {
        return this.conversionManager;
    }
    public FractionManagerView getFractionManager() throws ModelException {
        return this.fractionManager;
    }
    public MeasurementTypeManagerView getMeasurementTypeManager() throws ModelException {
        return this.measurementTypeManager;
    }
    public AccountTypeManagerView getAccountTypeManager() throws ModelException {
        return this.accountTypeManager;
    }
    public AccountManagerView getAccountManager() throws ModelException {
        return this.accountManager;
    }
    public AssociationManagerView getAssociationManager() throws ModelException {
        return this.associationManager;
    }
    public OperationManagerView getOperationManager() throws ModelException {
        return this.operationManager;
    }
    public MessageManagerView getMessageManager() throws ModelException {
        return this.messageManager;
    }
    public LinkManagerView getLinkManager() throws ModelException {
        return this.linkManager;
    }
    public java.util.Vector<ErrorDisplayView> getErrors() throws ModelException {
        return this.errors;
    }
    public void setErrors(java.util.Vector<ErrorDisplayView> newValue) throws ModelException {
        this.errors = newValue;
    }
    public String getUser() throws ModelException {
        return this.user;
    }
    public void setUser(String newValue) throws ModelException {
        this.user = newValue;
    }
    
    public void accept(RemoteVisitor visitor) throws ModelException {
        visitor.handleServer(this);
    }
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleServer(this);
    }
    public <E extends UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleServer(this);
    }
    public <R, E extends UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleServer(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleServer(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleServer(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleServer(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleServer(this);
    }
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        AspectManagerView aspectManager = this.getAspectManager();
        if (aspectManager != null) {
            ((ViewProxi)aspectManager).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(aspectManager.getClassId(), aspectManager.getId())));
        }
        TypeManagerView typeManager = this.getTypeManager();
        if (typeManager != null) {
            ((ViewProxi)typeManager).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(typeManager.getClassId(), typeManager.getId())));
        }
        QuantityManagerView quantityManager = this.getQuantityManager();
        if (quantityManager != null) {
            ((ViewProxi)quantityManager).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(quantityManager.getClassId(), quantityManager.getId())));
        }
        UnitTypeManagerView unitTypeManager = this.getUnitTypeManager();
        if (unitTypeManager != null) {
            ((ViewProxi)unitTypeManager).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(unitTypeManager.getClassId(), unitTypeManager.getId())));
        }
        ConversionManagerView conversionManager = this.getConversionManager();
        if (conversionManager != null) {
            ((ViewProxi)conversionManager).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(conversionManager.getClassId(), conversionManager.getId())));
        }
        FractionManagerView fractionManager = this.getFractionManager();
        if (fractionManager != null) {
            ((ViewProxi)fractionManager).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(fractionManager.getClassId(), fractionManager.getId())));
        }
        MeasurementTypeManagerView measurementTypeManager = this.getMeasurementTypeManager();
        if (measurementTypeManager != null) {
            ((ViewProxi)measurementTypeManager).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(measurementTypeManager.getClassId(), measurementTypeManager.getId())));
        }
        AccountTypeManagerView accountTypeManager = this.getAccountTypeManager();
        if (accountTypeManager != null) {
            ((ViewProxi)accountTypeManager).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(accountTypeManager.getClassId(), accountTypeManager.getId())));
        }
        AccountManagerView accountManager = this.getAccountManager();
        if (accountManager != null) {
            ((ViewProxi)accountManager).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(accountManager.getClassId(), accountManager.getId())));
        }
        AssociationManagerView associationManager = this.getAssociationManager();
        if (associationManager != null) {
            ((ViewProxi)associationManager).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(associationManager.getClassId(), associationManager.getId())));
        }
        OperationManagerView operationManager = this.getOperationManager();
        if (operationManager != null) {
            ((ViewProxi)operationManager).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(operationManager.getClassId(), operationManager.getId())));
        }
        MessageManagerView messageManager = this.getMessageManager();
        if (messageManager != null) {
            ((ViewProxi)messageManager).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(messageManager.getClassId(), messageManager.getId())));
        }
        LinkManagerView linkManager = this.getLinkManager();
        if (linkManager != null) {
            ((ViewProxi)linkManager).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(linkManager.getClassId(), linkManager.getId())));
        }
        java.util.Vector<?> errors = this.getErrors();
        if (errors != null) {
            ViewObject.resolveVectorProxies(errors, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index == 0 && this.getAspectManager() != null) return new AspectManagerServerWrapper(this, originalIndex, (ViewRoot)this.getAspectManager());
        if(this.getAspectManager() != null) index = index - 1;
        if(index == 0 && this.getTypeManager() != null) return new TypeManagerServerWrapper(this, originalIndex, (ViewRoot)this.getTypeManager());
        if(this.getTypeManager() != null) index = index - 1;
        if(index == 0 && this.getQuantityManager() != null) return new QuantityManagerServerWrapper(this, originalIndex, (ViewRoot)this.getQuantityManager());
        if(this.getQuantityManager() != null) index = index - 1;
        if(index == 0 && this.getUnitTypeManager() != null) return new UnitTypeManagerServerWrapper(this, originalIndex, (ViewRoot)this.getUnitTypeManager());
        if(this.getUnitTypeManager() != null) index = index - 1;
        if(index == 0 && this.getConversionManager() != null) return new ConversionManagerServerWrapper(this, originalIndex, (ViewRoot)this.getConversionManager());
        if(this.getConversionManager() != null) index = index - 1;
        if(index == 0 && this.getFractionManager() != null) return new FractionManagerServerWrapper(this, originalIndex, (ViewRoot)this.getFractionManager());
        if(this.getFractionManager() != null) index = index - 1;
        if(index == 0 && this.getMeasurementTypeManager() != null) return new MeasurementTypeManagerServerWrapper(this, originalIndex, (ViewRoot)this.getMeasurementTypeManager());
        if(this.getMeasurementTypeManager() != null) index = index - 1;
        if(index == 0 && this.getAccountTypeManager() != null) return new AccountTypeManagerServerWrapper(this, originalIndex, (ViewRoot)this.getAccountTypeManager());
        if(this.getAccountTypeManager() != null) index = index - 1;
        if(index == 0 && this.getAccountManager() != null) return new AccountManagerServerWrapper(this, originalIndex, (ViewRoot)this.getAccountManager());
        if(this.getAccountManager() != null) index = index - 1;
        if(index == 0 && this.getAssociationManager() != null) return new AssociationManagerServerWrapper(this, originalIndex, (ViewRoot)this.getAssociationManager());
        if(this.getAssociationManager() != null) index = index - 1;
        if(index == 0 && this.getOperationManager() != null) return new OperationManagerServerWrapper(this, originalIndex, (ViewRoot)this.getOperationManager());
        if(this.getOperationManager() != null) index = index - 1;
        if(index == 0 && this.getMessageManager() != null) return new MessageManagerServerWrapper(this, originalIndex, (ViewRoot)this.getMessageManager());
        if(this.getMessageManager() != null) index = index - 1;
        if(index == 0 && this.getLinkManager() != null) return new LinkManagerServerWrapper(this, originalIndex, (ViewRoot)this.getLinkManager());
        if(this.getLinkManager() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getAspectManager() == null ? 0 : 1)
            + (this.getTypeManager() == null ? 0 : 1)
            + (this.getQuantityManager() == null ? 0 : 1)
            + (this.getUnitTypeManager() == null ? 0 : 1)
            + (this.getConversionManager() == null ? 0 : 1)
            + (this.getFractionManager() == null ? 0 : 1)
            + (this.getMeasurementTypeManager() == null ? 0 : 1)
            + (this.getAccountTypeManager() == null ? 0 : 1)
            + (this.getAccountManager() == null ? 0 : 1)
            + (this.getAssociationManager() == null ? 0 : 1)
            + (this.getOperationManager() == null ? 0 : 1)
            + (this.getMessageManager() == null ? 0 : 1)
            + (this.getLinkManager() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getAspectManager() == null ? true : false)
            && (this.getTypeManager() == null ? true : false)
            && (this.getQuantityManager() == null ? true : false)
            && (this.getUnitTypeManager() == null ? true : false)
            && (this.getConversionManager() == null ? true : false)
            && (this.getFractionManager() == null ? true : false)
            && (this.getMeasurementTypeManager() == null ? true : false)
            && (this.getAccountTypeManager() == null ? true : false)
            && (this.getAccountManager() == null ? true : false)
            && (this.getAssociationManager() == null ? true : false)
            && (this.getOperationManager() == null ? true : false)
            && (this.getMessageManager() == null ? true : false)
            && (this.getLinkManager() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getAspectManager() != null && this.getAspectManager().equals(child)) return result;
        if(this.getAspectManager() != null) result = result + 1;
        if(this.getTypeManager() != null && this.getTypeManager().equals(child)) return result;
        if(this.getTypeManager() != null) result = result + 1;
        if(this.getQuantityManager() != null && this.getQuantityManager().equals(child)) return result;
        if(this.getQuantityManager() != null) result = result + 1;
        if(this.getUnitTypeManager() != null && this.getUnitTypeManager().equals(child)) return result;
        if(this.getUnitTypeManager() != null) result = result + 1;
        if(this.getConversionManager() != null && this.getConversionManager().equals(child)) return result;
        if(this.getConversionManager() != null) result = result + 1;
        if(this.getFractionManager() != null && this.getFractionManager().equals(child)) return result;
        if(this.getFractionManager() != null) result = result + 1;
        if(this.getMeasurementTypeManager() != null && this.getMeasurementTypeManager().equals(child)) return result;
        if(this.getMeasurementTypeManager() != null) result = result + 1;
        if(this.getAccountTypeManager() != null && this.getAccountTypeManager().equals(child)) return result;
        if(this.getAccountTypeManager() != null) result = result + 1;
        if(this.getAccountManager() != null && this.getAccountManager().equals(child)) return result;
        if(this.getAccountManager() != null) result = result + 1;
        if(this.getAssociationManager() != null && this.getAssociationManager().equals(child)) return result;
        if(this.getAssociationManager() != null) result = result + 1;
        if(this.getOperationManager() != null && this.getOperationManager().equals(child)) return result;
        if(this.getOperationManager() != null) result = result + 1;
        if(this.getMessageManager() != null && this.getMessageManager().equals(child)) return result;
        if(this.getMessageManager() != null) result = result + 1;
        if(this.getLinkManager() != null && this.getLinkManager().equals(child)) return result;
        if(this.getLinkManager() != null) result = result + 1;
        return -1;
    }
    public int getUserIndex() throws ModelException {
        return 0 + (this.getAspectManager() == null ? 0 : 1) + (this.getTypeManager() == null ? 0 : 1) + (this.getQuantityManager() == null ? 0 : 1) + (this.getUnitTypeManager() == null ? 0 : 1) + (this.getConversionManager() == null ? 0 : 1) + (this.getFractionManager() == null ? 0 : 1) + (this.getMeasurementTypeManager() == null ? 0 : 1) + (this.getAccountTypeManager() == null ? 0 : 1) + (this.getAccountManager() == null ? 0 : 1) + (this.getAssociationManager() == null ? 0 : 1) + (this.getOperationManager() == null ? 0 : 1) + (this.getMessageManager() == null ? 0 : 1) + (this.getLinkManager() == null ? 0 : 1);
    }
    public int getRowCount(){
        return 0 
            + 1;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
                if(rowIndex == 0) return "user";
                rowIndex = rowIndex - 1;
            } else {
                if(rowIndex == 0) return this.getUser();
                rowIndex = rowIndex - 1;
            }
            throw new ModelException("Table index out of bounds!", -1);
        } catch (ModelException e){
            return e.getMessage();
        }
    }
    
    public boolean isRowEditable(int index){
        return true;
    }
    public void setValueAt(String newValue, int rowIndex) throws Exception {
        if(rowIndex == 0){
            this.setUser(newValue);
            return;
        }
        rowIndex = rowIndex - 1;
    }
    public ServerConnection connectServer(ConnectionMaster master, ExceptionAndEventHandler handler) throws ModelException{
        ServerConnection result;
		try {
			result = (ServerConnection)new ServerConnection(master.getUrlString(), master.getHandler(), master.getReporter()).fork(master, this);
		} catch (java.net.MalformedURLException e) {
			throw new ModelException(e.getMessage(),0);
		}
		result.setHandler(handler);
		ConnectionIndex.getTheConnectionIndex().setConnection(handler,result);
		handler.setConnection(result);
		handler.initializeConnection();
		return result;
    }
    
    public boolean hasTransientFields(){
        return true;
    }
    /* Start of protected part that is not overridden by persistence generator */
    
    public void setIcon(IconRenderer renderer) {
        super.setIcon(renderer);
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
