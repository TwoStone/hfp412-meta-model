package view.objects;

import view.*;
import viewClient.*;

public abstract class NamedEntityProxi extends ViewProxi implements NamedEntityView{
    
    public NamedEntityProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    
    public String getName() throws ModelException {
        return ((NamedEntity)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws ModelException {
        ((NamedEntity)this.getTheObject()).setName(newValue);
    }
    
    
    
    public void setIcon(IconRenderer renderer){
        renderer.setIcon(null);
            //TODO: implement setIcon in view class NamedEntity
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
