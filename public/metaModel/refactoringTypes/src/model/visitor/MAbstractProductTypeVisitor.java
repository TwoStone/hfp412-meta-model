
package model.visitor;

import persistence.*;

public interface MAbstractProductTypeVisitor extends MNonEmptyProductTypeVisitor{
    
    public void handleMEmptyProductType(PersistentMEmptyProductType mEmptyProductType) throws PersistenceException;
    
}
