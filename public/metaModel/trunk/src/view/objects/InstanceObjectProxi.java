package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class InstanceObjectProxi extends ViewProxi implements InstanceObjectView{
    
    public InstanceObjectProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public InstanceObjectView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi type = null;
        String type$String = (String)resultTable.get("type");
        if (type$String != null) {
            common.ProxiInformation type$Info = common.RPCConstantsAndServices.createProxiInformation(type$String);
            type = ViewProxi.createProxi(type$Info,connectionKey);
            type.setToString(type$Info.getToString());
        }
        InstanceObjectView result$$ = new InstanceObject((MAtomicTypeView)type, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index == 0 && this.getType() != null) return new TypeInstanceObjectWrapper(this, originalIndex, (ViewRoot)this.getType());
        if(this.getType() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getType() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getType() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getType() != null && this.getType().equals(child)) return result;
        if(this.getType() != null) result = result + 1;
        return -1;
    }
    
    public MAtomicTypeView getType() throws ModelException {
        return ((InstanceObject)this.getTheObject()).getType();
    }
    public void setType(MAtomicTypeView newValue) throws ModelException {
        ((InstanceObject)this.getTheObject()).setType(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleInstanceObject(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleInstanceObject(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleInstanceObject(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleInstanceObject(this);
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
