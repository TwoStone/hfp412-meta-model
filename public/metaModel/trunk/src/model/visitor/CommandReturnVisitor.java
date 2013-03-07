
package model.visitor;

public interface CommandReturnVisitor<R> extends EnumerationManagerCommandReturnVisitor<R> ,AspectManagerCommandReturnVisitor<R> ,MessageManagerCommandReturnVisitor<R> ,FractionManagerCommandReturnVisitor<R> ,QuantityManagerCommandReturnVisitor<R> ,AccountManagerCommandReturnVisitor<R> ,UnitTypeManagerCommandReturnVisitor<R> ,QuantifObjectCommandReturnVisitor<R> ,AssociationManagerCommandReturnVisitor<R> ,AccountTypeManagerCommandReturnVisitor<R> ,TypeManagerCommandReturnVisitor<R> ,MeasurementTypeManagerCommandReturnVisitor<R> ,NameSchemeManagerCommandReturnVisitor<R> ,MAccountTypeCommandReturnVisitor<R> ,AccountCommandReturnVisitor<R> ,ObservationManagerCommandReturnVisitor<R> ,ObjectManagerCommandReturnVisitor<R> ,LinkManagerCommandReturnVisitor<R> ,OperationManagerCommandReturnVisitor<R> {
    
    
}
