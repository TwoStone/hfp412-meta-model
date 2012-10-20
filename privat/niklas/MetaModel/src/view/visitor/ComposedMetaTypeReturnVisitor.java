
package view.visitor;

import view.*;

public interface ComposedMetaTypeReturnVisitor<R> {
    
    public R handleOrMetaType(OrMetaTypeView orMetaType) throws ModelException;
    public R handleAndMetaType(AndMetaTypeView andMetaType) throws ModelException;
    
}
