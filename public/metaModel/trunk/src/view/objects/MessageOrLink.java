
package view.objects;

import view.*;


/* Additional import section end */

public abstract class MessageOrLink extends ViewObject implements MessageOrLinkView{
    
    protected InstanceObjectView source;
    protected InstanceObjectView target;
    
    public MessageOrLink(InstanceObjectView source,InstanceObjectView target,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.source = source;
        this.target = target;        
    }
    
    public InstanceObjectView getSource() throws ModelException {
        return this.source;
    }
    public void setSource(InstanceObjectView newValue) throws ModelException {
        this.source = newValue;
    }
    public InstanceObjectView getTarget() throws ModelException {
        return this.target;
    }
    public void setTarget(InstanceObjectView newValue) throws ModelException {
        this.target = newValue;
    }
    
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        InstanceObjectView source = this.getSource();
        if (source != null) {
            ((ViewProxi)source).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(source.getClassId(), source.getId())));
        }
        InstanceObjectView target = this.getTarget();
        if (target != null) {
            ((ViewProxi)target).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(target.getClassId(), target.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index == 0 && this.getSource() != null) return new SourceMessageOrLinkWrapper(this, originalIndex, (ViewRoot)this.getSource());
        if(this.getSource() != null) index = index - 1;
        if(index == 0 && this.getTarget() != null) return new TargetMessageOrLinkWrapper(this, originalIndex, (ViewRoot)this.getTarget());
        if(this.getTarget() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getSource() == null ? 0 : 1)
            + (this.getTarget() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getSource() == null ? true : false)
            && (this.getTarget() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getSource() != null && this.getSource().equals(child)) return result;
        if(this.getSource() != null) result = result + 1;
        if(this.getTarget() != null && this.getTarget().equals(child)) return result;
        if(this.getTarget() != null) result = result + 1;
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
        super.setIcon(renderer);
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
