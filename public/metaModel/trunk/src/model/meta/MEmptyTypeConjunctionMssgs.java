package model.meta;

public interface MEmptyTypeConjunctionMssgs {
    void accept(MEmptyTypeConjunctionMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MEmptyTypeConjunctionDOWNMssgs extends MAtomicTypeConjunctionDOWNMssgs, MEmptyTypeConjunctionMssgs{}
interface MEmptyTypeConjunctionUPMssgs extends Mssgs, MEmptyTypeConjunctionMssgs{}
