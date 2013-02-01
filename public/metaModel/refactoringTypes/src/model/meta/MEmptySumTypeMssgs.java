package model.meta;

public interface MEmptySumTypeMssgs {
    void accept(MEmptySumTypeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MEmptySumTypeDOWNMssgs extends MAbstractSumTypeDOWNMssgs, MEmptySumTypeMssgs{}
interface MEmptySumTypeUPMssgs extends Mssgs, MEmptySumTypeMssgs{}
