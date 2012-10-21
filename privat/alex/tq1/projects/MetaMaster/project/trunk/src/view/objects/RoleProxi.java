package view.objects;

import view.*;
import viewClient.*;

public abstract class RoleProxi extends ViewProxi implements RoleView{
    
    public RoleProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    
    public ActorView getOwner() throws ModelException {
        return ((Role)this.getTheObject()).getOwner();
    }
    public void setOwner(ActorView newValue) throws ModelException {
        ((Role)this.getTheObject()).setOwner(newValue);
    }
    
    
    
    public void setIcon(IconRenderer renderer){
        renderer.setIcon(null);
            //TODO: implement setIcon in view class Role
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
