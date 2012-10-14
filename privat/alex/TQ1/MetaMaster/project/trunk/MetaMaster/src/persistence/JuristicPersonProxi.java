package persistence;



public class JuristicPersonProxi extends ActorProxi implements PersistentJuristicPerson{
    
    public JuristicPersonProxi(long objectId) {
        super(objectId);
    }
    public JuristicPersonProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theJuristicPersonFacade
            .getJuristicPerson(this.getId());
    }
    
    public long getClassId() {
        return 116;
    }
    
    public PersistentJuristicPerson getThis() throws PersistenceException {
        return ((PersistentJuristicPerson)this.getTheObject()).getThis();
    }
    
    public void accept(model.visitor.ActorVisitor visitor) throws PersistenceException {
        visitor.handleJuristicPerson(this);
    }
    public <R> R accept(model.visitor.ActorReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleJuristicPerson(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.ActorExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleJuristicPerson(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.ActorReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleJuristicPerson(this);
    }
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleJuristicPerson(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleJuristicPerson(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleJuristicPerson(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleJuristicPerson(this);
    }
    
    
    public RoleSearchList getRoles(TDObserver observer) 
				throws PersistenceException{
        return ((PersistentJuristicPerson)this.getTheObject()).getRoles(observer);
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentJuristicPerson)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(Anything copy) 
				throws PersistenceException{
        ((PersistentJuristicPerson)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public RoleSearchList inverseGetRoleOwner() 
				throws PersistenceException{
        return ((PersistentJuristicPerson)this.getTheObject()).inverseGetRoleOwner();
    }
    public RoleSearchList getRoles() 
				throws PersistenceException{
        return ((PersistentJuristicPerson)this.getTheObject()).getRoles();
    }
    public void initialize(Anything This, java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentJuristicPerson)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void addRole(String roleName) 
				throws PersistenceException{
        ((PersistentJuristicPerson)this.getTheObject()).addRole(roleName);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentJuristicPerson)this.getTheObject()).initializeOnCreation();
    }

    
}
