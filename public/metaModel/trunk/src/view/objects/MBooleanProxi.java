package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class MBooleanProxi extends ViewProxi implements MBooleanView{
    
    public MBooleanProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public MBooleanView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        MBooleanView result$$ = new MBoolean( this.getId(), this.getClassId());
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
    
    
    public void accept(MBooleanVisitor visitor) throws ModelException {
        visitor.handleMBoolean(this);
    }
    public <R> R accept(MBooleanReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMBoolean(this);
    }
    public <E extends UserException>  void accept(MBooleanExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMBoolean(this);
    }
    public <R, E extends UserException> R accept(MBooleanReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMBoolean(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleMBoolean(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMBoolean(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMBoolean(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMBoolean(this);
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
