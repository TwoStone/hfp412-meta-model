package persistence;

import model.UserException;

import model.visitor.*;

public class AssociationManagerICProxi extends PersistentInCacheProxiOptimistic implements PersistentAssociationManager{
    
    public AssociationManagerICProxi(long objectId) {
        super(objectId);
    }
    public AssociationManagerICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theAssociationManagerFacade
            .getAssociationManager(this.getId());
    }
    
    public long getClassId() {
        return 141;
    }
    
    public AssociationManager_AssociationsProxi getAssociations() throws PersistenceException {
        return ((PersistentAssociationManager)this.getTheObject()).getAssociations();
    }
    public AssociationManager_HierarchiesProxi getHierarchies() throws PersistenceException {
        return ((PersistentAssociationManager)this.getTheObject()).getHierarchies();
    }
    public PersistentAssociationManager getThis() throws PersistenceException {
        return ((PersistentAssociationManager)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAssociationManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAssociationManager(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAssociationManager(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAssociationManager(this);
    }
    
    
    public void addToHierarchy(final PersistentMAssociation association, final PersistentMAHierarchy theHierarchy) 
				throws PersistenceException{
        ((PersistentAssociationManager)this.getTheObject()).addToHierarchy(association, theHierarchy);
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentAssociationManager)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentAssociationManager)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void createHierarchy(final String name, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAssociationManager)this.getTheObject()).createHierarchy(name, invoker);
    }
    public void addToHierarchy(final PersistentMAssociation association, final PersistentMAHierarchy theHierarchy, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAssociationManager)this.getTheObject()).addToHierarchy(association, theHierarchy, invoker);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentAssociationManager)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void createAssociation(final String name, final MType source, final MType target, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAssociationManager)this.getTheObject()).createAssociation(name, source, target, invoker);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentAssociationManager)this.getTheObject()).initializeOnCreation();
    }
    public void createAssociation(final String name, final MType source, final MType target) 
				throws model.DoubleDefinitionException, PersistenceException{
        ((PersistentAssociationManager)this.getTheObject()).createAssociation(name, source, target);
    }
    public void createHierarchy(final String name) 
				throws model.DoubleDefinitionException, PersistenceException{
        ((PersistentAssociationManager)this.getTheObject()).createHierarchy(name);
    }

    
}
