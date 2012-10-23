package model.meta;

public interface NamedEntityMssgs {
    void accept(NamedEntityMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface NamedEntityDOWNMssgs extends Mssgs, NamedEntityMssgs{}
interface NamedEntityUPMssgs extends MetaAspectUPMssgs, MetaAssociationUPMssgs, MetaHierarchyUPMssgs, MetaTypeUPMssgs, NamedEntityMssgs{}
