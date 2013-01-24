package model.meta;

public interface AbsQuantityMssgs {
    void accept(AbsQuantityMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface AbsQuantityDOWNMssgs extends Mssgs, AbsQuantityMssgs{}
interface AbsQuantityUPMssgs extends CompoundQuantityUPMssgs, QuantityUPMssgs, AbsQuantityMssgs{}