package model.meta;

public interface MDisjuncitveNFMssgs {
    void accept(MDisjuncitveNFMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MDisjuncitveNFDOWNMssgs extends MNonEmptySumTypeDOWNMssgs, MDisjuncitveNFMssgs{}
interface MDisjuncitveNFUPMssgs extends Mssgs, MDisjuncitveNFMssgs{}
