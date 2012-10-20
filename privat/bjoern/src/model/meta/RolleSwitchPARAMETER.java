package model.meta;

public interface RolleSwitchPARAMETER{
    persistence.PersistentLieferant handleLieferant() throws persistence.PersistenceException;
    persistence.PersistentKunde handleKunde() throws persistence.PersistenceException;
}
