package model.meta;

public interface TypeReferenceMssgs {
    void accept(TypeReferenceMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface TypeReferenceDOWNMssgs extends AbsUnitTypeDOWNMssgs, TypeReferenceMssgs{}
interface TypeReferenceUPMssgs extends Mssgs, TypeReferenceMssgs{}
