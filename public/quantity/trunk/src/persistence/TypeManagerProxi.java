package persistence;

import model.UserException;

import model.visitor.*;

public class TypeManagerProxi extends PersistentProxi implements PersistentTypeManager{
    
    public TypeManagerProxi(long objectId) {
        super(objectId);
    }
    public TypeManagerProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theTypeManagerFacade
            .getTypeManager(this.getId());
    }
    
    public long getClassId() {
        return 101;
    }
    
    public TypeManager_UnitTypesProxi getUnitTypes() throws PersistenceException {
        return ((PersistentTypeManager)this.getTheObject()).getUnitTypes();
    }
    public PersistentTypeManager getThis() throws PersistenceException {
        return ((PersistentTypeManager)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleTypeManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTypeManager(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTypeManager(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTypeManager(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentTypeManager)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentTypeManager)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentTypeManager)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentTypeManager)this.getTheObject()).initializeOnCreation();
    }

    
}
