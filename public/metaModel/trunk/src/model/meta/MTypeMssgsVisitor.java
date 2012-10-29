package model.meta;

public interface MTypeMssgsVisitor extends MTypeDOWNMssgsVisitor, MTypeUPMssgsVisitor {}


interface MTypeDOWNMssgsVisitor extends MAtomicTypeDOWNMssgsVisitor, MComplexTypeDOWNMssgsVisitor {

    
}


interface MTypeUPMssgsVisitor  {

    
}
