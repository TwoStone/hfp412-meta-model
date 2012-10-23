package view.objects;

import view.*;
import viewClient.*;

public class MAtomicTypeProxi extends ViewProxi implements MAtomicTypeView{
    
    public MAtomicTypeProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public MAtomicTypeView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String name = (String)resultTable.get("name");
        MAtomicTypeView result$$ = new MAtomicType((String)name, this.getId(), this.getClassId());
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
    
    public String getName() throws ModelException {
        return ((MAtomicType)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws ModelException {
        ((MAtomicType)this.getTheObject()).setName(newValue);
    }
    
    public void accept(view.visitor.MTypeVisitor visitor) throws ModelException {
        visitor.handleMAtomicType(this);
    }
    public <R> R accept(view.visitor.MTypeReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMAtomicType(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.MTypeExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMAtomicType(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.MTypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMAtomicType(this);
    }
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException {
        visitor.handleMAtomicType(this);
    }
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMAtomicType(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMAtomicType(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMAtomicType(this);
    }
    
    public boolean hasTransientFields(){
        return false;
    }
    
    public void setIcon(IconRenderer renderer){
        renderer.setIcon(null);
            //TODO: implement setIcon in view class MAtomicType
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
