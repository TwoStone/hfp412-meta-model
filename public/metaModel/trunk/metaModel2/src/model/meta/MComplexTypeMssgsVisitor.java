package model.meta;

public interface MComplexTypeMssgsVisitor extends MComplexTypeDOWNMssgsVisitor, MComplexTypeUPMssgsVisitor {}


interface MComplexTypeDOWNMssgsVisitor extends MProductTypeDOWNMssgsVisitor, MSumTypeDOWNMssgsVisitor {

    
}


interface MComplexTypeUPMssgsVisitor extends MTypeUPMssgsVisitor {

    
}
