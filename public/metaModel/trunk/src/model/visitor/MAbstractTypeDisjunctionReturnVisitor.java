
package model.visitor;

import persistence.*;

public interface MAbstractTypeDisjunctionReturnVisitor<R> extends MDisjunctiveNormalFormReturnVisitor<R> {
    
    public R handleMMixedTypeDisjunction(PersistentMMixedTypeDisjunction mMixedTypeDisjunction) throws PersistenceException;
    
}
