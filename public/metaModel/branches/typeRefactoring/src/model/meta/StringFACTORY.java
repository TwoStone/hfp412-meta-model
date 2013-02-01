package model.meta;

public class StringFACTORY{

    public static persistence.PersistentMBoolean createObjectBySubTypeNameForMBoolean(String name) throws persistence.PersistenceException {
        if(name.equals("false")) return model.basic.MFalse.getTheMFalse();
        if(name.equals("true")) return model.basic.MTrue.getTheMTrue();
        throw new persistence.PersistenceException("No such type name!",0);
    }
    
}
