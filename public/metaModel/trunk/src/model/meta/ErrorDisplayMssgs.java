package model.meta;

public interface ErrorDisplayMssgs {
    void accept(ErrorDisplayMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ErrorDisplayDOWNMssgs extends Mssgs, ErrorDisplayMssgs{}
interface ErrorDisplayUPMssgs extends Mssgs, ErrorDisplayMssgs{}
