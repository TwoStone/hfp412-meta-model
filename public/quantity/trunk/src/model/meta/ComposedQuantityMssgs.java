package model.meta;

public interface ComposedQuantityMssgs {
    void accept(ComposedQuantityMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ComposedQuantityDOWNMssgs extends AbsQuantityDOWNMssgs, ComposedQuantityMssgs{}
interface ComposedQuantityUPMssgs extends Mssgs, ComposedQuantityMssgs{}
