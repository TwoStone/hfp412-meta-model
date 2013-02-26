package model.meta;

public interface LinkManagerMssgs {
    void accept(LinkManagerMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface LinkManagerDOWNMssgs extends Mssgs, LinkManagerMssgs{}
interface LinkManagerUPMssgs extends Mssgs, LinkManagerMssgs{}
