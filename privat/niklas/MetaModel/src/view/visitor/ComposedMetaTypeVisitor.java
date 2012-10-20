
package view.visitor;

import view.*;

public interface ComposedMetaTypeVisitor {
    
    public void handleOrMetaType(OrMetaTypeView orMetaType) throws ModelException;
    public void handleAndMetaType(AndMetaTypeView andMetaType) throws ModelException;
    
}
