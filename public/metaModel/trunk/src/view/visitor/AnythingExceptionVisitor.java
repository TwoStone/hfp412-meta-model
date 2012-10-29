
package view.visitor;
import view.UserException;
import view.*;

public interface AnythingExceptionVisitor<E extends UserException> extends MComplexTypeExceptionVisitor<E>{
    
    public void handleMAtomicType(MAtomicTypeView mAtomicType) throws ModelException, E;
    public void handleTypeManager(TypeManagerView typeManager) throws ModelException, E;
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException, E;
    public void handleServer(ServerView server) throws ModelException, E;
    
}
