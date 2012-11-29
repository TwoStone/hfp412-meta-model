package persistence;

import model.UserException;

import model.visitor.*;

public class UnitICProxi extends AbsUnitICProxi implements PersistentUnit{
    
    public UnitICProxi(long objectId) {
        super(objectId);
    }
    public UnitICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theUnitFacade
            .getUnit(this.getId());
    }
    
    public long getClassId() {
        return 108;
    }
    
    public PersistentUnit getThis() throws PersistenceException {
        return ((PersistentUnit)this.getTheObject()).getThis();
    }
    
    public void accept(AbsUnitVisitor visitor) throws PersistenceException {
        visitor.handleUnit(this);
    }
    public <R> R accept(AbsUnitReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUnit(this);
    }
    public <E extends UserException>  void accept(AbsUnitExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUnit(this);
    }
    public <R, E extends UserException> R accept(AbsUnitReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUnit(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleUnit(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUnit(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUnit(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUnit(this);
    }
    
    
    public PersistentConversion getMyConversion() 
				throws PersistenceException{
        return ((PersistentUnit)this.getTheObject()).getMyConversion();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentUnit)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentUnit)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentUnit)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentUnit)this.getTheObject()).initializeOnCreation();
    }

    
}
