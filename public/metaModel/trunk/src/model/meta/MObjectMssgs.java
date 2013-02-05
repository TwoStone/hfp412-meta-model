package model.meta;

public interface MObjectMssgs {
    void accept(MObjectMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MObjectDOWNMssgs extends AbstractObjectDOWNMssgs, MObjectMssgs{}
interface MObjectUPMssgs extends Mssgs, MObjectMssgs{}
