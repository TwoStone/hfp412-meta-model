package persistence;

import model.UserException;

import model.visitor.*;

public class MAspectICProxi extends PersistentInCacheProxiOptimistic implements PersistentMAspect{
    
    public MAspectICProxi(long objectId) {
        super(objectId);
    }
    public MAspectICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theMAspectFacade
            .getMAspect(this.getId());
    }
    
    public long getClassId() {
        return 140;
    }
    
    public String getName() throws PersistenceException {
        return ((PersistentMAspect)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentMAspect)this.getTheObject()).setName(newValue);
    }
    public PersistentMAspect getThis() throws PersistenceException {
        return ((PersistentMAspect)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMAspect(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMAspect(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMAspect(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMAspect(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentMAspect)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentMAspect)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public MAtomicTypeSearchList getTypes() 
				throws PersistenceException{
        return ((PersistentMAspect)this.getTheObject()).getTypes();
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentMAspect)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentMAspect)this.getTheObject()).initializeOnCreation();
    }

    
}
