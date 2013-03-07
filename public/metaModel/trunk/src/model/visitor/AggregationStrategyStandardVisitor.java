
package model.visitor;

import persistence.AggregationStrategy;
import persistence.PersistenceException;
import persistence.PersistentAvgStrategy;
import persistence.PersistentMaxStrategy;
import persistence.PersistentMinStrategy;
import persistence.PersistentSumStrategy;

public abstract class AggregationStrategyStandardVisitor implements AggregationStrategyVisitor {
    
    public void handleSumStrategy(PersistentSumStrategy sumStrategy) throws PersistenceException{
        this.standardHandling(sumStrategy);
    }
    public void handleMaxStrategy(PersistentMaxStrategy maxStrategy) throws PersistenceException{
        this.standardHandling(maxStrategy);
    }
    public void handleAvgStrategy(PersistentAvgStrategy avgStrategy) throws PersistenceException{
        this.standardHandling(avgStrategy);
    }
    public void handleMinStrategy(PersistentMinStrategy minStrategy) throws PersistenceException{
        this.standardHandling(minStrategy);
    }
    protected abstract void standardHandling(AggregationStrategy aggregationStrategy) throws PersistenceException;
}
