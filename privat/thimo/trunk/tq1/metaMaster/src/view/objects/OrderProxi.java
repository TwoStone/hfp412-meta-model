package view.objects;

import view.*;
import viewClient.*;

public class OrderProxi extends ViewProxi implements OrderView{
    
    public OrderProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public OrderView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
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
        java.util.Vector<String> positions_string = (java.util.Vector<String>)resultTable.get("positions");
        java.util.Vector<PositionView> positions = ViewProxi.getProxiVector(positions_string, connectionKey);
        OrderView result$$ = new Order((CustomerView)customer,(SupplierView)contractor,positions, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
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
        if (this.object == null) return this.getLeafInfo() == 0;
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
    public java.util.Vector<PositionView> getPositions() throws ModelException {
        return ((Order)this.getTheObject()).getPositions();
    }
    public void setPositions(java.util.Vector<PositionView> newValue) throws ModelException {
        ((Order)this.getTheObject()).setPositions(newValue);
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
