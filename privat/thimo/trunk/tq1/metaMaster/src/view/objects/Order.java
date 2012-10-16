
package view.objects;

import view.*;


/* Additional import section end */

public class Order extends ViewObject implements OrderView{
    
    protected CustomerView customer;
    protected SupplierView contractor;
    protected java.util.Vector<PositionView> positions;
    
    public Order(CustomerView customer,SupplierView contractor,java.util.Vector<PositionView> positions,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.customer = customer;
        this.contractor = contractor;
        this.positions = positions;        
    }
    
    static public long getTypeId() {
        return 127;
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
    public SupplierView getContractor() throws ModelException {
        return this.contractor;
    }
    public void setContractor(SupplierView newValue) throws ModelException {
        this.contractor = newValue;
    }
    public java.util.Vector<PositionView> getPositions() throws ModelException {
        return this.positions;
    }
    public void setPositions(java.util.Vector<PositionView> newValue) throws ModelException {
        this.positions = newValue;
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
        SupplierView contractor = this.getContractor();
        if (contractor != null) {
            ((ViewProxi)contractor).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(contractor.getClassId(), contractor.getId())));
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
        if(index == 0 && this.getCustomer() != null) return new CustomerOrderWrapper(this, originalIndex, (ViewRoot)this.getCustomer());
        if(this.getCustomer() != null) index = index - 1;
        if(index == 0 && this.getContractor() != null) return new ContractorOrderWrapper(this, originalIndex, (ViewRoot)this.getContractor());
        if(this.getContractor() != null) index = index - 1;
        if(index < this.getPositions().size()) return new PositionsOrderWrapper(this, originalIndex, (ViewRoot)this.getPositions().get(index));
        index = index - this.getPositions().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getCustomer() == null ? 0 : 1)
            + (this.getContractor() == null ? 0 : 1)
            + (this.getPositions().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getCustomer() == null ? true : false)
            && (this.getContractor() == null ? true : false)
            && (this.getPositions().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getCustomer() != null && this.getCustomer().equals(child)) return result;
        if(this.getCustomer() != null) result = result + 1;
        if(this.getContractor() != null && this.getContractor().equals(child)) return result;
        if(this.getContractor() != null) result = result + 1;
        java.util.Iterator<?> getPositionsIterator = this.getPositions().iterator();
        while(getPositionsIterator.hasNext()){
            if(getPositionsIterator.next().equals(child)) return result;
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
        return false;
    }
    /* Start of protected part that is not overridden by persistence generator */
    
    public void setIcon(IconRenderer renderer) {
        renderer.setIcon(null);
            //TODO: implement setIcon in view class Order
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
