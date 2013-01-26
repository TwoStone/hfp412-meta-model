
package model.visitor;
import model.UserException;
public interface MComplexTypeExceptionVisitor<E extends UserException> extends MAbstractSumTypeExceptionVisitor<E>,MAbstractProductTypeExceptionVisitor<E>{
    
    
}
