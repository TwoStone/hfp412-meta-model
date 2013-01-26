package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class UnitTypeProxi extends AbsUnitTypeProxi implements UnitTypeView{
    
    public UnitTypeProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public UnitTypeView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String name = (String)resultTable.get("name");
        ViewProxi defaultUnit = null;
        String defaultUnit$String = (String)resultTable.get("defaultUnit");
        if (defaultUnit$String != null) {
            common.ProxiInformation defaultUnit$Info = common.RPCConstantsAndServices.createProxiInformation(defaultUnit$String);
            defaultUnit = ViewProxi.createProxi(defaultUnit$Info,connectionKey);
            defaultUnit.setToString(defaultUnit$Info.getToString());
        }
        UnitTypeView result$$ = new UnitType((String)name,(UnitView)defaultUnit, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index == 0 && this.getDefaultUnit() != null) return new DefaultUnitUnitTypeWrapper(this, originalIndex, (ViewRoot)this.getDefaultUnit());
        if(this.getDefaultUnit() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getDefaultUnit() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getDefaultUnit() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getDefaultUnit() != null && this.getDefaultUnit().equals(child)) return result;
        if(this.getDefaultUnit() != null) result = result + 1;
        return -1;
    }
    
    public UnitView getDefaultUnit() throws ModelException {
        return ((UnitType)this.getTheObject()).getDefaultUnit();
    }
    public void setDefaultUnit(UnitView newValue) throws ModelException {
        ((UnitType)this.getTheObject()).setDefaultUnit(newValue);
    }
    
    public void accept(AbsUnitTypeVisitor visitor) throws ModelException {
        visitor.handleUnitType(this);
    }
    public <R> R accept(AbsUnitTypeReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleUnitType(this);
    }
    public <E extends UserException>  void accept(AbsUnitTypeExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleUnitType(this);
    }
    public <R, E extends UserException> R accept(AbsUnitTypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleUnitType(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleUnitType(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleUnitType(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleUnitType(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleUnitType(this);
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
