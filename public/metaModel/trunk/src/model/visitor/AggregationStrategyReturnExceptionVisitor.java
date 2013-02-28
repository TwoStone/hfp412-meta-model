
package model.visitor;
import model.UserException;
import persistence.*;

public interface AggregationStrategyReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleMinStrategy(PersistentMinStrategy minStrategy) throws PersistenceException, E;
    public R handleAvgStrategy(PersistentAvgStrategy avgStrategy) throws PersistenceException, E;
    public R handleSumStrategy(PersistentSumStrategy sumStrategy) throws PersistenceException, E;
    public R handleMaxStrategy(PersistentMaxStrategy maxStrategy) throws PersistenceException, E;
    
}