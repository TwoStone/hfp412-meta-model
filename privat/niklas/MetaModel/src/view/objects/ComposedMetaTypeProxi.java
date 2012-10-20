package view.objects;

import view.*;
import viewClient.*;

public abstract class ComposedMetaTypeProxi extends AbstractMetaTypeProxi implements ComposedMetaTypeView{
    
    public ComposedMetaTypeProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    
    public java.util.Vector<AbstractMetaTypeView> getComponents() throws ModelException {
        return ((ComposedMetaType)this.getTheObject()).getComponents();
    }
    public void setComponents(java.util.Vector<AbstractMetaTypeView> newValue) throws ModelException {
        ((ComposedMetaType)this.getTheObject()).setComponents(newValue);
    }
    
    
    
    public void setIcon(IconRenderer renderer){
        renderer.setIcon(null);
            //TODO: implement setIcon in view class ComposedMetaType
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
