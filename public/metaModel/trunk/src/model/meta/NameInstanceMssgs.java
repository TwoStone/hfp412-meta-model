package model.meta;

public interface NameInstanceMssgs {
    void accept(NameInstanceMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface NameInstanceDOWNMssgs extends Mssgs, NameInstanceMssgs{}
interface NameInstanceUPMssgs extends Mssgs, NameInstanceMssgs{}
