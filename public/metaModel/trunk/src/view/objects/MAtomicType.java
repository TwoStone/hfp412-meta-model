
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class MAtomicType extends ViewObject implements MAtomicTypeView{
    
    protected String name;
    protected MAspectView aspect;
    protected MAtomicTypeView superType;
    protected java.util.Vector<MType> superTypes;
    protected java.util.Vector<MAtomicTypeView> subTypes;
    
    public MAtomicType(String name,MAspectView aspect,MAtomicTypeView superType,java.util.Vector<MType> superTypes,java.util.Vector<MAtomicTypeView> subTypes,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.name = name;
        this.aspect = aspect;
        this.superType = superType;
        this.superTypes = superTypes;
        this.subTypes = subTypes;        
    }
    
    static public long getTypeId() {
        return 102;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public String getName() throws ModelException {
        return this.name;
    }
    public void setName(String newValue) throws ModelException {
        this.name = newValue;
    }
    public MAspectView getAspect() throws ModelException {
        return this.aspect;
    }
    public void setAspect(MAspectView newValue) throws ModelException {
        this.aspect = newValue;
    }
    public MAtomicTypeView getSuperType() throws ModelException {
        return this.superType;
    }
    public void setSuperType(MAtomicTypeView newValue) throws ModelException {
        this.superType = newValue;
    }
    public java.util.Vector<MType> getSuperTypes() throws ModelException {
        return this.superTypes;
    }
    public java.util.Vector<MAtomicTypeView> getSubTypes() throws ModelException {
        return this.subTypes;
    }
    
    public void accept(MTypeVisitor visitor) throws ModelException {
        visitor.handleMAtomicType(this);
    }
    public <R> R accept(MTypeReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMAtomicType(this);
    }
    public <E extends UserException>  void accept(MTypeExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMAtomicType(this);
    }
    public <R, E extends UserException> R accept(MTypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMAtomicType(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleMAtomicType(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMAtomicType(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMAtomicType(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMAtomicType(this);
    }
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        MAspectView aspect = this.getAspect();
        if (aspect != null) {
            ((ViewProxi)aspect).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(aspect.getClassId(), aspect.getId())));
        }
        MAtomicTypeView superType = this.getSuperType();
        if (superType != null) {
            ((ViewProxi)superType).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(superType.getClassId(), superType.getId())));
        }
        java.util.Vector<?> superTypes = this.getSuperTypes();
        if (superTypes != null) {
            ViewObject.resolveVectorProxies(superTypes, resultTable);
        }
        java.util.Vector<?> subTypes = this.getSubTypes();
        if (subTypes != null) {
            ViewObject.resolveVectorProxies(subTypes, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index == 0 && this.getSuperType() != null) return new SuperTypeMAtomicTypeWrapper(this, originalIndex, (ViewRoot)this.getSuperType());
        if(this.getSuperType() != null) index = index - 1;
        if(index < this.getSuperTypes().size()) return new SuperTypesMAtomicTypeWrapper(this, originalIndex, (ViewRoot)this.getSuperTypes().get(index));
        index = index - this.getSuperTypes().size();
        if(index < this.getSubTypes().size()) return new SubTypesMAtomicTypeWrapper(this, originalIndex, (ViewRoot)this.getSubTypes().get(index));
        index = index - this.getSubTypes().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getSuperType() == null ? 0 : 1)
            + (this.getSuperTypes().size())
            + (this.getSubTypes().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getSuperType() == null ? true : false)
            && (this.getSuperTypes().size() == 0)
            && (this.getSubTypes().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getSuperType() != null && this.getSuperType().equals(child)) return result;
        if(this.getSuperType() != null) result = result + 1;
        java.util.Iterator<?> getSuperTypesIterator = this.getSuperTypes().iterator();
        while(getSuperTypesIterator.hasNext()){
            if(getSuperTypesIterator.next().equals(child)) return result;
            result = result + 1;
        }
        java.util.Iterator<?> getSubTypesIterator = this.getSubTypes().iterator();
        while(getSubTypesIterator.hasNext()){
            if(getSubTypesIterator.next().equals(child)) return result;
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
        return true;
    }
    /* Start of protected part that is not overridden by persistence generator */
    
    public void setIcon(IconRenderer renderer) {
        super.setIcon(renderer);
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
