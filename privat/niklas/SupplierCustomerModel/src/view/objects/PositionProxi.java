package view.objects;

import view.*;
import viewClient.*;

public class PositionProxi extends ViewProxi implements PositionView{
    
    public PositionProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public PositionView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi product = null;
        String product$String = (String)resultTable.get("product");
        if (product$String != null) {
            common.ProxiInformation product$Info = common.RPCConstantsAndServices.createProxiInformation(product$String);
            product = ViewProxi.createProxi(product$Info,connectionKey);
            product.setToString(product$Info.getToString());
        }
        long quantity = new Long((String)resultTable.get("quantity")).longValue();
        PositionView result$$ = new Position((ProductView)product,(long)quantity, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index == 0 && this.getProduct() != null) return new ProductPositionWrapper(this, originalIndex, (ViewRoot)this.getProduct());
        if(this.getProduct() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getProduct() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getProduct() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getProduct() != null && this.getProduct().equals(child)) return result;
        if(this.getProduct() != null) result = result + 1;
        return -1;
    }
    
    public ProductView getProduct() throws ModelException {
        return ((Position)this.getTheObject()).getProduct();
    }
    public void setProduct(ProductView newValue) throws ModelException {
        ((Position)this.getTheObject()).setProduct(newValue);
    }
    public long getQuantity() throws ModelException {
        return ((Position)this.getTheObject()).getQuantity();
    }
    public void setQuantity(long newValue) throws ModelException {
        ((Position)this.getTheObject()).setQuantity(newValue);
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
