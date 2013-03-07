package model.meta;

public interface MEnumValueMssgs {
    void accept(MEnumValueMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MEnumValueDOWNMssgs extends MModelItemDOWNMssgs, MEnumValueMssgs{}
interface MEnumValueUPMssgs extends Mssgs, MEnumValueMssgs{}
