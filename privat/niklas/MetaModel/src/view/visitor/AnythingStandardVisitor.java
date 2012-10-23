
package view.visitor;

import view.*;

public abstract class AnythingStandardVisitor implements AnythingVisitor {
    
    public void handleCONCNamedEntity(CONCNamedEntityView cONCNamedEntity) throws ModelException{
        this.standardHandling(cONCNamedEntity);
    }
    public void handleTypeManager(TypeManagerView typeManager) throws ModelException{
        this.standardHandling(typeManager);
    }
    public void handleOrMetaType(OrMetaTypeView orMetaType) throws ModelException{
        this.standardHandling(orMetaType);
    }
    public void handleAspectManager(AspectManagerView aspectManager) throws ModelException{
        this.standardHandling(aspectManager);
    }
    public void handleMetaAspect(MetaAspectView metaAspect) throws ModelException{
        this.standardHandling(metaAspect);
    }
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException{
        this.standardHandling(errorDisplay);
    }
    public void handleServer(ServerView server) throws ModelException{
        this.standardHandling(server);
    }
    public void handleMetaAssociation(MetaAssociationView metaAssociation) throws ModelException{
        this.standardHandling(metaAssociation);
    }
    public void handleAndMetaType(AndMetaTypeView andMetaType) throws ModelException{
        this.standardHandling(andMetaType);
    }
    public void handleMetaHierarchy(MetaHierarchyView metaHierarchy) throws ModelException{
        this.standardHandling(metaHierarchy);
    }
    public void handleMetaType(MetaTypeView metaType) throws ModelException{
        this.standardHandling(metaType);
    }
    protected abstract void standardHandling(Anything anything) throws ModelException;
}
