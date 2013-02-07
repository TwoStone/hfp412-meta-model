package model.meta;

public interface AvgStrategyMssgs {
    void accept(AvgStrategyMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface AvgStrategyDOWNMssgs extends AggregationStrategyDOWNMssgs, AvgStrategyMssgs{}
interface AvgStrategyUPMssgs extends Mssgs, AvgStrategyMssgs{}
