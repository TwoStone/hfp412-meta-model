package persistence;



public class AkteurProxi extends PersistentProxi implements PersistentAkteur{
    
    public AkteurProxi(long objectId) {
        super(objectId);
    }
    public AkteurProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theAkteurFacade
            .getAkteur(this.getId());
    }
    
    public long getClassId() {
        return 111;
    }
    
    public String getName() throws PersistenceException {
        return ((PersistentAkteur)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentAkteur)this.getTheObject()).setName(newValue);
    }
    public PersistentAkteur getThis() throws PersistenceException {
        return ((PersistentAkteur)this.getTheObject()).getThis();
    }
    
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAkteur(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAkteur(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAkteur(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAkteur(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentAkteur)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentAkteur)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentAkteur)this.getTheObject()).initialize(This, final$$Fields);
    }
    public RolleSearchList getMeineRollen(final TDObserver observer) 
				throws PersistenceException{
        return ((PersistentAkteur)this.getTheObject()).getMeineRollen(observer);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentAkteur)this.getTheObject()).initializeOnCreation();
    }
    public void addRole(final String rollenName) 
				throws PersistenceException{
        ((PersistentAkteur)this.getTheObject()).addRole(rollenName);
    }
    public RolleSearchList getMeineRollen() 
				throws PersistenceException{
        return ((PersistentAkteur)this.getTheObject()).getMeineRollen();
    }

    
}
