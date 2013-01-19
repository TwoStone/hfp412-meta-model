package view;

import view.objects.*;

import view.visitor.*;

public interface FormalParameterView extends Anything, AbstractViewProxi {
    
    public MTypeView getOfType() throws ModelException ;
    public void setOfType(MTypeView newValue) throws ModelException ;
    public String getName() throws ModelException ;
    public void setName(String newValue) throws ModelException ;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

