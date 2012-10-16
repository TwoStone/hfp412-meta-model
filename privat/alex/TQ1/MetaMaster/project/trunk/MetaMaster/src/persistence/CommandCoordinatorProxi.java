package persistence;



public class CommandCoordinatorProxi extends PersistentProxi implements PersistentCommandCoordinator{
    
    public CommandCoordinatorProxi(long objectId) {
        super(objectId);
    }
    public CommandCoordinatorProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theCommandCoordinatorFacade
            .getCommandCoordinator(this.getId());
    }
    
    public long getClassId() {
        return -121;
    }
    
    public CommandCoordinator_ExecuterProxi getExecuter() throws PersistenceException {
        return ((PersistentCommandCoordinator)this.getTheObject()).getExecuter();
    }
    
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCommandCoordinator(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCommandCoordinator(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCommandCoordinator(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCommandCoordinator(this);
    }
    
    
    public void coordinate(final Command command) 
				throws PersistenceException{
        ((PersistentCommandCoordinator)this.getTheObject()).coordinate(command);
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentCommandCoordinator)this.getTheObject()).initializeOnInstantiation();
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentCommandCoordinator)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentCommandCoordinator)this.getTheObject()).initializeOnCreation();
    }

    
}
