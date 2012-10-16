package model.meta;

public class StringFACTORY{

    public static persistence.PersistentRole createObjectBySubTypeNameForRole(String name, RoleSwitchPARAMETER switchAssistant) throws persistence.PersistenceException {
        if(name.equals("Customer")) return switchAssistant.handleCustomer();
        if(name.equals("Supplier")) return switchAssistant.handleSupplier();
        throw new persistence.PersistenceException("No such type name!",0);
    }
    
}
