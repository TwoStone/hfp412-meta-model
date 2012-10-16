
package view.objects;

import view.*;


/* Additional import section end */

public class Actor extends ViewObject implements ActorView{
    
    protected String name;
    protected java.util.Vector<RoleView> myRoles;
    
    public Actor(String name,java.util.Vector<RoleView> myRoles,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.name = name;
        this.myRoles = myRoles;        
    }
    
    static public long getTypeId() {
        return 131;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public String getName() throws ModelException {
        return this.name;
    }
    public void setName(String newValue) throws ModelException {
        this.name = newValue;
    }
    public java.util.Vector<RoleView> getMyRoles() throws ModelException {
        return this.myRoles;
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
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        java.util.Vector<?> myRoles = this.getMyRoles();
        if (myRoles != null) {
            ViewObject.resolveVectorProxies(myRoles, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
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
    public int getNameIndex() throws ModelException {
        return 0;
    }
    public int getRowCount(){
        return 0 
            + 1;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
                if(rowIndex == 0) return "name";
                rowIndex = rowIndex - 1;
            } else {
                if(rowIndex == 0) return this.getName();
                rowIndex = rowIndex - 1;
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
        if(rowIndex == 0){
            this.setName(newValue);
            return;
        }
        rowIndex = rowIndex - 1;
    }
    public boolean hasTransientFields(){
        return true;
    }
    /* Start of protected part that is not overridden by persistence generator */
    
    public void setIcon(IconRenderer renderer) {
        renderer.setIcon(null);
            //TODO: implement setIcon in view class Actor
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
