
package model.visitor;

import persistence.*;

public interface AnythingExceptionVisitor<E extends model.UserException> extends AbsUnitTypeExceptionVisitor<E>,AbsUnitExceptionVisitor<E>,AbsQuantityExceptionVisitor<E>{
    
    public void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException, E;
    public void handleServer(PersistentServer server) throws PersistenceException, E;
    public void handleFraction(PersistentFraction fraction) throws PersistenceException, E;
    public void handleConversionRate(PersistentConversionRate conversionRate) throws PersistenceException, E;
    
}
