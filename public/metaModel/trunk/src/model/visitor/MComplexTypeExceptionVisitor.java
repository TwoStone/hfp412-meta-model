
package model.visitor;
import model.UserException;
import persistence.*;

public interface MComplexTypeExceptionVisitor<E extends UserException> extends MAbstractSumTypeExceptionVisitor<E>,MAbstractProductTypeExceptionVisitor<E>{
    
    public void handleMAbstractProductType(PersistentMAbstractProductType mAbstractProductType) throws PersistenceException, E;
    
}
