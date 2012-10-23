package model.meta;

public interface DecorateesMssgs {
    void accept(DecorateesMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface DecorateesDOWNMssgs extends Mssgs, DecorateesMssgs{}
interface DecorateesUPMssgs extends Mssgs, DecorateesMssgs{}
