package persistence;

import model.*;
public interface PersistentAspectManager extends Anything, AbstractPersistentProxi {
    
    public AspectManager_AspectsProxi getAspects() throws PersistenceException ;
    public PersistentAspectManager getThis() throws PersistenceException ;
    
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void createAspect(final String name) 
				throws model.DoubleDefinitionException, PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException;
    public void createAspect(final String name, final Invoker invoker) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;

}

