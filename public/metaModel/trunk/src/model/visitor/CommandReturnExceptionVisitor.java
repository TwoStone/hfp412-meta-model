
package model.visitor;
import model.UserException;
public interface CommandReturnExceptionVisitor<R, E extends UserException> extends AspectManagerCommandReturnExceptionVisitor<R, E> ,MessageManagerCommandReturnExceptionVisitor<R, E> ,QuantityManagerCommandReturnExceptionVisitor<R, E> ,AccountManagerCommandReturnExceptionVisitor<R, E> ,UnitTypeManagerCommandReturnExceptionVisitor<R, E> ,AssociationManagerCommandReturnExceptionVisitor<R, E> ,TypeManagerCommandReturnExceptionVisitor<R, E> ,AccountTypeManagerCommandReturnExceptionVisitor<R, E> ,NameSchemeManagerCommandReturnExceptionVisitor<R, E> ,MeasurementTypeManagerCommandReturnExceptionVisitor<R, E> ,ObjectManagerCommandReturnExceptionVisitor<R, E> ,LinkManagerCommandReturnExceptionVisitor<R, E> ,NameSchemeInstaceManagerCommandReturnExceptionVisitor<R, E> ,OperationManagerCommandReturnExceptionVisitor<R, E> ,ConversionManagerCommandReturnExceptionVisitor<R, E> {
    
    
}
