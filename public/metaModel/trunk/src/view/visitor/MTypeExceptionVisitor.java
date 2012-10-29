
package view.visitor;
import view.UserException;
import view.*;

public interface MTypeExceptionVisitor<E extends UserException> extends MComplexTypeExceptionVisitor<E>{
    
    public void handleMAtomicType(MAtomicTypeView mAtomicType) throws ModelException, E;
    
}
