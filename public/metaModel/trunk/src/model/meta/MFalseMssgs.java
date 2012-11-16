package model.meta;

public interface MFalseMssgs {
    void accept(MFalseMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MFalseDOWNMssgs extends MBooleanDOWNMssgs, MFalseMssgs{}
interface MFalseUPMssgs extends Mssgs, MFalseMssgs{}
