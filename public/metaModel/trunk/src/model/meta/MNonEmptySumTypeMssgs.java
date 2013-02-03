package model.meta;

public interface MNonEmptySumTypeMssgs {
    void accept(MNonEmptySumTypeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MNonEmptySumTypeDOWNMssgs extends MAbstractSumTypeDOWNMssgs, MNonEmptySumTypeMssgs{}
interface MNonEmptySumTypeUPMssgs extends MDisjunctiveNFUPMssgs, MSumTypeUPMssgs, MNonEmptySumTypeMssgs{}
