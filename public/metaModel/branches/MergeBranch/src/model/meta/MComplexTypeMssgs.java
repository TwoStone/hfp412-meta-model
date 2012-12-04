package model.meta;

public interface MComplexTypeMssgs {
    void accept(MComplexTypeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MComplexTypeDOWNMssgs extends MTypeDOWNMssgs, MComplexTypeMssgs{}
interface MComplexTypeUPMssgs extends MProductTypeUPMssgs, MSumTypeUPMssgs, MComplexTypeMssgs{}
