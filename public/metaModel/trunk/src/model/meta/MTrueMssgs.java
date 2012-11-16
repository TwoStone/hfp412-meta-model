package model.meta;

public interface MTrueMssgs {
    void accept(MTrueMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MTrueDOWNMssgs extends MBooleanDOWNMssgs, MTrueMssgs{}
interface MTrueUPMssgs extends Mssgs, MTrueMssgs{}
