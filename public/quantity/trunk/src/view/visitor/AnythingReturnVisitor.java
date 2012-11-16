
package view.visitor;

import view.*;

public interface AnythingReturnVisitor<R> extends AbsUnitTypeReturnVisitor<R> ,AbsQuantityReturnVisitor<R> ,BooleanValueReturnVisitor<R> ,AbsUnitReturnVisitor<R> {
    
    public R handleConversionManager(ConversionManagerView conversionManager) throws ModelException;
    public R handleReferenceType(ReferenceTypeView referenceType) throws ModelException;
    public R handleQuantityManager(QuantityManagerView quantityManager) throws ModelException;
    public R handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public R handleUnitTypeManager(UnitTypeManagerView unitTypeManager) throws ModelException;
    public R handleServer(ServerView server) throws ModelException;
    public R handleFractionManager(FractionManagerView fractionManager) throws ModelException;
    public R handleReference(ReferenceView reference) throws ModelException;
    public R handleConversion(ConversionView conversion) throws ModelException;
    
}
