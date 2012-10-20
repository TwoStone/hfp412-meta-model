
package view.objects;

import view.*;


/* Additional import section end */

public abstract class ComposedMetaType extends view.objects.AbstractMetaType implements ComposedMetaTypeView{
    
    protected java.util.Vector<AbstractMetaTypeView> components;
    
    public ComposedMetaType(java.util.Vector<AbstractMetaTypeView> components,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.components = components;        
    }
    
    public java.util.Vector<AbstractMetaTypeView> getComponents() throws ModelException {
        return this.components;
    }
    public void setComponents(java.util.Vector<AbstractMetaTypeView> newValue) throws ModelException {
        this.components = newValue;
    }
    
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        java.util.Vector<?> components = this.getComponents();
        if (components != null) {
            ViewObject.resolveVectorProxies(components, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index < this.getComponents().size()) return new ComponentsComposedMetaTypeWrapper(this, originalIndex, (ViewRoot)this.getComponents().get(index));
        index = index - this.getComponents().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getComponents().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getComponents().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getComponentsIterator = this.getComponents().iterator();
        while(getComponentsIterator.hasNext()){
            if(getComponentsIterator.next().equals(child)) return result;
            result = result + 1;
        }
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
