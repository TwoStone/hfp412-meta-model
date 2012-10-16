package model.meta;

public interface JuristicPersonMssgs {
    void accept(JuristicPersonMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface JuristicPersonDOWNMssgs extends ActorDOWNMssgs, JuristicPersonMssgs{}
interface JuristicPersonUPMssgs extends Mssgs, JuristicPersonMssgs{}
