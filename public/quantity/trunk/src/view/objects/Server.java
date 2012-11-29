
package view.objects;

import view.*;
import viewClient.*;
import view.visitor.*;


/* Additional import section end */

public class Server extends ViewObject implements ServerView{
    
    protected QuantityManagerView quantityManager;
    protected UnitTypeManagerView unitTypeManager;
    protected ConversionManagerView conversionManager;
    protected FractionManagerView fractionManager;
    protected java.util.Vector<ErrorDisplayView> errors;
    protected String user;
    
    public Server(QuantityManagerView quantityManager,UnitTypeManagerView unitTypeManager,ConversionManagerView conversionManager,FractionManagerView fractionManager,java.util.Vector<ErrorDisplayView> errors,String user,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.quantityManager = quantityManager;
        this.unitTypeManager = unitTypeManager;
        this.conversionManager = conversionManager;
        this.fractionManager = fractionManager;
        this.errors = errors;
        this.user = user;        
    }
    
    static public long getTypeId() {
        return -129;
    }
    
    public long getClassId() {
        return getTypeId();
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
        java.util.Vector<?> errors = this.getErrors();
        if (errors != null) {
            ViewObject.resolveVectorProxies(errors, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index == 0 && this.getQuantityManager() != null) return new QuantityManagerServerWrapper(this, originalIndex, (ViewRoot)this.getQuantityManager());
        if(this.getQuantityManager() != null) index = index - 1;
        if(index == 0 && this.getUnitTypeManager() != null) return new UnitTypeManagerServerWrapper(this, originalIndex, (ViewRoot)this.getUnitTypeManager());
        if(this.getUnitTypeManager() != null) index = index - 1;
        if(index == 0 && this.getConversionManager() != null) return new ConversionManagerServerWrapper(this, originalIndex, (ViewRoot)this.getConversionManager());
        if(this.getConversionManager() != null) index = index - 1;
        if(index == 0 && this.getFractionManager() != null) return new FractionManagerServerWrapper(this, originalIndex, (ViewRoot)this.getFractionManager());
        if(this.getFractionManager() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getQuantityManager() == null ? 0 : 1)
            + (this.getUnitTypeManager() == null ? 0 : 1)
            + (this.getConversionManager() == null ? 0 : 1)
            + (this.getFractionManager() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getQuantityManager() == null ? true : false)
            && (this.getUnitTypeManager() == null ? true : false)
            && (this.getConversionManager() == null ? true : false)
            && (this.getFractionManager() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getQuantityManager() != null && this.getQuantityManager().equals(child)) return result;
        if(this.getQuantityManager() != null) result = result + 1;
        if(this.getUnitTypeManager() != null && this.getUnitTypeManager().equals(child)) return result;
        if(this.getUnitTypeManager() != null) result = result + 1;
        if(this.getConversionManager() != null && this.getConversionManager().equals(child)) return result;
        if(this.getConversionManager() != null) result = result + 1;
        if(this.getFractionManager() != null && this.getFractionManager().equals(child)) return result;
        if(this.getFractionManager() != null) result = result + 1;
        return -1;
    }
    public int getUserIndex() throws ModelException {
        return 0 + (this.getQuantityManager() == null ? 0 : 1) + (this.getUnitTypeManager() == null ? 0 : 1) + (this.getConversionManager() == null ? 0 : 1) + (this.getFractionManager() == null ? 0 : 1);
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
