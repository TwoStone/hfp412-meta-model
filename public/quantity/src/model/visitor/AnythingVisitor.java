
package model.visitor;

import persistence.*;

public interface AnythingVisitor extends AbsUnitTypeVisitor,AbsUnitVisitor,AbsQuantityVisitor{
    
    public void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public void handleServer(PersistentServer server) throws PersistenceException;
    public void handleFraction(PersistentFraction fraction) throws PersistenceException;
    public void handleConversionRate(PersistentConversionRate conversionRate) throws PersistenceException;
    
}
