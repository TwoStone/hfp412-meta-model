
package view.visitor;
import view.UserException;
import view.*;

public interface MessageOrLinkReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleMessage(MessageView message) throws ModelException, E;
    public R handleLink(LinkView link) throws ModelException, E;
    
}
