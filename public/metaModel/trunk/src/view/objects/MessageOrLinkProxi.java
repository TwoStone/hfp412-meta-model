package view.objects;

import view.*;
import viewClient.*;

public abstract class MessageOrLinkProxi extends ViewProxi implements MessageOrLinkView{
    
    public MessageOrLinkProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    
    public InstanceObjectView getSource() throws ModelException {
        return ((MessageOrLink)this.getTheObject()).getSource();
    }
    public void setSource(InstanceObjectView newValue) throws ModelException {
        ((MessageOrLink)this.getTheObject()).setSource(newValue);
    }
    public InstanceObjectView getTarget() throws ModelException {
        return ((MessageOrLink)this.getTheObject()).getTarget();
    }
    public void setTarget(InstanceObjectView newValue) throws ModelException {
        ((MessageOrLink)this.getTheObject()).setTarget(newValue);
    }
    
    
    
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
