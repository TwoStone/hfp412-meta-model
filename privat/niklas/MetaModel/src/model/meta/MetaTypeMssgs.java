package model.meta;

public interface MetaTypeMssgs {
    void accept(MetaTypeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MetaTypeDOWNMssgs extends AbstractMetaTypeDOWNMssgs, NamedEntityDOWNMssgs, MetaTypeMssgs{}
interface MetaTypeUPMssgs extends Mssgs, MetaTypeMssgs{}
