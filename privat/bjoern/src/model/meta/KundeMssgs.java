package model.meta;

public interface KundeMssgs {
    void accept(KundeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface KundeDOWNMssgs extends RolleDOWNMssgs, KundeMssgs{}
interface KundeUPMssgs extends Mssgs, KundeMssgs{}
