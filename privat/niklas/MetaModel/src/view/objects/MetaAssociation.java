
package view.objects;

import view.*;


/* Additional import section end */

public class MetaAssociation extends view.objects.NamedEntity implements MetaAssociationView{
    
    protected AbstractMetaTypeView source;
    protected AbstractMetaTypeView target;
    protected java.util.Vector<MetaHierarchyView> hierarchies;
    
    public MetaAssociation(String name,AbstractMetaTypeView source,AbstractMetaTypeView target,java.util.Vector<MetaHierarchyView> hierarchies,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super((String)name,id, classId);
        this.source = source;
        this.target = target;
        this.hierarchies = hierarchies;        
    }
    
    static public long getTypeId() {
        return 126;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public AbstractMetaTypeView getSource() throws ModelException {
        return this.source;
    }
    public void setSource(AbstractMetaTypeView newValue) throws ModelException {
        this.source = newValue;
    }
    public AbstractMetaTypeView getTarget() throws ModelException {
        return this.target;
    }
    public void setTarget(AbstractMetaTypeView newValue) throws ModelException {
        this.target = newValue;
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
        AbstractMetaTypeView source = this.getSource();
        if (source != null) {
            ((ViewProxi)source).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(source.getClassId(), source.getId())));
        }
        AbstractMetaTypeView target = this.getTarget();
        if (target != null) {
            ((ViewProxi)target).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(target.getClassId(), target.getId())));
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
        if(index == 0 && this.getSource() != null) return new SourceMetaAssociationWrapper(this, originalIndex, (ViewRoot)this.getSource());
        if(this.getSource() != null) index = index - 1;
        if(index == 0 && this.getTarget() != null) return new TargetMetaAssociationWrapper(this, originalIndex, (ViewRoot)this.getTarget());
        if(this.getTarget() != null) index = index - 1;
        if(index < this.getHierarchies().size()) return new HierarchiesMetaAssociationWrapper(this, originalIndex, (ViewRoot)this.getHierarchies().get(index));
        index = index - this.getHierarchies().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getSource() == null ? 0 : 1)
            + (this.getTarget() == null ? 0 : 1)
            + (this.getHierarchies().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getSource() == null ? true : false)
            && (this.getTarget() == null ? true : false)
            && (this.getHierarchies().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getSource() != null && this.getSource().equals(child)) return result;
        if(this.getSource() != null) result = result + 1;
        if(this.getTarget() != null && this.getTarget().equals(child)) return result;
        if(this.getTarget() != null) result = result + 1;
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
