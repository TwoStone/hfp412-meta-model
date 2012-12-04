
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class MAssociation extends ViewObject implements MAssociationView{
    
    protected String name;
    protected MType source;
    protected MType target;
    protected java.util.Vector<MAHierarchyView> hierarchies;
    
    public MAssociation(String name,MType source,MType target,java.util.Vector<MAHierarchyView> hierarchies,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.name = name;
        this.source = source;
        this.target = target;
        this.hierarchies = hierarchies;        
    }
    
    static public long getTypeId() {
        return 143;
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
    public MType getSource() throws ModelException {
        return this.source;
    }
    public void setSource(MType newValue) throws ModelException {
        this.source = newValue;
    }
    public MType getTarget() throws ModelException {
        return this.target;
    }
    public void setTarget(MType newValue) throws ModelException {
        this.target = newValue;
    }
    public java.util.Vector<MAHierarchyView> getHierarchies() throws ModelException {
        return this.hierarchies;
    }
    public void setHierarchies(java.util.Vector<MAHierarchyView> newValue) throws ModelException {
        this.hierarchies = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleMAssociation(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMAssociation(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMAssociation(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMAssociation(this);
    }
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        MType source = this.getSource();
        if (source != null) {
            ((ViewProxi)source).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(source.getClassId(), source.getId())));
        }
        MType target = this.getTarget();
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
        if(index == 0 && this.getSource() != null) return new SourceMAssociationWrapper(this, originalIndex, (ViewRoot)this.getSource());
        if(this.getSource() != null) index = index - 1;
        if(index == 0 && this.getTarget() != null) return new TargetMAssociationWrapper(this, originalIndex, (ViewRoot)this.getTarget());
        if(this.getTarget() != null) index = index - 1;
        if(index < this.getHierarchies().size()) return new HierarchiesMAssociationWrapper(this, originalIndex, (ViewRoot)this.getHierarchies().get(index));
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
        super.setIcon(renderer);
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}