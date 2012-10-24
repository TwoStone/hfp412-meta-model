
package model.visitor;

import persistence.*;

public interface AnythingReturnExceptionVisitor<R, E extends model.UserException> extends AbsUnitTypeReturnExceptionVisitor<R, E> ,AbsUnitReturnExceptionVisitor<R, E> ,AbsQuantityReturnExceptionVisitor<R, E> {
    
    public R handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException, E;
    public R handleServer(PersistentServer server) throws PersistenceException, E;
    public R handleFraction(PersistentFraction fraction) throws PersistenceException, E;
    public R handleConversionRate(PersistentConversionRate conversionRate) throws PersistenceException, E;
    
}
