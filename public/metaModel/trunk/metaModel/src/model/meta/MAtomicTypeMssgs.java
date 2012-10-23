package model.meta;

public interface MAtomicTypeMssgs {
    void accept(MAtomicTypeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MAtomicTypeDOWNMssgs extends MTypeDOWNMssgs, MAtomicTypeMssgs{}
interface MAtomicTypeUPMssgs extends Mssgs, MAtomicTypeMssgs{}
