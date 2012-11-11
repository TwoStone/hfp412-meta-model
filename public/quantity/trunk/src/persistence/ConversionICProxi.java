package persistence;

import model.UserException;

import model.visitor.*;

public class ConversionICProxi extends PersistentInCacheProxiOptimistic implements PersistentConversion{
    
    public ConversionICProxi(long objectId) {
        super(objectId);
    }
    public ConversionICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theConversionFacade
            .getConversion(this.getId());
    }
    
    public long getClassId() {
        return 115;
    }
    
    public PersistentUnit getSource() throws PersistenceException {
        return ((PersistentConversion)this.getTheObject()).getSource();
    }
    public void setSource(PersistentUnit newValue) throws PersistenceException {
        ((PersistentConversion)this.getTheObject()).setSource(newValue);
    }
    public PersistentUnitType getType() throws PersistenceException {
        return ((PersistentConversion)this.getTheObject()).getType();
    }
    public void setType(PersistentUnitType newValue) throws PersistenceException {
        ((PersistentConversion)this.getTheObject()).setType(newValue);
    }
    public common.Fraction getFactor() throws PersistenceException {
        return ((PersistentConversion)this.getTheObject()).getFactor();
    }
    public void setFactor(common.Fraction newValue) throws PersistenceException {
        ((PersistentConversion)this.getTheObject()).setFactor(newValue);
    }
    public common.Fraction getConstant() throws PersistenceException {
        return ((PersistentConversion)this.getTheObject()).getConstant();
    }
    public void setConstant(common.Fraction newValue) throws PersistenceException {
        ((PersistentConversion)this.getTheObject()).setConstant(newValue);
    }
    public PersistentConversion getThis() throws PersistenceException {
        return ((PersistentConversion)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleConversion(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleConversion(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleConversion(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleConversion(this);
    }
    
    
    public PersistentQuantity convert(final common.Fraction amount) 
				throws PersistenceException{
        return ((PersistentConversion)this.getTheObject()).convert(amount);
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentConversion)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentConversion)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentConversion)this.getTheObject()).initialize(This, final$$Fields);
    }
    public PersistentQuantity convertInverse(final common.Fraction amount) 
				throws PersistenceException{
        return ((PersistentConversion)this.getTheObject()).convertInverse(amount);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentConversion)this.getTheObject()).initializeOnCreation();
    }

    
}
