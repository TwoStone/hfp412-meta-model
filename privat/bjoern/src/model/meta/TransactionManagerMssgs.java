package model.meta;

public interface TransactionManagerMssgs {
    void accept(TransactionManagerMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface TransactionManagerDOWNMssgs extends Mssgs, TransactionManagerMssgs{}
interface TransactionManagerUPMssgs extends Mssgs, TransactionManagerMssgs{}
