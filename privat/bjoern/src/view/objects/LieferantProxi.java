package view.objects;

import view.*;
import viewClient.*;

public class LieferantProxi extends RolleProxi implements LieferantView{
    
    public LieferantProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public LieferantView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi rolleFuer = null;
        String rolleFuer$String = (String)resultTable.get("rolleFuer");
        if (rolleFuer$String != null) {
            common.ProxiInformation rolleFuer$Info = common.RPCConstantsAndServices.createProxiInformation(rolleFuer$String);
            rolleFuer = ViewProxi.createProxi(rolleFuer$Info,connectionKey);
            rolleFuer.setToString(rolleFuer$Info.getToString());
        }
        java.util.Vector<String> portfolio_string = (java.util.Vector<String>)resultTable.get("portfolio");
        java.util.Vector<ProduktView> portfolio = ViewProxi.getProxiVector(portfolio_string, connectionKey);
        LieferantView result$$ = new Lieferant((AkteurView)rolleFuer,portfolio, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
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
    
    public java.util.Vector<ProduktView> getPortfolio() throws ModelException {
        return ((Lieferant)this.getTheObject()).getPortfolio();
    }
    public void setPortfolio(java.util.Vector<ProduktView> newValue) throws ModelException {
        ((Lieferant)this.getTheObject()).setPortfolio(newValue);
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
    
    public boolean hasTransientFields(){
        return false;
    }
    
    public void setIcon(IconRenderer renderer){
        renderer.setIcon(null);
            //TODO: implement setIcon in view class Lieferant
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
