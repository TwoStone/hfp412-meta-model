
package model.visitor;

public interface CommandReturnVisitor<R> extends AssociationManagerCommandReturnVisitor<R> ,AccountTypeManagerCommandReturnVisitor<R> ,TypeManagerCommandReturnVisitor<R> ,AspectManagerCommandReturnVisitor<R> ,MeasurementTypeManagerCommandReturnVisitor<R> ,QuantityManagerCommandReturnVisitor<R> ,AccountManagerCommandReturnVisitor<R> ,UnitTypeManagerCommandReturnVisitor<R> ,ConversionManagerCommandReturnVisitor<R> {
    
    
}
