
package model.visitor;

public interface CommandReturnVisitor<R> extends AssociationManagerCommandReturnVisitor<R> ,AccountTypeManagerCommandReturnVisitor<R> ,TypeManagerCommandReturnVisitor<R> ,AspectManagerCommandReturnVisitor<R> ,MessageManagerCommandReturnVisitor<R> ,MeasurementTypeManagerCommandReturnVisitor<R> ,QuantityManagerCommandReturnVisitor<R> ,AccountManagerCommandReturnVisitor<R> ,UnitTypeManagerCommandReturnVisitor<R> ,LinkManagerCommandReturnVisitor<R> ,OperationManagerCommandReturnVisitor<R> ,ConversionManagerCommandReturnVisitor<R> {
    
    
}
