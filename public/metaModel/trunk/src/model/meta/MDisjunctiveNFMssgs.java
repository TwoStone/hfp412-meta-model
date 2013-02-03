package model.meta;

public interface MDisjunctiveNFMssgs {
    void accept(MDisjunctiveNFMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MDisjunctiveNFDOWNMssgs extends MNonEmptySumTypeDOWNMssgs, MDisjunctiveNFMssgs{}
interface MDisjunctiveNFUPMssgs extends Mssgs, MDisjunctiveNFMssgs{}
