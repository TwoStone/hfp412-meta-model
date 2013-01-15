package persistence;

import model.UserException;

import model.visitor.*;

public class MAssociationProxi extends PersistentProxi implements PersistentMAssociation{
    
    public MAssociationProxi(long objectId) {
        super(objectId);
    }
    public MAssociationProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theMAssociationFacade
            .getMAssociation(this.getId());
    }
    
    public long getClassId() {
        return 143;
    }
    
    public String getName() throws PersistenceException {
        return ((PersistentMAssociation)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentMAssociation)this.getTheObject()).setName(newValue);
    }
    public PersistentMType getSource() throws PersistenceException {
        return ((PersistentMAssociation)this.getTheObject()).getSource();
    }
    public void setSource(PersistentMType newValue) throws PersistenceException {
        ((PersistentMAssociation)this.getTheObject()).setSource(newValue);
    }
    public PersistentMType getTarget() throws PersistenceException {
        return ((PersistentMAssociation)this.getTheObject()).getTarget();
    }
    public void setTarget(PersistentMType newValue) throws PersistenceException {
        ((PersistentMAssociation)this.getTheObject()).setTarget(newValue);
    }
    public MAssociation_HierarchiesProxi getHierarchies() throws PersistenceException {
        return ((PersistentMAssociation)this.getTheObject()).getHierarchies();
    }
    public PersistentMAssociation getThis() throws PersistenceException {
        return ((PersistentMAssociation)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMAssociation(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMAssociation(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMAssociation(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMAssociation(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentMAssociation)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentMAssociation)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentMAssociation)this.getTheObject()).initialize(This, final$$Fields);
    }
    public PersistentMBoolean isObservation() 
				throws PersistenceException{
        return ((PersistentMAssociation)this.getTheObject()).isObservation();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentMAssociation)this.getTheObject()).initializeOnCreation();
    }

    
}
