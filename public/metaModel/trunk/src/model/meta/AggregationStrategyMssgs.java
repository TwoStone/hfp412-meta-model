package model.meta;

public interface AggregationStrategyMssgs {
    void accept(AggregationStrategyMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface AggregationStrategyDOWNMssgs extends Mssgs, AggregationStrategyMssgs{}
interface AggregationStrategyUPMssgs extends MinStrategyUPMssgs, AvgStrategyUPMssgs, SumStrategyUPMssgs, MaxStrategyUPMssgs, AggregationStrategyMssgs{}
