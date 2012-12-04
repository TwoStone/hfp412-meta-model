package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class MTrueProxi extends MBooleanProxi implements MTrueView{
    
    public MTrueProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public MTrueView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        MTrueView result$$ = new MTrue( this.getId(), this.getClassId());
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
        visitor.handleMTrue(this);
    }
    public <R> R accept(MBooleanReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMTrue(this);
    }
    public <E extends UserException>  void accept(MBooleanExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMTrue(this);
    }
    public <R, E extends UserException> R accept(MBooleanReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMTrue(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleMTrue(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMTrue(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMTrue(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMTrue(this);
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
