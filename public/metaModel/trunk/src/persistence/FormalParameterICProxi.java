package persistence;

import model.UserException;

import model.visitor.*;

public class FormalParameterICProxi extends PersistentInCacheProxiOptimistic implements PersistentFormalParameter{
    
    public FormalParameterICProxi(long objectId) {
        super(objectId);
    }
    public FormalParameterICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theFormalParameterFacade
            .getFormalParameter(this.getId());
    }
    
    public long getClassId() {
        return 225;
    }
    
    public PersistentMType getOfType() throws PersistenceException {
        return ((PersistentFormalParameter)this.getTheObject()).getOfType();
    }
    public void setOfType(PersistentMType newValue) throws PersistenceException {
        ((PersistentFormalParameter)this.getTheObject()).setOfType(newValue);
    }
    public String getName() throws PersistenceException {
        return ((PersistentFormalParameter)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentFormalParameter)this.getTheObject()).setName(newValue);
    }
    public PersistentFormalParameter getThis() throws PersistenceException {
        return ((PersistentFormalParameter)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleFormalParameter(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleFormalParameter(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleFormalParameter(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleFormalParameter(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentFormalParameter)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentFormalParameter)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentFormalParameter)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentFormalParameter)this.getTheObject()).initializeOnCreation();
    }

    
}
