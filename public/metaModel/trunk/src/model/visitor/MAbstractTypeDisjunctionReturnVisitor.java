
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentMMixedTypeDisjunction;

public interface MAbstractTypeDisjunctionReturnVisitor<R> extends MDisjunctiveNormalFormReturnVisitor<R> {
    
    public R handleMMixedTypeDisjunction(PersistentMMixedTypeDisjunction mMixedTypeDisjunction) throws PersistenceException;
    
}
