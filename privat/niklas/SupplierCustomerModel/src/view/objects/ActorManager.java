
package view.objects;

import view.*;


/* Additional import section end */

public class ActorManager extends ViewObject implements ActorManagerView{
    
    protected java.util.Vector<ActorView> actors;
    protected long nextOrderId;
    
    public ActorManager(java.util.Vector<ActorView> actors,long nextOrderId,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.actors = actors;
        this.nextOrderId = nextOrderId;        
    }
    
    static public long getTypeId() {
        return 102;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<ActorView> getActors() throws ModelException {
        return this.actors;
    }
    public void setActors(java.util.Vector<ActorView> newValue) throws ModelException {
        this.actors = newValue;
    }
    public long getNextOrderId() throws ModelException {
        return this.nextOrderId;
    }
    public void setNextOrderId(long newValue) throws ModelException {
        this.nextOrderId = newValue;
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
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        java.util.Vector<?> actors = this.getActors();
        if (actors != null) {
            ViewObject.resolveVectorProxies(actors, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
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
            //TODO: implement setIcon in view class ActorManager
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
