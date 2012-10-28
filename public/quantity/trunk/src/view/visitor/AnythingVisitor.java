
package view.visitor;

import view.*;

public interface AnythingVisitor extends AbsUnitTypeVisitor,AbsUnitVisitor,AbsQuantityVisitor{
    
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public void handleServer(ServerView server) throws ModelException;
    public void handleFraction(FractionView fraction) throws ModelException;
    public void handleConversionRate(ConversionRateView conversionRate) throws ModelException;
    
}
