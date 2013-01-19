package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class ActualParameterProxi extends ViewProxi implements ActualParameterView{
    
    public ActualParameterProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public ActualParameterView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi type = null;
        String type$String = (String)resultTable.get("type");
        if (type$String != null) {
            common.ProxiInformation type$Info = common.RPCConstantsAndServices.createProxiInformation(type$String);
            type = ViewProxi.createProxi(type$Info,connectionKey);
            type.setToString(type$Info.getToString());
        }
        ViewProxi value = null;
        String value$String = (String)resultTable.get("value");
        if (value$String != null) {
            common.ProxiInformation value$Info = common.RPCConstantsAndServices.createProxiInformation(value$String);
            value = ViewProxi.createProxi(value$Info,connectionKey);
            value.setToString(value$Info.getToString());
        }
        ActualParameterView result$$ = new ActualParameter((FormalParameterView)type,(InstanceObjectView)value, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index == 0 && this.getType() != null) return new TypeActualParameterWrapper(this, originalIndex, (ViewRoot)this.getType());
        if(this.getType() != null) index = index - 1;
        if(index == 0 && this.getValue() != null) return new ValueActualParameterWrapper(this, originalIndex, (ViewRoot)this.getValue());
        if(this.getValue() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getType() == null ? 0 : 1)
            + (this.getValue() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getType() == null ? true : false)
            && (this.getValue() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getType() != null && this.getType().equals(child)) return result;
        if(this.getType() != null) result = result + 1;
        if(this.getValue() != null && this.getValue().equals(child)) return result;
        if(this.getValue() != null) result = result + 1;
        return -1;
    }
    
    public FormalParameterView getType() throws ModelException {
        return ((ActualParameter)this.getTheObject()).getType();
    }
    public void setType(FormalParameterView newValue) throws ModelException {
        ((ActualParameter)this.getTheObject()).setType(newValue);
    }
    public InstanceObjectView getValue() throws ModelException {
        return ((ActualParameter)this.getTheObject()).getValue();
    }
    public void setValue(InstanceObjectView newValue) throws ModelException {
        ((ActualParameter)this.getTheObject()).setValue(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleActualParameter(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleActualParameter(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleActualParameter(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleActualParameter(this);
    }
    
    public boolean hasTransientFields(){
        return false;
    }
    
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
