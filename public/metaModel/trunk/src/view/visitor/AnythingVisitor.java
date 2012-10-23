
package view.visitor;

import view.*;

public interface AnythingVisitor extends MComplexTypeVisitor{
    
    public void handleMAtomicType(MAtomicTypeView mAtomicType) throws ModelException;
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public void handleServer(ServerView server) throws ModelException;
    
}
