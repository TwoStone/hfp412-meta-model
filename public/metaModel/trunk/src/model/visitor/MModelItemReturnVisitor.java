
package model.visitor;

import persistence.*;

public interface MModelItemReturnVisitor<R> extends MTypeReturnVisitor<R> {
    
    public R handleCONCMModelItem(PersistentCONCMModelItem cONCMModelItem) throws PersistenceException;
    
}
