package persistence;



public class KundeProxi extends RolleProxi implements PersistentKunde{
    
    public KundeProxi(long objectId) {
        super(objectId);
    }
    public KundeProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theKundeFacade
            .getKunde(this.getId());
    }
    
    public long getClassId() {
        return 122;
    }
    
    public PersistentKunde getThis() throws PersistenceException {
        return ((PersistentKunde)this.getTheObject()).getThis();
    }
    
    public void accept(model.visitor.RolleVisitor visitor) throws PersistenceException {
        visitor.handleKunde(this);
    }
    public <R> R accept(model.visitor.RolleReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleKunde(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.RolleExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleKunde(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.RolleReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleKunde(this);
    }
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleKunde(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleKunde(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleKunde(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleKunde(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentKunde)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentKunde)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentKunde)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentKunde)this.getTheObject()).initializeOnCreation();
    }

    
}
