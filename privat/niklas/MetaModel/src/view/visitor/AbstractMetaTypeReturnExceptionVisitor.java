
package view.visitor;

import view.*;

public interface AbstractMetaTypeReturnExceptionVisitor<R, E extends model.UserException> extends ComposedMetaTypeReturnExceptionVisitor<R, E> {
    
    public R handleMetaType(MetaTypeView metaType) throws ModelException, E;
    
}
