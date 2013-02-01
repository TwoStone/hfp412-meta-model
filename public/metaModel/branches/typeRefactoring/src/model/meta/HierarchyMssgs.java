package model.meta;

public interface HierarchyMssgs {
    void accept(HierarchyMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface HierarchyDOWNMssgs extends Mssgs, HierarchyMssgs{}
interface HierarchyUPMssgs extends Mssgs, HierarchyMssgs{}
