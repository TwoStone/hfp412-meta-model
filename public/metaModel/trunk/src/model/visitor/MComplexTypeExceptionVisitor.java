
package model.visitor;
import model.UserException;
public interface MComplexTypeExceptionVisitor<E extends UserException> extends MAbstractTypeDisjunctionExceptionVisitor<E>,MAbstractTypeConjunctionExceptionVisitor<E>{
    
    
}
