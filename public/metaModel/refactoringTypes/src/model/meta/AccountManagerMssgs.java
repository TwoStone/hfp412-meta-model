package model.meta;

public interface AccountManagerMssgs {
    void accept(AccountManagerMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface AccountManagerDOWNMssgs extends Mssgs, AccountManagerMssgs{}
interface AccountManagerUPMssgs extends Mssgs, AccountManagerMssgs{}
