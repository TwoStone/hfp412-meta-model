
package model.visitor;

public interface CommandReturnVisitor<R> extends AssociationManagerCommandReturnVisitor<R> ,AccountTypeManagerCommandReturnVisitor<R> ,TypeManagerCommandReturnVisitor<R> ,AspectManagerCommandReturnVisitor<R> ,MessageManagerCommandReturnVisitor<R> ,MeasurementTypeManagerCommandReturnVisitor<R> ,NameSchemeManagerCommandReturnVisitor<R> ,QuantityManagerCommandReturnVisitor<R> ,AccountManagerCommandReturnVisitor<R> ,ObjectManagerCommandReturnVisitor<R> ,UnitTypeManagerCommandReturnVisitor<R> ,LinkManagerCommandReturnVisitor<R> ,OperationManagerCommandReturnVisitor<R> {
    
    
}
