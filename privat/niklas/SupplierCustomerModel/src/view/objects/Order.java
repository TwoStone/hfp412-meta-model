
package view.objects;

import view.*;


/* Additional import section end */

public class Order extends ViewObject implements OrderView{
    
    protected CustomerView customer;
    protected SupplierView supplier;
    protected java.util.Vector<PositionView> positions;
    protected long orderId;
    
    public Order(CustomerView customer,SupplierView supplier,java.util.Vector<PositionView> positions,long orderId,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.customer = customer;
        this.supplier = supplier;
        this.positions = positions;
        this.orderId = orderId;        
    }
    
    static public long getTypeId() {
        return 106;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public CustomerView getCustomer() throws ModelException {
        return this.customer;
    }
    public void setCustomer(CustomerView newValue) throws ModelException {
        this.customer = newValue;
    }
    public SupplierView getSupplier() throws ModelException {
        return this.supplier;
    }
    public void setSupplier(SupplierView newValue) throws ModelException {
        this.supplier = newValue;
    }
    public java.util.Vector<PositionView> getPositions() throws ModelException {
        return this.positions;
    }
    public void setPositions(java.util.Vector<PositionView> newValue) throws ModelException {
        this.positions = newValue;
    }
    public long getOrderId() throws ModelException {
        return this.orderId;
    }
    public void setOrderId(long newValue) throws ModelException {
        this.orderId = newValue;
    }
    
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException {
        visitor.handleOrder(this);
    }
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleOrder(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleOrder(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleOrder(this);
    }
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        CustomerView customer = this.getCustomer();
        if (customer != null) {
            ((ViewProxi)customer).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(customer.getClassId(), customer.getId())));
        }
        SupplierView supplier = this.getSupplier();
        if (supplier != null) {
            ((ViewProxi)supplier).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(supplier.getClassId(), supplier.getId())));
        }
        java.util.Vector<?> positions = this.getPositions();
        if (positions != null) {
            ViewObject.resolveVectorProxies(positions, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index == 0 && this.getSupplier() != null) return new SupplierOrderWrapper(this, originalIndex, (ViewRoot)this.getSupplier());
        if(this.getSupplier() != null) index = index - 1;
        if(index < this.getPositions().size()) return new PositionsOrderWrapper(this, originalIndex, (ViewRoot)this.getPositions().get(index));
        index = index - this.getPositions().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getSupplier() == null ? 0 : 1)
            + (this.getPositions().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getSupplier() == null ? true : false)
            && (this.getPositions().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getSupplier() != null && this.getSupplier().equals(child)) return result;
        if(this.getSupplier() != null) result = result + 1;
        java.util.Iterator<?> getPositionsIterator = this.getPositions().iterator();
        while(getPositionsIterator.hasNext()){
            if(getPositionsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    public int getOrderIdIndex() throws ModelException {
        return 0 + (this.getSupplier() == null ? 0 : 1) + this.getPositions().size();
    }
    public int getRowCount(){
        return 0 
            + 1;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
                if(rowIndex == 0) return "orderId";
                rowIndex = rowIndex - 1;
            } else {
                if(rowIndex == 0) return new Long(getOrderId());
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
            this.setOrderId(Long.parseLong(newValue));
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
            //TODO: implement setIcon in view class Order
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}