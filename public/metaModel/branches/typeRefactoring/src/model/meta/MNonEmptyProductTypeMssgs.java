package model.meta;

public interface MNonEmptyProductTypeMssgs {
    void accept(MNonEmptyProductTypeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MNonEmptyProductTypeDOWNMssgs extends MAbstractProductTypeDOWNMssgs, MNonEmptyProductTypeMssgs{}
interface MNonEmptyProductTypeUPMssgs extends MAtomicTypeProductUPMssgs, MProductTypeUPMssgs, MNonEmptyProductTypeMssgs{}
