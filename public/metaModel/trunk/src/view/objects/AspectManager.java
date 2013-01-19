
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class AspectManager extends ViewObject implements AspectManagerView{
    
    protected java.util.Vector<MAspectView> aspects;
    
    public AspectManager(java.util.Vector<MAspectView> aspects,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.aspects = aspects;        
    }
    
    static public long getTypeId() {
        return 136;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<MAspectView> getAspects() throws ModelException {
        return this.aspects;
    }
    public void setAspects(java.util.Vector<MAspectView> newValue) throws ModelException {
        this.aspects = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleAspectManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleAspectManager(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleAspectManager(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleAspectManager(this);
    }
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        java.util.Vector<?> aspects = this.getAspects();
        if (aspects != null) {
            ViewObject.resolveVectorProxies(aspects, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index < this.getAspects().size()) return new AspectsAspectManagerWrapper(this, originalIndex, (ViewRoot)this.getAspects().get(index));
        index = index - this.getAspects().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getAspects().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getAspects().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getAspectsIterator = this.getAspects().iterator();
        while(getAspectsIterator.hasNext()){
            if(getAspectsIterator.next().equals(child)) return result;
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
