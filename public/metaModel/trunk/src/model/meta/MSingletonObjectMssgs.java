package model.meta;

public interface MSingletonObjectMssgs {
    void accept(MSingletonObjectMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MSingletonObjectDOWNMssgs extends AbstractObjectDOWNMssgs, MSingletonObjectMssgs{}
interface MSingletonObjectUPMssgs extends Mssgs, MSingletonObjectMssgs{}
