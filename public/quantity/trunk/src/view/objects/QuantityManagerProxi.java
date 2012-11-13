package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class QuantityManagerProxi extends ViewProxi implements QuantityManagerView{
    
    public QuantityManagerProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public QuantityManagerView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> quantities_string = (java.util.Vector<String>)resultTable.get("quantities");
        java.util.Vector<AbsQuantityView> quantities = ViewProxi.getProxiVector(quantities_string, connectionKey);
        QuantityManagerView result$$ = new QuantityManager(quantities, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index < this.getQuantities().size()) return new QuantitiesQuantityManagerWrapper(this, originalIndex, (ViewRoot)this.getQuantities().get(index));
        index = index - this.getQuantities().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getQuantities().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getQuantities().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getQuantitiesIterator = this.getQuantities().iterator();
        while(getQuantitiesIterator.hasNext()){
            if(getQuantitiesIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<AbsQuantityView> getQuantities() throws ModelException {
        return ((QuantityManager)this.getTheObject()).getQuantities();
    }
    public void setQuantities(java.util.Vector<AbsQuantityView> newValue) throws ModelException {
        ((QuantityManager)this.getTheObject()).setQuantities(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleQuantityManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleQuantityManager(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleQuantityManager(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleQuantityManager(this);
    }
    
    public boolean hasTransientFields(){
        return false;
    }
    
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
