
package view.objects;

import view.*;


/* Additional import section end */

public class Akteur extends ViewObject implements AkteurView{
    
    protected String name;
    protected java.util.Vector<RolleView> meineRollen;
    
    public Akteur(String name,java.util.Vector<RolleView> meineRollen,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.name = name;
        this.meineRollen = meineRollen;        
    }
    
    static public long getTypeId() {
        return 111;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public String getName() throws ModelException {
        return this.name;
    }
    public void setName(String newValue) throws ModelException {
        this.name = newValue;
    }
    public java.util.Vector<RolleView> getMeineRollen() throws ModelException {
        return this.meineRollen;
    }
    
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException {
        visitor.handleAkteur(this);
    }
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleAkteur(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleAkteur(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleAkteur(this);
    }
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        java.util.Vector<?> meineRollen = this.getMeineRollen();
        if (meineRollen != null) {
            ViewObject.resolveVectorProxies(meineRollen, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index < this.getMeineRollen().size()) return new MeineRollenAkteurWrapper(this, originalIndex, (ViewRoot)this.getMeineRollen().get(index));
        index = index - this.getMeineRollen().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getMeineRollen().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getMeineRollen().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getMeineRollenIterator = this.getMeineRollen().iterator();
        while(getMeineRollenIterator.hasNext()){
            if(getMeineRollenIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    public int getNameIndex() throws ModelException {
        return 0;
    }
    public int getRowCount(){
        return 0 
            + 1;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
                if(rowIndex == 0) return "name";
                rowIndex = rowIndex - 1;
            } else {
                if(rowIndex == 0) return this.getName();
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
            this.setName(newValue);
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
            //TODO: implement setIcon in view class Akteur
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
