
package model.visitor;

public interface CommandReturnVisitor<R> extends TypeManagerCommandReturnVisitor<R> ,ConversionManagerCommandReturnVisitor<R> ,QuantityManagerCommandReturnVisitor<R> ,UnitManagerCommandReturnVisitor<R> {
    
    
}
