package model.meta;

public interface OrMetaTypeMssgs {
    void accept(OrMetaTypeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface OrMetaTypeDOWNMssgs extends ComposedMetaTypeDOWNMssgs, OrMetaTypeMssgs{}
interface OrMetaTypeUPMssgs extends Mssgs, OrMetaTypeMssgs{}
