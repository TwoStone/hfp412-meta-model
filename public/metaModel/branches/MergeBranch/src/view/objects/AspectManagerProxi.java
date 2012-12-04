package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class AspectManagerProxi extends ViewProxi implements AspectManagerView{
    
    public AspectManagerProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public AspectManagerView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> aspects_string = (java.util.Vector<String>)resultTable.get("aspects");
        java.util.Vector<MAspectView> aspects = ViewProxi.getProxiVector(aspects_string, connectionKey);
        AspectManagerView result$$ = new AspectManager(aspects, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index < this.getAspects().size()) return new AspectsAspectManagerWrapper(this, originalIndex, (ViewRoot)this.getAspects().get(index));
        index = index - this.getAspects().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getAspects().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getAspects().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getAspectsIterator = this.getAspects().iterator();
        while(getAspectsIterator.hasNext()){
            if(getAspectsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<MAspectView> getAspects() throws ModelException {
        return ((AspectManager)this.getTheObject()).getAspects();
    }
    public void setAspects(java.util.Vector<MAspectView> newValue) throws ModelException {
        ((AspectManager)this.getTheObject()).setAspects(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleAspectManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleAspectManager(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleAspectManager(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleAspectManager(this);
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
