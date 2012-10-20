
package view.objects;

import view.*;


/* Additional import section end */

public class Auftrag extends ViewObject implements AuftragView{
    
    protected KundeView auftraggeber;
    protected LieferantView auftragnehmer;
    protected java.util.Vector<PositionView> positionen;
    
    public Auftrag(KundeView auftraggeber,LieferantView auftragnehmer,java.util.Vector<PositionView> positionen,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.auftraggeber = auftraggeber;
        this.auftragnehmer = auftragnehmer;
        this.positionen = positionen;        
    }
    
    static public long getTypeId() {
        return 124;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public KundeView getAuftraggeber() throws ModelException {
        return this.auftraggeber;
    }
    public void setAuftraggeber(KundeView newValue) throws ModelException {
        this.auftraggeber = newValue;
    }
    public LieferantView getAuftragnehmer() throws ModelException {
        return this.auftragnehmer;
    }
    public void setAuftragnehmer(LieferantView newValue) throws ModelException {
        this.auftragnehmer = newValue;
    }
    public java.util.Vector<PositionView> getPositionen() throws ModelException {
        return this.positionen;
    }
    public void setPositionen(java.util.Vector<PositionView> newValue) throws ModelException {
        this.positionen = newValue;
    }
    
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException {
        visitor.handleAuftrag(this);
    }
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleAuftrag(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleAuftrag(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleAuftrag(this);
    }
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        KundeView auftraggeber = this.getAuftraggeber();
        if (auftraggeber != null) {
            ((ViewProxi)auftraggeber).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(auftraggeber.getClassId(), auftraggeber.getId())));
        }
        LieferantView auftragnehmer = this.getAuftragnehmer();
        if (auftragnehmer != null) {
            ((ViewProxi)auftragnehmer).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(auftragnehmer.getClassId(), auftragnehmer.getId())));
        }
        java.util.Vector<?> positionen = this.getPositionen();
        if (positionen != null) {
            ViewObject.resolveVectorProxies(positionen, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index == 0 && this.getAuftraggeber() != null) return new AuftraggeberAuftragWrapper(this, originalIndex, (ViewRoot)this.getAuftraggeber());
        if(this.getAuftraggeber() != null) index = index - 1;
        if(index == 0 && this.getAuftragnehmer() != null) return new AuftragnehmerAuftragWrapper(this, originalIndex, (ViewRoot)this.getAuftragnehmer());
        if(this.getAuftragnehmer() != null) index = index - 1;
        if(index < this.getPositionen().size()) return new PositionenAuftragWrapper(this, originalIndex, (ViewRoot)this.getPositionen().get(index));
        index = index - this.getPositionen().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getAuftraggeber() == null ? 0 : 1)
            + (this.getAuftragnehmer() == null ? 0 : 1)
            + (this.getPositionen().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getAuftraggeber() == null ? true : false)
            && (this.getAuftragnehmer() == null ? true : false)
            && (this.getPositionen().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getAuftraggeber() != null && this.getAuftraggeber().equals(child)) return result;
        if(this.getAuftraggeber() != null) result = result + 1;
        if(this.getAuftragnehmer() != null && this.getAuftragnehmer().equals(child)) return result;
        if(this.getAuftragnehmer() != null) result = result + 1;
        java.util.Iterator<?> getPositionenIterator = this.getPositionen().iterator();
        while(getPositionenIterator.hasNext()){
            if(getPositionenIterator.next().equals(child)) return result;
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
        renderer.setIcon(null);
            //TODO: implement setIcon in view class Auftrag
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
