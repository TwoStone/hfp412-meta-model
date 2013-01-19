
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class Message extends view.objects.MessageOrLink implements MessageView{
    
    protected OperationView type;
    protected java.util.Vector<ActualParameterView> actualParameters;
    
    public Message(InstanceObjectView source,InstanceObjectView target,OperationView type,java.util.Vector<ActualParameterView> actualParameters,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super((InstanceObjectView)source,(InstanceObjectView)target,id, classId);
        this.type = type;
        this.actualParameters = actualParameters;        
    }
    
    static public long getTypeId() {
        return 205;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public OperationView getType() throws ModelException {
        return this.type;
    }
    public void setType(OperationView newValue) throws ModelException {
        this.type = newValue;
    }
    public java.util.Vector<ActualParameterView> getActualParameters() throws ModelException {
        return this.actualParameters;
    }
    public void setActualParameters(java.util.Vector<ActualParameterView> newValue) throws ModelException {
        this.actualParameters = newValue;
    }
    
    public void accept(MessageOrLinkVisitor visitor) throws ModelException {
        visitor.handleMessage(this);
    }
    public <R> R accept(MessageOrLinkReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMessage(this);
    }
    public <E extends UserException>  void accept(MessageOrLinkExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMessage(this);
    }
    public <R, E extends UserException> R accept(MessageOrLinkReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMessage(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleMessage(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMessage(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMessage(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMessage(this);
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
        OperationView type = this.getType();
        if (type != null) {
            ((ViewProxi)type).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(type.getClassId(), type.getId())));
        }
        java.util.Vector<?> actualParameters = this.getActualParameters();
        if (actualParameters != null) {
            ViewObject.resolveVectorProxies(actualParameters, resultTable);
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
        if(index == 0 && this.getType() != null) return new TypeMessageWrapper(this, originalIndex, (ViewRoot)this.getType());
        if(this.getType() != null) index = index - 1;
        if(index < this.getActualParameters().size()) return new ActualParametersMessageWrapper(this, originalIndex, (ViewRoot)this.getActualParameters().get(index));
        index = index - this.getActualParameters().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getSource() == null ? 0 : 1)
            + (this.getTarget() == null ? 0 : 1)
            + (this.getType() == null ? 0 : 1)
            + (this.getActualParameters().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getSource() == null ? true : false)
            && (this.getTarget() == null ? true : false)
            && (this.getType() == null ? true : false)
            && (this.getActualParameters().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getSource() != null && this.getSource().equals(child)) return result;
        if(this.getSource() != null) result = result + 1;
        if(this.getTarget() != null && this.getTarget().equals(child)) return result;
        if(this.getTarget() != null) result = result + 1;
        if(this.getType() != null && this.getType().equals(child)) return result;
        if(this.getType() != null) result = result + 1;
        java.util.Iterator<?> getActualParametersIterator = this.getActualParameters().iterator();
        while(getActualParametersIterator.hasNext()){
            if(getActualParametersIterator.next().equals(child)) return result;
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
    public boolean hasTransientFields(){
        return false;
    }
    /* Start of protected part that is not overridden by persistence generator */
    
    public void setIcon(IconRenderer renderer) {
        super.setIcon(renderer);
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
