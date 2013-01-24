
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class Operation extends view.objects.AbsOperation implements OperationView{
    
    
    public Operation(String name,MTypeView source,MTypeView target,java.util.Vector<FormalParameterView> parameters,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super((String)name,(MTypeView)source,(MTypeView)target,parameters,id, classId);        
    }
    
    static public long getTypeId() {
        return 146;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    
    public void accept(AbsOperationVisitor visitor) throws ModelException {
        visitor.handleOperation(this);
    }
    public <R> R accept(AbsOperationReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleOperation(this);
    }
    public <E extends UserException>  void accept(AbsOperationExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleOperation(this);
    }
    public <R, E extends UserException> R accept(AbsOperationReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleOperation(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleOperation(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleOperation(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleOperation(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleOperation(this);
    }
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        MTypeView source = this.getSource();
        if (source != null) {
            ((ViewProxi)source).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(source.getClassId(), source.getId())));
        }
        MTypeView target = this.getTarget();
        if (target != null) {
            ((ViewProxi)target).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(target.getClassId(), target.getId())));
        }
        java.util.Vector<?> parameters = this.getParameters();
        if (parameters != null) {
            ViewObject.resolveVectorProxies(parameters, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index == 0 && this.getSource() != null) return new SourceAbsOperationWrapper(this, originalIndex, (ViewRoot)this.getSource());
        if(this.getSource() != null) index = index - 1;
        if(index == 0 && this.getTarget() != null) return new TargetAbsOperationWrapper(this, originalIndex, (ViewRoot)this.getTarget());
        if(this.getTarget() != null) index = index - 1;
        if(index < this.getParameters().size()) return new ParametersAbsOperationWrapper(this, originalIndex, (ViewRoot)this.getParameters().get(index));
        index = index - this.getParameters().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getSource() == null ? 0 : 1)
            + (this.getTarget() == null ? 0 : 1)
            + (this.getParameters().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getSource() == null ? true : false)
            && (this.getTarget() == null ? true : false)
            && (this.getParameters().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getSource() != null && this.getSource().equals(child)) return result;
        if(this.getSource() != null) result = result + 1;
        if(this.getTarget() != null && this.getTarget().equals(child)) return result;
        if(this.getTarget() != null) result = result + 1;
        java.util.Iterator<?> getParametersIterator = this.getParameters().iterator();
        while(getParametersIterator.hasNext()){
            if(getParametersIterator.next().equals(child)) return result;
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
