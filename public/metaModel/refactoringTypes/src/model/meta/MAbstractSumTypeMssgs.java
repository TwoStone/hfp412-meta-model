package model.meta;

public interface MAbstractSumTypeMssgs {
    void accept(MAbstractSumTypeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MAbstractSumTypeDOWNMssgs extends MComplexTypeDOWNMssgs, MAbstractSumTypeMssgs{}
interface MAbstractSumTypeUPMssgs extends MEmptySumTypeUPMssgs, MNonEmptySumTypeUPMssgs, MAbstractSumTypeMssgs{}
