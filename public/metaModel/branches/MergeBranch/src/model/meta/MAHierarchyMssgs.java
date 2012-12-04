package model.meta;

public interface MAHierarchyMssgs {
    void accept(MAHierarchyMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MAHierarchyDOWNMssgs extends Mssgs, MAHierarchyMssgs{}
interface MAHierarchyUPMssgs extends Mssgs, MAHierarchyMssgs{}
