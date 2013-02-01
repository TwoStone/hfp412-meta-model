package model.meta;

public interface MAbstractProductTypeMssgs {
    void accept(MAbstractProductTypeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MAbstractProductTypeDOWNMssgs extends MComplexTypeDOWNMssgs, MAbstractProductTypeMssgs{}
interface MAbstractProductTypeUPMssgs extends MNonEmptyProductTypeUPMssgs, MEmptyProductTypeUPMssgs, MAbstractProductTypeMssgs{}
