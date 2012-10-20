
package view.objects;

import view.*;


/* Additional import section end */

public class Kunde extends view.objects.Rolle implements KundeView{
    
    
    public Kunde(AkteurView rolleFuer,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super((AkteurView)rolleFuer,id, classId);        
    }
    
    static public long getTypeId() {
        return 122;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    
    public void accept(view.visitor.RolleVisitor visitor) throws ModelException {
        visitor.handleKunde(this);
    }
    public <R> R accept(view.visitor.RolleReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleKunde(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.RolleExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleKunde(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.RolleReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleKunde(this);
    }
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException {
        visitor.handleKunde(this);
    }
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleKunde(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleKunde(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleKunde(this);
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
    public boolean hasTransientFields(){
        return false;
    }
    /* Start of protected part that is not overridden by persistence generator */
    
    public void setIcon(IconRenderer renderer) {
        renderer.setIcon(null);
            //TODO: implement setIcon in view class Kunde
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
