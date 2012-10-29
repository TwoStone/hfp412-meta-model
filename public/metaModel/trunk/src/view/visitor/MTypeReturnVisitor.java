
package view.visitor;

import view.*;

public interface MTypeReturnVisitor<R> extends MComplexTypeReturnVisitor<R> {
    
    public R handleMAtomicType(MAtomicTypeView mAtomicType) throws ModelException;
    
}
