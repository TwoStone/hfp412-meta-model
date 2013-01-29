
package model.visitor;
import model.UserException;
public interface CommandReturnExceptionVisitor<R, E extends UserException> extends AssociationManagerCommandReturnExceptionVisitor<R, E> ,AccountTypeManagerCommandReturnExceptionVisitor<R, E> ,TypeManagerCommandReturnExceptionVisitor<R, E> ,AspectManagerCommandReturnExceptionVisitor<R, E> ,MessageManagerCommandReturnExceptionVisitor<R, E> ,MeasurementTypeManagerCommandReturnExceptionVisitor<R, E> ,NameSchemeManagerCommandReturnExceptionVisitor<R, E> ,QuantityManagerCommandReturnExceptionVisitor<R, E> ,AccountManagerCommandReturnExceptionVisitor<R, E> ,ObjectManagerCommandReturnExceptionVisitor<R, E> ,UnitTypeManagerCommandReturnExceptionVisitor<R, E> ,NameSchemeInstaceManagerCommandReturnExceptionVisitor<R, E> ,LinkManagerCommandReturnExceptionVisitor<R, E> ,OperationManagerCommandReturnExceptionVisitor<R, E> {
    
    
}
