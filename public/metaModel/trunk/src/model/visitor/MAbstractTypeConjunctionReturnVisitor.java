
package model.visitor;

import persistence.*;

public interface MAbstractTypeConjunctionReturnVisitor<R> extends MAtomicTypeConjunctionReturnVisitor<R> {
    
    public R handleMMixedConjunction(PersistentMMixedConjunction mMixedConjunction) throws PersistenceException;
    
}
