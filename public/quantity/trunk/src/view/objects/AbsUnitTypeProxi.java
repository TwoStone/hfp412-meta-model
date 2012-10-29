package view.objects;

import view.*;
import viewClient.*;

public abstract class AbsUnitTypeProxi extends ViewProxi implements AbsUnitTypeView{
    
    public AbsUnitTypeProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    
    public AbsUnitView getDefaultUnit() throws ModelException {
        return ((AbsUnitType)this.getTheObject()).getDefaultUnit();
    }
    public void setDefaultUnit(AbsUnitView newValue) throws ModelException {
        ((AbsUnitType)this.getTheObject()).setDefaultUnit(newValue);
    }
    public String getName() throws ModelException {
        return ((AbsUnitType)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws ModelException {
        ((AbsUnitType)this.getTheObject()).setName(newValue);
    }
    
    
    
    public void setIcon(IconRenderer renderer){
        renderer.setIcon(null);
            //TODO: implement setIcon in view class AbsUnitType
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
