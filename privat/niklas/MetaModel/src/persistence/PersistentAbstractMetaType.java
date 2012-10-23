package persistence;

public interface PersistentAbstractMetaType extends Anything, AbstractPersistentProxi {
    
    public abstract PersistentAbstractMetaType getThis() throws PersistenceException ;
    
    public void accept(model.visitor.AbstractMetaTypeVisitor visitor) throws PersistenceException;
    public <R> R accept(model.visitor.AbstractMetaTypeReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(model.visitor.AbstractMetaTypeExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(model.visitor.AbstractMetaTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public java.lang.Boolean specializes(final PersistentAbstractMetaType metaType) 
				throws PersistenceException;

}

