package model.meta;

public interface MAccountTypeMssgs {
    void accept(MAccountTypeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MAccountTypeDOWNMssgs extends MQuantiObjectTypeDOWNMssgs, MAccountTypeMssgs{}
interface MAccountTypeUPMssgs extends Mssgs, MAccountTypeMssgs{}
