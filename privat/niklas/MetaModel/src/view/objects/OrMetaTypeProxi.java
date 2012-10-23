package view.objects;

import view.*;
import viewClient.*;

public class OrMetaTypeProxi extends ComposedMetaTypeProxi implements OrMetaTypeView{
    
    public OrMetaTypeProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public OrMetaTypeView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> components_string = (java.util.Vector<String>)resultTable.get("components");
        java.util.Vector<AbstractMetaTypeView> components = ViewProxi.getProxiVector(components_string, connectionKey);
        ViewProxi disjunctiveNormalform = null;
        String disjunctiveNormalform$String = (String)resultTable.get("disjunctiveNormalform");
        if (disjunctiveNormalform$String != null) {
            common.ProxiInformation disjunctiveNormalform$Info = common.RPCConstantsAndServices.createProxiInformation(disjunctiveNormalform$String);
            disjunctiveNormalform = ViewProxi.createProxi(disjunctiveNormalform$Info,connectionKey);
            disjunctiveNormalform.setToString(disjunctiveNormalform$Info.getToString());
        }
        OrMetaTypeView result$$ = new OrMetaType(components,(OrMetaTypeView)disjunctiveNormalform, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index < this.getComponents().size()) return new ComponentsComposedMetaTypeWrapper(this, originalIndex, (ViewRoot)this.getComponents().get(index));
        index = index - this.getComponents().size();
        if(index == 0 && this.getDisjunctiveNormalform() != null) return new DisjunctiveNormalformComposedMetaTypeWrapper(this, originalIndex, (ViewRoot)this.getDisjunctiveNormalform());
        if(this.getDisjunctiveNormalform() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getComponents().size())
            + (this.getDisjunctiveNormalform() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getComponents().size() == 0)
            && (this.getDisjunctiveNormalform() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getComponentsIterator = this.getComponents().iterator();
        while(getComponentsIterator.hasNext()){
            if(getComponentsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        if(this.getDisjunctiveNormalform() != null && this.getDisjunctiveNormalform().equals(child)) return result;
        if(this.getDisjunctiveNormalform() != null) result = result + 1;
        return -1;
    }
    
    
    public void accept(view.visitor.ComposedMetaTypeVisitor visitor) throws ModelException {
        visitor.handleOrMetaType(this);
    }
    public <R> R accept(view.visitor.ComposedMetaTypeReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleOrMetaType(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.ComposedMetaTypeExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleOrMetaType(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.ComposedMetaTypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleOrMetaType(this);
    }
    public void accept(view.visitor.AbstractMetaTypeVisitor visitor) throws ModelException {
        visitor.handleOrMetaType(this);
    }
    public <R> R accept(view.visitor.AbstractMetaTypeReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleOrMetaType(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AbstractMetaTypeExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleOrMetaType(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AbstractMetaTypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleOrMetaType(this);
    }
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException {
        visitor.handleOrMetaType(this);
    }
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleOrMetaType(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleOrMetaType(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleOrMetaType(this);
    }
    
    public boolean hasTransientFields(){
        return true;
    }
    
    public void setIcon(IconRenderer renderer){
        renderer.setIcon(null);
            //TODO: implement setIcon in view class OrMetaType
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
