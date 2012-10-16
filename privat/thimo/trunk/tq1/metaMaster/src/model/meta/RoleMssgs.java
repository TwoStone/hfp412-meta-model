package model.meta;

public interface RoleMssgs {
    void accept(RoleMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface RoleDOWNMssgs extends Mssgs, RoleMssgs{}
interface RoleUPMssgs extends CustomerUPMssgs, SupplierUPMssgs, RoleMssgs{}
