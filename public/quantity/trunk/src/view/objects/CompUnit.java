
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class CompUnit extends view.objects.AbsUnit implements CompUnitView{
    
    protected java.util.Vector<ReferenceView> refs;
    
    public CompUnit(AbsUnitTypeView type,String name,java.util.Vector<ReferenceView> refs,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super((AbsUnitTypeView)type,(String)name,id, classId);
        this.refs = refs;        
    }
    
    static public long getTypeId() {
        return 118;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<ReferenceView> getRefs() throws ModelException {
        return this.refs;
    }
    public void setRefs(java.util.Vector<ReferenceView> newValue) throws ModelException {
        this.refs = newValue;
    }
    
    public void accept(AbsUnitVisitor visitor) throws ModelException {
        visitor.handleCompUnit(this);
    }
    public <R> R accept(AbsUnitReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleCompUnit(this);
    }
    public <E extends UserException>  void accept(AbsUnitExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleCompUnit(this);
    }
    public <R, E extends UserException> R accept(AbsUnitReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleCompUnit(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleCompUnit(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleCompUnit(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleCompUnit(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleCompUnit(this);
    }
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        AbsUnitTypeView type = this.getType();
        if (type != null) {
            ((ViewProxi)type).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(type.getClassId(), type.getId())));
        }
        java.util.Vector<?> refs = this.getRefs();
        if (refs != null) {
            ViewObject.resolveVectorProxies(refs, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index < this.getRefs().size()) return new RefsCompUnitWrapper(this, originalIndex, (ViewRoot)this.getRefs().get(index));
        index = index - this.getRefs().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getRefs().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getRefs().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getRefsIterator = this.getRefs().iterator();
        while(getRefsIterator.hasNext()){
            if(getRefsIterator.next().equals(child)) return result;
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
        return false;
    }
    /* Start of protected part that is not overridden by persistence generator */
    
    public void setIcon(IconRenderer renderer) {
        super.setIcon(renderer);
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
