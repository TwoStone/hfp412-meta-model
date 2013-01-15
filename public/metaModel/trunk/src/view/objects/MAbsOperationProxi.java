package view.objects;

import view.*;
import viewClient.*;

public abstract class MAbsOperationProxi extends ViewProxi implements MAbsOperationView{
    
    public MAbsOperationProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    
    public String getName() throws ModelException {
        return ((MAbsOperation)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws ModelException {
        ((MAbsOperation)this.getTheObject()).setName(newValue);
    }
    public MType getSource() throws ModelException {
        return ((MAbsOperation)this.getTheObject()).getSource();
    }
    public void setSource(MType newValue) throws ModelException {
        ((MAbsOperation)this.getTheObject()).setSource(newValue);
    }
    public MType getTarget() throws ModelException {
        return ((MAbsOperation)this.getTheObject()).getTarget();
    }
    public void setTarget(MType newValue) throws ModelException {
        ((MAbsOperation)this.getTheObject()).setTarget(newValue);
    }
    public java.util.Vector<MFormalParameterView> getParameters() throws ModelException {
        return ((MAbsOperation)this.getTheObject()).getParameters();
    }
    public void setParameters(java.util.Vector<MFormalParameterView> newValue) throws ModelException {
        ((MAbsOperation)this.getTheObject()).setParameters(newValue);
    }
    
    
    
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
