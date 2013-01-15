
package view.visitor;

import view.*;

public interface MAbstractSumTypeVisitor {
    
    public void handleMEmptySumType(MEmptySumTypeView mEmptySumType) throws ModelException;
    public void handleMSumType(MSumTypeView mSumType) throws ModelException;
    
}
