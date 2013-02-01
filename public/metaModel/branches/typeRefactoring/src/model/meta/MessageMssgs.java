package model.meta;

public interface MessageMssgs {
    void accept(MessageMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MessageDOWNMssgs extends MessageOrLinkDOWNMssgs, MessageMssgs{}
interface MessageUPMssgs extends Mssgs, MessageMssgs{}
