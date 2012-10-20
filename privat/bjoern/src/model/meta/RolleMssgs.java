package model.meta;

public interface RolleMssgs {
    void accept(RolleMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface RolleDOWNMssgs extends Mssgs, RolleMssgs{}
interface RolleUPMssgs extends LieferantUPMssgs, KundeUPMssgs, RolleMssgs{}
