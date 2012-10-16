package view.objects;

import view.*;
import viewClient.*;

public class JuristicPersonProxi extends ActorProxi implements JuristicPersonView{
    
    public JuristicPersonProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public JuristicPersonView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String name = (String)resultTable.get("name");
        java.util.Vector<String> roles_string = (java.util.Vector<String>)resultTable.get("roles");
        java.util.Vector<RoleView> roles = ViewProxi.getProxiVector(roles_string, connectionKey);
        JuristicPersonView result$$ = new JuristicPerson((String)name,roles, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index < this.getRoles().size()) return new RolesActorWrapper(this, originalIndex, (ViewRoot)this.getRoles().get(index));
        index = index - this.getRoles().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getRoles().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getRoles().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getRolesIterator = this.getRoles().iterator();
        while(getRolesIterator.hasNext()){
            if(getRolesIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    
    public void accept(view.visitor.ActorVisitor visitor) throws ModelException {
        visitor.handleJuristicPerson(this);
    }
    public <R> R accept(view.visitor.ActorReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleJuristicPerson(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.ActorExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleJuristicPerson(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.ActorReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleJuristicPerson(this);
    }
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException {
        visitor.handleJuristicPerson(this);
    }
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleJuristicPerson(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleJuristicPerson(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleJuristicPerson(this);
    }
    
    public boolean hasTransientFields(){
        return true;
    }
    
    public void setIcon(IconRenderer renderer){
        renderer.setIcon(null);
            //TODO: implement setIcon in view class JuristicPerson
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
