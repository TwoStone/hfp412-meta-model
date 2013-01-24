package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class AssociationProxi extends AbsOperationProxi implements AssociationView{
    
    public AssociationProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public AssociationView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
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
        java.util.Vector<String> parameters_string = (java.util.Vector<String>)resultTable.get("parameters");
        java.util.Vector<FormalParameterView> parameters = ViewProxi.getProxiVector(parameters_string, connectionKey);
        java.util.Vector<String> hierarchies_string = (java.util.Vector<String>)resultTable.get("hierarchies");
        java.util.Vector<HierarchyView> hierarchies = ViewProxi.getProxiVector(hierarchies_string, connectionKey);
        AssociationView result$$ = new Association((String)name,(MTypeView)source,(MTypeView)target,parameters,hierarchies, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index == 0 && this.getSource() != null) return new SourceAbsOperationWrapper(this, originalIndex, (ViewRoot)this.getSource());
        if(this.getSource() != null) index = index - 1;
        if(index == 0 && this.getTarget() != null) return new TargetAbsOperationWrapper(this, originalIndex, (ViewRoot)this.getTarget());
        if(this.getTarget() != null) index = index - 1;
        if(index < this.getParameters().size()) return new ParametersAbsOperationWrapper(this, originalIndex, (ViewRoot)this.getParameters().get(index));
        index = index - this.getParameters().size();
        if(index < this.getHierarchies().size()) return new HierarchiesAssociationWrapper(this, originalIndex, (ViewRoot)this.getHierarchies().get(index));
        index = index - this.getHierarchies().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getSource() == null ? 0 : 1)
            + (this.getTarget() == null ? 0 : 1)
            + (this.getParameters().size())
            + (this.getHierarchies().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getSource() == null ? true : false)
            && (this.getTarget() == null ? true : false)
            && (this.getParameters().size() == 0)
            && (this.getHierarchies().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getSource() != null && this.getSource().equals(child)) return result;
        if(this.getSource() != null) result = result + 1;
        if(this.getTarget() != null && this.getTarget().equals(child)) return result;
        if(this.getTarget() != null) result = result + 1;
        java.util.Iterator<?> getParametersIterator = this.getParameters().iterator();
        while(getParametersIterator.hasNext()){
            if(getParametersIterator.next().equals(child)) return result;
            result = result + 1;
        }
        java.util.Iterator<?> getHierarchiesIterator = this.getHierarchies().iterator();
        while(getHierarchiesIterator.hasNext()){
            if(getHierarchiesIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<HierarchyView> getHierarchies() throws ModelException {
        return ((Association)this.getTheObject()).getHierarchies();
    }
    public void setHierarchies(java.util.Vector<HierarchyView> newValue) throws ModelException {
        ((Association)this.getTheObject()).setHierarchies(newValue);
    }
    
    public void accept(AbsOperationVisitor visitor) throws ModelException {
        visitor.handleAssociation(this);
    }
    public <R> R accept(AbsOperationReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleAssociation(this);
    }
    public <E extends UserException>  void accept(AbsOperationExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleAssociation(this);
    }
    public <R, E extends UserException> R accept(AbsOperationReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleAssociation(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleAssociation(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleAssociation(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleAssociation(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleAssociation(this);
    }
    
    public boolean hasTransientFields(){
        return false;
    }
    
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
