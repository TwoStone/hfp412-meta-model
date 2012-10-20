
package view.visitor;

import view.*;

public abstract class AbstractMetaTypeStandardVisitor implements AbstractMetaTypeVisitor {
    
    public void handleOrMetaType(OrMetaTypeView orMetaType) throws ModelException{
        this.standardHandling(orMetaType);
    }
    public void handleAndMetaType(AndMetaTypeView andMetaType) throws ModelException{
        this.standardHandling(andMetaType);
    }
    public void handleMetaType(MetaTypeView metaType) throws ModelException{
        this.standardHandling(metaType);
    }
    protected abstract void standardHandling(AbstractMetaTypeView abstractMetaType) throws ModelException;
}
