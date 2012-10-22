package model.meta;

public interface ActorMssgs {
    void accept(ActorMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ActorDOWNMssgs extends Mssgs, ActorMssgs{}
interface ActorUPMssgs extends Mssgs, ActorMssgs{}
