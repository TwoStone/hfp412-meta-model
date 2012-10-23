
package view.visitor;

import view.*;

public interface MTypeReturnExceptionVisitor<R, E extends model.UserException> extends MComplexTypeReturnExceptionVisitor<R, E> {
    
    public R handleMAtomicType(MAtomicTypeView mAtomicType) throws ModelException, E;
    
}
