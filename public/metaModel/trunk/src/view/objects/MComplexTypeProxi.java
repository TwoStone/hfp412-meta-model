package view.objects;

import view.*;
import viewClient.*;

public abstract class MComplexTypeProxi extends MTypeProxi implements MComplexTypeView{
    
    public MComplexTypeProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    
    public java.util.Vector<MTypeView> getContainedTypes() throws ModelException {
        return ((MComplexType)this.getTheObject()).getContainedTypes();
    }
    public void setContainedTypes(java.util.Vector<MTypeView> newValue) throws ModelException {
        ((MComplexType)this.getTheObject()).setContainedTypes(newValue);
    }
    
    
    
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
