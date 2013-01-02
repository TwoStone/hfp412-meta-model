
package model.visitor;

import persistence.*;

public interface MComplexTypeVisitor extends MProductTypeVisitor,MSumTypeVisitor{
    
    public void handleMProductType(PersistentMProductType mProductType) throws PersistenceException;
    public void handleMSumType(PersistentMSumType mSumType) throws PersistenceException;
    
}
