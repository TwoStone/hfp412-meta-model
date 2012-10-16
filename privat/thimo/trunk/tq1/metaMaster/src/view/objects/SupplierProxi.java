package view.objects;

import view.*;
import viewClient.*;

public class SupplierProxi extends RoleProxi implements SupplierView{
    
    public SupplierProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public SupplierView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi roleFor = null;
        String roleFor$String = (String)resultTable.get("roleFor");
        if (roleFor$String != null) {
            common.ProxiInformation roleFor$Info = common.RPCConstantsAndServices.createProxiInformation(roleFor$String);
            roleFor = ViewProxi.createProxi(roleFor$Info,connectionKey);
            roleFor.setToString(roleFor$Info.getToString());
        }
        java.util.Vector<String> portfolio_string = (java.util.Vector<String>)resultTable.get("portfolio");
        java.util.Vector<ProductView> portfolio = ViewProxi.getProxiVector(portfolio_string, connectionKey);
        SupplierView result$$ = new Supplier((ActorView)roleFor,portfolio, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
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
        if (this.object == null) return this.getLeafInfo() == 0;
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
    
    public java.util.Vector<ProductView> getPortfolio() throws ModelException {
        return ((Supplier)this.getTheObject()).getPortfolio();
    }
    public void setPortfolio(java.util.Vector<ProductView> newValue) throws ModelException {
        ((Supplier)this.getTheObject()).setPortfolio(newValue);
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
    
    public boolean hasTransientFields(){
        return false;
    }
    
    public void setIcon(IconRenderer renderer){
        renderer.setIcon(null);
            //TODO: implement setIcon in view class Supplier
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
