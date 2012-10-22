package model.meta;

public class StringFACTORY{

    public static persistence.PersistentRolle createObjectBySubTypeNameForRolle(String name, RolleSwitchPARAMETER switchAssistant) throws persistence.PersistenceException {
        if(name.equals("Lieferant")) return switchAssistant.handleLieferant();
        if(name.equals("Kunde")) return switchAssistant.handleKunde();
        throw new persistence.PersistenceException("No such type name!",0);
    }
    
}
