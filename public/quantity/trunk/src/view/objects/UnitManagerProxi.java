package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class UnitManagerProxi extends ViewProxi implements UnitManagerView{
    
    public UnitManagerProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public UnitManagerView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> units_string = (java.util.Vector<String>)resultTable.get("units");
        java.util.Vector<AbsUnitView> units = ViewProxi.getProxiVector(units_string, connectionKey);
        UnitManagerView result$$ = new UnitManager(units, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index < this.getUnits().size()) return new UnitsUnitManagerWrapper(this, originalIndex, (ViewRoot)this.getUnits().get(index));
        index = index - this.getUnits().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getUnits().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getUnits().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getUnitsIterator = this.getUnits().iterator();
        while(getUnitsIterator.hasNext()){
            if(getUnitsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<AbsUnitView> getUnits() throws ModelException {
        return ((UnitManager)this.getTheObject()).getUnits();
    }
    public void setUnits(java.util.Vector<AbsUnitView> newValue) throws ModelException {
        ((UnitManager)this.getTheObject()).setUnits(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleUnitManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleUnitManager(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleUnitManager(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleUnitManager(this);
    }
    
    public boolean hasTransientFields(){
        return false;
    }
    
    public void setIcon(IconRenderer renderer){
        renderer.setIcon(null);
            //TODO: implement setIcon in view class UnitManager
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
