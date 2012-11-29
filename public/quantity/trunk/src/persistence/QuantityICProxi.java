package persistence;

import model.UserException;

import model.visitor.*;

public class QuantityICProxi extends AbsQuantityICProxi implements PersistentQuantity{
    
    public QuantityICProxi(long objectId) {
        super(objectId);
    }
    public QuantityICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theQuantityFacade
            .getQuantity(this.getId());
    }
    
    public long getClassId() {
        return 122;
    }
    
    public common.Fraction getAmount() throws PersistenceException {
        return ((PersistentQuantity)this.getTheObject()).getAmount();
    }
    public void setAmount(common.Fraction newValue) throws PersistenceException {
        ((PersistentQuantity)this.getTheObject()).setAmount(newValue);
    }
    public PersistentUnit getUnit() throws PersistenceException {
        return ((PersistentQuantity)this.getTheObject()).getUnit();
    }
    public void setUnit(PersistentUnit newValue) throws PersistenceException {
        ((PersistentQuantity)this.getTheObject()).setUnit(newValue);
    }
    public PersistentQuantity getThis() throws PersistenceException {
        return ((PersistentQuantity)this.getTheObject()).getThis();
    }
    
    public void accept(AbsQuantityVisitor visitor) throws PersistenceException {
        visitor.handleQuantity(this);
    }
    public <R> R accept(AbsQuantityReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleQuantity(this);
    }
    public <E extends UserException>  void accept(AbsQuantityExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleQuantity(this);
    }
    public <R, E extends UserException> R accept(AbsQuantityReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleQuantity(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleQuantity(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleQuantity(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleQuantity(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleQuantity(this);
    }
    
    
    public PersistentAbsQuantity sub(final PersistentAbsQuantity minuend) 
				throws PersistenceException{
        return ((PersistentQuantity)this.getTheObject()).sub(minuend);
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentQuantity)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentQuantity)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public PersistentAbsQuantity div(final PersistentAbsQuantity divisor) 
				throws PersistenceException{
        return ((PersistentQuantity)this.getTheObject()).div(divisor);
    }
    public PersistentAbsQuantity mul(final PersistentAbsQuantity factor) 
				throws PersistenceException{
        return ((PersistentQuantity)this.getTheObject()).mul(factor);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentQuantity)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentQuantity)this.getTheObject()).initializeOnCreation();
    }
    public PersistentAbsQuantity add(final PersistentAbsQuantity summand) 
				throws PersistenceException{
        return ((PersistentQuantity)this.getTheObject()).add(summand);
    }

    
}
