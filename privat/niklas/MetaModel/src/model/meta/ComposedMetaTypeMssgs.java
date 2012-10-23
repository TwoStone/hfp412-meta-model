package model.meta;

public interface ComposedMetaTypeMssgs {
    void accept(ComposedMetaTypeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ComposedMetaTypeDOWNMssgs extends AbstractMetaTypeDOWNMssgs, ComposedMetaTypeMssgs{}
interface ComposedMetaTypeUPMssgs extends OrMetaTypeUPMssgs, AndMetaTypeUPMssgs, ComposedMetaTypeMssgs{}
