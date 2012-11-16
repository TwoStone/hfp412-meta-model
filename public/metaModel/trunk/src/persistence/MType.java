package persistence;

import model.visitor.*;
import model.*;


/* Additional import section end */

public interface MType extends  MComplexTypeHierarchyHIERARCHY {
    
    public String fetchName() 
				throws PersistenceException;
    public PersistentMBoolean lessOrEqual(final MType otherType) 
				throws PersistenceException;

    public void accept(MTypeVisitor visitor) throws PersistenceException;
    public <R> R accept(MTypeReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(MTypeExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(MTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

