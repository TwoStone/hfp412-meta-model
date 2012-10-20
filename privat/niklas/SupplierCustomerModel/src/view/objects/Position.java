
package view.objects;

import view.*;


/* Additional import section end */

public class Position extends ViewObject implements PositionView{
    
    protected ProductView product;
    protected long quantity;
    
    public Position(ProductView product,long quantity,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.product = product;
        this.quantity = quantity;        
    }
    
    static public long getTypeId() {
        return 115;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public ProductView getProduct() throws ModelException {
        return this.product;
    }
    public void setProduct(ProductView newValue) throws ModelException {
        this.product = newValue;
    }
    public long getQuantity() throws ModelException {
        return this.quantity;
    }
    public void setQuantity(long newValue) throws ModelException {
        this.quantity = newValue;
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
        ProductView product = this.getProduct();
        if (product != null) {
            ((ViewProxi)product).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(product.getClassId(), product.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index == 0 && this.getProduct() != null) return new ProductPositionWrapper(this, originalIndex, (ViewRoot)this.getProduct());
        if(this.getProduct() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getProduct() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getProduct() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getProduct() != null && this.getProduct().equals(child)) return result;
        if(this.getProduct() != null) result = result + 1;
        return -1;
    }
    public int getQuantityIndex() throws ModelException {
        return 0 + (this.getProduct() == null ? 0 : 1);
    }
    public int getRowCount(){
        return 0 
            + 1;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
                if(rowIndex == 0) return "quantity";
                rowIndex = rowIndex - 1;
            } else {
                if(rowIndex == 0) return new Long(getQuantity());
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
            this.setQuantity(Long.parseLong(newValue));
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
