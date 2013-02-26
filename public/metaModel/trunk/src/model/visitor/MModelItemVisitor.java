
package model.visitor;

import persistence.*;

public interface MModelItemVisitor extends MTypeVisitor{
    
    public void handleCONCMModelItem(PersistentCONCMModelItem cONCMModelItem) throws PersistenceException;
    
}
