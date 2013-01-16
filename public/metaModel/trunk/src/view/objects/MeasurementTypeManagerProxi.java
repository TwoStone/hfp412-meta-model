package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class MeasurementTypeManagerProxi extends ViewProxi implements MeasurementTypeManagerView{
    
    public MeasurementTypeManagerProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public MeasurementTypeManagerView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> measurementTypes_string = (java.util.Vector<String>)resultTable.get("measurementTypes");
        java.util.Vector<MMeasurementTypeView> measurementTypes = ViewProxi.getProxiVector(measurementTypes_string, connectionKey);
        MeasurementTypeManagerView result$$ = new MeasurementTypeManager(measurementTypes, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index < this.getMeasurementTypes().size()) return new MeasurementTypesMeasurementTypeManagerWrapper(this, originalIndex, (ViewRoot)this.getMeasurementTypes().get(index));
        index = index - this.getMeasurementTypes().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getMeasurementTypes().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getMeasurementTypes().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getMeasurementTypesIterator = this.getMeasurementTypes().iterator();
        while(getMeasurementTypesIterator.hasNext()){
            if(getMeasurementTypesIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<MMeasurementTypeView> getMeasurementTypes() throws ModelException {
        return ((MeasurementTypeManager)this.getTheObject()).getMeasurementTypes();
    }
    public void setMeasurementTypes(java.util.Vector<MMeasurementTypeView> newValue) throws ModelException {
        ((MeasurementTypeManager)this.getTheObject()).setMeasurementTypes(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleMeasurementTypeManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMeasurementTypeManager(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMeasurementTypeManager(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMeasurementTypeManager(this);
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
