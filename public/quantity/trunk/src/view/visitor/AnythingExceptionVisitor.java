
package view.visitor;
import view.UserException;
import view.*;

public interface AnythingExceptionVisitor<E extends UserException> extends AbsUnitTypeExceptionVisitor<E>,AbsQuantityExceptionVisitor<E>,BooleanValueExceptionVisitor<E>,AbsUnitExceptionVisitor<E>{
    
    public void handleConversionManager(ConversionManagerView conversionManager) throws ModelException, E;
    public void handleReferenceType(ReferenceTypeView referenceType) throws ModelException, E;
    public void handleQuantityManager(QuantityManagerView quantityManager) throws ModelException, E;
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException, E;
    public void handleUnitTypeManager(UnitTypeManagerView unitTypeManager) throws ModelException, E;
    public void handleFunction(FunctionView function) throws ModelException, E;
    public void handleServer(ServerView server) throws ModelException, E;
    public void handleFractionManager(FractionManagerView fractionManager) throws ModelException, E;
    public void handleReference(ReferenceView reference) throws ModelException, E;
    public void handleConversion(ConversionView conversion) throws ModelException, E;
    
}
