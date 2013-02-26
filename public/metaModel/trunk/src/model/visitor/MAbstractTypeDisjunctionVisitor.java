
package model.visitor;

import persistence.*;

public interface MAbstractTypeDisjunctionVisitor extends MDisjunctiveNormalFormVisitor{
    
    public void handleMMixedTypeDisjunction(PersistentMMixedTypeDisjunction mMixedTypeDisjunction) throws PersistenceException;
    
}
