
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class MAtomicType extends view.objects.MType implements MAtomicTypeView{
    
    protected String name;
    protected String singletonType;
    protected String abstractType;
    protected MAspectView aspect;
    protected MAtomicTypeView superType;
    protected java.util.Vector<MAtomicTypeView> subTypes;
    
    public MAtomicType(String name,String singletonType,String abstractType,MAspectView aspect,MAtomicTypeView superType,java.util.Vector<MAtomicTypeView> subTypes,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.name = name;
        this.singletonType = singletonType;
        this.abstractType = abstractType;
        this.aspect = aspect;
        this.superType = superType;
        this.subTypes = subTypes;        
    }
    
    static public long getTypeId() {
        return 113;
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
    public String getSingletonType() throws ModelException {
        return this.singletonType;
    }
    public void setSingletonType(String newValue) throws ModelException {
        this.singletonType = newValue;
    }
    public String getAbstractType() throws ModelException {
        return this.abstractType;
    }
    public void setAbstractType(String newValue) throws ModelException {
        this.abstractType = newValue;
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
        java.util.Vector<?> subTypes = this.getSubTypes();
        if (subTypes != null) {
            ViewObject.resolveVectorProxies(subTypes, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index < this.getSubTypes().size()) return new SubTypesMAtomicTypeWrapper(this, originalIndex, (ViewRoot)this.getSubTypes().get(index));
        index = index - this.getSubTypes().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getSubTypes().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getSubTypes().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
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
    public int getSingletonTypeIndex() throws ModelException {
        return 0 + 1;
    }
    public int getAbstractTypeIndex() throws ModelException {
        return 0 + 1 + 1;
    }
    public int getRowCount(){
        return 0 
            + 1
            + 1
            + 1;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
                if(rowIndex == 0) return "name";
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return "singletonType";
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return "abstractType";
                rowIndex = rowIndex - 1;
            } else {
                if(rowIndex == 0) return this.getName();
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return this.getSingletonType();
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return this.getAbstractType();
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
