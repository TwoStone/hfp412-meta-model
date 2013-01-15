package view;

import view.objects.*;

import view.visitor.*;

public interface AccountView extends Anything, AbstractViewProxi {
    
    public MAccountTypeView getType() throws ModelException ;
    public void setType(MAccountTypeView newValue) throws ModelException ;
    public java.util.Vector<AccountView> getSubAccounts() throws ModelException ;
    public void setSubAccounts(java.util.Vector<AccountView> newValue) throws ModelException ;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

