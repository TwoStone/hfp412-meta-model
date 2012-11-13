
package model.visitor;

public interface CommandReturnVisitor<R> extends UnitTypeManagerCommandReturnVisitor<R> ,ConversionManagerCommandReturnVisitor<R> ,QuantityManagerCommandReturnVisitor<R> {
    
    
}
