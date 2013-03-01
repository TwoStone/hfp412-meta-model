package model.meta;

public interface AbstractObjectMssgs {
    void accept(AbstractObjectMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface AbstractObjectDOWNMssgs extends MModelItemDOWNMssgs, AbstractObjectMssgs{}
interface AbstractObjectUPMssgs extends MObjectUPMssgs, MSingletonObjectUPMssgs, AbstractObjectMssgs{}
