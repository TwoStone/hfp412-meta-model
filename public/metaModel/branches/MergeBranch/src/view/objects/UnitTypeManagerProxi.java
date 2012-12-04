package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class UnitTypeManagerProxi extends ViewProxi implements UnitTypeManagerView{
    
    public UnitTypeManagerProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public UnitTypeManagerView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> unitTypes_string = (java.util.Vector<String>)resultTable.get("unitTypes");
        java.util.Vector<AbsUnitTypeView> unitTypes = ViewProxi.getProxiVector(unitTypes_string, connectionKey);
        java.util.Vector<String> units_string = (java.util.Vector<String>)resultTable.get("units");
        java.util.Vector<AbsUnitView> units = ViewProxi.getProxiVector(units_string, connectionKey);
        UnitTypeManagerView result$$ = new UnitTypeManager(unitTypes,units, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index < this.getUnitTypes().size()) return new UnitTypesUnitTypeManagerWrapper(this, originalIndex, (ViewRoot)this.getUnitTypes().get(index));
        index = index - this.getUnitTypes().size();
        if(index < this.getUnits().size()) return new UnitsUnitTypeManagerWrapper(this, originalIndex, (ViewRoot)this.getUnits().get(index));
        index = index - this.getUnits().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getUnitTypes().size())
            + (this.getUnits().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getUnitTypes().size() == 0)
            && (this.getUnits().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getUnitTypesIterator = this.getUnitTypes().iterator();
        while(getUnitTypesIterator.hasNext()){
            if(getUnitTypesIterator.next().equals(child)) return result;
            result = result + 1;
        }
        java.util.Iterator<?> getUnitsIterator = this.getUnits().iterator();
        while(getUnitsIterator.hasNext()){
            if(getUnitsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<AbsUnitTypeView> getUnitTypes() throws ModelException {
        return ((UnitTypeManager)this.getTheObject()).getUnitTypes();
    }
    public void setUnitTypes(java.util.Vector<AbsUnitTypeView> newValue) throws ModelException {
        ((UnitTypeManager)this.getTheObject()).setUnitTypes(newValue);
    }
    public java.util.Vector<AbsUnitView> getUnits() throws ModelException {
        return ((UnitTypeManager)this.getTheObject()).getUnits();
    }
    public void setUnits(java.util.Vector<AbsUnitView> newValue) throws ModelException {
        ((UnitTypeManager)this.getTheObject()).setUnits(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleUnitTypeManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleUnitTypeManager(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleUnitTypeManager(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleUnitTypeManager(this);
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
