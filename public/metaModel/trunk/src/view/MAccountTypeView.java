package view;

import view.visitor.*;

public interface MAccountTypeView extends MQuantiObjectTypeView {
    
    public java.util.Vector<MAccountTypeView> getSubAccountTypes() throws ModelException ;
    public void setSubAccountTypes(java.util.Vector<MAccountTypeView> newValue) throws ModelException ;
    
    public void accept(MQuantiObjectTypeVisitor visitor) throws ModelException;
    public <R> R accept(MQuantiObjectTypeReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(MQuantiObjectTypeExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(MQuantiObjectTypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

