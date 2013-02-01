
package model.visitor;

import persistence.*;

public abstract class MessageOrLinkStandardVisitor implements MessageOrLinkVisitor {
    
    public void handleLink(PersistentLink link) throws PersistenceException{
        this.standardHandling(link);
    }
    public void handleMessage(PersistentMessage message) throws PersistenceException{
        this.standardHandling(message);
    }
    protected abstract void standardHandling(PersistentMessageOrLink messageOrLink) throws PersistenceException;
}
