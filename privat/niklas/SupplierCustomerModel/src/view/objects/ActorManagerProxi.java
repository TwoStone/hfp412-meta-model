package view.objects;

import view.*;
import viewClient.*;

public class ActorManagerProxi extends ViewProxi implements ActorManagerView{
    
    public ActorManagerProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public ActorManagerView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> actors_string = (java.util.Vector<String>)resultTable.get("actors");
        java.util.Vector<ActorView> actors = ViewProxi.getProxiVector(actors_string, connectionKey);
        long nextOrderId = new Long((String)resultTable.get("nextOrderId")).longValue();
        ActorManagerView result$$ = new ActorManager(actors,(long)nextOrderId, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index < this.getActors().size()) return new ActorsActorManagerWrapper(this, originalIndex, (ViewRoot)this.getActors().get(index));
        index = index - this.getActors().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getActors().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getActors().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getActorsIterator = this.getActors().iterator();
        while(getActorsIterator.hasNext()){
            if(getActorsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<ActorView> getActors() throws ModelException {
        return ((ActorManager)this.getTheObject()).getActors();
    }
    public void setActors(java.util.Vector<ActorView> newValue) throws ModelException {
        ((ActorManager)this.getTheObject()).setActors(newValue);
    }
    public long getNextOrderId() throws ModelException {
        return ((ActorManager)this.getTheObject()).getNextOrderId();
    }
    public void setNextOrderId(long newValue) throws ModelException {
        ((ActorManager)this.getTheObject()).setNextOrderId(newValue);
    }
    
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException {
        visitor.handleActorManager(this);
    }
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleActorManager(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleActorManager(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleActorManager(this);
    }
    
    public boolean hasTransientFields(){
        return false;
    }
    
    public void setIcon(IconRenderer renderer){
        renderer.setIcon(null);
            //TODO: implement setIcon in view class ActorManager
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
