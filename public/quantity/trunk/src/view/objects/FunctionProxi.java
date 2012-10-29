package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class FunctionProxi extends ViewProxi implements FunctionView{
    
    public FunctionProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public FunctionView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        common.Fraction factor = common.Fraction.parse((String)resultTable.get("factor"));
        common.Fraction constant = common.Fraction.parse((String)resultTable.get("constant"));
        FunctionView result$$ = new Function((common.Fraction)factor,(common.Fraction)constant, this.getId(), this.getClassId());
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
    
    public common.Fraction getFactor() throws ModelException {
        return ((Function)this.getTheObject()).getFactor();
    }
    public void setFactor(common.Fraction newValue) throws ModelException {
        ((Function)this.getTheObject()).setFactor(newValue);
    }
    public common.Fraction getConstant() throws ModelException {
        return ((Function)this.getTheObject()).getConstant();
    }
    public void setConstant(common.Fraction newValue) throws ModelException {
        ((Function)this.getTheObject()).setConstant(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleFunction(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleFunction(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleFunction(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleFunction(this);
    }
    
    public boolean hasTransientFields(){
        return false;
    }
    
    public void setIcon(IconRenderer renderer){
        renderer.setIcon(null);
            //TODO: implement setIcon in view class Function
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
