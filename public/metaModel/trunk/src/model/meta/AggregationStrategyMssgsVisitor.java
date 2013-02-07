package model.meta;

public interface AggregationStrategyMssgsVisitor extends AggregationStrategyDOWNMssgsVisitor, AggregationStrategyUPMssgsVisitor {}


interface AggregationStrategyDOWNMssgsVisitor extends MinStrategyDOWNMssgsVisitor, AvgStrategyDOWNMssgsVisitor, SumStrategyDOWNMssgsVisitor, MaxStrategyDOWNMssgsVisitor {

    
}


interface AggregationStrategyUPMssgsVisitor  {

    
}
