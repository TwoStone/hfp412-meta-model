
package view.visitor;
import view.UserException;
public interface MComplexTypeExceptionVisitor<E extends UserException> extends MAbstractSumTypeExceptionVisitor<E>,MAbstractProductTypeExceptionVisitor<E>{
    
    
}
