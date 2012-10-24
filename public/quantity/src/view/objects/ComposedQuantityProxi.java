package view.objects;

import view.*;
import viewClient.*;

public class ComposedQuantityProxi extends AbsQuantityProxi implements ComposedQuantityView{
    
    public ComposedQuantityProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public ComposedQuantityView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> parts_string = (java.util.Vector<String>)resultTable.get("parts");
        java.util.Vector<QuantityView> parts = ViewProxi.getProxiVector(parts_string, connectionKey);
        ComposedQuantityView result$$ = new ComposedQuantity(parts, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index < this.getParts().size()) return new PartsComposedQuantityWrapper(this, originalIndex, (ViewRoot)this.getParts().get(index));
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
        return ((ComposedQuantity)this.getTheObject()).getParts();
    }
    public void setParts(java.util.Vector<QuantityView> newValue) throws ModelException {
        ((ComposedQuantity)this.getTheObject()).setParts(newValue);
    }
    
    public void accept(view.visitor.AbsQuantityVisitor visitor) throws ModelException {
        visitor.handleComposedQuantity(this);
    }
    public <R> R accept(view.visitor.AbsQuantityReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleComposedQuantity(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AbsQuantityExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleComposedQuantity(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AbsQuantityReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleComposedQuantity(this);
    }
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException {
        visitor.handleComposedQuantity(this);
    }
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleComposedQuantity(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleComposedQuantity(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleComposedQuantity(this);
    }
    
    public boolean hasTransientFields(){
        return false;
    }
    
    public void setIcon(IconRenderer renderer){
        renderer.setIcon(null);
            //TODO: implement setIcon in view class ComposedQuantity
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
