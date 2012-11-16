
package view.visitor;
import view.UserException;
import view.*;

public interface AnythingReturnExceptionVisitor<R, E extends UserException> extends AbsUnitTypeReturnExceptionVisitor<R, E> ,AbsQuantityReturnExceptionVisitor<R, E> ,BooleanValueReturnExceptionVisitor<R, E> ,AbsUnitReturnExceptionVisitor<R, E> {
    
    public R handleConversionManager(ConversionManagerView conversionManager) throws ModelException, E;
    public R handleReferenceType(ReferenceTypeView referenceType) throws ModelException, E;
    public R handleQuantityManager(QuantityManagerView quantityManager) throws ModelException, E;
    public R handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException, E;
    public R handleUnitTypeManager(UnitTypeManagerView unitTypeManager) throws ModelException, E;
    public R handleServer(ServerView server) throws ModelException, E;
    public R handleFractionManager(FractionManagerView fractionManager) throws ModelException, E;
    public R handleReference(ReferenceView reference) throws ModelException, E;
    public R handleConversion(ConversionView conversion) throws ModelException, E;
    
}
