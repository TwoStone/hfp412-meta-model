package model.meta;

public interface MSumTypeMssgs {
    void accept(MSumTypeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MSumTypeDOWNMssgs extends MComplexTypeDOWNMssgs, MSumTypeMssgs{}
interface MSumTypeUPMssgs extends MEmptySumUPMssgs, MSumTypeMssgs{}
