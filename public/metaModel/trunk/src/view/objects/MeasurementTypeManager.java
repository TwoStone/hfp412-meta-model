
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class MeasurementTypeManager extends ViewObject implements MeasurementTypeManagerView{
    
    protected java.util.Vector<MMeasurementTypeView> measurementTypes;
    
    public MeasurementTypeManager(java.util.Vector<MMeasurementTypeView> measurementTypes,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.measurementTypes = measurementTypes;        
    }
    
    static public long getTypeId() {
        return 186;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<MMeasurementTypeView> getMeasurementTypes() throws ModelException {
        return this.measurementTypes;
    }
    public void setMeasurementTypes(java.util.Vector<MMeasurementTypeView> newValue) throws ModelException {
        this.measurementTypes = newValue;
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
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        java.util.Vector<?> measurementTypes = this.getMeasurementTypes();
        if (measurementTypes != null) {
            ViewObject.resolveVectorProxies(measurementTypes, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
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
    public int getRowCount(){
        return 0 ;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
            } else {
            }
            throw new ModelException("Table index out of bounds!", -1);
        } catch (ModelException e){
            return e.getMessage();
        }
    }
    
    public boolean isRowEditable(int index){
        return true;
    }
    public void setValueAt(String newValue, int rowIndex) throws Exception {
        
    }
    public boolean hasTransientFields(){
        return false;
    }
    /* Start of protected part that is not overridden by persistence generator */
    
    public void setIcon(IconRenderer renderer) {
        super.setIcon(renderer);
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
