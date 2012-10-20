package model.meta;

public interface RoleMssgsVisitor extends RoleDOWNMssgsVisitor, RoleUPMssgsVisitor {}


interface RoleDOWNMssgsVisitor extends CustomerDOWNMssgsVisitor, SupplierDOWNMssgsVisitor {

    
}


interface RoleUPMssgsVisitor  {

    
}
