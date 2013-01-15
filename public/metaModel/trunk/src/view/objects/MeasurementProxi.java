package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class MeasurementProxi extends ViewProxi implements MeasurementView{
    
    public MeasurementProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public MeasurementView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi type = null;
        String type$String = (String)resultTable.get("type");
        if (type$String != null) {
            common.ProxiInformation type$Info = common.RPCConstantsAndServices.createProxiInformation(type$String);
            type = ViewProxi.createProxi(type$Info,connectionKey);
            type.setToString(type$Info.getToString());
        }
        ViewProxi quantity = null;
        String quantity$String = (String)resultTable.get("quantity");
        if (quantity$String != null) {
            common.ProxiInformation quantity$Info = common.RPCConstantsAndServices.createProxiInformation(quantity$String);
            quantity = ViewProxi.createProxi(quantity$Info,connectionKey);
            quantity.setToString(quantity$Info.getToString());
        }
        MeasurementView result$$ = new Measurement((MMeasurementTypeView)type,(AbsQuantityView)quantity, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index == 0 && this.getType() != null) return new TypeMeasurementWrapper(this, originalIndex, (ViewRoot)this.getType());
        if(this.getType() != null) index = index - 1;
        if(index == 0 && this.getQuantity() != null) return new QuantityMeasurementWrapper(this, originalIndex, (ViewRoot)this.getQuantity());
        if(this.getQuantity() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getType() == null ? 0 : 1)
            + (this.getQuantity() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getType() == null ? true : false)
            && (this.getQuantity() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getType() != null && this.getType().equals(child)) return result;
        if(this.getType() != null) result = result + 1;
        if(this.getQuantity() != null && this.getQuantity().equals(child)) return result;
        if(this.getQuantity() != null) result = result + 1;
        return -1;
    }
    
    public MMeasurementTypeView getType() throws ModelException {
        return ((Measurement)this.getTheObject()).getType();
    }
    public void setType(MMeasurementTypeView newValue) throws ModelException {
        ((Measurement)this.getTheObject()).setType(newValue);
    }
    public AbsQuantityView getQuantity() throws ModelException {
        return ((Measurement)this.getTheObject()).getQuantity();
    }
    public void setQuantity(AbsQuantityView newValue) throws ModelException {
        ((Measurement)this.getTheObject()).setQuantity(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleMeasurement(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMeasurement(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMeasurement(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMeasurement(this);
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
