package model.meta;

public interface MProductTypeMssgs {
    void accept(MProductTypeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MProductTypeDOWNMssgs extends MComplexTypeDOWNMssgs, MProductTypeMssgs{}
interface MProductTypeUPMssgs extends Mssgs, MProductTypeMssgs{}
