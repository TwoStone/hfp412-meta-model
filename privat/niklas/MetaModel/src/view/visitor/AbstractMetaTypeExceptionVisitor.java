
package view.visitor;

import view.*;

public interface AbstractMetaTypeExceptionVisitor<E extends model.UserException> extends ComposedMetaTypeExceptionVisitor<E>{
    
    public void handleMetaType(MetaTypeView metaType) throws ModelException, E;
    
}
