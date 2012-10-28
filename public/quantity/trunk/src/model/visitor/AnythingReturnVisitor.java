
package model.visitor;

import persistence.*;

public interface AnythingReturnVisitor<R> extends AbsUnitTypeReturnVisitor<R> ,AbsUnitReturnVisitor<R> ,AbsQuantityReturnVisitor<R> {
    
    public R handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public R handleServer(PersistentServer server) throws PersistenceException;
    public R handleFraction(PersistentFraction fraction) throws PersistenceException;
    public R handleConversionRate(PersistentConversionRate conversionRate) throws PersistenceException;
    
}
