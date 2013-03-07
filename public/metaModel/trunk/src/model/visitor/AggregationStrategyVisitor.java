
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentAvgStrategy;
import persistence.PersistentMaxStrategy;
import persistence.PersistentMinStrategy;
import persistence.PersistentSumStrategy;

public interface AggregationStrategyVisitor {
    
    public void handleMinStrategy(PersistentMinStrategy minStrategy) throws PersistenceException;
    public void handleAvgStrategy(PersistentAvgStrategy avgStrategy) throws PersistenceException;
    public void handleSumStrategy(PersistentSumStrategy sumStrategy) throws PersistenceException;
    public void handleMaxStrategy(PersistentMaxStrategy maxStrategy) throws PersistenceException;
    
}
