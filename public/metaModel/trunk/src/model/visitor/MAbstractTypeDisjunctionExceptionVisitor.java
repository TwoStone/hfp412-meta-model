
package model.visitor;
import model.UserException;
import persistence.PersistenceException;
import persistence.PersistentMMixedTypeDisjunction;

public interface MAbstractTypeDisjunctionExceptionVisitor<E extends UserException> extends MDisjunctiveNormalFormExceptionVisitor<E>{
    
    public void handleMMixedTypeDisjunction(PersistentMMixedTypeDisjunction mMixedTypeDisjunction) throws PersistenceException, E;
    
}
