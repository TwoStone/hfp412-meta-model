package model.meta;

public interface ReferenceMssgs {
    void accept(ReferenceMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ReferenceDOWNMssgs extends Mssgs, ReferenceMssgs{}
interface ReferenceUPMssgs extends Mssgs, ReferenceMssgs{}
