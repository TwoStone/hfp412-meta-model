package model.meta;

public interface TransactionFcdeMssgs {
    void accept(TransactionFcdeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface TransactionFcdeDOWNMssgs extends Mssgs, TransactionFcdeMssgs{}
interface TransactionFcdeUPMssgs extends Mssgs, TransactionFcdeMssgs{}
