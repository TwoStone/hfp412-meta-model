package model.meta;

public interface CompoundQuantityMssgs {
    void accept(CompoundQuantityMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface CompoundQuantityDOWNMssgs extends AbsQuantityDOWNMssgs, CompoundQuantityMssgs{}
interface CompoundQuantityUPMssgs extends Mssgs, CompoundQuantityMssgs{}
