package model.meta;

public interface AccountTypeManagerMssgs {
    void accept(AccountTypeManagerMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface AccountTypeManagerDOWNMssgs extends Mssgs, AccountTypeManagerMssgs{}
interface AccountTypeManagerUPMssgs extends Mssgs, AccountTypeManagerMssgs{}
