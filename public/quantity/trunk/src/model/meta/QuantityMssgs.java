package model.meta;

public interface QuantityMssgs {
    void accept(QuantityMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface QuantityDOWNMssgs extends AbsQuantityDOWNMssgs, QuantityMssgs{}
interface QuantityUPMssgs extends Mssgs, QuantityMssgs{}
