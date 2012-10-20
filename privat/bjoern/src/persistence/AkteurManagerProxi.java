package persistence;

import model.*;

public class AkteurManagerProxi extends PersistentProxi implements PersistentAkteurManager{
    
    public AkteurManagerProxi(long objectId) {
        super(objectId);
    }
    public AkteurManagerProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theAkteurManagerFacade
            .getAkteurManager(this.getId());
    }
    
    public long getClassId() {
        return 117;
    }
    
    public AkteurManager_AkteureProxi getAkteure() throws PersistenceException {
        return ((PersistentAkteurManager)this.getTheObject()).getAkteure();
    }
    public PersistentAkteurManager getThis() throws PersistenceException {
        return ((PersistentAkteurManager)this.getTheObject()).getThis();
    }
    
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAkteurManager(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAkteurManager(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAkteurManager(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAkteurManager(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentAkteurManager)this.getTheObject()).initializeOnInstantiation();
    }
    public void addRole(final PersistentAkteur akteur, final String rollenName, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAkteurManager)this.getTheObject()).addRole(akteur, rollenName, invoker);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentAkteurManager)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void createAkteur(final String name, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAkteurManager)this.getTheObject()).createAkteur(name, invoker);
    }
    public void createAkteur(final String name) 
				throws model.DoubleDefinition, PersistenceException{
        ((PersistentAkteurManager)this.getTheObject()).createAkteur(name);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentAkteurManager)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentAkteurManager)this.getTheObject()).initializeOnCreation();
    }
    public void addRole(final PersistentAkteur akteur, final String rollenName) 
				throws PersistenceException{
        ((PersistentAkteurManager)this.getTheObject()).addRole(akteur, rollenName);
    }

    
}
