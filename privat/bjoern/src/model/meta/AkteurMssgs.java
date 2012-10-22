package model.meta;

public interface AkteurMssgs {
    void accept(AkteurMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface AkteurDOWNMssgs extends Mssgs, AkteurMssgs{}
interface AkteurUPMssgs extends Mssgs, AkteurMssgs{}
