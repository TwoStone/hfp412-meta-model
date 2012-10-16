package view.objects;

import view.*;
import viewClient.*;

public abstract class ActorProxi extends ViewProxi implements ActorView{
    
    public ActorProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    
    public String getName() throws ModelException {
        return ((Actor)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws ModelException {
        ((Actor)this.getTheObject()).setName(newValue);
    }
    public java.util.Vector<RoleView> getRoles() throws ModelException {
        return ((Actor)this.getTheObject()).getRoles();
    }
    
    
    
    public void setIcon(IconRenderer renderer){
        renderer.setIcon(null);
            //TODO: implement setIcon in view class Actor
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
