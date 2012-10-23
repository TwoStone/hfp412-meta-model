
package view.visitor;

import view.*;

public interface ComposedMetaTypeExceptionVisitor<E extends model.UserException> {
    
    public void handleOrMetaType(OrMetaTypeView orMetaType) throws ModelException, E;
    public void handleAndMetaType(AndMetaTypeView andMetaType) throws ModelException, E;
    
}
