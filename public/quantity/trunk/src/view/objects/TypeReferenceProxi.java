package view.objects;

import view.*;
import viewClient.*;

public class TypeReferenceProxi extends AbsUnitTypeProxi implements TypeReferenceView{
    
    public TypeReferenceProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public TypeReferenceView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        TypeReferenceView result$$ = new TypeReference( this.getId(), this.getClassId());
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
    
    
    public void accept(view.visitor.AbsUnitTypeVisitor visitor) throws ModelException {
        visitor.handleTypeReference(this);
    }
    public <R> R accept(view.visitor.AbsUnitTypeReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleTypeReference(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AbsUnitTypeExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleTypeReference(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AbsUnitTypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleTypeReference(this);
    }
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException {
        visitor.handleTypeReference(this);
    }
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleTypeReference(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleTypeReference(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleTypeReference(this);
    }
    
    public boolean hasTransientFields(){
        return false;
    }
    
    public void setIcon(IconRenderer renderer){
        renderer.setIcon(null);
            //TODO: implement setIcon in view class TypeReference
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
