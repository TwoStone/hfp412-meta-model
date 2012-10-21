package view.objects;

import view.*;
import viewClient.*;

public class OrderProxi extends ViewProxi implements OrderView{
    
    public OrderProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public OrderView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> items_string = (java.util.Vector<String>)resultTable.get("items");
        java.util.Vector<OrderItemView> items = ViewProxi.getProxiVector(items_string, connectionKey);
        ViewProxi customer = null;
        String customer$String = (String)resultTable.get("customer");
        if (customer$String != null) {
            common.ProxiInformation customer$Info = common.RPCConstantsAndServices.createProxiInformation(customer$String);
            customer = ViewProxi.createProxi(customer$Info,connectionKey);
            customer.setToString(customer$Info.getToString());
        }
        ViewProxi contractor = null;
        String contractor$String = (String)resultTable.get("contractor");
        if (contractor$String != null) {
            common.ProxiInformation contractor$Info = common.RPCConstantsAndServices.createProxiInformation(contractor$String);
            contractor = ViewProxi.createProxi(contractor$Info,connectionKey);
            contractor.setToString(contractor$Info.getToString());
        }
        OrderView result$$ = new Order(items,(CustomerView)customer,(SupplierView)contractor, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index < this.getItems().size()) return new ItemsOrderWrapper(this, originalIndex, (ViewRoot)this.getItems().get(index));
        index = index - this.getItems().size();
        if(index == 0 && this.getCustomer() != null) return new CustomerOrderWrapper(this, originalIndex, (ViewRoot)this.getCustomer());
        if(this.getCustomer() != null) index = index - 1;
        if(index == 0 && this.getContractor() != null) return new ContractorOrderWrapper(this, originalIndex, (ViewRoot)this.getContractor());
        if(this.getContractor() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getItems().size())
            + (this.getCustomer() == null ? 0 : 1)
            + (this.getContractor() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getItems().size() == 0)
            && (this.getCustomer() == null ? true : false)
            && (this.getContractor() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getItemsIterator = this.getItems().iterator();
        while(getItemsIterator.hasNext()){
            if(getItemsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        if(this.getCustomer() != null && this.getCustomer().equals(child)) return result;
        if(this.getCustomer() != null) result = result + 1;
        if(this.getContractor() != null && this.getContractor().equals(child)) return result;
        if(this.getContractor() != null) result = result + 1;
        return -1;
    }
    
    public java.util.Vector<OrderItemView> getItems() throws ModelException {
        return ((Order)this.getTheObject()).getItems();
    }
    public void setItems(java.util.Vector<OrderItemView> newValue) throws ModelException {
        ((Order)this.getTheObject()).setItems(newValue);
    }
    public CustomerView getCustomer() throws ModelException {
        return ((Order)this.getTheObject()).getCustomer();
    }
    public void setCustomer(CustomerView newValue) throws ModelException {
        ((Order)this.getTheObject()).setCustomer(newValue);
    }
    public SupplierView getContractor() throws ModelException {
        return ((Order)this.getTheObject()).getContractor();
    }
    public void setContractor(SupplierView newValue) throws ModelException {
        ((Order)this.getTheObject()).setContractor(newValue);
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
    
    public boolean hasTransientFields(){
        return false;
    }
    
    public void setIcon(IconRenderer renderer){
        renderer.setIcon(null);
            //TODO: implement setIcon in view class Order
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
