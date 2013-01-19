
package view.objects;

import view.*;


/* Additional import section end */

public abstract class AbsOperation extends ViewObject implements AbsOperationView{
    
    protected String name;
    protected MTypeView source;
    protected MTypeView target;
    protected java.util.Vector<FormalParameterView> parameters;
    
    public AbsOperation(String name,MTypeView source,MTypeView target,java.util.Vector<FormalParameterView> parameters,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.name = name;
        this.source = source;
        this.target = target;
        this.parameters = parameters;        
    }
    
    public String getName() throws ModelException {
        return this.name;
    }
    public void setName(String newValue) throws ModelException {
        this.name = newValue;
    }
    public MTypeView getSource() throws ModelException {
        return this.source;
    }
    public void setSource(MTypeView newValue) throws ModelException {
        this.source = newValue;
    }
    public MTypeView getTarget() throws ModelException {
        return this.target;
    }
    public void setTarget(MTypeView newValue) throws ModelException {
        this.target = newValue;
    }
    public java.util.Vector<FormalParameterView> getParameters() throws ModelException {
        return this.parameters;
    }
    public void setParameters(java.util.Vector<FormalParameterView> newValue) throws ModelException {
        this.parameters = newValue;
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
    /* Start of protected part that is not overridden by persistence generator */
    
    public void setIcon(IconRenderer renderer) {
        super.setIcon(renderer);
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
