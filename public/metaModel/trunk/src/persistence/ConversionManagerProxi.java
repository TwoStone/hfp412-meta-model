package persistence;

import model.UserException;

import model.visitor.*;

public class ConversionManagerProxi extends PersistentProxi implements PersistentConversionManager{
    
    public ConversionManagerProxi(long objectId) {
        super(objectId);
    }
    public ConversionManagerProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theConversionManagerFacade
            .getConversionManager(this.getId());
    }
    
    public long getClassId() {
        return 149;
    }
    
    public ConversionManager_ConversionsProxi getConversions() throws PersistenceException {
        return ((PersistentConversionManager)this.getTheObject()).getConversions();
    }
    public PersistentConversionManager getThis() throws PersistenceException {
        return ((PersistentConversionManager)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleConversionManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleConversionManager(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleConversionManager(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleConversionManager(this);
    }
    
    
    public void createConversion(final PersistentUnit unit, final common.Fraction factor, final common.Fraction constant) 
				throws PersistenceException{
        ((PersistentConversionManager)this.getTheObject()).createConversion(unit, factor, constant);
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentConversionManager)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentConversionManager)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentConversionManager)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentConversionManager)this.getTheObject()).initializeOnCreation();
    }
    public void createConversion(final PersistentUnit unit, final common.Fraction factor, final common.Fraction constant, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentConversionManager)this.getTheObject()).createConversion(unit, factor, constant, invoker);
    }

    
}
