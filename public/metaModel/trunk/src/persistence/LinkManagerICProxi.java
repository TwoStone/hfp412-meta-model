package persistence;

import model.UserException;

import model.visitor.*;

public class LinkManagerICProxi extends PersistentInCacheProxiOptimistic implements PersistentLinkManager{
    
    public LinkManagerICProxi(long objectId) {
        super(objectId);
    }
    public LinkManagerICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theLinkManagerFacade
            .getLinkManager(this.getId());
    }
    
    public long getClassId() {
        return 244;
    }
    
    public LinkManager_LinksProxi getLinks() throws PersistenceException {
        return ((PersistentLinkManager)this.getTheObject()).getLinks();
    }
    public PersistentLinkManager getThis() throws PersistenceException {
        return ((PersistentLinkManager)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleLinkManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleLinkManager(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleLinkManager(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleLinkManager(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentLinkManager)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentLinkManager)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentLinkManager)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void createLink(final PersistentAssociation type, final PersistentInstanceObject source, final PersistentInstanceObject target) 
				throws PersistenceException{
        ((PersistentLinkManager)this.getTheObject()).createLink(type, source, target);
    }
    public void removeLink(final PersistentLink link, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentLinkManager)this.getTheObject()).removeLink(link, invoker);
    }
    public void removeLink(final PersistentLink link) 
				throws PersistenceException{
        ((PersistentLinkManager)this.getTheObject()).removeLink(link);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentLinkManager)this.getTheObject()).initializeOnCreation();
    }
    public void createLink(final PersistentAssociation type, final PersistentInstanceObject source, final PersistentInstanceObject target, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentLinkManager)this.getTheObject()).createLink(type, source, target, invoker);
    }

    
}
