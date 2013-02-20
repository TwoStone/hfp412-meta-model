package model.meta;

public interface MTypeMssgs {
    void accept(MTypeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MTypeDOWNMssgs extends MModelItemDOWNMssgs, MTypeMssgs{}
interface MTypeUPMssgs extends MComplexTypeUPMssgs, MAtomicTypeUPMssgs, MTypeMssgs{}
