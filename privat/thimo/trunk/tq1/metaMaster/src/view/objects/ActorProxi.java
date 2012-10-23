package view.objects;

import view.*;
import viewClient.*;

public class ActorProxi extends ViewProxi implements ActorView{
    
    public ActorProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public ActorView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String name = (String)resultTable.get("name");
        java.util.Vector<String> myRoles_string = (java.util.Vector<String>)resultTable.get("myRoles");
        java.util.Vector<RoleView> myRoles = ViewProxi.getProxiVector(myRoles_string, connectionKey);
        ActorView result$$ = new Actor((String)name,myRoles, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index < this.getMyRoles().size()) return new MyRolesActorWrapper(this, originalIndex, (ViewRoot)this.getMyRoles().get(index));
        index = index - this.getMyRoles().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getMyRoles().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getMyRoles().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getMyRolesIterator = this.getMyRoles().iterator();
        while(getMyRolesIterator.hasNext()){
            if(getMyRolesIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public String getName() throws ModelException {
        return ((Actor)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws ModelException {
        ((Actor)this.getTheObject()).setName(newValue);
    }
    public java.util.Vector<RoleView> getMyRoles() throws ModelException {
        return ((Actor)this.getTheObject()).getMyRoles();
    }
    
    public void accept(view.visitor.ActorVisitor visitor) throws ModelException {
        visitor.handleActor(this);
    }
    public <R> R accept(view.visitor.ActorReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleActor(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.ActorExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleActor(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.ActorReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleActor(this);
    }
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException {
        visitor.handleActor(this);
    }
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleActor(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleActor(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleActor(this);
    }
    
    public boolean hasTransientFields(){
        return true;
    }
    
    public void setIcon(IconRenderer renderer){
        renderer.setIcon(null);
            //TODO: implement setIcon in view class Actor
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}