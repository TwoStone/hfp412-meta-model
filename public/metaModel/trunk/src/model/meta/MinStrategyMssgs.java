package model.meta;

public interface MinStrategyMssgs {
    void accept(MinStrategyMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MinStrategyDOWNMssgs extends AggregationStrategyDOWNMssgs, MinStrategyMssgs{}
interface MinStrategyUPMssgs extends Mssgs, MinStrategyMssgs{}
