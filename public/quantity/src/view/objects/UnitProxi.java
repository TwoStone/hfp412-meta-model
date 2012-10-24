package view.objects;

import view.*;
import viewClient.*;

public class UnitProxi extends AbsUnitProxi implements UnitView{
    
    public UnitProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public UnitView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String name = (String)resultTable.get("name");
        ViewProxi unitType = null;
        String unitType$String = (String)resultTable.get("unitType");
        if (unitType$String != null) {
            common.ProxiInformation unitType$Info = common.RPCConstantsAndServices.createProxiInformation(unitType$String);
            unitType = ViewProxi.createProxi(unitType$Info,connectionKey);
            unitType.setToString(unitType$Info.getToString());
        }
        UnitView result$$ = new Unit((String)name,(UnitTypeView)unitType, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index == 0 && this.getUnitType() != null) return new UnitTypeUnitWrapper(this, originalIndex, (ViewRoot)this.getUnitType());
        if(this.getUnitType() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getUnitType() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getUnitType() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getUnitType() != null && this.getUnitType().equals(child)) return result;
        if(this.getUnitType() != null) result = result + 1;
        return -1;
    }
    
    public UnitTypeView getUnitType() throws ModelException {
        return ((Unit)this.getTheObject()).getUnitType();
    }
    public void setUnitType(UnitTypeView newValue) throws ModelException {
        ((Unit)this.getTheObject()).setUnitType(newValue);
    }
    
    public void accept(view.visitor.AbsUnitVisitor visitor) throws ModelException {
        visitor.handleUnit(this);
    }
    public <R> R accept(view.visitor.AbsUnitReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleUnit(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AbsUnitExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleUnit(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AbsUnitReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleUnit(this);
    }
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException {
        visitor.handleUnit(this);
    }
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleUnit(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleUnit(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleUnit(this);
    }
    
    public boolean hasTransientFields(){
        return false;
    }
    
    public void setIcon(IconRenderer renderer){
        renderer.setIcon(null);
            //TODO: implement setIcon in view class Unit
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
