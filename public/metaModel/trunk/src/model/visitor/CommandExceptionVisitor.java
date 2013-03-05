
package model.visitor;
import model.UserException;
public interface CommandExceptionVisitor<E extends UserException> extends AspectManagerCommandExceptionVisitor<E>,MessageManagerCommandExceptionVisitor<E>,FractionManagerCommandExceptionVisitor<E>,QuantityManagerCommandExceptionVisitor<E>,AccountManagerCommandExceptionVisitor<E>,UnitTypeManagerCommandExceptionVisitor<E>,QuantifObjectCommandExceptionVisitor<E>,AssociationManagerCommandExceptionVisitor<E>,AccountTypeManagerCommandExceptionVisitor<E>,TypeManagerCommandExceptionVisitor<E>,MeasurementTypeManagerCommandExceptionVisitor<E>,NameSchemeManagerCommandExceptionVisitor<E>,MAccountTypeCommandExceptionVisitor<E>,AccountCommandExceptionVisitor<E>,ObjectManagerCommandExceptionVisitor<E>,LinkManagerCommandExceptionVisitor<E>,OperationManagerCommandExceptionVisitor<E>{
    
    
}
