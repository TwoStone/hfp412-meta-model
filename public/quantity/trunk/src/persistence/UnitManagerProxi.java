package persistence;

import model.UserException;

import model.visitor.*;

public class UnitManagerProxi extends PersistentProxi implements PersistentUnitManager{
    
    public UnitManagerProxi(long objectId) {
        super(objectId);
    }
    public UnitManagerProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theUnitManagerFacade
            .getUnitManager(this.getId());
    }
    
    public long getClassId() {
        return 119;
    }
    
    public UnitManager_UnitsProxi getUnits() throws PersistenceException {
        return ((PersistentUnitManager)this.getTheObject()).getUnits();
    }
    public PersistentUnitManager getThis() throws PersistenceException {
        return ((PersistentUnitManager)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleUnitManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUnitManager(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUnitManager(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUnitManager(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentUnitManager)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentUnitManager)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentUnitManager)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentUnitManager)this.getTheObject()).initializeOnCreation();
    }

    
}
