package model.meta;

public interface MAbstractTypeDisjunctionMssgs {
    void accept(MAbstractTypeDisjunctionMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MAbstractTypeDisjunctionDOWNMssgs extends MComplexTypeDOWNMssgs, MAbstractTypeDisjunctionMssgs{}
interface MAbstractTypeDisjunctionUPMssgs extends MMixedTypeDisjunctionUPMssgs, MDisjunctiveNormalFormUPMssgs, MAbstractTypeDisjunctionMssgs{}
