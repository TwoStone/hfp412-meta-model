
package model.visitor;

import persistence.*;

public interface MModelItemVisitor extends MTypeVisitor,MessageOrLinkVisitor{
    
    public void handleCONCMModelItem(PersistentCONCMModelItem cONCMModelItem) throws PersistenceException;
    
}
