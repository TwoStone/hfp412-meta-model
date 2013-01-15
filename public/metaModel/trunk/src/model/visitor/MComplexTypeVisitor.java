
package model.visitor;

import persistence.*;

public interface MComplexTypeVisitor extends MAbstractSumTypeVisitor,MAbstractProductTypeVisitor{
    
    public void handleMAbstractProductType(PersistentMAbstractProductType mAbstractProductType) throws PersistenceException;
    
}
