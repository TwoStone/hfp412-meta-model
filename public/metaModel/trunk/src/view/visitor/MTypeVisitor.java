
package view.visitor;

import view.*;

public interface MTypeVisitor extends MComplexTypeVisitor{
    
    public void handleMAtomicType(MAtomicTypeView mAtomicType) throws ModelException;
    
}
