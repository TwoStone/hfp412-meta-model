
package view.visitor;

import view.*;

public interface MessageOrLinkReturnVisitor<R> {
    
    public R handleMessage(MessageView message) throws ModelException;
    public R handleLink(LinkView link) throws ModelException;
    
}
