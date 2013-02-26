
package model.visitor;
import model.UserException;
import persistence.*;

public interface MAbstractTypeConjunctionExceptionVisitor<E extends UserException> extends MAtomicTypeConjunctionExceptionVisitor<E>{
    
    public void handleMMixedConjunction(PersistentMMixedConjunction mMixedConjunction) throws PersistenceException, E;
    
}
