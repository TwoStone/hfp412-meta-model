package persistence;

import model.UserException;

import model.visitor.*;

public class HierarchyICProxi extends PersistentInCacheProxiOptimistic implements PersistentHierarchy{
    
    public HierarchyICProxi(long objectId) {
        super(objectId);
    }
    public HierarchyICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theHierarchyFacade
            .getHierarchy(this.getId());
    }
    
    public long getClassId() {
        return 165;
    }
    
    public String getName() throws PersistenceException {
        return ((PersistentHierarchy)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentHierarchy)this.getTheObject()).setName(newValue);
    }
    public PersistentHierarchy getThis() throws PersistenceException {
        return ((PersistentHierarchy)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleHierarchy(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleHierarchy(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleHierarchy(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleHierarchy(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentHierarchy)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentHierarchy)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public AssociationSearchList getAssociations() 
				throws PersistenceException{
        return ((PersistentHierarchy)this.getTheObject()).getAssociations();
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentHierarchy)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentHierarchy)this.getTheObject()).initializeOnCreation();
    }

    
}
