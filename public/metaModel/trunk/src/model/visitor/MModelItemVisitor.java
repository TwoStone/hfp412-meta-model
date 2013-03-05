
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentCONCMModelItem;

public interface MModelItemVisitor extends AbstractObjectVisitor,MTypeVisitor,MessageOrLinkVisitor{
    
    public void handleCONCMModelItem(PersistentCONCMModelItem cONCMModelItem) throws PersistenceException;
    
}
