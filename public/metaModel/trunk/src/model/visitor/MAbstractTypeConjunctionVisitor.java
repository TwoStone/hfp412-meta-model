
package model.visitor;

import persistence.*;

public interface MAbstractTypeConjunctionVisitor extends MAtomicTypeConjunctionVisitor{
    
    public void handleMMixedConjunction(PersistentMMixedConjunction mMixedConjunction) throws PersistenceException;
    
}
