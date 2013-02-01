package model.meta;

public interface InstanceObjectMssgs {
    void accept(InstanceObjectMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface InstanceObjectDOWNMssgs extends Mssgs, InstanceObjectMssgs{}
interface InstanceObjectUPMssgs extends Mssgs, InstanceObjectMssgs{}
