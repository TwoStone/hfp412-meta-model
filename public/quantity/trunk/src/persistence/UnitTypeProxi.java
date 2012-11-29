package persistence;

import model.UserException;

import model.visitor.*;

public class UnitTypeProxi extends AbsUnitTypeProxi implements PersistentUnitType{
    
    public UnitTypeProxi(long objectId) {
        super(objectId);
    }
    public UnitTypeProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theUnitTypeFacade
            .getUnitType(this.getId());
    }
    
    public long getClassId() {
        return 109;
    }
    
    public PersistentUnitType getThis() throws PersistenceException {
        return ((PersistentUnitType)this.getTheObject()).getThis();
    }
    
    public void accept(AbsUnitTypeVisitor visitor) throws PersistenceException {
        visitor.handleUnitType(this);
    }
    public <R> R accept(AbsUnitTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUnitType(this);
    }
    public <E extends UserException>  void accept(AbsUnitTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUnitType(this);
    }
    public <R, E extends UserException> R accept(AbsUnitTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUnitType(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleUnitType(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUnitType(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUnitType(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUnitType(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentUnitType)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentUnitType)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentUnitType)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentUnitType)this.getTheObject()).initializeOnCreation();
    }

    
}
