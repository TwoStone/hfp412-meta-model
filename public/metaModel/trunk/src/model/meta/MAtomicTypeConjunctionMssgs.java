package model.meta;

public interface MAtomicTypeConjunctionMssgs {
    void accept(MAtomicTypeConjunctionMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MAtomicTypeConjunctionDOWNMssgs extends MAbstractTypeConjunctionDOWNMssgs, MAtomicTypeConjunctionMssgs{}
interface MAtomicTypeConjunctionUPMssgs extends MNonEmptyAtomicTypeConjunctionUPMssgs, MEmptyTypeConjunctionUPMssgs, MAtomicTypeConjunctionMssgs{}
