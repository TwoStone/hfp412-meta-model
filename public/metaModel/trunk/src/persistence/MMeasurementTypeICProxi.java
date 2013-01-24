package persistence;

import model.UserException;

import model.visitor.*;

public class MMeasurementTypeICProxi extends MQuantiObjectTypeICProxi implements PersistentMMeasurementType{
    
    public MMeasurementTypeICProxi(long objectId) {
        super(objectId);
    }
    public MMeasurementTypeICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theMMeasurementTypeFacade
            .getMMeasurementType(this.getId());
    }
    
    public long getClassId() {
        return 125;
    }
    
    public PersistentMMeasurementType getThis() throws PersistenceException {
        return ((PersistentMMeasurementType)this.getTheObject()).getThis();
    }
    
    public void accept(MQuantiObjectTypeVisitor visitor) throws PersistenceException {
        visitor.handleMMeasurementType(this);
    }
    public <R> R accept(MQuantiObjectTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMMeasurementType(this);
    }
    public <E extends UserException>  void accept(MQuantiObjectTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMMeasurementType(this);
    }
    public <R, E extends UserException> R accept(MQuantiObjectTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMMeasurementType(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMMeasurementType(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMMeasurementType(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMMeasurementType(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMMeasurementType(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentMMeasurementType)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentMMeasurementType)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentMMeasurementType)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentMMeasurementType)this.getTheObject()).initializeOnCreation();
    }

    
}
