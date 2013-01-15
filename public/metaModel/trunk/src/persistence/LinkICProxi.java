package persistence;

import model.UserException;

import model.visitor.*;

public class LinkICProxi extends MessageOrLinkICProxi implements PersistentLink{
    
    public LinkICProxi(long objectId) {
        super(objectId);
    }
    public LinkICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theLinkFacade
            .getLink(this.getId());
    }
    
    public long getClassId() {
        return 207;
    }
    
    public PersistentMAssociation getType() throws PersistenceException {
        return ((PersistentLink)this.getTheObject()).getType();
    }
    public void setType(PersistentMAssociation newValue) throws PersistenceException {
        ((PersistentLink)this.getTheObject()).setType(newValue);
    }
    public PersistentLink getThis() throws PersistenceException {
        return ((PersistentLink)this.getTheObject()).getThis();
    }
    
    public void accept(MessageOrLinkVisitor visitor) throws PersistenceException {
        visitor.handleLink(this);
    }
    public <R> R accept(MessageOrLinkReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleLink(this);
    }
    public <E extends UserException>  void accept(MessageOrLinkExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleLink(this);
    }
    public <R, E extends UserException> R accept(MessageOrLinkReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleLink(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleLink(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleLink(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleLink(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleLink(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentLink)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentLink)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentLink)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentLink)this.getTheObject()).initializeOnCreation();
    }

    
}
