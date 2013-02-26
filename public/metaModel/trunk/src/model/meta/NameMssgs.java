package model.meta;

public interface NameMssgs {
    void accept(NameMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface NameDOWNMssgs extends Mssgs, NameMssgs{}
interface NameUPMssgs extends Mssgs, NameMssgs{}
