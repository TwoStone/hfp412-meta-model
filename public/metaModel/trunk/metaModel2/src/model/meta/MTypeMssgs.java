package model.meta;

public interface MTypeMssgs {
    void accept(MTypeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MTypeDOWNMssgs extends Mssgs, MTypeMssgs{}
interface MTypeUPMssgs extends MAtomicTypeUPMssgs, MComplexTypeUPMssgs, MTypeMssgs{}
