
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class CompUnitType extends view.objects.AbsUnitType implements CompUnitTypeView{
    
    protected java.util.Vector<ReferenceTypeView> refs;
    
    public CompUnitType(AbsUnitView defaultUnit,String name,java.util.Vector<ReferenceTypeView> refs,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super((AbsUnitView)defaultUnit,(String)name,id, classId);
        this.refs = refs;        
    }
    
    static public long getTypeId() {
        return 120;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<ReferenceTypeView> getRefs() throws ModelException {
        return this.refs;
    }
    public void setRefs(java.util.Vector<ReferenceTypeView> newValue) throws ModelException {
        this.refs = newValue;
    }
    
    public void accept(AbsUnitTypeVisitor visitor) throws ModelException {
        visitor.handleCompUnitType(this);
    }
    public <R> R accept(AbsUnitTypeReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleCompUnitType(this);
    }
    public <E extends UserException>  void accept(AbsUnitTypeExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleCompUnitType(this);
    }
    public <R, E extends UserException> R accept(AbsUnitTypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleCompUnitType(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleCompUnitType(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleCompUnitType(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleCompUnitType(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleCompUnitType(this);
    }
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        AbsUnitView defaultUnit = this.getDefaultUnit();
        if (defaultUnit != null) {
            ((ViewProxi)defaultUnit).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(defaultUnit.getClassId(), defaultUnit.getId())));
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
        if(index == 0 && this.getDefaultUnit() != null) return new DefaultUnitAbsUnitTypeWrapper(this, originalIndex, (ViewRoot)this.getDefaultUnit());
        if(this.getDefaultUnit() != null) index = index - 1;
        if(index < this.getRefs().size()) return new RefsCompUnitTypeWrapper(this, originalIndex, (ViewRoot)this.getRefs().get(index));
        index = index - this.getRefs().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getDefaultUnit() == null ? 0 : 1)
            + (this.getRefs().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getDefaultUnit() == null ? true : false)
            && (this.getRefs().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getDefaultUnit() != null && this.getDefaultUnit().equals(child)) return result;
        if(this.getDefaultUnit() != null) result = result + 1;
        java.util.Iterator<?> getRefsIterator = this.getRefs().iterator();
        while(getRefsIterator.hasNext()){
            if(getRefsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    public int getNameIndex() throws ModelException {
        return 0 + (this.getDefaultUnit() == null ? 0 : 1);
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
        renderer.setIcon(null);
            //TODO: implement setIcon in view class CompUnitType
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
