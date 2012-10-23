package persistence;

public interface PersistentMetaType extends PersistentCONCNamedEntity, PersistentAbstractMetaType {
    
    public MetaType_SubtypesProxi getSubtypes() throws PersistenceException ;
    public PersistentMetaAspect getMyAspect() throws PersistenceException ;
    public void setMyAspect(PersistentMetaAspect newValue) throws PersistenceException ;
    public PersistentNamedEntity getMyCONCNamedEntity() throws PersistenceException ;
    public void setMyCONCNamedEntity(PersistentNamedEntity newValue) throws PersistenceException ;
    public PersistentMetaType getThis() throws PersistenceException ;
    
    public void accept(model.visitor.AbstractMetaTypeVisitor visitor) throws PersistenceException;
    public <R> R accept(model.visitor.AbstractMetaTypeReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(model.visitor.AbstractMetaTypeExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(model.visitor.AbstractMetaTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(model.visitor.NamedEntityVisitor visitor) throws PersistenceException;
    public <R> R accept(model.visitor.NamedEntityReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(model.visitor.NamedEntityExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(model.visitor.NamedEntityReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public MetaTypeSearchList inverseGetSubtypes() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;

}

