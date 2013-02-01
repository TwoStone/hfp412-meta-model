package model.meta;

public interface LinkMssgs {
    void accept(LinkMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface LinkDOWNMssgs extends MessageOrLinkDOWNMssgs, LinkMssgs{}
interface LinkUPMssgs extends Mssgs, LinkMssgs{}
