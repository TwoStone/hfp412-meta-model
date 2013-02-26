package model.meta;

public interface MNonEmptyDisjunctiveNormalFormMssgs {
    void accept(MNonEmptyDisjunctiveNormalFormMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MNonEmptyDisjunctiveNormalFormDOWNMssgs extends MDisjunctiveNormalFormDOWNMssgs, MNonEmptyDisjunctiveNormalFormMssgs{}
interface MNonEmptyDisjunctiveNormalFormUPMssgs extends Mssgs, MNonEmptyDisjunctiveNormalFormMssgs{}
