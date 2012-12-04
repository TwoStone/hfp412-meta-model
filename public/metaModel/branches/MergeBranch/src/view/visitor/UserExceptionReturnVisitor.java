
package view.visitor;

import view.*;

public interface UserExceptionReturnVisitor<R> {
    
    public R handleWrongSubTypeAspectException(WrongSubTypeAspectException wrongSubTypeAspectException) throws ModelException;
    public R handleConsistencyException(ConsistencyException consistencyException) throws ModelException;
    public R handleCycleException(CycleException cycleException) throws ModelException;
    public R handleDoubleDefinitionException(DoubleDefinitionException doubleDefinitionException) throws ModelException;
    public R handleRestrictionException(RestrictionException restrictionException) throws ModelException;
    
}
