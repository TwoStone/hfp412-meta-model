
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentMMixedTypeDisjunction;

public interface MAbstractTypeDisjunctionVisitor extends MDisjunctiveNormalFormVisitor{
    
    public void handleMMixedTypeDisjunction(PersistentMMixedTypeDisjunction mMixedTypeDisjunction) throws PersistenceException;
    
}
