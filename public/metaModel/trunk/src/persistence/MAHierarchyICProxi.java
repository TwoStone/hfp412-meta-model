package persistence;

import model.UserException;

import model.visitor.*;

public class MAHierarchyICProxi extends PersistentInCacheProxiOptimistic implements PersistentMAHierarchy{
    
    public MAHierarchyICProxi(long objectId) {
        super(objectId);
    }
    public MAHierarchyICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theMAHierarchyFacade
            .getMAHierarchy(this.getId());
    }
    
    public long getClassId() {
        return 142;
    }
    
    public String getName() throws PersistenceException {
        return ((PersistentMAHierarchy)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentMAHierarchy)this.getTheObject()).setName(newValue);
    }
    public PersistentMAHierarchy getThis() throws PersistenceException {
        return ((PersistentMAHierarchy)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMAHierarchy(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMAHierarchy(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMAHierarchy(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMAHierarchy(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentMAHierarchy)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentMAHierarchy)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public MAssociationSearchList getAssociations() 
				throws PersistenceException{
        return ((PersistentMAHierarchy)this.getTheObject()).getAssociations();
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentMAHierarchy)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentMAHierarchy)this.getTheObject()).initializeOnCreation();
    }

    
}
