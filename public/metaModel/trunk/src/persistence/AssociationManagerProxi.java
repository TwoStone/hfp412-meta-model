package persistence;

import model.UserException;

import model.visitor.*;

public class AssociationManagerProxi extends PersistentProxi implements PersistentAssociationManager{
    
    public AssociationManagerProxi(long objectId) {
        super(objectId);
    }
    public AssociationManagerProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theAssociationManagerFacade
            .getAssociationManager(this.getId());
    }
    
    public long getClassId() {
        return 152;
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
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentAssociationManager)this.getTheObject()).initializeOnInstantiation();
    }
    public void createAssociation(final PersistentMType source, final PersistentMType target, final String name) 
				throws model.DoubleDefinitionException, PersistenceException{
        ((PersistentAssociationManager)this.getTheObject()).createAssociation(source, target, name);
    }
    public void addAssociation(final PersistentHierarchy h, final PersistentAssociation a, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAssociationManager)this.getTheObject()).addAssociation(h, a, invoker);
    }
    public void addAssociation(final PersistentHierarchy h, final PersistentAssociation a) 
				throws model.DoubleDefinitionException, model.CycleException, PersistenceException{
        ((PersistentAssociationManager)this.getTheObject()).addAssociation(h, a);
    }
    public void removeAssoFrmHier(final PersistentHierarchy h, final PersistentAssociation a) 
				throws model.NotAvailableException, model.CycleException, PersistenceException{
        ((PersistentAssociationManager)this.getTheObject()).removeAssoFrmHier(h, a);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentAssociationManager)this.getTheObject()).initializeOnCreation();
    }
    public void removeAssoFrmHier(final PersistentHierarchy h, final PersistentAssociation a, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAssociationManager)this.getTheObject()).removeAssoFrmHier(h, a, invoker);
    }
    public void removeAssociation(final PersistentAssociation a) 
				throws model.ConsistencyException, model.CycleException, PersistenceException{
        ((PersistentAssociationManager)this.getTheObject()).removeAssociation(a);
    }
    public void createAssociation(final PersistentMType source, final PersistentMType target, final String name, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAssociationManager)this.getTheObject()).createAssociation(source, target, name, invoker);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentAssociationManager)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void createHierarchy(final PersistentAssociation a, final String name, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAssociationManager)this.getTheObject()).createHierarchy(a, name, invoker);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentAssociationManager)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void removeAssociation(final PersistentAssociation a, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAssociationManager)this.getTheObject()).removeAssociation(a, invoker);
    }
    public void createHierarchy(final PersistentAssociation a, final String name) 
				throws model.DoubleDefinitionException, PersistenceException{
        ((PersistentAssociationManager)this.getTheObject()).createHierarchy(a, name);
    }

    
}
