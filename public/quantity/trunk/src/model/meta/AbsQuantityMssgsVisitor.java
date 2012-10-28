package model.meta;

public interface AbsQuantityMssgsVisitor extends AbsQuantityDOWNMssgsVisitor, AbsQuantityUPMssgsVisitor {}


interface AbsQuantityDOWNMssgsVisitor extends QuantityDOWNMssgsVisitor, ComposedQuantityDOWNMssgsVisitor {

    
}


interface AbsQuantityUPMssgsVisitor  {

    
}
