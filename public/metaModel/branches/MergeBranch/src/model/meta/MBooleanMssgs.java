package model.meta;

public interface MBooleanMssgs {
    void accept(MBooleanMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MBooleanDOWNMssgs extends Mssgs, MBooleanMssgs{}
interface MBooleanUPMssgs extends MFalseUPMssgs, MTrueUPMssgs, MBooleanMssgs{}
