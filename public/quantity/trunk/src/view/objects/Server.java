
package view.objects;

import view.*;
import viewClient.*;
import view.visitor.*;


/* Additional import section end */

public class Server extends ViewObject implements ServerView{
    
    protected TypeManagerView typeManager;
    protected QuantityManagerView quantityManager;
    protected UnitManagerView unitManager;
    protected ConversionManagerView conversionManager;
    protected java.util.Vector<ErrorDisplayView> errors;
    protected String user;
    
    public Server(TypeManagerView typeManager,QuantityManagerView quantityManager,UnitManagerView unitManager,ConversionManagerView conversionManager,java.util.Vector<ErrorDisplayView> errors,String user,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.typeManager = typeManager;
        this.quantityManager = quantityManager;
        this.unitManager = unitManager;
        this.conversionManager = conversionManager;
        this.errors = errors;
        this.user = user;        
    }
    
    static public long getTypeId() {
        return -114;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public TypeManagerView getTypeManager() throws ModelException {
        return this.typeManager;
    }
    public QuantityManagerView getQuantityManager() throws ModelException {
        return this.quantityManager;
    }
    public UnitManagerView getUnitManager() throws ModelException {
        return this.unitManager;
    }
    public ConversionManagerView getConversionManager() throws ModelException {
        return this.conversionManager;
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
        TypeManagerView typeManager = this.getTypeManager();
        if (typeManager != null) {
            ((ViewProxi)typeManager).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(typeManager.getClassId(), typeManager.getId())));
        }
        QuantityManagerView quantityManager = this.getQuantityManager();
        if (quantityManager != null) {
            ((ViewProxi)quantityManager).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(quantityManager.getClassId(), quantityManager.getId())));
        }
        UnitManagerView unitManager = this.getUnitManager();
        if (unitManager != null) {
            ((ViewProxi)unitManager).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(unitManager.getClassId(), unitManager.getId())));
        }
        ConversionManagerView conversionManager = this.getConversionManager();
        if (conversionManager != null) {
            ((ViewProxi)conversionManager).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(conversionManager.getClassId(), conversionManager.getId())));
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
        if(index == 0 && this.getTypeManager() != null) return new TypeManagerServerWrapper(this, originalIndex, (ViewRoot)this.getTypeManager());
        if(this.getTypeManager() != null) index = index - 1;
        if(index == 0 && this.getQuantityManager() != null) return new QuantityManagerServerWrapper(this, originalIndex, (ViewRoot)this.getQuantityManager());
        if(this.getQuantityManager() != null) index = index - 1;
        if(index == 0 && this.getUnitManager() != null) return new UnitManagerServerWrapper(this, originalIndex, (ViewRoot)this.getUnitManager());
        if(this.getUnitManager() != null) index = index - 1;
        if(index == 0 && this.getConversionManager() != null) return new ConversionManagerServerWrapper(this, originalIndex, (ViewRoot)this.getConversionManager());
        if(this.getConversionManager() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getTypeManager() == null ? 0 : 1)
            + (this.getQuantityManager() == null ? 0 : 1)
            + (this.getUnitManager() == null ? 0 : 1)
            + (this.getConversionManager() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getTypeManager() == null ? true : false)
            && (this.getQuantityManager() == null ? true : false)
            && (this.getUnitManager() == null ? true : false)
            && (this.getConversionManager() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getTypeManager() != null && this.getTypeManager().equals(child)) return result;
        if(this.getTypeManager() != null) result = result + 1;
        if(this.getQuantityManager() != null && this.getQuantityManager().equals(child)) return result;
        if(this.getQuantityManager() != null) result = result + 1;
        if(this.getUnitManager() != null && this.getUnitManager().equals(child)) return result;
        if(this.getUnitManager() != null) result = result + 1;
        if(this.getConversionManager() != null && this.getConversionManager().equals(child)) return result;
        if(this.getConversionManager() != null) result = result + 1;
        return -1;
    }
    public int getUserIndex() throws ModelException {
        return 0 + (this.getTypeManager() == null ? 0 : 1) + (this.getQuantityManager() == null ? 0 : 1) + (this.getUnitManager() == null ? 0 : 1) + (this.getConversionManager() == null ? 0 : 1);
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
