package view.objects;

import view.*;
import viewClient.*;

public abstract class AbsQuantityProxi extends ViewProxi implements AbsQuantityView{
    
    public AbsQuantityProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    
    
    
    
    public void setIcon(IconRenderer renderer){
        renderer.setIcon(null);
            //TODO: implement setIcon in view class AbsQuantity
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
