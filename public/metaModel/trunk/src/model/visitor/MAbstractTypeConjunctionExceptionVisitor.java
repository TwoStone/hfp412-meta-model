
package model.visitor;
import model.UserException;
import persistence.PersistenceException;
import persistence.PersistentMMixedConjunction;

public interface MAbstractTypeConjunctionExceptionVisitor<E extends UserException> extends MAtomicTypeConjunctionExceptionVisitor<E>{
    
    public void handleMMixedConjunction(PersistentMMixedConjunction mMixedConjunction) throws PersistenceException, E;
    
}
