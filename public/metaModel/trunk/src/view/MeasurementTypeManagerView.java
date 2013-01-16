package view;

import view.objects.*;

import view.visitor.*;

public interface MeasurementTypeManagerView extends Anything, AbstractViewProxi {
    
    public java.util.Vector<MMeasurementTypeView> getMeasurementTypes() throws ModelException ;
    public void setMeasurementTypes(java.util.Vector<MMeasurementTypeView> newValue) throws ModelException ;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

