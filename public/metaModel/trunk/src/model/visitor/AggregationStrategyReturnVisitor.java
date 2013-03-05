
package model.visitor;

import persistence.*;

public interface AggregationStrategyReturnVisitor<R> {
    
    public R handleMinStrategy(PersistentMinStrategy minStrategy) throws PersistenceException;
    public R handleAvgStrategy(PersistentAvgStrategy avgStrategy) throws PersistenceException;
    public R handleSumStrategy(PersistentSumStrategy sumStrategy) throws PersistenceException;
    public R handleMaxStrategy(PersistentMaxStrategy maxStrategy) throws PersistenceException;
    
}
