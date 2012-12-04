
package view.visitor;
import view.UserException;
import view.*;

public interface MTypeReturnExceptionVisitor<R, E extends UserException> extends MComplexTypeReturnExceptionVisitor<R, E> {
    
    public R handleMAtomicType(MAtomicTypeView mAtomicType) throws ModelException, E;
    
}
