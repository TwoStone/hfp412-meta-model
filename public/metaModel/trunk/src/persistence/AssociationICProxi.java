package persistence;

import model.UserException;

import model.visitor.*;

public class AssociationICProxi extends AbsOperationICProxi implements PersistentAssociation{
    
    public AssociationICProxi(long objectId) {
        super(objectId);
    }
    public AssociationICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theAssociationFacade
            .getAssociation(this.getId());
    }
    
    public long getClassId() {
        return 116;
    }
    
    public Association_HierarchiesProxi getHierarchies() throws PersistenceException {
        return ((PersistentAssociation)this.getTheObject()).getHierarchies();
    }
    public PersistentAssociation getThis() throws PersistenceException {
        return ((PersistentAssociation)this.getTheObject()).getThis();
    }
    
    public void accept(AbsOperationVisitor visitor) throws PersistenceException {
        visitor.handleAssociation(this);
    }
    public <R> R accept(AbsOperationReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAssociation(this);
    }
    public <E extends UserException>  void accept(AbsOperationExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAssociation(this);
    }
    public <R, E extends UserException> R accept(AbsOperationReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAssociation(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAssociation(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAssociation(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAssociation(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAssociation(this);
    }
    
    
    public PersistentMBoolean hasEqualSourceTargetName(final PersistentAssociation other) 
				throws PersistenceException{
        return ((PersistentAssociation)this.getTheObject()).hasEqualSourceTargetName(other);
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentAssociation)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentAssociation)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentAssociation)this.getTheObject()).initialize(This, final$$Fields);
    }
    public PersistentMBoolean isObservation() 
				throws PersistenceException{
        return ((PersistentAssociation)this.getTheObject()).isObservation();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentAssociation)this.getTheObject()).initializeOnCreation();
    }

    
}
