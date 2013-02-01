package model.meta;

public interface MAspectMssgs {
    void accept(MAspectMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MAspectDOWNMssgs extends Mssgs, MAspectMssgs{}
interface MAspectUPMssgs extends Mssgs, MAspectMssgs{}
