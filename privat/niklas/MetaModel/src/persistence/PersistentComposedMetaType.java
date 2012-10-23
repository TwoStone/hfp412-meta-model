package persistence;

public interface PersistentComposedMetaType extends PersistentAbstractMetaType {
    
    public ComposedMetaType_ComponentsProxi getComponents() throws PersistenceException ;
    
    public void accept(model.visitor.ComposedMetaTypeVisitor visitor) throws PersistenceException;
    public <R> R accept(model.visitor.ComposedMetaTypeReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(model.visitor.ComposedMetaTypeExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(model.visitor.ComposedMetaTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public PersistentOrMetaType getDisjunctiveNormalform(final TDObserver observer) 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public PersistentOrMetaType getDisjunctiveNormalform() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;

}

