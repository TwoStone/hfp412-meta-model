package model.meta;

public interface AndMetaTypeMssgs {
    void accept(AndMetaTypeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface AndMetaTypeDOWNMssgs extends ComposedMetaTypeDOWNMssgs, AndMetaTypeMssgs{}
interface AndMetaTypeUPMssgs extends Mssgs, AndMetaTypeMssgs{}
