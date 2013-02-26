package model.meta;

public interface NameSchemeMssgs {
    void accept(NameSchemeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface NameSchemeDOWNMssgs extends Mssgs, NameSchemeMssgs{}
interface NameSchemeUPMssgs extends Mssgs, NameSchemeMssgs{}
