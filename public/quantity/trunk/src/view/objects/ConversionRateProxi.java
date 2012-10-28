package view.objects;

import view.*;
import viewClient.*;

public class ConversionRateProxi extends ViewProxi implements ConversionRateView{
    
    public ConversionRateProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public ConversionRateView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi fromUnit = null;
        String fromUnit$String = (String)resultTable.get("fromUnit");
        if (fromUnit$String != null) {
            common.ProxiInformation fromUnit$Info = common.RPCConstantsAndServices.createProxiInformation(fromUnit$String);
            fromUnit = ViewProxi.createProxi(fromUnit$Info,connectionKey);
            fromUnit.setToString(fromUnit$Info.getToString());
        }
        ViewProxi toUnit = null;
        String toUnit$String = (String)resultTable.get("toUnit");
        if (toUnit$String != null) {
            common.ProxiInformation toUnit$Info = common.RPCConstantsAndServices.createProxiInformation(toUnit$String);
            toUnit = ViewProxi.createProxi(toUnit$Info,connectionKey);
            toUnit.setToString(toUnit$Info.getToString());
        }
        ViewProxi conversionRate = null;
        String conversionRate$String = (String)resultTable.get("conversionRate");
        if (conversionRate$String != null) {
            common.ProxiInformation conversionRate$Info = common.RPCConstantsAndServices.createProxiInformation(conversionRate$String);
            conversionRate = ViewProxi.createProxi(conversionRate$Info,connectionKey);
            conversionRate.setToString(conversionRate$Info.getToString());
        }
        ConversionRateView result$$ = new ConversionRate((UnitView)fromUnit,(UnitView)toUnit,(FractionView)conversionRate, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index == 0 && this.getFromUnit() != null) return new FromUnitConversionRateWrapper(this, originalIndex, (ViewRoot)this.getFromUnit());
        if(this.getFromUnit() != null) index = index - 1;
        if(index == 0 && this.getToUnit() != null) return new ToUnitConversionRateWrapper(this, originalIndex, (ViewRoot)this.getToUnit());
        if(this.getToUnit() != null) index = index - 1;
        if(index == 0 && this.getConversionRate() != null) return new ConversionRateConversionRateWrapper(this, originalIndex, (ViewRoot)this.getConversionRate());
        if(this.getConversionRate() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getFromUnit() == null ? 0 : 1)
            + (this.getToUnit() == null ? 0 : 1)
            + (this.getConversionRate() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getFromUnit() == null ? true : false)
            && (this.getToUnit() == null ? true : false)
            && (this.getConversionRate() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getFromUnit() != null && this.getFromUnit().equals(child)) return result;
        if(this.getFromUnit() != null) result = result + 1;
        if(this.getToUnit() != null && this.getToUnit().equals(child)) return result;
        if(this.getToUnit() != null) result = result + 1;
        if(this.getConversionRate() != null && this.getConversionRate().equals(child)) return result;
        if(this.getConversionRate() != null) result = result + 1;
        return -1;
    }
    
    public UnitView getFromUnit() throws ModelException {
        return ((ConversionRate)this.getTheObject()).getFromUnit();
    }
    public void setFromUnit(UnitView newValue) throws ModelException {
        ((ConversionRate)this.getTheObject()).setFromUnit(newValue);
    }
    public UnitView getToUnit() throws ModelException {
        return ((ConversionRate)this.getTheObject()).getToUnit();
    }
    public void setToUnit(UnitView newValue) throws ModelException {
        ((ConversionRate)this.getTheObject()).setToUnit(newValue);
    }
    public FractionView getConversionRate() throws ModelException {
        return ((ConversionRate)this.getTheObject()).getConversionRate();
    }
    public void setConversionRate(FractionView newValue) throws ModelException {
        ((ConversionRate)this.getTheObject()).setConversionRate(newValue);
    }
    
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException {
        visitor.handleConversionRate(this);
    }
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleConversionRate(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleConversionRate(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleConversionRate(this);
    }
    
    public boolean hasTransientFields(){
        return false;
    }
    
    public void setIcon(IconRenderer renderer){
        renderer.setIcon(null);
            //TODO: implement setIcon in view class ConversionRate
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
