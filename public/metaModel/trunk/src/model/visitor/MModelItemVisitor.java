
package model.visitor;

import persistence.*;

public interface MModelItemVisitor extends AbstractObjectVisitor,MTypeVisitor,MessageOrLinkVisitor{
    
    public void handleCONCMModelItem(PersistentCONCMModelItem cONCMModelItem) throws PersistenceException;
    
}
