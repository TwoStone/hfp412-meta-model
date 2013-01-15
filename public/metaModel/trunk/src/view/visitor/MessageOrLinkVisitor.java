
package view.visitor;

import view.*;

public interface MessageOrLinkVisitor {
    
    public void handleMessage(MessageView message) throws ModelException;
    public void handleLink(LinkView link) throws ModelException;
    
}
