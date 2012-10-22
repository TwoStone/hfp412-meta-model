package model.meta;

public interface LieferantMssgs {
    void accept(LieferantMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface LieferantDOWNMssgs extends RolleDOWNMssgs, LieferantMssgs{}
interface LieferantUPMssgs extends Mssgs, LieferantMssgs{}
