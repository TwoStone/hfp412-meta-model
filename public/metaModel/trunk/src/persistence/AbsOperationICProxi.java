package persistence;



public abstract class AbsOperationICProxi extends PersistentInCacheProxiOptimistic implements PersistentAbsOperation{
    
    public AbsOperationICProxi(long objectId) {
        super(objectId);
    }
    public AbsOperationICProxi(PersistentObject object) {
        super(object);
    }
    
    
    public String getName() throws PersistenceException {
        return ((PersistentAbsOperation)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentAbsOperation)this.getTheObject()).setName(newValue);
    }
    public PersistentMType getSource() throws PersistenceException {
        return ((PersistentAbsOperation)this.getTheObject()).getSource();
    }
    public void setSource(PersistentMType newValue) throws PersistenceException {
        ((PersistentAbsOperation)this.getTheObject()).setSource(newValue);
    }
    public PersistentMType getTarget() throws PersistenceException {
        return ((PersistentAbsOperation)this.getTheObject()).getTarget();
    }
    public void setTarget(PersistentMType newValue) throws PersistenceException {
        ((PersistentAbsOperation)this.getTheObject()).setTarget(newValue);
    }
    public AbsOperation_ParametersProxi getParameters() throws PersistenceException {
        return ((PersistentAbsOperation)this.getTheObject()).getParameters();
    }
    public abstract PersistentAbsOperation getThis() throws PersistenceException ;
    
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentAbsOperation)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentAbsOperation)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentAbsOperation)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentAbsOperation)this.getTheObject()).initializeOnCreation();
    }

    
}
