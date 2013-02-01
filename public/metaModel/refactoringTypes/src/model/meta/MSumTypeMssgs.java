package model.meta;

public interface MSumTypeMssgs {
    void accept(MSumTypeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MSumTypeDOWNMssgs extends MNonEmptySumTypeDOWNMssgs, MSumTypeMssgs{}
interface MSumTypeUPMssgs extends Mssgs, MSumTypeMssgs{}
