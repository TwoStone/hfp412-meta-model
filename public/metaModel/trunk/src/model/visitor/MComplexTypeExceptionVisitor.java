
package model.visitor;
import model.UserException;
import persistence.*;

public interface MComplexTypeExceptionVisitor<E extends UserException> extends MProductTypeExceptionVisitor<E>,MSumTypeExceptionVisitor<E>{
    
    public void handleMProductType(PersistentMProductType mProductType) throws PersistenceException, E;
    public void handleMSumType(PersistentMSumType mSumType) throws PersistenceException, E;
    
}
