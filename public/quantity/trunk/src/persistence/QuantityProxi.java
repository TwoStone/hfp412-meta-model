package persistence;



public class QuantityProxi extends AbsQuantityProxi implements PersistentQuantity{
    
    public QuantityProxi(long objectId) {
        super(objectId);
    }
    public QuantityProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theQuantityFacade
            .getQuantity(this.getId());
    }
    
    public long getClassId() {
        return 112;
    }
    
    public PersistentFraction getAmount() throws PersistenceException {
        return ((PersistentQuantity)this.getTheObject()).getAmount();
    }
    public void setAmount(PersistentFraction newValue) throws PersistenceException {
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
    
    public void accept(model.visitor.AbsQuantityVisitor visitor) throws PersistenceException {
        visitor.handleQuantity(this);
    }
    public <R> R accept(model.visitor.AbsQuantityReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleQuantity(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AbsQuantityExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleQuantity(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AbsQuantityReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleQuantity(this);
    }
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleQuantity(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleQuantity(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleQuantity(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleQuantity(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentQuantity)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentQuantity)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentQuantity)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentQuantity)this.getTheObject()).initializeOnCreation();
    }

    
}
