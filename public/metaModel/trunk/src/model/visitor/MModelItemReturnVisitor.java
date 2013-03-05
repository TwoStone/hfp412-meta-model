
package model.visitor;

import persistence.*;

public interface MModelItemReturnVisitor<R> extends AbstractObjectReturnVisitor<R> ,MTypeReturnVisitor<R> ,MessageOrLinkReturnVisitor<R> {
    
    public R handleCONCMModelItem(PersistentCONCMModelItem cONCMModelItem) throws PersistenceException;
    
}
