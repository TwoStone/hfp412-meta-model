
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentMMixedConjunction;

public interface MAbstractTypeConjunctionVisitor extends MAtomicTypeConjunctionVisitor{
    
    public void handleMMixedConjunction(PersistentMMixedConjunction mMixedConjunction) throws PersistenceException;
    
}
