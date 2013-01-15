
package view.visitor;

import view.*;

public abstract class MessageOrLinkStandardVisitor implements MessageOrLinkVisitor {
    
    public void handleLink(LinkView link) throws ModelException{
        this.standardHandling(link);
    }
    public void handleMessage(MessageView message) throws ModelException{
        this.standardHandling(message);
    }
    protected abstract void standardHandling(MessageOrLinkView messageOrLink) throws ModelException;
}
