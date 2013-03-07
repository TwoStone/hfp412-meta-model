package model.meta;

public interface MEnumMssgs {
    void accept(MEnumMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MEnumDOWNMssgs extends MModelItemDOWNMssgs, MEnumMssgs{}
interface MEnumUPMssgs extends Mssgs, MEnumMssgs{}
