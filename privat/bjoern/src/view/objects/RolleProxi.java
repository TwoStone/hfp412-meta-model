package view.objects;

import view.*;
import viewClient.*;

public abstract class RolleProxi extends ViewProxi implements RolleView{
    
    public RolleProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    
    public AkteurView getRolleFuer() throws ModelException {
        return ((Rolle)this.getTheObject()).getRolleFuer();
    }
    public void setRolleFuer(AkteurView newValue) throws ModelException {
        ((Rolle)this.getTheObject()).setRolleFuer(newValue);
    }
    
    
    
    public void setIcon(IconRenderer renderer){
        renderer.setIcon(null);
            //TODO: implement setIcon in view class Rolle
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
