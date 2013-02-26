package model.meta;

public interface MTypeMssgsVisitor extends MTypeDOWNMssgsVisitor, MTypeUPMssgsVisitor {}


interface MTypeDOWNMssgsVisitor extends MComplexTypeDOWNMssgsVisitor, MAtomicTypeDOWNMssgsVisitor {

    
}


interface MTypeUPMssgsVisitor extends MModelItemUPMssgsVisitor {

    
}
