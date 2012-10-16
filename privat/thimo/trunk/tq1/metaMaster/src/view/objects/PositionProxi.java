package view.objects;

import view.*;
import viewClient.*;

public class PositionProxi extends ViewProxi implements PositionView{
    
    public PositionProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public PositionView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi relateTo = null;
        String relateTo$String = (String)resultTable.get("relateTo");
        if (relateTo$String != null) {
            common.ProxiInformation relateTo$Info = common.RPCConstantsAndServices.createProxiInformation(relateTo$String);
            relateTo = ViewProxi.createProxi(relateTo$Info,connectionKey);
            relateTo.setToString(relateTo$Info.getToString());
        }
        long amount = new Long((String)resultTable.get("amount")).longValue();
        PositionView result$$ = new Position((ProductView)relateTo,(long)amount, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index == 0 && this.getRelateTo() != null) return new RelateToPositionWrapper(this, originalIndex, (ViewRoot)this.getRelateTo());
        if(this.getRelateTo() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getRelateTo() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getRelateTo() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getRelateTo() != null && this.getRelateTo().equals(child)) return result;
        if(this.getRelateTo() != null) result = result + 1;
        return -1;
    }
    
    public ProductView getRelateTo() throws ModelException {
        return ((Position)this.getTheObject()).getRelateTo();
    }
    public void setRelateTo(ProductView newValue) throws ModelException {
        ((Position)this.getTheObject()).setRelateTo(newValue);
    }
    public long getAmount() throws ModelException {
        return ((Position)this.getTheObject()).getAmount();
    }
    public void setAmount(long newValue) throws ModelException {
        ((Position)this.getTheObject()).setAmount(newValue);
    }
    
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException {
        visitor.handlePosition(this);
    }
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handlePosition(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handlePosition(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handlePosition(this);
    }
    
    public boolean hasTransientFields(){
        return false;
    }
    
    public void setIcon(IconRenderer renderer){
        renderer.setIcon(null);
            //TODO: implement setIcon in view class Position
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
