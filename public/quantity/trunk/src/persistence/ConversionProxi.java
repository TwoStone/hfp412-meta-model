package persistence;

import model.UserException;

import model.visitor.*;

public class ConversionProxi extends PersistentProxi implements PersistentConversion{
    
    public ConversionProxi(long objectId) {
        super(objectId);
    }
    public ConversionProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theConversionFacade
            .getConversion(this.getId());
    }
    
    public long getClassId() {
        return 116;
    }
    
    public PersistentUnit getSource() throws PersistenceException {
        return ((PersistentConversion)this.getTheObject()).getSource();
    }
    public void setSource(PersistentUnit newValue) throws PersistenceException {
        ((PersistentConversion)this.getTheObject()).setSource(newValue);
    }
    public PersistentUnit getTarget() throws PersistenceException {
        return ((PersistentConversion)this.getTheObject()).getTarget();
    }
    public void setTarget(PersistentUnit newValue) throws PersistenceException {
        ((PersistentConversion)this.getTheObject()).setTarget(newValue);
    }
    public PersistentFunction getConvFunction() throws PersistenceException {
        return ((PersistentConversion)this.getTheObject()).getConvFunction();
    }
    public void setConvFunction(PersistentFunction newValue) throws PersistenceException {
        ((PersistentConversion)this.getTheObject()).setConvFunction(newValue);
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
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentConversion)this.getTheObject()).initializeOnCreation();
    }

    
}
