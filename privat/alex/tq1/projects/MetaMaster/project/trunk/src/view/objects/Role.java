
package view.objects;

import view.*;


/* Additional import section end */

public abstract class Role extends ViewObject implements RoleView{
    
    protected ActorView owner;
    
    public Role(ActorView owner,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.owner = owner;        
    }
    
    public ActorView getOwner() throws ModelException {
        return this.owner;
    }
    public void setOwner(ActorView newValue) throws ModelException {
        this.owner = newValue;
    }
    
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        ActorView owner = this.getOwner();
        if (owner != null) {
            ((ViewProxi)owner).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(owner.getClassId(), owner.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 ;
    }
    public boolean isLeaf() throws ModelException {
        return true;
    }
    public int getIndexOfChild(Object child) throws ModelException {
        
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
    /* Start of protected part that is not overridden by persistence generator */
    
    public void setIcon(IconRenderer renderer) {
        renderer.setIcon(null);
            //TODO: implement setIcon in view class Role
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
