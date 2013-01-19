package view.objects;

import view.*;
import viewClient.*;

public abstract class AbsOperationProxi extends ViewProxi implements AbsOperationView{
    
    public AbsOperationProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    
    public String getName() throws ModelException {
        return ((AbsOperation)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws ModelException {
        ((AbsOperation)this.getTheObject()).setName(newValue);
    }
    public MTypeView getSource() throws ModelException {
        return ((AbsOperation)this.getTheObject()).getSource();
    }
    public void setSource(MTypeView newValue) throws ModelException {
        ((AbsOperation)this.getTheObject()).setSource(newValue);
    }
    public MTypeView getTarget() throws ModelException {
        return ((AbsOperation)this.getTheObject()).getTarget();
    }
    public void setTarget(MTypeView newValue) throws ModelException {
        ((AbsOperation)this.getTheObject()).setTarget(newValue);
    }
    public java.util.Vector<FormalParameterView> getParameters() throws ModelException {
        return ((AbsOperation)this.getTheObject()).getParameters();
    }
    public void setParameters(java.util.Vector<FormalParameterView> newValue) throws ModelException {
        ((AbsOperation)this.getTheObject()).setParameters(newValue);
    }
    
    
    
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
