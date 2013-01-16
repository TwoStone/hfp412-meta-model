package view;

import view.visitor.*;

public interface AccountView extends QuantifObjectView {
    
    public MAccountTypeView getType() throws ModelException ;
    public void setType(MAccountTypeView newValue) throws ModelException ;
    public java.util.Vector<AccountView> getSubAccounts() throws ModelException ;
    public void setSubAccounts(java.util.Vector<AccountView> newValue) throws ModelException ;
    public java.util.Vector<MeasurementView> getEntries() throws ModelException ;
    public void setEntries(java.util.Vector<MeasurementView> newValue) throws ModelException ;
    
    public void accept(QuantifObjectVisitor visitor) throws ModelException;
    public <R> R accept(QuantifObjectReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(QuantifObjectExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(QuantifObjectReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

