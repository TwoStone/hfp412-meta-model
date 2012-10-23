
package view.objects;

import view.*;


/* Additional import section end */

public class MetaAspect extends view.objects.NamedEntity implements MetaAspectView{
    
    protected java.util.Vector<MetaTypeView> types;
    
    public MetaAspect(String name,java.util.Vector<MetaTypeView> types,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super((String)name,id, classId);
        this.types = types;        
    }
    
    static public long getTypeId() {
        return 119;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<MetaTypeView> getTypes() throws ModelException {
        return this.types;
    }
    
    public void accept(view.visitor.NamedEntityVisitor visitor) throws ModelException {
        visitor.handleMetaAspect(this);
    }
    public <R> R accept(view.visitor.NamedEntityReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMetaAspect(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.NamedEntityExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMetaAspect(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.NamedEntityReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMetaAspect(this);
    }
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException {
        visitor.handleMetaAspect(this);
    }
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMetaAspect(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMetaAspect(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMetaAspect(this);
    }
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        java.util.Vector<?> types = this.getTypes();
        if (types != null) {
            ViewObject.resolveVectorProxies(types, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index < this.getTypes().size()) return new TypesMetaAspectWrapper(this, originalIndex, (ViewRoot)this.getTypes().get(index));
        index = index - this.getTypes().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getTypes().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getTypes().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getTypesIterator = this.getTypes().iterator();
        while(getTypesIterator.hasNext()){
            if(getTypesIterator.next().equals(child)) return result;
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
        renderer.setIcon(null);
            //TODO: implement setIcon in view class MetaAspect
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
