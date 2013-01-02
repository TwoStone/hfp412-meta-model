package persistence;

import model.visitor.*;
import model.*;


/* Additional import section end */

public interface MType extends  MComplexTypeHierarchyHIERARCHY {
    
    public PersistentMProductType transientAddFactor(final MType factor) 
				throws model.ConsistencyException, PersistenceException;
    public PersistentMBoolean contains(final MType otherType) 
				throws PersistenceException;
    public PersistentMBoolean isStructuralEqual(final MType otherType) 
				throws PersistenceException;
    public MAssociationSearchList fetchAssociations() 
				throws PersistenceException;
    public String fetchName() 
				throws PersistenceException;
    public PersistentMSumType transientAddAddend(final MType addend) 
				throws model.ConsistencyException, PersistenceException;
    public PersistentMBoolean isLessOrEqual(final MType otherType) 
				throws PersistenceException;
    public PersistentMBoolean isSingleton() 
				throws PersistenceException;
    public PersistentMSumType fetchDisjunctiveNormalform() 
				throws PersistenceException;
    public PersistentMBoolean isAbstract() 
				throws PersistenceException;
    public PersistentMBoolean allObjectsOfTypeAreSingleton() 
				throws PersistenceException;

    public void accept(MTypeVisitor visitor) throws PersistenceException;
    public <R> R accept(MTypeReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(MTypeExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(MTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

