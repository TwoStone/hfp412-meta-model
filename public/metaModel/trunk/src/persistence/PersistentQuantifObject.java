package persistence;

public interface PersistentQuantifObject extends Anything, AbstractPersistentProxi {
    
    public PersistentInstanceObject getDefaultType() throws PersistenceException ;
    public void setDefaultType(PersistentInstanceObject newValue) throws PersistenceException ;
    public abstract PersistentQuantifObject getThis() throws PersistenceException ;
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;

}

