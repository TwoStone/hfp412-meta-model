package model.meta;

public interface MNonEmptyAtomicTypeConjunctionMssgs {
    void accept(MNonEmptyAtomicTypeConjunctionMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MNonEmptyAtomicTypeConjunctionDOWNMssgs extends MAtomicTypeConjunctionDOWNMssgs, MNonEmptyAtomicTypeConjunctionMssgs{}
interface MNonEmptyAtomicTypeConjunctionUPMssgs extends Mssgs, MNonEmptyAtomicTypeConjunctionMssgs{}
