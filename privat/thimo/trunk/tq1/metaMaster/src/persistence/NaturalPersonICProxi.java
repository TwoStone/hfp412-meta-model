package persistence;



public class NaturalPersonICProxi extends ActorICProxi implements PersistentNaturalPerson{
    
    public NaturalPersonICProxi(long objectId) {
        super(objectId);
    }
    public NaturalPersonICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theNaturalPersonFacade
            .getNaturalPerson(this.getId());
    }
    
    public long getClassId() {
        return 129;
    }
    
    public PersistentNaturalPerson getThis() throws PersistenceException {
        return ((PersistentNaturalPerson)this.getTheObject()).getThis();
    }
    
    public void accept(model.visitor.ActorVisitor visitor) throws PersistenceException {
        visitor.handleNaturalPerson(this);
    }
    public <R> R accept(model.visitor.ActorReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNaturalPerson(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.ActorExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNaturalPerson(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.ActorReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNaturalPerson(this);
    }
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleNaturalPerson(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNaturalPerson(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNaturalPerson(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNaturalPerson(this);
    }
    
    
    public RoleSearchList inverseGetRoleFor() 
				throws PersistenceException{
        return ((PersistentNaturalPerson)this.getTheObject()).inverseGetRoleFor();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentNaturalPerson)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentNaturalPerson)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public RoleSearchList getMyRoles(final TDObserver observer) 
				throws PersistenceException{
        return ((PersistentNaturalPerson)this.getTheObject()).getMyRoles(observer);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentNaturalPerson)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void addRole(final String roleName) 
				throws PersistenceException{
        ((PersistentNaturalPerson)this.getTheObject()).addRole(roleName);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentNaturalPerson)this.getTheObject()).initializeOnCreation();
    }
    public RoleSearchList getMyRoles() 
				throws PersistenceException{
        return ((PersistentNaturalPerson)this.getTheObject()).getMyRoles();
    }

    
}
