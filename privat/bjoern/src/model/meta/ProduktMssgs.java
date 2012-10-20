package model.meta;

public interface ProduktMssgs {
    void accept(ProduktMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ProduktDOWNMssgs extends Mssgs, ProduktMssgs{}
interface ProduktUPMssgs extends Mssgs, ProduktMssgs{}
