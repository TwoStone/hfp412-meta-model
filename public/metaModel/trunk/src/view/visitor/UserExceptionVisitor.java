
package view.visitor;

import view.*;

public interface UserExceptionVisitor {
    
    public void handleExponentMatchingException(ExponentMatchingException exponentMatchingException) throws ModelException;
    public void handleWrongSubTypeAspectException(WrongSubTypeAspectException wrongSubTypeAspectException) throws ModelException;
    public void handleConsistencyException(ConsistencyException consistencyException) throws ModelException;
    public void handleCycleException(CycleException cycleException) throws ModelException;
    public void handleAlreadyFinalizedException(AlreadyFinalizedException alreadyFinalizedException) throws ModelException;
    public void handleNotAvailableException(NotAvailableException notAvailableException) throws ModelException;
    public void handleDoubleDefinitionException(DoubleDefinitionException doubleDefinitionException) throws ModelException;
    public void handleNotFinalizedException(NotFinalizedException notFinalizedException) throws ModelException;
    public void handleRestrictionException(RestrictionException restrictionException) throws ModelException;
    
}
