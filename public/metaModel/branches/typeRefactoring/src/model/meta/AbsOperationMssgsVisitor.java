package model.meta;

public interface AbsOperationMssgsVisitor extends AbsOperationDOWNMssgsVisitor, AbsOperationUPMssgsVisitor {}


interface AbsOperationDOWNMssgsVisitor extends OperationDOWNMssgsVisitor, AssociationDOWNMssgsVisitor {

    
}


interface AbsOperationUPMssgsVisitor  {

    
}