package model.meta;

public interface SumStrategyMssgs {
    void accept(SumStrategyMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface SumStrategyDOWNMssgs extends AggregationStrategyDOWNMssgs, SumStrategyMssgs{}
interface SumStrategyUPMssgs extends Mssgs, SumStrategyMssgs{}
