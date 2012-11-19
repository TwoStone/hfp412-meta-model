package view;

import view.visitor.*;

public interface CompUnitTypeView extends AbsUnitTypeView {
    
    public java.util.Vector<ReferenceTypeView> getRefs() throws ModelException ;
    public void setRefs(java.util.Vector<ReferenceTypeView> newValue) throws ModelException ;
    public BooleanValueView getIsFinal() throws ModelException ;
    public void setIsFinal(BooleanValueView newValue) throws ModelException ;
    
    public void accept(AbsUnitTypeVisitor visitor) throws ModelException;
    public <R> R accept(AbsUnitTypeReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AbsUnitTypeExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AbsUnitTypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

