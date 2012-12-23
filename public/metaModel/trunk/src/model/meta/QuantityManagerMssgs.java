package model.meta;

public interface QuantityManagerMssgs {
    void accept(QuantityManagerMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface QuantityManagerDOWNMssgs extends Mssgs, QuantityManagerMssgs{}
interface QuantityManagerUPMssgs extends Mssgs, QuantityManagerMssgs{}
