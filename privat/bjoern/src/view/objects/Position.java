
package view.objects;

import view.*;


/* Additional import section end */

public class Position extends ViewObject implements PositionView{
    
    protected ProduktView beziehtSichAuf;
    
    public Position(ProduktView beziehtSichAuf,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.beziehtSichAuf = beziehtSichAuf;        
    }
    
    static public long getTypeId() {
        return 123;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public ProduktView getBeziehtSichAuf() throws ModelException {
        return this.beziehtSichAuf;
    }
    public void setBeziehtSichAuf(ProduktView newValue) throws ModelException {
        this.beziehtSichAuf = newValue;
    }
    
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException {
        visitor.handlePosition(this);
    }
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handlePosition(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handlePosition(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handlePosition(this);
    }
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        ProduktView beziehtSichAuf = this.getBeziehtSichAuf();
        if (beziehtSichAuf != null) {
            ((ViewProxi)beziehtSichAuf).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(beziehtSichAuf.getClassId(), beziehtSichAuf.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index == 0 && this.getBeziehtSichAuf() != null) return new BeziehtSichAufPositionWrapper(this, originalIndex, (ViewRoot)this.getBeziehtSichAuf());
        if(this.getBeziehtSichAuf() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getBeziehtSichAuf() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getBeziehtSichAuf() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getBeziehtSichAuf() != null && this.getBeziehtSichAuf().equals(child)) return result;
        if(this.getBeziehtSichAuf() != null) result = result + 1;
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
            //TODO: implement setIcon in view class Position
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
