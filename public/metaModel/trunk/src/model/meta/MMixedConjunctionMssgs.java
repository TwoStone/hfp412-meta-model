package model.meta;

public interface MMixedConjunctionMssgs {
    void accept(MMixedConjunctionMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MMixedConjunctionDOWNMssgs extends MAbstractTypeConjunctionDOWNMssgs, MMixedConjunctionMssgs{}
interface MMixedConjunctionUPMssgs extends Mssgs, MMixedConjunctionMssgs{}
