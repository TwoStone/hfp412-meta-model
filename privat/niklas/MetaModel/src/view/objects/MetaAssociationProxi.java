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
        ViewProxi fromType = null;
        String fromType$String = (String)resultTable.get("fromType");
        if (fromType$String != null) {
            common.ProxiInformation fromType$Info = common.RPCConstantsAndServices.createProxiInformation(fromType$String);
            fromType = ViewProxi.createProxi(fromType$Info,connectionKey);
            fromType.setToString(fromType$Info.getToString());
        }
        ViewProxi toType = null;
        String toType$String = (String)resultTable.get("toType");
        if (toType$String != null) {
            common.ProxiInformation toType$Info = common.RPCConstantsAndServices.createProxiInformation(toType$String);
            toType = ViewProxi.createProxi(toType$Info,connectionKey);
            toType.setToString(toType$Info.getToString());
        }
        java.util.Vector<String> hierarchies_string = (java.util.Vector<String>)resultTable.get("hierarchies");
        java.util.Vector<MetaHierarchyView> hierarchies = ViewProxi.getProxiVector(hierarchies_string, connectionKey);
        MetaAssociationView result$$ = new MetaAssociation((String)name,(AbstractMetaTypeView)fromType,(AbstractMetaTypeView)toType,hierarchies, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index == 0 && this.getFromType() != null) return new FromTypeMetaAssociationWrapper(this, originalIndex, (ViewRoot)this.getFromType());
        if(this.getFromType() != null) index = index - 1;
        if(index == 0 && this.getToType() != null) return new ToTypeMetaAssociationWrapper(this, originalIndex, (ViewRoot)this.getToType());
        if(this.getToType() != null) index = index - 1;
        if(index < this.getHierarchies().size()) return new HierarchiesMetaAssociationWrapper(this, originalIndex, (ViewRoot)this.getHierarchies().get(index));
        index = index - this.getHierarchies().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getFromType() == null ? 0 : 1)
            + (this.getToType() == null ? 0 : 1)
            + (this.getHierarchies().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getFromType() == null ? true : false)
            && (this.getToType() == null ? true : false)
            && (this.getHierarchies().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getFromType() != null && this.getFromType().equals(child)) return result;
        if(this.getFromType() != null) result = result + 1;
        if(this.getToType() != null && this.getToType().equals(child)) return result;
        if(this.getToType() != null) result = result + 1;
        java.util.Iterator<?> getHierarchiesIterator = this.getHierarchies().iterator();
        while(getHierarchiesIterator.hasNext()){
            if(getHierarchiesIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public AbstractMetaTypeView getFromType() throws ModelException {
        return ((MetaAssociation)this.getTheObject()).getFromType();
    }
    public void setFromType(AbstractMetaTypeView newValue) throws ModelException {
        ((MetaAssociation)this.getTheObject()).setFromType(newValue);
    }
    public AbstractMetaTypeView getToType() throws ModelException {
        return ((MetaAssociation)this.getTheObject()).getToType();
    }
    public void setToType(AbstractMetaTypeView newValue) throws ModelException {
        ((MetaAssociation)this.getTheObject()).setToType(newValue);
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
