
package view.objects;

import view.*;


/* Additional import section end */

public class MetaType extends view.objects.AbstractMetaType implements MetaTypeView{
    
    protected java.util.Vector<MetaTypeView> subtypes;
    protected MetaAspectView myAspect;
    protected NamedEntityView myCONCNamedEntity;
    
    public MetaType(java.util.Vector<MetaTypeView> subtypes,MetaAspectView myAspect,NamedEntityView myCONCNamedEntity,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.subtypes = subtypes;
        this.myAspect = myAspect;
        this.myCONCNamedEntity = myCONCNamedEntity;        
    }
    
    static public long getTypeId() {
        return 122;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<MetaTypeView> getSubtypes() throws ModelException {
        return this.subtypes;
    }
    public void setSubtypes(java.util.Vector<MetaTypeView> newValue) throws ModelException {
        this.subtypes = newValue;
    }
    public MetaAspectView getMyAspect() throws ModelException {
        return this.myAspect;
    }
    public void setMyAspect(MetaAspectView newValue) throws ModelException {
        this.myAspect = newValue;
    }
    public NamedEntityView getMyCONCNamedEntity() throws ModelException {
        return this.myCONCNamedEntity;
    }
    public void setMyCONCNamedEntity(NamedEntityView newValue) throws ModelException {
        this.myCONCNamedEntity = newValue;
    }
    public String getName() throws ModelException {
        return this.getMyCONCNamedEntity().getName();
    }
    public void setName(String newValue) throws ModelException {
        this.getMyCONCNamedEntity().setName(newValue);
    }
    
    public void accept(view.visitor.AbstractMetaTypeVisitor visitor) throws ModelException {
        visitor.handleMetaType(this);
    }
    public <R> R accept(view.visitor.AbstractMetaTypeReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMetaType(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AbstractMetaTypeExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMetaType(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AbstractMetaTypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMetaType(this);
    }
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException {
        visitor.handleMetaType(this);
    }
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMetaType(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMetaType(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMetaType(this);
    }
    public void accept(view.visitor.NamedEntityVisitor visitor) throws ModelException {
        visitor.handleMetaType(this);
    }
    public <R> R accept(view.visitor.NamedEntityReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMetaType(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.NamedEntityExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMetaType(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.NamedEntityReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMetaType(this);
    }
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        java.util.Vector<?> subtypes = this.getSubtypes();
        if (subtypes != null) {
            ViewObject.resolveVectorProxies(subtypes, resultTable);
        }
        MetaAspectView myAspect = this.getMyAspect();
        if (myAspect != null) {
            ((ViewProxi)myAspect).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(myAspect.getClassId(), myAspect.getId())));
        }
        NamedEntityView myCONCNamedEntity = this.getMyCONCNamedEntity();
        if (myCONCNamedEntity != null) {
            ((ViewProxi)myCONCNamedEntity).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(myCONCNamedEntity.getClassId(), myCONCNamedEntity.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index < this.getSubtypes().size()) return new SubtypesMetaTypeWrapper(this, originalIndex, (ViewRoot)this.getSubtypes().get(index));
        index = index - this.getSubtypes().size();
        if(index == 0 && this.getMyAspect() != null) return new MyAspectMetaTypeWrapper(this, originalIndex, (ViewRoot)this.getMyAspect());
        if(this.getMyAspect() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getSubtypes().size())
            + (this.getMyAspect() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getSubtypes().size() == 0)
            && (this.getMyAspect() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getSubtypesIterator = this.getSubtypes().iterator();
        while(getSubtypesIterator.hasNext()){
            if(getSubtypesIterator.next().equals(child)) return result;
            result = result + 1;
        }
        if(this.getMyAspect() != null && this.getMyAspect().equals(child)) return result;
        if(this.getMyAspect() != null) result = result + 1;
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
        renderer.setIcon(null);
            //TODO: implement setIcon in view class MetaType
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
