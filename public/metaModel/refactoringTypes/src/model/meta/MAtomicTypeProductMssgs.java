package model.meta;

public interface MAtomicTypeProductMssgs {
    void accept(MAtomicTypeProductMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MAtomicTypeProductDOWNMssgs extends MNonEmptyProductTypeDOWNMssgs, MAtomicTypeProductMssgs{}
interface MAtomicTypeProductUPMssgs extends Mssgs, MAtomicTypeProductMssgs{}
