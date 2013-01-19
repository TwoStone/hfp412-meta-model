package model.meta;

public interface AssociationMssgs {
    void accept(AssociationMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface AssociationDOWNMssgs extends Mssgs, AssociationMssgs{}
interface AssociationUPMssgs extends Mssgs, AssociationMssgs{}
