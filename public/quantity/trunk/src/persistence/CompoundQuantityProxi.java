package persistence;

import model.UserException;

import model.visitor.*;

public class CompoundQuantityProxi extends AbsQuantityProxi implements PersistentCompoundQuantity{
    
    public CompoundQuantityProxi(long objectId) {
        super(objectId);
    }
    public CompoundQuantityProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theCompoundQuantityFacade
            .getCompoundQuantity(this.getId());
    }
    
    public long getClassId() {
        return 105;
    }
    
    public CompoundQuantity_PartsProxi getParts() throws PersistenceException {
        return ((PersistentCompoundQuantity)this.getTheObject()).getParts();
    }
    public PersistentCompoundQuantity getThis() throws PersistenceException {
        return ((PersistentCompoundQuantity)this.getTheObject()).getThis();
    }
    
    public void accept(AbsQuantityVisitor visitor) throws PersistenceException {
        visitor.handleCompoundQuantity(this);
    }
    public <R> R accept(AbsQuantityReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompoundQuantity(this);
    }
    public <E extends UserException>  void accept(AbsQuantityExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompoundQuantity(this);
    }
    public <R, E extends UserException> R accept(AbsQuantityReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompoundQuantity(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCompoundQuantity(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompoundQuantity(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompoundQuantity(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompoundQuantity(this);
    }
    
    
    public PersistentAbsQuantity sub(final PersistentAbsQuantity minuend) 
				throws PersistenceException{
        return ((PersistentCompoundQuantity)this.getTheObject()).sub(minuend);
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentCompoundQuantity)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentCompoundQuantity)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public PersistentAbsQuantity div(final PersistentAbsQuantity divisor) 
				throws PersistenceException{
        return ((PersistentCompoundQuantity)this.getTheObject()).div(divisor);
    }
    public PersistentAbsQuantity mul(final PersistentAbsQuantity factor) 
				throws PersistenceException{
        return ((PersistentCompoundQuantity)this.getTheObject()).mul(factor);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentCompoundQuantity)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentCompoundQuantity)this.getTheObject()).initializeOnCreation();
    }
    public PersistentAbsQuantity add(final PersistentAbsQuantity summand) 
				throws PersistenceException{
        return ((PersistentCompoundQuantity)this.getTheObject()).add(summand);
    }

    
}
