package view;

import view.objects.*;

import view.visitor.*;

public interface UnitTypeManagerView extends Anything, AbstractViewProxi {
    
    public java.util.Vector<AbsUnitTypeView> getUnitTypes() throws ModelException ;
    public void setUnitTypes(java.util.Vector<AbsUnitTypeView> newValue) throws ModelException ;
    public java.util.Vector<AbsUnitView> getUnits() throws ModelException ;
    public void setUnits(java.util.Vector<AbsUnitView> newValue) throws ModelException ;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}
