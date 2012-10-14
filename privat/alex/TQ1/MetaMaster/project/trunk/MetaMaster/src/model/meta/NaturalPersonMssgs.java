package model.meta;

public interface NaturalPersonMssgs {
    void accept(NaturalPersonMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface NaturalPersonDOWNMssgs extends ActorDOWNMssgs, NaturalPersonMssgs{}
interface NaturalPersonUPMssgs extends Mssgs, NaturalPersonMssgs{}
