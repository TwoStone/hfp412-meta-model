
package view.visitor;

import view.*;

public interface AnythingReturnExceptionVisitor<R, E extends model.UserException> extends AbsUnitTypeReturnExceptionVisitor<R, E> ,AbsUnitReturnExceptionVisitor<R, E> ,AbsQuantityReturnExceptionVisitor<R, E> {
    
    public R handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException, E;
    public R handleServer(ServerView server) throws ModelException, E;
    public R handleFraction(FractionView fraction) throws ModelException, E;
    public R handleConversionRate(ConversionRateView conversionRate) throws ModelException, E;
    
}
