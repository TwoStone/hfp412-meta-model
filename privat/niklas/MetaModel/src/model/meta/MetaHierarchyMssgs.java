package model.meta;

public interface MetaHierarchyMssgs {
    void accept(MetaHierarchyMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MetaHierarchyDOWNMssgs extends NamedEntityDOWNMssgs, MetaHierarchyMssgs{}
interface MetaHierarchyUPMssgs extends Mssgs, MetaHierarchyMssgs{}
