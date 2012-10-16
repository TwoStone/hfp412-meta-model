
package view.objects;

import view.*;


/* Additional import section end */

public class Order extends ViewObject implements OrderView{
    
    protected PositionView position;
    protected CustomerView customer;
    protected SupplierView contractor;
    
    public Order(PositionView position,CustomerView customer,SupplierView contractor,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.position = position;
        this.customer = customer;
        this.contractor = contractor;        
    }
    
    static public long getTypeId() {
        return 107;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public PositionView getPosition() throws ModelException {
        return this.position;
    }
    public void setPosition(PositionView newValue) throws ModelException {
        this.position = newValue;
    }
    public CustomerView getCustomer() throws ModelException {
        return this.customer;
    }
    public void setCustomer(CustomerView newValue) throws ModelException {
        this.customer = newValue;
    }
    public SupplierView getContractor() throws ModelException {
        return this.contractor;
    }
    public void setContractor(SupplierView newValue) throws ModelException {
        this.contractor = newValue;
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
        PositionView position = this.getPosition();
        if (position != null) {
            ((ViewProxi)position).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(position.getClassId(), position.getId())));
        }
        CustomerView customer = this.getCustomer();
        if (customer != null) {
            ((ViewProxi)customer).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(customer.getClassId(), customer.getId())));
        }
        SupplierView contractor = this.getContractor();
        if (contractor != null) {
            ((ViewProxi)contractor).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(contractor.getClassId(), contractor.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index == 0 && this.getPosition() != null) return new PositionOrderWrapper(this, originalIndex, (ViewRoot)this.getPosition());
        if(this.getPosition() != null) index = index - 1;
        if(index == 0 && this.getCustomer() != null) return new CustomerOrderWrapper(this, originalIndex, (ViewRoot)this.getCustomer());
        if(this.getCustomer() != null) index = index - 1;
        if(index == 0 && this.getContractor() != null) return new ContractorOrderWrapper(this, originalIndex, (ViewRoot)this.getContractor());
        if(this.getContractor() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getPosition() == null ? 0 : 1)
            + (this.getCustomer() == null ? 0 : 1)
            + (this.getContractor() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getPosition() == null ? true : false)
            && (this.getCustomer() == null ? true : false)
            && (this.getContractor() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getPosition() != null && this.getPosition().equals(child)) return result;
        if(this.getPosition() != null) result = result + 1;
        if(this.getCustomer() != null && this.getCustomer().equals(child)) return result;
        if(this.getCustomer() != null) result = result + 1;
        if(this.getContractor() != null && this.getContractor().equals(child)) return result;
        if(this.getContractor() != null) result = result + 1;
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
            //TODO: implement setIcon in view class Order
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
