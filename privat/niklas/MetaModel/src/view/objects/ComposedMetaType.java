
package view.objects;

import view.*;


/* Additional import section end */

public abstract class ComposedMetaType extends view.objects.AbstractMetaType implements ComposedMetaTypeView{
    
    protected java.util.Vector<AbstractMetaTypeView> components;
    protected OrMetaTypeView disjunctiveNormalform;
    
    public ComposedMetaType(java.util.Vector<AbstractMetaTypeView> components,OrMetaTypeView disjunctiveNormalform,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.components = components;
        this.disjunctiveNormalform = disjunctiveNormalform;        
    }
    
    public java.util.Vector<AbstractMetaTypeView> getComponents() throws ModelException {
        return this.components;
    }
    public void setComponents(java.util.Vector<AbstractMetaTypeView> newValue) throws ModelException {
        this.components = newValue;
    }
    public OrMetaTypeView getDisjunctiveNormalform() throws ModelException {
        return this.disjunctiveNormalform;
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
    /* Start of protected part that is not overridden by persistence generator */
    
    public void setIcon(IconRenderer renderer) {
        renderer.setIcon(null);
            //TODO: implement setIcon in view class ComposedMetaType
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
