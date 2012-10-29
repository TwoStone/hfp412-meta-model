package view.objects;

import view.*;
import viewClient.*;

public abstract class AbsUnitProxi extends ViewProxi implements AbsUnitView{
    
    public AbsUnitProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    
    public AbsUnitTypeView getType() throws ModelException {
        return ((AbsUnit)this.getTheObject()).getType();
    }
    public void setType(AbsUnitTypeView newValue) throws ModelException {
        ((AbsUnit)this.getTheObject()).setType(newValue);
    }
    public String getName() throws ModelException {
        return ((AbsUnit)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws ModelException {
        ((AbsUnit)this.getTheObject()).setName(newValue);
    }
    
    
    
    public void setIcon(IconRenderer renderer){
        renderer.setIcon(null);
            //TODO: implement setIcon in view class AbsUnit
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
