package model.meta;

public interface ActorManagerMssgs {
    void accept(ActorManagerMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ActorManagerDOWNMssgs extends Mssgs, ActorManagerMssgs{}
interface ActorManagerUPMssgs extends Mssgs, ActorManagerMssgs{}
