package model.meta;

public interface ReferenceTypeMssgs {
    void accept(ReferenceTypeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ReferenceTypeDOWNMssgs extends Mssgs, ReferenceTypeMssgs{}
interface ReferenceTypeUPMssgs extends Mssgs, ReferenceTypeMssgs{}
