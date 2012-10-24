
package view.visitor;

import view.*;

public interface AnythingExceptionVisitor<E extends model.UserException> extends AbsUnitTypeExceptionVisitor<E>,AbsUnitExceptionVisitor<E>,AbsQuantityExceptionVisitor<E>{
    
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException, E;
    public void handleServer(ServerView server) throws ModelException, E;
    public void handleFraction(FractionView fraction) throws ModelException, E;
    public void handleConversionRate(ConversionRateView conversionRate) throws ModelException, E;
    
}
