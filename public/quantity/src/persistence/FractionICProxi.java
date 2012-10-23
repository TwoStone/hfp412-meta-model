package persistence;



public class FractionICProxi extends PersistentInCacheProxiOptimistic implements PersistentFraction{
    
    public FractionICProxi(long objectId) {
        super(objectId);
    }
    public FractionICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theFractionFacade
            .getFraction(this.getId());
    }
    
    public long getClassId() {
        return 111;
    }
    
    public long getEnumerator() throws PersistenceException {
        return ((PersistentFraction)this.getTheObject()).getEnumerator();
    }
    public void setEnumerator(long newValue) throws PersistenceException {
        ((PersistentFraction)this.getTheObject()).setEnumerator(newValue);
    }
    public long getDenominator() throws PersistenceException {
        return ((PersistentFraction)this.getTheObject()).getDenominator();
    }
    public void setDenominator(long newValue) throws PersistenceException {
        ((PersistentFraction)this.getTheObject()).setDenominator(newValue);
    }
    public PersistentFraction getThis() throws PersistenceException {
        return ((PersistentFraction)this.getTheObject()).getThis();
    }
    
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleFraction(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleFraction(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleFraction(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleFraction(this);
    }
    
    
    public PersistentFraction add(final PersistentFraction fraction) 
				throws PersistenceException{
        return ((PersistentFraction)this.getTheObject()).add(fraction);
    }
    public PersistentFraction toRational() 
				throws PersistenceException{
        return ((PersistentFraction)this.getTheObject()).toRational();
    }
    public PersistentFraction mul(final PersistentFraction fraction) 
				throws PersistenceException{
        return ((PersistentFraction)this.getTheObject()).mul(fraction);
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentFraction)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentFraction)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentFraction)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentFraction)this.getTheObject()).initializeOnCreation();
    }

    
}
