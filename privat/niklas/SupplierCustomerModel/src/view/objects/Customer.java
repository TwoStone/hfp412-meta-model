
package view.objects;

import view.*;


/* Additional import section end */

public class Customer extends view.objects.Role implements CustomerView{
    
    protected java.util.Vector<OrderView> myOrders;
    
    public Customer(java.util.Vector<OrderView> myOrders,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.myOrders = myOrders;        
    }
    
    static public long getTypeId() {
        return 101;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<OrderView> getMyOrders() throws ModelException {
        return this.myOrders;
    }
    
    public void accept(view.visitor.RoleVisitor visitor) throws ModelException {
        visitor.handleCustomer(this);
    }
    public <R> R accept(view.visitor.RoleReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleCustomer(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.RoleExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleCustomer(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.RoleReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleCustomer(this);
    }
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException {
        visitor.handleCustomer(this);
    }
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleCustomer(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleCustomer(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleCustomer(this);
    }
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        java.util.Vector<?> myOrders = this.getMyOrders();
        if (myOrders != null) {
            ViewObject.resolveVectorProxies(myOrders, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index < this.getMyOrders().size()) return new MyOrdersCustomerWrapper(this, originalIndex, (ViewRoot)this.getMyOrders().get(index));
        index = index - this.getMyOrders().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getMyOrders().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getMyOrders().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getMyOrdersIterator = this.getMyOrders().iterator();
        while(getMyOrdersIterator.hasNext()){
            if(getMyOrdersIterator.next().equals(child)) return result;
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
            //TODO: implement setIcon in view class Customer
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}