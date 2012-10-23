package view.objects;

import view.*;
import viewClient.*;

public abstract class MComplexTypeProxi extends ViewProxi implements MComplexTypeView{
    
    public MComplexTypeProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    
    public java.util.Vector<MType> getContainedTypes() throws ModelException {
        return ((MComplexType)this.getTheObject()).getContainedTypes();
    }
    public void setContainedTypes(java.util.Vector<MType> newValue) throws ModelException {
        ((MComplexType)this.getTheObject()).setContainedTypes(newValue);
    }
    public String getTypeLinkOperator() throws ModelException {
        return ((MComplexType)this.getTheObject()).getTypeLinkOperator();
    }
    
    
    
    public void setIcon(IconRenderer renderer){
        renderer.setIcon(null);
            //TODO: implement setIcon in view class MComplexType
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
