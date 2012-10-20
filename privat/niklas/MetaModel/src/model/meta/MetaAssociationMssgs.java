package model.meta;

public interface MetaAssociationMssgs {
    void accept(MetaAssociationMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MetaAssociationDOWNMssgs extends NamedEntityDOWNMssgs, MetaAssociationMssgs{}
interface MetaAssociationUPMssgs extends Mssgs, MetaAssociationMssgs{}
