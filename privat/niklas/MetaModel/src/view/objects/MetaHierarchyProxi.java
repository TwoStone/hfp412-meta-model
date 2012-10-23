package view.objects;

import view.*;
import viewClient.*;

public class MetaHierarchyProxi extends NamedEntityProxi implements MetaHierarchyView{
    
    public MetaHierarchyProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public MetaHierarchyView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String name = (String)resultTable.get("name");
        MetaHierarchyView result$$ = new MetaHierarchy((String)name, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 ;
    }
    public boolean isLeaf() throws ModelException {
        return true;
    }
    public int getIndexOfChild(Object child) throws ModelException {
        
        return -1;
    }
    
    
    public void accept(view.visitor.NamedEntityVisitor visitor) throws ModelException {
        visitor.handleMetaHierarchy(this);
    }
    public <R> R accept(view.visitor.NamedEntityReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMetaHierarchy(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.NamedEntityExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMetaHierarchy(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.NamedEntityReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMetaHierarchy(this);
    }
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException {
        visitor.handleMetaHierarchy(this);
    }
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMetaHierarchy(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMetaHierarchy(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMetaHierarchy(this);
    }
    
    public boolean hasTransientFields(){
        return false;
    }
    
    public void setIcon(IconRenderer renderer){
        renderer.setIcon(null);
            //TODO: implement setIcon in view class MetaHierarchy
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
