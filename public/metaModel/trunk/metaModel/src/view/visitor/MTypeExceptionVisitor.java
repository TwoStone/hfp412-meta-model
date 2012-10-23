
package view.visitor;

import view.*;

public interface MTypeExceptionVisitor<E extends model.UserException> extends MComplexTypeExceptionVisitor<E>{
    
    public void handleMAtomicType(MAtomicTypeView mAtomicType) throws ModelException, E;
    
}
