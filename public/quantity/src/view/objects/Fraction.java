
package view.objects;

import view.*;


/* Additional import section end */

public class Fraction extends ViewObject implements FractionView{
    
    protected long enumerator;
    protected long denominator;
    
    public Fraction(long enumerator,long denominator,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.enumerator = enumerator;
        this.denominator = denominator;        
    }
    
    static public long getTypeId() {
        return 111;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public long getEnumerator() throws ModelException {
        return this.enumerator;
    }
    public void setEnumerator(long newValue) throws ModelException {
        this.enumerator = newValue;
    }
    public long getDenominator() throws ModelException {
        return this.denominator;
    }
    public void setDenominator(long newValue) throws ModelException {
        this.denominator = newValue;
    }
    
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException {
        visitor.handleFraction(this);
    }
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleFraction(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleFraction(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleFraction(this);
    }
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 ;
    }
    public boolean isLeaf() throws ModelException {
        return true;
    }
    public int getIndexOfChild(Object child) throws ModelException {
        
        return -1;
    }
    public int getEnumeratorIndex() throws ModelException {
        return 0;
    }
    public int getDenominatorIndex() throws ModelException {
        return 0 + 1;
    }
    public int getRowCount(){
        return 0 
            + 1
            + 1;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
                if(rowIndex == 0) return "enumerator";
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return "denominator";
                rowIndex = rowIndex - 1;
            } else {
                if(rowIndex == 0) return new Long(getEnumerator());
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return new Long(getDenominator());
                rowIndex = rowIndex - 1;
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
        if(rowIndex == 0){
            this.setEnumerator(Long.parseLong(newValue));
            return;
        }
        rowIndex = rowIndex - 1;
        if(rowIndex == 0){
            this.setDenominator(Long.parseLong(newValue));
            return;
        }
        rowIndex = rowIndex - 1;
    }
    public boolean hasTransientFields(){
        return false;
    }
    /* Start of protected part that is not overridden by persistence generator */
    
    public void setIcon(IconRenderer renderer) {
        renderer.setIcon(null);
            //TODO: implement setIcon in view class Fraction
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
