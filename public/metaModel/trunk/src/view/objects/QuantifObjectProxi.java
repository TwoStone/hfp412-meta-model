package view.objects;

import view.*;
import viewClient.*;

public abstract class QuantifObjectProxi extends ViewProxi implements QuantifObjectView{
    
    public QuantifObjectProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    
    public InstanceObjectView getObject() throws ModelException {
        return ((QuantifObject)this.getTheObject()).getObject();
    }
    public void setObject(InstanceObjectView newValue) throws ModelException {
        ((QuantifObject)this.getTheObject()).setObject(newValue);
    }
    
    
    
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
