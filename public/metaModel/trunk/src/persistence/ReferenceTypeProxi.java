package persistence;

import model.UserException;

import model.visitor.*;

public class ReferenceTypeProxi extends PersistentProxi implements PersistentReferenceType{
    
    public ReferenceTypeProxi(long objectId) {
        super(objectId);
    }
    public ReferenceTypeProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theReferenceTypeFacade
            .getReferenceType(this.getId());
    }
    
    public long getClassId() {
        return 180;
    }
    
    public long getExponent() throws PersistenceException {
        return ((PersistentReferenceType)this.getTheObject()).getExponent();
    }
    public void setExponent(long newValue) throws PersistenceException {
        ((PersistentReferenceType)this.getTheObject()).setExponent(newValue);
    }
    public PersistentUnitType getRef() throws PersistenceException {
        return ((PersistentReferenceType)this.getTheObject()).getRef();
    }
    public void setRef(PersistentUnitType newValue) throws PersistenceException {
        ((PersistentReferenceType)this.getTheObject()).setRef(newValue);
    }
    public PersistentReferenceType getThis() throws PersistenceException {
        return ((PersistentReferenceType)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleReferenceType(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleReferenceType(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleReferenceType(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleReferenceType(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentReferenceType)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentReferenceType)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentReferenceType)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentReferenceType)this.getTheObject()).initializeOnCreation();
    }

    
}
