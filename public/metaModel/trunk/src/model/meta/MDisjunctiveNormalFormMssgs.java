package model.meta;

public interface MDisjunctiveNormalFormMssgs {
    void accept(MDisjunctiveNormalFormMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MDisjunctiveNormalFormDOWNMssgs extends MAbstractTypeDisjunctionDOWNMssgs, MDisjunctiveNormalFormMssgs{}
interface MDisjunctiveNormalFormUPMssgs extends MNonEmptyDisjunctiveNormalFormUPMssgs, MEmptyTypeDisjunctionUPMssgs, MDisjunctiveNormalFormMssgs{}
