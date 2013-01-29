
package model.visitor;

public interface CommandReturnVisitor<R> extends AspectManagerCommandReturnVisitor<R> ,MessageManagerCommandReturnVisitor<R> ,QuantityManagerCommandReturnVisitor<R> ,AccountManagerCommandReturnVisitor<R> ,UnitTypeManagerCommandReturnVisitor<R> ,AssociationManagerCommandReturnVisitor<R> ,TypeManagerCommandReturnVisitor<R> ,AccountTypeManagerCommandReturnVisitor<R> ,NameSchemeManagerCommandReturnVisitor<R> ,MeasurementTypeManagerCommandReturnVisitor<R> ,ObjectManagerCommandReturnVisitor<R> ,LinkManagerCommandReturnVisitor<R> ,NameSchemeInstaceManagerCommandReturnVisitor<R> ,OperationManagerCommandReturnVisitor<R> ,ConversionManagerCommandReturnVisitor<R> {
    
    
}
