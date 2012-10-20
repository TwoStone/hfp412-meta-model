
package view.visitor;

import view.*;

public abstract class AbstractMetaTypeDirectVisitor implements AbstractMetaTypeVisitor {
    
    public abstract void handleComposedMetaType(ComposedMetaTypeView composedMetaType) throws ModelException;
    
    public void handleOrMetaType(OrMetaTypeView orMetaType) throws ModelException{
        this.handleComposedMetaType(orMetaType);
    }
    public void handleAndMetaType(AndMetaTypeView andMetaType) throws ModelException{
        this.handleComposedMetaType(andMetaType);
    }
    public abstract void handleMetaType(MetaTypeView metaType) throws ModelException;
    
    
}
