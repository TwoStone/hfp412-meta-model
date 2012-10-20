package model.meta;

public interface RoleSwitchPARAMETER{
    persistence.PersistentCustomer handleCustomer() throws persistence.PersistenceException;
    persistence.PersistentSupplier handleSupplier() throws persistence.PersistenceException;
}
