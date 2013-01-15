package view;

import view.objects.*;

import view.visitor.*;

public interface MQuantiObjectTypeView extends Anything, AbstractViewProxi {
    
    public MTypeView getType() throws ModelException ;
    public void setType(MTypeView newValue) throws ModelException ;
    public AbsUnitTypeView getUnitType() throws ModelException ;
    public void setUnitType(AbsUnitTypeView newValue) throws ModelException ;
    
    public void accept(MQuantiObjectTypeVisitor visitor) throws ModelException;
    public <R> R accept(MQuantiObjectTypeReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(MQuantiObjectTypeExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(MQuantiObjectTypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

