package model.meta;

public interface MaxStrategyMssgs {
    void accept(MaxStrategyMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MaxStrategyDOWNMssgs extends AggregationStrategyDOWNMssgs, MaxStrategyMssgs{}
interface MaxStrategyUPMssgs extends Mssgs, MaxStrategyMssgs{}
