package view.objects;

import view.*;
import viewClient.*;

public class MetaAspectProxi extends NamedEntityProxi implements MetaAspectView{
    
    public MetaAspectProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public MetaAspectView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String name = (String)resultTable.get("name");
        java.util.Vector<String> types_string = (java.util.Vector<String>)resultTable.get("types");
        java.util.Vector<MetaTypeView> types = ViewProxi.getProxiVector(types_string, connectionKey);
        MetaAspectView result$$ = new MetaAspect((String)name,types, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index < this.getTypes().size()) return new TypesMetaAspectWrapper(this, originalIndex, (ViewRoot)this.getTypes().get(index));
        index = index - this.getTypes().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getTypes().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getTypes().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getTypesIterator = this.getTypes().iterator();
        while(getTypesIterator.hasNext()){
            if(getTypesIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<MetaTypeView> getTypes() throws ModelException {
        return ((MetaAspect)this.getTheObject()).getTypes();
    }
    
    public void accept(view.visitor.NamedEntityVisitor visitor) throws ModelException {
        visitor.handleMetaAspect(this);
    }
    public <R> R accept(view.visitor.NamedEntityReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMetaAspect(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.NamedEntityExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMetaAspect(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.NamedEntityReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMetaAspect(this);
    }
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException {
        visitor.handleMetaAspect(this);
    }
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMetaAspect(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMetaAspect(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMetaAspect(this);
    }
    
    public boolean hasTransientFields(){
        return true;
    }
    
    public void setIcon(IconRenderer renderer){
        renderer.setIcon(null);
            //TODO: implement setIcon in view class MetaAspect
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
