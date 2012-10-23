package model.meta;

public interface AspectManagerMssgs {
    void accept(AspectManagerMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface AspectManagerDOWNMssgs extends Mssgs, AspectManagerMssgs{}
interface AspectManagerUPMssgs extends Mssgs, AspectManagerMssgs{}
