package persistence;



public abstract class MessageOrLinkICProxi extends PersistentInCacheProxiOptimistic implements PersistentMessageOrLink{
    
    public MessageOrLinkICProxi(long objectId) {
        super(objectId);
    }
    public MessageOrLinkICProxi(PersistentObject object) {
        super(object);
    }
    
    
    public PersistentInstanceObject getSource() throws PersistenceException {
        return ((PersistentMessageOrLink)this.getTheObject()).getSource();
    }
    public void setSource(PersistentInstanceObject newValue) throws PersistenceException {
        ((PersistentMessageOrLink)this.getTheObject()).setSource(newValue);
    }
    public PersistentInstanceObject getTarget() throws PersistenceException {
        return ((PersistentMessageOrLink)this.getTheObject()).getTarget();
    }
    public void setTarget(PersistentInstanceObject newValue) throws PersistenceException {
        ((PersistentMessageOrLink)this.getTheObject()).setTarget(newValue);
    }
    public abstract PersistentMessageOrLink getThis() throws PersistenceException ;
    
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentMessageOrLink)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentMessageOrLink)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentMessageOrLink)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentMessageOrLink)this.getTheObject()).initializeOnCreation();
    }

    
}
