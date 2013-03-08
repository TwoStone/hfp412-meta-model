package model.meta;

public interface EnumValueManagerMssgs {
    void accept(EnumValueManagerMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface EnumValueManagerDOWNMssgs extends Mssgs, EnumValueManagerMssgs{}
interface EnumValueManagerUPMssgs extends Mssgs, EnumValueManagerMssgs{}
