package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class QuantityProxi extends AbsQuantityProxi implements QuantityView{
    
    public QuantityProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public QuantityView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        common.Fraction amount = common.Fraction.parse((String)resultTable.get("amount"));
        ViewProxi unit = null;
        String unit$String = (String)resultTable.get("unit");
        if (unit$String != null) {
            common.ProxiInformation unit$Info = common.RPCConstantsAndServices.createProxiInformation(unit$String);
            unit = ViewProxi.createProxi(unit$Info,connectionKey);
            unit.setToString(unit$Info.getToString());
        }
        QuantityView result$$ = new Quantity((common.Fraction)amount,(UnitView)unit, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index == 0 && this.getUnit() != null) return new UnitQuantityWrapper(this, originalIndex, (ViewRoot)this.getUnit());
        if(this.getUnit() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getUnit() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getUnit() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getUnit() != null && this.getUnit().equals(child)) return result;
        if(this.getUnit() != null) result = result + 1;
        return -1;
    }
    
    public common.Fraction getAmount() throws ModelException {
        return ((Quantity)this.getTheObject()).getAmount();
    }
    public void setAmount(common.Fraction newValue) throws ModelException {
        ((Quantity)this.getTheObject()).setAmount(newValue);
    }
    public UnitView getUnit() throws ModelException {
        return ((Quantity)this.getTheObject()).getUnit();
    }
    public void setUnit(UnitView newValue) throws ModelException {
        ((Quantity)this.getTheObject()).setUnit(newValue);
    }
    
    public void accept(AbsQuantityVisitor visitor) throws ModelException {
        visitor.handleQuantity(this);
    }
    public <R> R accept(AbsQuantityReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleQuantity(this);
    }
    public <E extends UserException>  void accept(AbsQuantityExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleQuantity(this);
    }
    public <R, E extends UserException> R accept(AbsQuantityReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleQuantity(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleQuantity(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleQuantity(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleQuantity(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleQuantity(this);
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
