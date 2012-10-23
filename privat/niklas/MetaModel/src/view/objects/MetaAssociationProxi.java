package view.objects;

import view.*;
import viewClient.*;

public class MetaAssociationProxi extends NamedEntityProxi implements MetaAssociationView{
    
    public MetaAssociationProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public MetaAssociationView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String name = (String)resultTable.get("name");
        ViewProxi source = null;
        String source$String = (String)resultTable.get("source");
        if (source$String != null) {
            common.ProxiInformation source$Info = common.RPCConstantsAndServices.createProxiInformation(source$String);
            source = ViewProxi.createProxi(source$Info,connectionKey);
            source.setToString(source$Info.getToString());
        }
        ViewProxi target = null;
        String target$String = (String)resultTable.get("target");
        if (target$String != null) {
            common.ProxiInformation target$Info = common.RPCConstantsAndServices.createProxiInformation(target$String);
            target = ViewProxi.createProxi(target$Info,connectionKey);
            target.setToString(target$Info.getToString());
        }
        java.util.Vector<String> hierarchies_string = (java.util.Vector<String>)resultTable.get("hierarchies");
        java.util.Vector<MetaHierarchyView> hierarchies = ViewProxi.getProxiVector(hierarchies_string, connectionKey);
        MetaAssociationView result$$ = new MetaAssociation((String)name,(AbstractMetaTypeView)source,(AbstractMetaTypeView)target,hierarchies, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index == 0 && this.getSource() != null) return new SourceMetaAssociationWrapper(this, originalIndex, (ViewRoot)this.getSource());
        if(this.getSource() != null) index = index - 1;
        if(index == 0 && this.getTarget() != null) return new TargetMetaAssociationWrapper(this, originalIndex, (ViewRoot)this.getTarget());
        if(this.getTarget() != null) index = index - 1;
        if(index < this.getHierarchies().size()) return new HierarchiesMetaAssociationWrapper(this, originalIndex, (ViewRoot)this.getHierarchies().get(index));
        index = index - this.getHierarchies().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getSource() == null ? 0 : 1)
            + (this.getTarget() == null ? 0 : 1)
            + (this.getHierarchies().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getSource() == null ? true : false)
            && (this.getTarget() == null ? true : false)
            && (this.getHierarchies().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getSource() != null && this.getSource().equals(child)) return result;
        if(this.getSource() != null) result = result + 1;
        if(this.getTarget() != null && this.getTarget().equals(child)) return result;
        if(this.getTarget() != null) result = result + 1;
        java.util.Iterator<?> getHierarchiesIterator = this.getHierarchies().iterator();
        while(getHierarchiesIterator.hasNext()){
            if(getHierarchiesIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public AbstractMetaTypeView getSource() throws ModelException {
        return ((MetaAssociation)this.getTheObject()).getSource();
    }
    public void setSource(AbstractMetaTypeView newValue) throws ModelException {
        ((MetaAssociation)this.getTheObject()).setSource(newValue);
    }
    public AbstractMetaTypeView getTarget() throws ModelException {
        return ((MetaAssociation)this.getTheObject()).getTarget();
    }
    public void setTarget(AbstractMetaTypeView newValue) throws ModelException {
        ((MetaAssociation)this.getTheObject()).setTarget(newValue);
    }
    public java.util.Vector<MetaHierarchyView> getHierarchies() throws ModelException {
        return ((MetaAssociation)this.getTheObject()).getHierarchies();
    }
    public void setHierarchies(java.util.Vector<MetaHierarchyView> newValue) throws ModelException {
        ((MetaAssociation)this.getTheObject()).setHierarchies(newValue);
    }
    
    public void accept(view.visitor.NamedEntityVisitor visitor) throws ModelException {
        visitor.handleMetaAssociation(this);
    }
    public <R> R accept(view.visitor.NamedEntityReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMetaAssociation(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.NamedEntityExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMetaAssociation(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.NamedEntityReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMetaAssociation(this);
    }
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException {
        visitor.handleMetaAssociation(this);
    }
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMetaAssociation(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMetaAssociation(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMetaAssociation(this);
    }
    
    public boolean hasTransientFields(){
        return false;
    }
    
    public void setIcon(IconRenderer renderer){
        renderer.setIcon(null);
            //TODO: implement setIcon in view class MetaAssociation
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
