package view.objects;

import view.*;
import viewClient.*;

public abstract class AbsUnitTypeProxi extends ViewProxi implements AbsUnitTypeView{
    
    public AbsUnitTypeProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    
    public String getName() throws ModelException {
        return ((AbsUnitType)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws ModelException {
        ((AbsUnitType)this.getTheObject()).setName(newValue);
    }
    
    
    
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
