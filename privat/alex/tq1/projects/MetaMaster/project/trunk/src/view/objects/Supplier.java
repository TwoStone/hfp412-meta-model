
package view.objects;

import view.*;


/* Additional import section end */

public class Supplier extends view.objects.Role implements SupplierView{
    
    protected java.util.Vector<ProductView> portfolio;
    
    public Supplier(ActorView owner,java.util.Vector<ProductView> portfolio,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super((ActorView)owner,id, classId);
        this.portfolio = portfolio;        
    }
    
    static public long getTypeId() {
        return 113;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<ProductView> getPortfolio() throws ModelException {
        return this.portfolio;
    }
    public void setPortfolio(java.util.Vector<ProductView> newValue) throws ModelException {
        this.portfolio = newValue;
    }
    
    public void accept(view.visitor.RoleVisitor visitor) throws ModelException {
        visitor.handleSupplier(this);
    }
    public <R> R accept(view.visitor.RoleReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleSupplier(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.RoleExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleSupplier(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.RoleReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleSupplier(this);
    }
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException {
        visitor.handleSupplier(this);
    }
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleSupplier(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleSupplier(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleSupplier(this);
    }
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        ActorView owner = this.getOwner();
        if (owner != null) {
            ((ViewProxi)owner).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(owner.getClassId(), owner.getId())));
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
        if(index < this.getPortfolio().size()) return new PortfolioSupplierWrapper(this, originalIndex, (ViewRoot)this.getPortfolio().get(index));
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
            //TODO: implement setIcon in view class Supplier
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
