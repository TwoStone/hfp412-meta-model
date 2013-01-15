package view;

import view.objects.*;

public interface QuantifObjectView extends Anything, AbstractViewProxi {
    
    public InstanceObjectView getDefaultType() throws ModelException ;
    public void setDefaultType(InstanceObjectView newValue) throws ModelException ;
    
    
}

