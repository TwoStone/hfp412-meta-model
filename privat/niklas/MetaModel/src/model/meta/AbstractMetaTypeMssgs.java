package model.meta;

public interface AbstractMetaTypeMssgs {
    void accept(AbstractMetaTypeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface AbstractMetaTypeDOWNMssgs extends Mssgs, AbstractMetaTypeMssgs{}
interface AbstractMetaTypeUPMssgs extends ComposedMetaTypeUPMssgs, MetaTypeUPMssgs, AbstractMetaTypeMssgs{}
