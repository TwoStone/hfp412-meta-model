package persistence;



public class ProduktProxi extends PersistentProxi implements PersistentProdukt{
    
    public ProduktProxi(long objectId) {
        super(objectId);
    }
    public ProduktProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theProduktFacade
            .getProdukt(this.getId());
    }
    
    public long getClassId() {
        return 125;
    }
    
    public String getName() throws PersistenceException {
        return ((PersistentProdukt)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentProdukt)this.getTheObject()).setName(newValue);
    }
    public PersistentProdukt getThis() throws PersistenceException {
        return ((PersistentProdukt)this.getTheObject()).getThis();
    }
    
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleProdukt(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleProdukt(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleProdukt(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleProdukt(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentProdukt)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentProdukt)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentProdukt)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentProdukt)this.getTheObject()).initializeOnCreation();
    }

    
}
