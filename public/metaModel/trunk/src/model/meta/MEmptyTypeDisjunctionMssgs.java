package model.meta;

public interface MEmptyTypeDisjunctionMssgs {
    void accept(MEmptyTypeDisjunctionMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MEmptyTypeDisjunctionDOWNMssgs extends MDisjunctiveNormalFormDOWNMssgs, MEmptyTypeDisjunctionMssgs{}
interface MEmptyTypeDisjunctionUPMssgs extends Mssgs, MEmptyTypeDisjunctionMssgs{}
