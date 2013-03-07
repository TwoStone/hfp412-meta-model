
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentMMixedConjunction;

public interface MAbstractTypeConjunctionReturnVisitor<R> extends MAtomicTypeConjunctionReturnVisitor<R> {
    
    public R handleMMixedConjunction(PersistentMMixedConjunction mMixedConjunction) throws PersistenceException;
    
}
