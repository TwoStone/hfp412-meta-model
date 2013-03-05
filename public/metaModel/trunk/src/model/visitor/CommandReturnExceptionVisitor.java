
package model.visitor;
import model.UserException;
public interface CommandReturnExceptionVisitor<R, E extends UserException> extends AspectManagerCommandReturnExceptionVisitor<R, E> ,MessageManagerCommandReturnExceptionVisitor<R, E> ,FractionManagerCommandReturnExceptionVisitor<R, E> ,QuantityManagerCommandReturnExceptionVisitor<R, E> ,AccountManagerCommandReturnExceptionVisitor<R, E> ,UnitTypeManagerCommandReturnExceptionVisitor<R, E> ,QuantifObjectCommandReturnExceptionVisitor<R, E> ,AssociationManagerCommandReturnExceptionVisitor<R, E> ,AccountTypeManagerCommandReturnExceptionVisitor<R, E> ,TypeManagerCommandReturnExceptionVisitor<R, E> ,NameSchemeManagerCommandReturnExceptionVisitor<R, E> ,MAccountTypeCommandReturnExceptionVisitor<R, E> ,MeasurementTypeManagerCommandReturnExceptionVisitor<R, E> ,AccountCommandReturnExceptionVisitor<R, E> ,ObjectManagerCommandReturnExceptionVisitor<R, E> ,LinkManagerCommandReturnExceptionVisitor<R, E> ,OperationManagerCommandReturnExceptionVisitor<R, E> {
    
    
}
