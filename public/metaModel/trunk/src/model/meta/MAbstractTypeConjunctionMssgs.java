package model.meta;

public interface MAbstractTypeConjunctionMssgs {
    void accept(MAbstractTypeConjunctionMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MAbstractTypeConjunctionDOWNMssgs extends MComplexTypeDOWNMssgs, MAbstractTypeConjunctionMssgs{}
interface MAbstractTypeConjunctionUPMssgs extends MMixedConjunctionUPMssgs, MAtomicTypeConjunctionUPMssgs, MAbstractTypeConjunctionMssgs{}
