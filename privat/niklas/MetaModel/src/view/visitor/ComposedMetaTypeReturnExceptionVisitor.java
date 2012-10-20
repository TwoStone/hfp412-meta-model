
package view.visitor;

import view.*;

public interface ComposedMetaTypeReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleOrMetaType(OrMetaTypeView orMetaType) throws ModelException, E;
    public R handleAndMetaType(AndMetaTypeView andMetaType) throws ModelException, E;
    
}
