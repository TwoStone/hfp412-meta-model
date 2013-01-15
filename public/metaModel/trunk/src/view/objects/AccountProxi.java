package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class AccountProxi extends ViewProxi implements AccountView{
    
    public AccountProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public AccountView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi type = null;
        String type$String = (String)resultTable.get("type");
        if (type$String != null) {
            common.ProxiInformation type$Info = common.RPCConstantsAndServices.createProxiInformation(type$String);
            type = ViewProxi.createProxi(type$Info,connectionKey);
            type.setToString(type$Info.getToString());
        }
        java.util.Vector<String> subAccounts_string = (java.util.Vector<String>)resultTable.get("subAccounts");
        java.util.Vector<AccountView> subAccounts = ViewProxi.getProxiVector(subAccounts_string, connectionKey);
        AccountView result$$ = new Account((MAccountTypeView)type,subAccounts, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index == 0 && this.getType() != null) return new TypeAccountWrapper(this, originalIndex, (ViewRoot)this.getType());
        if(this.getType() != null) index = index - 1;
        if(index < this.getSubAccounts().size()) return new SubAccountsAccountWrapper(this, originalIndex, (ViewRoot)this.getSubAccounts().get(index));
        index = index - this.getSubAccounts().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getType() == null ? 0 : 1)
            + (this.getSubAccounts().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getType() == null ? true : false)
            && (this.getSubAccounts().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getType() != null && this.getType().equals(child)) return result;
        if(this.getType() != null) result = result + 1;
        java.util.Iterator<?> getSubAccountsIterator = this.getSubAccounts().iterator();
        while(getSubAccountsIterator.hasNext()){
            if(getSubAccountsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public MAccountTypeView getType() throws ModelException {
        return ((Account)this.getTheObject()).getType();
    }
    public void setType(MAccountTypeView newValue) throws ModelException {
        ((Account)this.getTheObject()).setType(newValue);
    }
    public java.util.Vector<AccountView> getSubAccounts() throws ModelException {
        return ((Account)this.getTheObject()).getSubAccounts();
    }
    public void setSubAccounts(java.util.Vector<AccountView> newValue) throws ModelException {
        ((Account)this.getTheObject()).setSubAccounts(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleAccount(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleAccount(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleAccount(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleAccount(this);
    }
    
    public boolean hasTransientFields(){
        return false;
    }
    
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
