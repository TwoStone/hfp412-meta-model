package model.meta;

public interface MEmptyProductMssgs {
    void accept(MEmptyProductMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MEmptyProductDOWNMssgs extends MAbstractProductTypeDOWNMssgs, MEmptyProductMssgs{}
interface MEmptyProductUPMssgs extends Mssgs, MEmptyProductMssgs{}
