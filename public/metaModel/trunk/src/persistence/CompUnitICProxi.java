package persistence;

import model.UserException;

import model.visitor.*;

public class CompUnitICProxi extends AbsUnitICProxi implements PersistentCompUnit{
    
    public CompUnitICProxi(long objectId) {
        super(objectId);
    }
    public CompUnitICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theCompUnitFacade
            .getCompUnit(this.getId());
    }
    
    public long getClassId() {
        return 162;
    }
    
    public CompUnit_RefsProxi getRefs() throws PersistenceException {
        return ((PersistentCompUnit)this.getTheObject()).getRefs();
    }
    public PersistentMBoolean getIsFinal() throws PersistenceException {
        return ((PersistentCompUnit)this.getTheObject()).getIsFinal();
    }
    public void setIsFinal(PersistentMBoolean newValue) throws PersistenceException {
        ((PersistentCompUnit)this.getTheObject()).setIsFinal(newValue);
    }
    public PersistentCompUnit getThis() throws PersistenceException {
        return ((PersistentCompUnit)this.getTheObject()).getThis();
    }
    
    public void accept(AbsUnitVisitor visitor) throws PersistenceException {
        visitor.handleCompUnit(this);
    }
    public <R> R accept(AbsUnitReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompUnit(this);
    }
    public <E extends UserException>  void accept(AbsUnitExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompUnit(this);
    }
    public <R, E extends UserException> R accept(AbsUnitReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompUnit(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCompUnit(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompUnit(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompUnit(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompUnit(this);
    }
    
    
    public PersistentMBoolean isFinal() 
				throws PersistenceException{
        return ((PersistentCompUnit)this.getTheObject()).isFinal();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentCompUnit)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentCompUnit)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentCompUnit)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void finishModeling() 
				throws model.AlreadyFinalizedException, model.ExponentMatchingException, PersistenceException{
        ((PersistentCompUnit)this.getTheObject()).finishModeling();
    }
    public void checkExponents() 
				throws model.ExponentMatchingException, PersistenceException{
        ((PersistentCompUnit)this.getTheObject()).checkExponents();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentCompUnit)this.getTheObject()).initializeOnCreation();
    }

    
}
