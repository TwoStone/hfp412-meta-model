
package view.objects;

import view.*;


/* Additional import section end */

public class TransactionManager extends ViewObject implements TransactionManagerView{
    
    protected java.util.Vector<AkteurView> akteure;
    
    public TransactionManager(java.util.Vector<AkteurView> akteure,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.akteure = akteure;        
    }
    
    static public long getTypeId() {
        return 129;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<AkteurView> getAkteure() throws ModelException {
        return this.akteure;
    }
    public void setAkteure(java.util.Vector<AkteurView> newValue) throws ModelException {
        this.akteure = newValue;
    }
    
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException {
        visitor.handleTransactionManager(this);
    }
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleTransactionManager(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleTransactionManager(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleTransactionManager(this);
    }
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        java.util.Vector<?> akteure = this.getAkteure();
        if (akteure != null) {
            ViewObject.resolveVectorProxies(akteure, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index < this.getAkteure().size()) return new AkteureTransactionManagerWrapper(this, originalIndex, (ViewRoot)this.getAkteure().get(index));
        index = index - this.getAkteure().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getAkteure().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getAkteure().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getAkteureIterator = this.getAkteure().iterator();
        while(getAkteureIterator.hasNext()){
            if(getAkteureIterator.next().equals(child)) return result;
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
            //TODO: implement setIcon in view class TransactionManager
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
