package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class MessageProxi extends MessageOrLinkProxi implements MessageView{
    
    public MessageProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public MessageView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi source = null;
        String source$String = (String)resultTable.get("source");
        if (source$String != null) {
            common.ProxiInformation source$Info = common.RPCConstantsAndServices.createProxiInformation(source$String);
            source = ViewProxi.createProxi(source$Info,connectionKey);
            source.setToString(source$Info.getToString());
        }
        ViewProxi target = null;
        String target$String = (String)resultTable.get("target");
        if (target$String != null) {
            common.ProxiInformation target$Info = common.RPCConstantsAndServices.createProxiInformation(target$String);
            target = ViewProxi.createProxi(target$Info,connectionKey);
            target.setToString(target$Info.getToString());
        }
        ViewProxi type = null;
        String type$String = (String)resultTable.get("type");
        if (type$String != null) {
            common.ProxiInformation type$Info = common.RPCConstantsAndServices.createProxiInformation(type$String);
            type = ViewProxi.createProxi(type$Info,connectionKey);
            type.setToString(type$Info.getToString());
        }
        MessageView result$$ = new Message((InstanceObjectView)source,(InstanceObjectView)target,(MOperationView)type, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index == 0 && this.getSource() != null) return new SourceMessageOrLinkWrapper(this, originalIndex, (ViewRoot)this.getSource());
        if(this.getSource() != null) index = index - 1;
        if(index == 0 && this.getTarget() != null) return new TargetMessageOrLinkWrapper(this, originalIndex, (ViewRoot)this.getTarget());
        if(this.getTarget() != null) index = index - 1;
        if(index == 0 && this.getType() != null) return new TypeMessageWrapper(this, originalIndex, (ViewRoot)this.getType());
        if(this.getType() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getSource() == null ? 0 : 1)
            + (this.getTarget() == null ? 0 : 1)
            + (this.getType() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getSource() == null ? true : false)
            && (this.getTarget() == null ? true : false)
            && (this.getType() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getSource() != null && this.getSource().equals(child)) return result;
        if(this.getSource() != null) result = result + 1;
        if(this.getTarget() != null && this.getTarget().equals(child)) return result;
        if(this.getTarget() != null) result = result + 1;
        if(this.getType() != null && this.getType().equals(child)) return result;
        if(this.getType() != null) result = result + 1;
        return -1;
    }
    
    public MOperationView getType() throws ModelException {
        return ((Message)this.getTheObject()).getType();
    }
    public void setType(MOperationView newValue) throws ModelException {
        ((Message)this.getTheObject()).setType(newValue);
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
