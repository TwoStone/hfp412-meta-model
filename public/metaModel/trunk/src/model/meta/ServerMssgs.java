package model.meta;

public interface ServerMssgs {
    void accept(ServerMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ServerDOWNMssgs extends Mssgs, ServerMssgs{}
interface ServerUPMssgs extends Mssgs, ServerMssgs{}
