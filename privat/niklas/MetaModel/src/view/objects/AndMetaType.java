
package view.objects;

import view.*;


/* Additional import section end */

public class AndMetaType extends view.objects.ComposedMetaType implements AndMetaTypeView{
    
    
    public AndMetaType(java.util.Vector<AbstractMetaTypeView> components,OrMetaTypeView disjunctiveNormalform,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(components,(OrMetaTypeView)disjunctiveNormalform,id, classId);        
    }
    
    static public long getTypeId() {
        return 118;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    
    public void accept(view.visitor.ComposedMetaTypeVisitor visitor) throws ModelException {
        visitor.handleAndMetaType(this);
    }
    public <R> R accept(view.visitor.ComposedMetaTypeReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleAndMetaType(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.ComposedMetaTypeExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleAndMetaType(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.ComposedMetaTypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleAndMetaType(this);
    }
    public void accept(view.visitor.AbstractMetaTypeVisitor visitor) throws ModelException {
        visitor.handleAndMetaType(this);
    }
    public <R> R accept(view.visitor.AbstractMetaTypeReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleAndMetaType(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AbstractMetaTypeExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleAndMetaType(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AbstractMetaTypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleAndMetaType(this);
    }
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException {
        visitor.handleAndMetaType(this);
    }
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleAndMetaType(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleAndMetaType(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleAndMetaType(this);
    }
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        java.util.Vector<?> components = this.getComponents();
        if (components != null) {
            ViewObject.resolveVectorProxies(components, resultTable);
        }
        OrMetaTypeView disjunctiveNormalform = this.getDisjunctiveNormalform();
        if (disjunctiveNormalform != null) {
            ((ViewProxi)disjunctiveNormalform).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(disjunctiveNormalform.getClassId(), disjunctiveNormalform.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index < this.getComponents().size()) return new ComponentsComposedMetaTypeWrapper(this, originalIndex, (ViewRoot)this.getComponents().get(index));
        index = index - this.getComponents().size();
        if(index == 0 && this.getDisjunctiveNormalform() != null) return new DisjunctiveNormalformComposedMetaTypeWrapper(this, originalIndex, (ViewRoot)this.getDisjunctiveNormalform());
        if(this.getDisjunctiveNormalform() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getComponents().size())
            + (this.getDisjunctiveNormalform() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getComponents().size() == 0)
            && (this.getDisjunctiveNormalform() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getComponentsIterator = this.getComponents().iterator();
        while(getComponentsIterator.hasNext()){
            if(getComponentsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        if(this.getDisjunctiveNormalform() != null && this.getDisjunctiveNormalform().equals(child)) return result;
        if(this.getDisjunctiveNormalform() != null) result = result + 1;
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
        return true;
    }
    /* Start of protected part that is not overridden by persistence generator */
    
    public void setIcon(IconRenderer renderer) {
        renderer.setIcon(null);
            //TODO: implement setIcon in view class AndMetaType
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
