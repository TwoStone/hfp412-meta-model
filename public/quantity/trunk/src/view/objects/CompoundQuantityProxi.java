package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class CompoundQuantityProxi extends AbsQuantityProxi implements CompoundQuantityView{
    
    public CompoundQuantityProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public CompoundQuantityView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> parts_string = (java.util.Vector<String>)resultTable.get("parts");
        java.util.Vector<QuantityView> parts = ViewProxi.getProxiVector(parts_string, connectionKey);
        CompoundQuantityView result$$ = new CompoundQuantity(parts, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index < this.getParts().size()) return new PartsCompoundQuantityWrapper(this, originalIndex, (ViewRoot)this.getParts().get(index));
        index = index - this.getParts().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getParts().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getParts().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getPartsIterator = this.getParts().iterator();
        while(getPartsIterator.hasNext()){
            if(getPartsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<QuantityView> getParts() throws ModelException {
        return ((CompoundQuantity)this.getTheObject()).getParts();
    }
    public void setParts(java.util.Vector<QuantityView> newValue) throws ModelException {
        ((CompoundQuantity)this.getTheObject()).setParts(newValue);
    }
    
    public void accept(AbsQuantityVisitor visitor) throws ModelException {
        visitor.handleCompoundQuantity(this);
    }
    public <R> R accept(AbsQuantityReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleCompoundQuantity(this);
    }
    public <E extends UserException>  void accept(AbsQuantityExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleCompoundQuantity(this);
    }
    public <R, E extends UserException> R accept(AbsQuantityReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleCompoundQuantity(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleCompoundQuantity(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleCompoundQuantity(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleCompoundQuantity(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleCompoundQuantity(this);
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
