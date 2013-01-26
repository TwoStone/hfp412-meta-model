package model.meta;

public interface MEmptyProductTypeMssgs {
    void accept(MEmptyProductTypeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MEmptyProductTypeDOWNMssgs extends MAbstractProductTypeDOWNMssgs, MEmptyProductTypeMssgs{}
interface MEmptyProductTypeUPMssgs extends Mssgs, MEmptyProductTypeMssgs{}
