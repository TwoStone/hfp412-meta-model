package view.objects;

import view.*;
import viewClient.*;

public class FractionProxi extends ViewProxi implements FractionView{
    
    public FractionProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public FractionView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        long enumerator = new Long((String)resultTable.get("enumerator")).longValue();
        long denominator = new Long((String)resultTable.get("denominator")).longValue();
        FractionView result$$ = new Fraction((long)enumerator,(long)denominator, this.getId(), this.getClassId());
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
    
    public long getEnumerator() throws ModelException {
        return ((Fraction)this.getTheObject()).getEnumerator();
    }
    public void setEnumerator(long newValue) throws ModelException {
        ((Fraction)this.getTheObject()).setEnumerator(newValue);
    }
    public long getDenominator() throws ModelException {
        return ((Fraction)this.getTheObject()).getDenominator();
    }
    public void setDenominator(long newValue) throws ModelException {
        ((Fraction)this.getTheObject()).setDenominator(newValue);
    }
    
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException {
        visitor.handleFraction(this);
    }
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleFraction(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleFraction(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleFraction(this);
    }
    
    public boolean hasTransientFields(){
        return false;
    }
    
    public void setIcon(IconRenderer renderer){
        renderer.setIcon(null);
            //TODO: implement setIcon in view class Fraction
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
