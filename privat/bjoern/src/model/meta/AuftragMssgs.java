package model.meta;

public interface AuftragMssgs {
    void accept(AuftragMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface AuftragDOWNMssgs extends Mssgs, AuftragMssgs{}
interface AuftragUPMssgs extends Mssgs, AuftragMssgs{}
