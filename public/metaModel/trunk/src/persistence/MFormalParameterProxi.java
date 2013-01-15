package persistence;

import model.UserException;

import model.visitor.*;

public class MFormalParameterProxi extends PersistentProxi implements PersistentMFormalParameter{
    
    public MFormalParameterProxi(long objectId) {
        super(objectId);
    }
    public MFormalParameterProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theMFormalParameterFacade
            .getMFormalParameter(this.getId());
    }
    
    public long getClassId() {
        return 201;
    }
    
    public PersistentMType getOfType() throws PersistenceException {
        return ((PersistentMFormalParameter)this.getTheObject()).getOfType();
    }
    public void setOfType(PersistentMType newValue) throws PersistenceException {
        ((PersistentMFormalParameter)this.getTheObject()).setOfType(newValue);
    }
    public String getName() throws PersistenceException {
        return ((PersistentMFormalParameter)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentMFormalParameter)this.getTheObject()).setName(newValue);
    }
    public PersistentMFormalParameter getThis() throws PersistenceException {
        return ((PersistentMFormalParameter)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMFormalParameter(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMFormalParameter(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMFormalParameter(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMFormalParameter(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentMFormalParameter)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentMFormalParameter)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentMFormalParameter)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentMFormalParameter)this.getTheObject()).initializeOnCreation();
    }

    
}
