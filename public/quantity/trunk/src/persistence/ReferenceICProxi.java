package persistence;

import model.UserException;

import model.visitor.*;

public class ReferenceICProxi extends PersistentInCacheProxiOptimistic implements PersistentReference{
    
    public ReferenceICProxi(long objectId) {
        super(objectId);
    }
    public ReferenceICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theReferenceFacade
            .getReference(this.getId());
    }
    
    public long getClassId() {
        return 117;
    }
    
    public PersistentReferenceType getType() throws PersistenceException {
        return ((PersistentReference)this.getTheObject()).getType();
    }
    public void setType(PersistentReferenceType newValue) throws PersistenceException {
        ((PersistentReference)this.getTheObject()).setType(newValue);
    }
    public long getExponent() throws PersistenceException {
        return ((PersistentReference)this.getTheObject()).getExponent();
    }
    public void setExponent(long newValue) throws PersistenceException {
        ((PersistentReference)this.getTheObject()).setExponent(newValue);
    }
    public PersistentUnit getRef() throws PersistenceException {
        return ((PersistentReference)this.getTheObject()).getRef();
    }
    public void setRef(PersistentUnit newValue) throws PersistenceException {
        ((PersistentReference)this.getTheObject()).setRef(newValue);
    }
    public PersistentReference getThis() throws PersistenceException {
        return ((PersistentReference)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleReference(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleReference(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleReference(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleReference(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentReference)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentReference)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentReference)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentReference)this.getTheObject()).initializeOnCreation();
    }

    
}
