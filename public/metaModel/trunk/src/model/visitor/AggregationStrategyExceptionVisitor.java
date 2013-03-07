
package model.visitor;
import model.UserException;
import persistence.PersistenceException;
import persistence.PersistentAvgStrategy;
import persistence.PersistentMaxStrategy;
import persistence.PersistentMinStrategy;
import persistence.PersistentSumStrategy;

public interface AggregationStrategyExceptionVisitor<E extends UserException> {
    
    public void handleMinStrategy(PersistentMinStrategy minStrategy) throws PersistenceException, E;
    public void handleAvgStrategy(PersistentAvgStrategy avgStrategy) throws PersistenceException, E;
    public void handleSumStrategy(PersistentSumStrategy sumStrategy) throws PersistenceException, E;
    public void handleMaxStrategy(PersistentMaxStrategy maxStrategy) throws PersistenceException, E;
    
}
