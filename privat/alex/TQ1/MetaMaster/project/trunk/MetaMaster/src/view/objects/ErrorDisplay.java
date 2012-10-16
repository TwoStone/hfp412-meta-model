
package view.objects;

import view.*;


/* Additional import section end */

public class ErrorDisplay extends ViewObject implements ErrorDisplayView{
    
    protected String message;
    
    public ErrorDisplay(String message,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.message = message;        
    }
    
    static public long getTypeId() {
        return -109;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public String getMessage() throws ModelException {
        return this.message;
    }
    public void setMessage(String newValue) throws ModelException {
        this.message = newValue;
    }
    
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException {
        visitor.handleErrorDisplay(this);
    }
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleErrorDisplay(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleErrorDisplay(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleErrorDisplay(this);
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
    public int getMessageIndex() throws ModelException {
        return 0;
    }
    public int getRowCount(){
        return 0 
            + 1;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
                if(rowIndex == 0) return "message";
                rowIndex = rowIndex - 1;
            } else {
                if(rowIndex == 0) return this.getMessage();
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
            this.setMessage(newValue);
            return;
        }
        rowIndex = rowIndex - 1;
    }
    public boolean hasTransientFields(){
        return true;
    }
    /* Start of protected part that is not overridden by persistence generator */
    
    public void setIcon(IconRenderer renderer) {
        renderer.setIcon(null);
            //TODO: implement setIcon in view class ErrorDisplay
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
