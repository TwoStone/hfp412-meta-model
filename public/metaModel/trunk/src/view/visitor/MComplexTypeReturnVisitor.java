
package view.visitor;

import view.*;

public interface MComplexTypeReturnVisitor<R> extends MAbstractSumTypeReturnVisitor<R> ,MAbstractProductTypeReturnVisitor<R> {
    
    public R handleMAbstractProductType(MAbstractProductTypeView mAbstractProductType) throws ModelException;
    
}
