package persistence;



public abstract class MAbsOperationProxi extends PersistentProxi implements PersistentMAbsOperation{
    
    public MAbsOperationProxi(long objectId) {
        super(objectId);
    }
    public MAbsOperationProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public String getName() throws PersistenceException {
        return ((PersistentMAbsOperation)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentMAbsOperation)this.getTheObject()).setName(newValue);
    }
    public MType getSource() throws PersistenceException {
        return ((PersistentMAbsOperation)this.getTheObject()).getSource();
    }
    public void setSource(MType newValue) throws PersistenceException {
        ((PersistentMAbsOperation)this.getTheObject()).setSource(newValue);
    }
    public MType getTarget() throws PersistenceException {
        return ((PersistentMAbsOperation)this.getTheObject()).getTarget();
    }
    public void setTarget(MType newValue) throws PersistenceException {
        ((PersistentMAbsOperation)this.getTheObject()).setTarget(newValue);
    }
    public MAbsOperation_ParametersProxi getParameters() throws PersistenceException {
        return ((PersistentMAbsOperation)this.getTheObject()).getParameters();
    }
    public abstract PersistentMAbsOperation getThis() throws PersistenceException ;
    
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentMAbsOperation)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentMAbsOperation)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentMAbsOperation)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentMAbsOperation)this.getTheObject()).initializeOnCreation();
    }

    
}
