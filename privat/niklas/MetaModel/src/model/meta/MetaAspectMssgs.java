package model.meta;

public interface MetaAspectMssgs {
    void accept(MetaAspectMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MetaAspectDOWNMssgs extends NamedEntityDOWNMssgs, MetaAspectMssgs{}
interface MetaAspectUPMssgs extends Mssgs, MetaAspectMssgs{}
