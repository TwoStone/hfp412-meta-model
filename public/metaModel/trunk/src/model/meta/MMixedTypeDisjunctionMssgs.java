package model.meta;

public interface MMixedTypeDisjunctionMssgs {
    void accept(MMixedTypeDisjunctionMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MMixedTypeDisjunctionDOWNMssgs extends MAbstractTypeDisjunctionDOWNMssgs, MMixedTypeDisjunctionMssgs{}
interface MMixedTypeDisjunctionUPMssgs extends Mssgs, MMixedTypeDisjunctionMssgs{}
