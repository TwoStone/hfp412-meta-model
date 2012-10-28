
package view.objects;

import view.*;


/* Additional import section end */

public class ConversionRate extends ViewObject implements ConversionRateView{
    
    protected UnitView fromUnit;
    protected UnitView toUnit;
    protected FractionView conversionRate;
    
    public ConversionRate(UnitView fromUnit,UnitView toUnit,FractionView conversionRate,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.fromUnit = fromUnit;
        this.toUnit = toUnit;
        this.conversionRate = conversionRate;        
    }
    
    static public long getTypeId() {
        return 120;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public UnitView getFromUnit() throws ModelException {
        return this.fromUnit;
    }
    public void setFromUnit(UnitView newValue) throws ModelException {
        this.fromUnit = newValue;
    }
    public UnitView getToUnit() throws ModelException {
        return this.toUnit;
    }
    public void setToUnit(UnitView newValue) throws ModelException {
        this.toUnit = newValue;
    }
    public FractionView getConversionRate() throws ModelException {
        return this.conversionRate;
    }
    public void setConversionRate(FractionView newValue) throws ModelException {
        this.conversionRate = newValue;
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
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        UnitView fromUnit = this.getFromUnit();
        if (fromUnit != null) {
            ((ViewProxi)fromUnit).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(fromUnit.getClassId(), fromUnit.getId())));
        }
        UnitView toUnit = this.getToUnit();
        if (toUnit != null) {
            ((ViewProxi)toUnit).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(toUnit.getClassId(), toUnit.getId())));
        }
        FractionView conversionRate = this.getConversionRate();
        if (conversionRate != null) {
            ((ViewProxi)conversionRate).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(conversionRate.getClassId(), conversionRate.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
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
        renderer.setIcon(null);
            //TODO: implement setIcon in view class ConversionRate
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
