package persistence;

import model.UserException;

import model.visitor.*;

public class FunctionProxi extends PersistentProxi implements PersistentFunction{
    
    public FunctionProxi(long objectId) {
        super(objectId);
    }
    public FunctionProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theFunctionFacade
            .getFunction(this.getId());
    }
    
    public long getClassId() {
        return 135;
    }
    
    public common.Fraction getFactor() throws PersistenceException {
        return ((PersistentFunction)this.getTheObject()).getFactor();
    }
    public void setFactor(common.Fraction newValue) throws PersistenceException {
        ((PersistentFunction)this.getTheObject()).setFactor(newValue);
    }
    public common.Fraction getConstant() throws PersistenceException {
        return ((PersistentFunction)this.getTheObject()).getConstant();
    }
    public void setConstant(common.Fraction newValue) throws PersistenceException {
        ((PersistentFunction)this.getTheObject()).setConstant(newValue);
    }
    public PersistentFunction getThis() throws PersistenceException {
        return ((PersistentFunction)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleFunction(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleFunction(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleFunction(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleFunction(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentFunction)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentFunction)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentFunction)this.getTheObject()).initialize(This, final$$Fields);
    }
    public common.Fraction executeInverse(final common.Fraction amount) 
				throws PersistenceException{
        return ((PersistentFunction)this.getTheObject()).executeInverse(amount);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentFunction)this.getTheObject()).initializeOnCreation();
    }
    public common.Fraction execute(final common.Fraction amount) 
				throws PersistenceException{
        return ((PersistentFunction)this.getTheObject()).execute(amount);
    }

    
}
