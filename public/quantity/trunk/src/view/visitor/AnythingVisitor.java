
package view.visitor;

import view.*;

public interface AnythingVisitor extends AbsUnitTypeVisitor,AbsQuantityVisitor,BooleanValueVisitor,AbsUnitVisitor{
    
    public void handleConversionManager(ConversionManagerView conversionManager) throws ModelException;
    public void handleReferenceType(ReferenceTypeView referenceType) throws ModelException;
    public void handleQuantityManager(QuantityManagerView quantityManager) throws ModelException;
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public void handleUnitTypeManager(UnitTypeManagerView unitTypeManager) throws ModelException;
    public void handleServer(ServerView server) throws ModelException;
    public void handleFractionManager(FractionManagerView fractionManager) throws ModelException;
    public void handleReference(ReferenceView reference) throws ModelException;
    public void handleConversion(ConversionView conversion) throws ModelException;
    
}
