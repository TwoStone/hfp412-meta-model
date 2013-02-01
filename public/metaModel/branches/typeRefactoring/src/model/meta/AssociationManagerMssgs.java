package model.meta;

public interface AssociationManagerMssgs {
    void accept(AssociationManagerMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface AssociationManagerDOWNMssgs extends Mssgs, AssociationManagerMssgs{}
interface AssociationManagerUPMssgs extends Mssgs, AssociationManagerMssgs{}
