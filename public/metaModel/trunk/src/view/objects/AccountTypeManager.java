
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class AccountTypeManager extends ViewObject implements AccountTypeManagerView{
    
    protected java.util.Vector<MAccountTypeView> accountTypes;
    
    public AccountTypeManager(java.util.Vector<MAccountTypeView> accountTypes,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.accountTypes = accountTypes;        
    }
    
    static public long getTypeId() {
        return 128;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<MAccountTypeView> getAccountTypes() throws ModelException {
        return this.accountTypes;
    }
    public void setAccountTypes(java.util.Vector<MAccountTypeView> newValue) throws ModelException {
        this.accountTypes = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleAccountTypeManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleAccountTypeManager(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleAccountTypeManager(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleAccountTypeManager(this);
    }
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        java.util.Vector<?> accountTypes = this.getAccountTypes();
        if (accountTypes != null) {
            ViewObject.resolveVectorProxies(accountTypes, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index < this.getAccountTypes().size()) return new AccountTypesAccountTypeManagerWrapper(this, originalIndex, (ViewRoot)this.getAccountTypes().get(index));
        index = index - this.getAccountTypes().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getAccountTypes().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getAccountTypes().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getAccountTypesIterator = this.getAccountTypes().iterator();
        while(getAccountTypesIterator.hasNext()){
            if(getAccountTypesIterator.next().equals(child)) return result;
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
        super.setIcon(renderer);
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
