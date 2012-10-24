package view.objects;

import view.*;
import viewClient.*;

public class QuantityProxi extends AbsQuantityProxi implements QuantityView{
    
    public QuantityProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public QuantityView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi amount = null;
        String amount$String = (String)resultTable.get("amount");
        if (amount$String != null) {
            common.ProxiInformation amount$Info = common.RPCConstantsAndServices.createProxiInformation(amount$String);
            amount = ViewProxi.createProxi(amount$Info,connectionKey);
            amount.setToString(amount$Info.getToString());
        }
        ViewProxi unit = null;
        String unit$String = (String)resultTable.get("unit");
        if (unit$String != null) {
            common.ProxiInformation unit$Info = common.RPCConstantsAndServices.createProxiInformation(unit$String);
            unit = ViewProxi.createProxi(unit$Info,connectionKey);
            unit.setToString(unit$Info.getToString());
        }
        QuantityView result$$ = new Quantity((FractionView)amount,(UnitView)unit, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index == 0 && this.getAmount() != null) return new AmountQuantityWrapper(this, originalIndex, (ViewRoot)this.getAmount());
        if(this.getAmount() != null) index = index - 1;
        if(index == 0 && this.getUnit() != null) return new UnitQuantityWrapper(this, originalIndex, (ViewRoot)this.getUnit());
        if(this.getUnit() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getAmount() == null ? 0 : 1)
            + (this.getUnit() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getAmount() == null ? true : false)
            && (this.getUnit() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getAmount() != null && this.getAmount().equals(child)) return result;
        if(this.getAmount() != null) result = result + 1;
        if(this.getUnit() != null && this.getUnit().equals(child)) return result;
        if(this.getUnit() != null) result = result + 1;
        return -1;
    }
    
    public FractionView getAmount() throws ModelException {
        return ((Quantity)this.getTheObject()).getAmount();
    }
    public void setAmount(FractionView newValue) throws ModelException {
        ((Quantity)this.getTheObject()).setAmount(newValue);
    }
    public UnitView getUnit() throws ModelException {
        return ((Quantity)this.getTheObject()).getUnit();
    }
    public void setUnit(UnitView newValue) throws ModelException {
        ((Quantity)this.getTheObject()).setUnit(newValue);
    }
    
    public void accept(view.visitor.AbsQuantityVisitor visitor) throws ModelException {
        visitor.handleQuantity(this);
    }
    public <R> R accept(view.visitor.AbsQuantityReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleQuantity(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AbsQuantityExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleQuantity(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AbsQuantityReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleQuantity(this);
    }
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException {
        visitor.handleQuantity(this);
    }
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleQuantity(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleQuantity(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleQuantity(this);
    }
    
    public boolean hasTransientFields(){
        return false;
    }
    
    public void setIcon(IconRenderer renderer){
        renderer.setIcon(null);
            //TODO: implement setIcon in view class Quantity
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
