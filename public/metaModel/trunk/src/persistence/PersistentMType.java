package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentMType extends MComplexTypeHierarchyHIERARCHY, Anything, AbstractPersistentProxi {
    
    public abstract PersistentMType getThis() throws PersistenceException ;
    
    public void accept(MTypeVisitor visitor) throws PersistenceException;
    public <R> R accept(MTypeReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(MTypeExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(MTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException;
    public PersistentMBoolean isStructuralEquivalant(final PersistentMType other) 
				throws PersistenceException;
    public String fetchName() 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public PersistentMBoolean isSingleton() 
				throws PersistenceException;
    public PersistentMBoolean isLessOrEqual() 
				throws PersistenceException;
    public PersistentMBoolean isAbstract() 
				throws PersistenceException;

}

