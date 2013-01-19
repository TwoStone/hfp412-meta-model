package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentLinkManager extends Anything, AbstractPersistentProxi {
    
    public LinkManager_LinksProxi getLinks() throws PersistenceException ;
    public PersistentLinkManager getThis() throws PersistenceException ;
    
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException;
    public void removeLink(final PersistentLink link, final Invoker invoker) 
				throws PersistenceException;
    public void createLink(final PersistentAssociation type, final PersistentInstanceObject source, final PersistentInstanceObject target) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void removeLink(final PersistentLink link) 
				throws PersistenceException;
    public void createLink(final PersistentAssociation type, final PersistentInstanceObject source, final PersistentInstanceObject target, final Invoker invoker) 
				throws PersistenceException;

}

