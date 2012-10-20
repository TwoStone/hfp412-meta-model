
package view.objects;

import view.*;


/* Additional import section end */

public class Supplier extends view.objects.Role implements SupplierView{
    
    protected java.util.Vector<ProductView> products;
    
    public Supplier(java.util.Vector<ProductView> products,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.products = products;        
    }
    
    static public long getTypeId() {
        return 110;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<ProductView> getProducts() throws ModelException {
        return this.products;
    }
    
    public void accept(view.visitor.RoleVisitor visitor) throws ModelException {
        visitor.handleSupplier(this);
    }
    public <R> R accept(view.visitor.RoleReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleSupplier(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.RoleExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleSupplier(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.RoleReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleSupplier(this);
    }
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException {
        visitor.handleSupplier(this);
    }
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleSupplier(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleSupplier(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleSupplier(this);
    }
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        java.util.Vector<?> products = this.getProducts();
        if (products != null) {
            ViewObject.resolveVectorProxies(products, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index < this.getProducts().size()) return new ProductsSupplierWrapper(this, originalIndex, (ViewRoot)this.getProducts().get(index));
        index = index - this.getProducts().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getProducts().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getProducts().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getProductsIterator = this.getProducts().iterator();
        while(getProductsIterator.hasNext()){
            if(getProductsIterator.next().equals(child)) return result;
            result = result + 1;
        }
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
        return true;
    }
    /* Start of protected part that is not overridden by persistence generator */
    
    public void setIcon(IconRenderer renderer) {
        renderer.setIcon(null);
            //TODO: implement setIcon in view class Supplier
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
