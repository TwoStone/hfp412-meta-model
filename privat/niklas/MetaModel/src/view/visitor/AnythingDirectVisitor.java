
package view.visitor;

import view.*;

public abstract class AnythingDirectVisitor implements AnythingVisitor {
    
    public abstract void handleTypeManager(TypeManagerView typeManager) throws ModelException;
    
    public abstract void handleAspectManager(AspectManagerView aspectManager) throws ModelException;
    
    public abstract void handleAbstractMetaType(AbstractMetaTypeView abstractMetaType) throws ModelException;
    
    public void handleOrMetaType(OrMetaTypeView orMetaType) throws ModelException{
        this.handleAbstractMetaType(orMetaType);
    }
    public void handleAndMetaType(AndMetaTypeView andMetaType) throws ModelException{
        this.handleAbstractMetaType(andMetaType);
    }
    public void handleMetaType(MetaTypeView metaType) throws ModelException{
        this.handleAbstractMetaType(metaType);
    }
    public abstract void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    
    public abstract void handleNamedEntity(NamedEntityView namedEntity) throws ModelException;
    
    public void handleCONCNamedEntity(CONCNamedEntityView cONCNamedEntity) throws ModelException{
        this.handleNamedEntity(cONCNamedEntity);
    }
    public void handleMetaAspect(MetaAspectView metaAspect) throws ModelException{
        this.handleNamedEntity(metaAspect);
    }
    public void handleMetaHierarchy(MetaHierarchyView metaHierarchy) throws ModelException{
        this.handleNamedEntity(metaHierarchy);
    }
    public void handleMetaAssociation(MetaAssociationView metaAssociation) throws ModelException{
        this.handleNamedEntity(metaAssociation);
    }
    public abstract void handleServer(ServerView server) throws ModelException;
    
    
}
