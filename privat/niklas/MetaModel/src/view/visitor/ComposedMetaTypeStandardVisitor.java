
package view.visitor;

import view.*;

public abstract class ComposedMetaTypeStandardVisitor implements ComposedMetaTypeVisitor {
    
    public void handleOrMetaType(OrMetaTypeView orMetaType) throws ModelException{
        this.standardHandling(orMetaType);
    }
    public void handleAndMetaType(AndMetaTypeView andMetaType) throws ModelException{
        this.standardHandling(andMetaType);
    }
    protected abstract void standardHandling(ComposedMetaTypeView composedMetaType) throws ModelException;
}
