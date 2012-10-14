
package view.objects;

import view.*;


/* Additional import section end */

public abstract class Actor extends ViewObject implements ActorView{
    
    protected String name;
    protected java.util.Vector<RoleView> roles;
    
    public Actor(String name,java.util.Vector<RoleView> roles,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.name = name;
        this.roles = roles;        
    }
    
    public String getName() throws ModelException {
        return this.name;
    }
    public void setName(String newValue) throws ModelException {
        this.name = newValue;
    }
    public java.util.Vector<RoleView> getRoles() throws ModelException {
        return this.roles;
    }
    
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        java.util.Vector<?> roles = this.getRoles();
        if (roles != null) {
            ViewObject.resolveVectorProxies(roles, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
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
    /* Start of protected part that is not overridden by persistence generator */
    
    public void setIcon(IconRenderer renderer) {
        renderer.setIcon(null);
            //TODO: implement setIcon in view class Actor
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
