
package model.visitor;

public interface CommandReturnVisitor<R> extends AspectManagerCommandReturnVisitor<R> ,MessageManagerCommandReturnVisitor<R> ,FractionManagerCommandReturnVisitor<R> ,QuantityManagerCommandReturnVisitor<R> ,AccountManagerCommandReturnVisitor<R> ,UnitTypeManagerCommandReturnVisitor<R> ,QuantifObjectCommandReturnVisitor<R> ,AssociationManagerCommandReturnVisitor<R> ,AccountTypeManagerCommandReturnVisitor<R> ,TypeManagerCommandReturnVisitor<R> ,MeasurementTypeManagerCommandReturnVisitor<R> ,NameSchemeManagerCommandReturnVisitor<R> ,MAccountTypeCommandReturnVisitor<R> ,AccountCommandReturnVisitor<R> ,ObjectManagerCommandReturnVisitor<R> ,LinkManagerCommandReturnVisitor<R> ,OperationManagerCommandReturnVisitor<R> {
    
    
}
