
package view.visitor;

import view.*;

public interface AbstractMetaTypeReturnVisitor<R> extends ComposedMetaTypeReturnVisitor<R> {
    
    public R handleMetaType(MetaTypeView metaType) throws ModelException;
    
}
