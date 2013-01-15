
package view.visitor;
import view.UserException;
import view.*;

public interface MessageOrLinkExceptionVisitor<E extends UserException> {
    
    public void handleMessage(MessageView message) throws ModelException, E;
    public void handleLink(LinkView link) throws ModelException, E;
    
}
