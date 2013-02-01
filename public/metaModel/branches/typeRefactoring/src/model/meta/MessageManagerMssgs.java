package model.meta;

public interface MessageManagerMssgs {
    void accept(MessageManagerMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MessageManagerDOWNMssgs extends Mssgs, MessageManagerMssgs{}
interface MessageManagerUPMssgs extends Mssgs, MessageManagerMssgs{}
