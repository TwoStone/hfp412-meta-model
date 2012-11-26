package model.meta;

public interface MAssociationMssgs {
    void accept(MAssociationMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MAssociationDOWNMssgs extends Mssgs, MAssociationMssgs{}
interface MAssociationUPMssgs extends Mssgs, MAssociationMssgs{}
