
package view.objects;

import view.*;


/* Additional import section end */

public abstract class Role extends ViewObject implements RoleView{
    
    protected ActorView roleFor;
    
    public Role(ActorView roleFor,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.roleFor = roleFor;        
    }
    
    public ActorView getRoleFor() throws ModelException {
        return this.roleFor;
    }
    public void setRoleFor(ActorView newValue) throws ModelException {
        this.roleFor = newValue;
    }
    
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        ActorView roleFor = this.getRoleFor();
        if (roleFor != null) {
            ((ViewProxi)roleFor).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(roleFor.getClassId(), roleFor.getId())));
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
