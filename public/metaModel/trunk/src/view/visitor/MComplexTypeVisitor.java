
package view.visitor;

import view.*;

public interface MComplexTypeVisitor extends MAbstractSumTypeVisitor,MAbstractProductTypeVisitor{
    
    public void handleMAbstractProductType(MAbstractProductTypeView mAbstractProductType) throws ModelException;
    
}
