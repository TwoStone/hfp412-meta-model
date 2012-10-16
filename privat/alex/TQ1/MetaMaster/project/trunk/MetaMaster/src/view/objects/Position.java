
package view.objects;

import view.*;


/* Additional import section end */

public class Position extends ViewObject implements PositionView{
    
    protected long amount;
    protected ProductView relateTo;
    
    public Position(long amount,ProductView relateTo,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.amount = amount;
        this.relateTo = relateTo;        
    }
    
    static public long getTypeId() {
        return 116;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public long getAmount() throws ModelException {
        return this.amount;
    }
    public void setAmount(long newValue) throws ModelException {
        this.amount = newValue;
    }
    public ProductView getRelateTo() throws ModelException {
        return this.relateTo;
    }
    public void setRelateTo(ProductView newValue) throws ModelException {
        this.relateTo = newValue;
    }
    
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException {
        visitor.handlePosition(this);
    }
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handlePosition(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handlePosition(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handlePosition(this);
    }
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        ProductView relateTo = this.getRelateTo();
        if (relateTo != null) {
            ((ViewProxi)relateTo).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(relateTo.getClassId(), relateTo.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index == 0 && this.getRelateTo() != null) return new RelateToPositionWrapper(this, originalIndex, (ViewRoot)this.getRelateTo());
        if(this.getRelateTo() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getRelateTo() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getRelateTo() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getRelateTo() != null && this.getRelateTo().equals(child)) return result;
        if(this.getRelateTo() != null) result = result + 1;
        return -1;
    }
    public int getAmountIndex() throws ModelException {
        return 0;
    }
    public int getRowCount(){
        return 0 
            + 1;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
                if(rowIndex == 0) return "amount";
                rowIndex = rowIndex - 1;
            } else {
                if(rowIndex == 0) return new Long(getAmount());
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
            this.setAmount(Long.parseLong(newValue));
            return;
        }
        rowIndex = rowIndex - 1;
    }
    public boolean hasTransientFields(){
        return false;
    }
    /* Start of protected part that is not overridden by persistence generator */
    
    public void setIcon(IconRenderer renderer) {
        renderer.setIcon(null);
            //TODO: implement setIcon in view class Position
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
