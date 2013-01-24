package view;

import view.visitor.*;

public interface MeasurementView extends QuantifObjectView {
    
    public MMeasurementTypeView getType() throws ModelException ;
    public void setType(MMeasurementTypeView newValue) throws ModelException ;
    public AbsQuantityView getQuantity() throws ModelException ;
    public void setQuantity(AbsQuantityView newValue) throws ModelException ;
    
    public void accept(QuantifObjectVisitor visitor) throws ModelException;
    public <R> R accept(QuantifObjectReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(QuantifObjectExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(QuantifObjectReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}
