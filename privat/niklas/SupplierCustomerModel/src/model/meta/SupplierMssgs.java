package model.meta;

public interface SupplierMssgs {
    void accept(SupplierMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface SupplierDOWNMssgs extends RoleDOWNMssgs, SupplierMssgs{}
interface SupplierUPMssgs extends Mssgs, SupplierMssgs{}
