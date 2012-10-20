
package view.visitor;

import view.*;

public interface AbstractMetaTypeVisitor extends ComposedMetaTypeVisitor{
    
    public void handleMetaType(MetaTypeView metaType) throws ModelException;
    
}
