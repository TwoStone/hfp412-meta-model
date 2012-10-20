
package view.objects;

import view.*;


/* Additional import section end */

public class MetaAssociation extends view.objects.NamedEntity implements MetaAssociationView{
    
    protected AbstractMetaTypeView fromType;
    protected AbstractMetaTypeView toType;
    protected java.util.Vector<MetaHierarchyView> hierarchies;
    
    public MetaAssociation(String name,AbstractMetaTypeView fromType,AbstractMetaTypeView toType,java.util.Vector<MetaHierarchyView> hierarchies,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super((String)name,id, classId);
        this.fromType = fromType;
        this.toType = toType;
        this.hierarchies = hierarchies;        
    }
    
    static public long getTypeId() {
        return 126;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public AbstractMetaTypeView getFromType() throws ModelException {
        return this.fromType;
    }
    public void setFromType(AbstractMetaTypeView newValue) throws ModelException {
        this.fromType = newValue;
    }
    public AbstractMetaTypeView getToType() throws ModelException {
        return this.toType;
    }
    public void setToType(AbstractMetaTypeView newValue) throws ModelException {
        this.toType = newValue;
    }
    public java.util.Vector<MetaHierarchyView> getHierarchies() throws ModelException {
        return this.hierarchies;
    }
    public void setHierarchies(java.util.Vector<MetaHierarchyView> newValue) throws ModelException {
        this.hierarchies = newValue;
    }
    
    public void accept(view.visitor.NamedEntityVisitor visitor) throws ModelException {
        visitor.handleMetaAssociation(this);
    }
    public <R> R accept(view.visitor.NamedEntityReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMetaAssociation(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.NamedEntityExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMetaAssociation(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.NamedEntityReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMetaAssociation(this);
    }
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException {
        visitor.handleMetaAssociation(this);
    }
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMetaAssociation(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMetaAssociation(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMetaAssociation(this);
    }
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        AbstractMetaTypeView fromType = this.getFromType();
        if (fromType != null) {
            ((ViewProxi)fromType).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(fromType.getClassId(), fromType.getId())));
        }
        AbstractMetaTypeView toType = this.getToType();
        if (toType != null) {
            ((ViewProxi)toType).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(toType.getClassId(), toType.getId())));
        }
        java.util.Vector<?> hierarchies = this.getHierarchies();
        if (hierarchies != null) {
            ViewObject.resolveVectorProxies(hierarchies, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index == 0 && this.getFromType() != null) return new FromTypeMetaAssociationWrapper(this, originalIndex, (ViewRoot)this.getFromType());
        if(this.getFromType() != null) index = index - 1;
        if(index == 0 && this.getToType() != null) return new ToTypeMetaAssociationWrapper(this, originalIndex, (ViewRoot)this.getToType());
        if(this.getToType() != null) index = index - 1;
        if(index < this.getHierarchies().size()) return new HierarchiesMetaAssociationWrapper(this, originalIndex, (ViewRoot)this.getHierarchies().get(index));
        index = index - this.getHierarchies().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getFromType() == null ? 0 : 1)
            + (this.getToType() == null ? 0 : 1)
            + (this.getHierarchies().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getFromType() == null ? true : false)
            && (this.getToType() == null ? true : false)
            && (this.getHierarchies().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getFromType() != null && this.getFromType().equals(child)) return result;
        if(this.getFromType() != null) result = result + 1;
        if(this.getToType() != null && this.getToType().equals(child)) return result;
        if(this.getToType() != null) result = result + 1;
        java.util.Iterator<?> getHierarchiesIterator = this.getHierarchies().iterator();
        while(getHierarchiesIterator.hasNext()){
            if(getHierarchiesIterator.next().equals(child)) return result;
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
        renderer.setIcon(null);
            //TODO: implement setIcon in view class MetaAssociation
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
