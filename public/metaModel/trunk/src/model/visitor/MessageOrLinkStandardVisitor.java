
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentLink;
import persistence.PersistentMessage;
import persistence.PersistentMessageOrLink;

public abstract class MessageOrLinkStandardVisitor implements MessageOrLinkVisitor {
    
    public void handleLink(PersistentLink link) throws PersistenceException{
        this.standardHandling(link);
    }
    public void handleMessage(PersistentMessage message) throws PersistenceException{
        this.standardHandling(message);
    }
    protected abstract void standardHandling(PersistentMessageOrLink messageOrLink) throws PersistenceException;
}
