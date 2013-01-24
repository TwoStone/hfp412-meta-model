
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class ConversionManager extends ViewObject implements ConversionManagerView{
    
    protected java.util.Vector<ConversionView> conversions;
    
    public ConversionManager(java.util.Vector<ConversionView> conversions,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.conversions = conversions;        
    }
    
    static public long getTypeId() {
        return 147;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<ConversionView> getConversions() throws ModelException {
        return this.conversions;
    }
    public void setConversions(java.util.Vector<ConversionView> newValue) throws ModelException {
        this.conversions = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleConversionManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleConversionManager(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleConversionManager(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleConversionManager(this);
    }
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        java.util.Vector<?> conversions = this.getConversions();
        if (conversions != null) {
            ViewObject.resolveVectorProxies(conversions, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index < this.getConversions().size()) return new ConversionsConversionManagerWrapper(this, originalIndex, (ViewRoot)this.getConversions().get(index));
        index = index - this.getConversions().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getConversions().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getConversions().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getConversionsIterator = this.getConversions().iterator();
        while(getConversionsIterator.hasNext()){
            if(getConversionsIterator.next().equals(child)) return result;
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
