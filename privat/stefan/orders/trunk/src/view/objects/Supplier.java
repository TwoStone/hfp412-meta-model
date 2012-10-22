
package view.objects;

import view.*;


/* Additional import section end */

public class Supplier extends view.objects.Role implements SupplierView{
    
    
    public Supplier(ActorView roleFor,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super((ActorView)roleFor,id, classId);        
    }
    
    static public long getTypeId() {
        return 104;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    
    public void accept(view.visitor.RoleVisitor visitor) throws ModelException {
        visitor.handleSupplier(this);
    }
    public <R> R accept(view.visitor.RoleReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleSupplier(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.RoleExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleSupplier(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.RoleReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleSupplier(this);
    }
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException {
        visitor.handleSupplier(this);
    }
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleSupplier(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleSupplier(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleSupplier(this);
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
    public boolean hasTransientFields(){
        return false;
    }
    /* Start of protected part that is not overridden by persistence generator */
    
    public void setIcon(IconRenderer renderer) {
        renderer.setIcon(null);
            //TODO: implement setIcon in view class Supplier
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
