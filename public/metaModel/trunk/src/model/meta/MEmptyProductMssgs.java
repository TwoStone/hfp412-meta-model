package model.meta;

public interface MEmptyProductMssgs {
    void accept(MEmptyProductMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MEmptyProductDOWNMssgs extends MProductTypeDOWNMssgs, MEmptyProductMssgs{}
interface MEmptyProductUPMssgs extends Mssgs, MEmptyProductMssgs{}
