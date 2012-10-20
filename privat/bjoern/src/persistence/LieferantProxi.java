package persistence;



public class LieferantProxi extends RolleProxi implements PersistentLieferant{
    
    public LieferantProxi(long objectId) {
        super(objectId);
    }
    public LieferantProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theLieferantFacade
            .getLieferant(this.getId());
    }
    
    public long getClassId() {
        return 121;
    }
    
    public Lieferant_PortfolioProxi getPortfolio() throws PersistenceException {
        return ((PersistentLieferant)this.getTheObject()).getPortfolio();
    }
    public PersistentLieferant getThis() throws PersistenceException {
        return ((PersistentLieferant)this.getTheObject()).getThis();
    }
    
    public void accept(model.visitor.RolleVisitor visitor) throws PersistenceException {
        visitor.handleLieferant(this);
    }
    public <R> R accept(model.visitor.RolleReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleLieferant(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.RolleExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleLieferant(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.RolleReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleLieferant(this);
    }
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleLieferant(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleLieferant(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleLieferant(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleLieferant(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentLieferant)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentLieferant)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentLieferant)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentLieferant)this.getTheObject()).initializeOnCreation();
    }

    
}
