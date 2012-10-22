package view.objects;

import view.*;
import viewClient.*;

public class PositionProxi extends ViewProxi implements PositionView{
    
    public PositionProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public PositionView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi beziehtSichAuf = null;
        String beziehtSichAuf$String = (String)resultTable.get("beziehtSichAuf");
        if (beziehtSichAuf$String != null) {
            common.ProxiInformation beziehtSichAuf$Info = common.RPCConstantsAndServices.createProxiInformation(beziehtSichAuf$String);
            beziehtSichAuf = ViewProxi.createProxi(beziehtSichAuf$Info,connectionKey);
            beziehtSichAuf.setToString(beziehtSichAuf$Info.getToString());
        }
        PositionView result$$ = new Position((ProduktView)beziehtSichAuf, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index == 0 && this.getBeziehtSichAuf() != null) return new BeziehtSichAufPositionWrapper(this, originalIndex, (ViewRoot)this.getBeziehtSichAuf());
        if(this.getBeziehtSichAuf() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getBeziehtSichAuf() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getBeziehtSichAuf() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getBeziehtSichAuf() != null && this.getBeziehtSichAuf().equals(child)) return result;
        if(this.getBeziehtSichAuf() != null) result = result + 1;
        return -1;
    }
    
    public ProduktView getBeziehtSichAuf() throws ModelException {
        return ((Position)this.getTheObject()).getBeziehtSichAuf();
    }
    public void setBeziehtSichAuf(ProduktView newValue) throws ModelException {
        ((Position)this.getTheObject()).setBeziehtSichAuf(newValue);
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
