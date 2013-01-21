
package model.visitor;
import model.UserException;
public interface CommandExceptionVisitor<E extends UserException> extends AssociationManagerCommandExceptionVisitor<E>,AccountTypeManagerCommandExceptionVisitor<E>,TypeManagerCommandExceptionVisitor<E>,AspectManagerCommandExceptionVisitor<E>,MessageManagerCommandExceptionVisitor<E>,MeasurementTypeManagerCommandExceptionVisitor<E>,QuantityManagerCommandExceptionVisitor<E>,AccountManagerCommandExceptionVisitor<E>,ObjectManagerCommandExceptionVisitor<E>,UnitTypeManagerCommandExceptionVisitor<E>,LinkManagerCommandExceptionVisitor<E>,OperationManagerCommandExceptionVisitor<E>,ConversionManagerCommandExceptionVisitor<E>{
    
    
}
