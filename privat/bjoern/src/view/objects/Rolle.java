
package view.objects;

import view.*;


/* Additional import section end */

public abstract class Rolle extends ViewObject implements RolleView{
    
    protected AkteurView rolleFuer;
    
    public Rolle(AkteurView rolleFuer,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.rolleFuer = rolleFuer;        
    }
    
    public AkteurView getRolleFuer() throws ModelException {
        return this.rolleFuer;
    }
    public void setRolleFuer(AkteurView newValue) throws ModelException {
        this.rolleFuer = newValue;
    }
    
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        AkteurView rolleFuer = this.getRolleFuer();
        if (rolleFuer != null) {
            ((ViewProxi)rolleFuer).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(rolleFuer.getClassId(), rolleFuer.getId())));
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
            //TODO: implement setIcon in view class Rolle
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
