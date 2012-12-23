
package model.visitor;

public interface CommandReturnVisitor<R> extends AssociationManagerCommandReturnVisitor<R> ,TypeManagerCommandReturnVisitor<R> ,AspectManagerCommandReturnVisitor<R> ,QuantityManagerCommandReturnVisitor<R> ,UnitTypeManagerCommandReturnVisitor<R> ,ConversionManagerCommandReturnVisitor<R> {
    
    
}
