package view.objects;

import view.*;
import viewClient.*;

public abstract class MQuantiObjectTypeProxi extends ViewProxi implements MQuantiObjectTypeView{
    
    public MQuantiObjectTypeProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    
    public MTypeView getType() throws ModelException {
        return ((MQuantiObjectType)this.getTheObject()).getType();
    }
    public void setType(MTypeView newValue) throws ModelException {
        ((MQuantiObjectType)this.getTheObject()).setType(newValue);
    }
    public AbsUnitTypeView getUnitType() throws ModelException {
        return ((MQuantiObjectType)this.getTheObject()).getUnitType();
    }
    public void setUnitType(AbsUnitTypeView newValue) throws ModelException {
        ((MQuantiObjectType)this.getTheObject()).setUnitType(newValue);
    }
    
    
    
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
