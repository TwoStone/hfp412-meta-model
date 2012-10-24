
package view.objects;

import view.*;


/* Additional import section end */

public class Quantity extends view.objects.AbsQuantity implements QuantityView{
    
    protected FractionView amount;
    protected UnitView unit;
    
    public Quantity(FractionView amount,UnitView unit,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.amount = amount;
        this.unit = unit;        
    }
    
    static public long getTypeId() {
        return 112;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public FractionView getAmount() throws ModelException {
        return this.amount;
    }
    public void setAmount(FractionView newValue) throws ModelException {
        this.amount = newValue;
    }
    public UnitView getUnit() throws ModelException {
        return this.unit;
    }
    public void setUnit(UnitView newValue) throws ModelException {
        this.unit = newValue;
    }
    
    public void accept(view.visitor.AbsQuantityVisitor visitor) throws ModelException {
        visitor.handleQuantity(this);
    }
    public <R> R accept(view.visitor.AbsQuantityReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleQuantity(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AbsQuantityExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleQuantity(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AbsQuantityReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleQuantity(this);
    }
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException {
        visitor.handleQuantity(this);
    }
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleQuantity(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleQuantity(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleQuantity(this);
    }
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        FractionView amount = this.getAmount();
        if (amount != null) {
            ((ViewProxi)amount).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(amount.getClassId(), amount.getId())));
        }
        UnitView unit = this.getUnit();
        if (unit != null) {
            ((ViewProxi)unit).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(unit.getClassId(), unit.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index == 0 && this.getAmount() != null) return new AmountQuantityWrapper(this, originalIndex, (ViewRoot)this.getAmount());
        if(this.getAmount() != null) index = index - 1;
        if(index == 0 && this.getUnit() != null) return new UnitQuantityWrapper(this, originalIndex, (ViewRoot)this.getUnit());
        if(this.getUnit() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getAmount() == null ? 0 : 1)
            + (this.getUnit() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getAmount() == null ? true : false)
            && (this.getUnit() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getAmount() != null && this.getAmount().equals(child)) return result;
        if(this.getAmount() != null) result = result + 1;
        if(this.getUnit() != null && this.getUnit().equals(child)) return result;
        if(this.getUnit() != null) result = result + 1;
        return -1;
    }
    public int getRowCount(){
        return 0 ;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
            } else {
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
        
    }
    public boolean hasTransientFields(){
        return false;
    }
    /* Start of protected part that is not overridden by persistence generator */
    
    public void setIcon(IconRenderer renderer) {
        renderer.setIcon(null);
            //TODO: implement setIcon in view class Quantity
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
