
package model.visitor;
import model.UserException;
public interface CommandExceptionVisitor<E extends UserException> extends AssociationManagerCommandExceptionVisitor<E>,AccountTypeManagerCommandExceptionVisitor<E>,TypeManagerCommandExceptionVisitor<E>,AspectManagerCommandExceptionVisitor<E>,MeasurementTypeManagerCommandExceptionVisitor<E>,QuantityManagerCommandExceptionVisitor<E>,AccountManagerCommandExceptionVisitor<E>,UnitTypeManagerCommandExceptionVisitor<E>,ConversionManagerCommandExceptionVisitor<E>{
    
    
}
