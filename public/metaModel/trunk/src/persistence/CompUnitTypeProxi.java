package persistence;

import model.UserException;

import model.visitor.*;

public class CompUnitTypeProxi extends AbsUnitTypeProxi implements PersistentCompUnitType{
    
    public CompUnitTypeProxi(long objectId) {
        super(objectId);
    }
    public CompUnitTypeProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theCompUnitTypeFacade
            .getCompUnitType(this.getId());
    }
    
    public long getClassId() {
        return 165;
    }
    
    public CompUnitType_RefsProxi getRefs() throws PersistenceException {
        return ((PersistentCompUnitType)this.getTheObject()).getRefs();
    }
    public PersistentMBoolean getIsFinal() throws PersistenceException {
        return ((PersistentCompUnitType)this.getTheObject()).getIsFinal();
    }
    public void setIsFinal(PersistentMBoolean newValue) throws PersistenceException {
        ((PersistentCompUnitType)this.getTheObject()).setIsFinal(newValue);
    }
    public PersistentCompUnitType getThis() throws PersistenceException {
        return ((PersistentCompUnitType)this.getTheObject()).getThis();
    }
    
    public void accept(AbsUnitTypeVisitor visitor) throws PersistenceException {
        visitor.handleCompUnitType(this);
    }
    public <R> R accept(AbsUnitTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompUnitType(this);
    }
    public <E extends UserException>  void accept(AbsUnitTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompUnitType(this);
    }
    public <R, E extends UserException> R accept(AbsUnitTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompUnitType(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCompUnitType(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompUnitType(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompUnitType(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompUnitType(this);
    }
    
    
    public PersistentMBoolean isFinal() 
				throws PersistenceException{
        return ((PersistentCompUnitType)this.getTheObject()).isFinal();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentCompUnitType)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentCompUnitType)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentCompUnitType)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void finishModeling() 
				throws model.AlreadyFinalizedException, PersistenceException{
        ((PersistentCompUnitType)this.getTheObject()).finishModeling();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentCompUnitType)this.getTheObject()).initializeOnCreation();
    }

    
}
