package model.meta;

public interface MessageOrLinkMssgs {
    void accept(MessageOrLinkMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MessageOrLinkDOWNMssgs extends Mssgs, MessageOrLinkMssgs{}
interface MessageOrLinkUPMssgs extends MessageUPMssgs, LinkUPMssgs, MessageOrLinkMssgs{}
