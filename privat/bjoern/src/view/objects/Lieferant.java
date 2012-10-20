
package view.objects;

import view.*;


/* Additional import section end */

public class Lieferant extends view.objects.Rolle implements LieferantView{
    
    protected java.util.Vector<ProduktView> portfolio;
    
    public Lieferant(AkteurView rolleFuer,java.util.Vector<ProduktView> portfolio,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super((AkteurView)rolleFuer,id, classId);
        this.portfolio = portfolio;        
    }
    
    static public long getTypeId() {
        return 121;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<ProduktView> getPortfolio() throws ModelException {
        return this.portfolio;
    }
    public void setPortfolio(java.util.Vector<ProduktView> newValue) throws ModelException {
        this.portfolio = newValue;
    }
    
    public void accept(view.visitor.RolleVisitor visitor) throws ModelException {
        visitor.handleLieferant(this);
    }
    public <R> R accept(view.visitor.RolleReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleLieferant(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.RolleExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleLieferant(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.RolleReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleLieferant(this);
    }
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException {
        visitor.handleLieferant(this);
    }
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleLieferant(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleLieferant(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleLieferant(this);
    }
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        AkteurView rolleFuer = this.getRolleFuer();
        if (rolleFuer != null) {
            ((ViewProxi)rolleFuer).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(rolleFuer.getClassId(), rolleFuer.getId())));
        }
        java.util.Vector<?> portfolio = this.getPortfolio();
        if (portfolio != null) {
            ViewObject.resolveVectorProxies(portfolio, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index < this.getPortfolio().size()) return new PortfolioLieferantWrapper(this, originalIndex, (ViewRoot)this.getPortfolio().get(index));
        index = index - this.getPortfolio().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getPortfolio().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getPortfolio().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getPortfolioIterator = this.getPortfolio().iterator();
        while(getPortfolioIterator.hasNext()){
            if(getPortfolioIterator.next().equals(child)) return result;
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
            //TODO: implement setIcon in view class Lieferant
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
