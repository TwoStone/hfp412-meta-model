package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class AccountProxi extends QuantifObjectProxi implements AccountView{
    
    public AccountProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public AccountView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi object = null;
        String object$String = (String)resultTable.get("object");
        if (object$String != null) {
            common.ProxiInformation object$Info = common.RPCConstantsAndServices.createProxiInformation(object$String);
            object = ViewProxi.createProxi(object$Info,connectionKey);
            object.setToString(object$Info.getToString());
        }
        ViewProxi type = null;
        String type$String = (String)resultTable.get("type");
        if (type$String != null) {
            common.ProxiInformation type$Info = common.RPCConstantsAndServices.createProxiInformation(type$String);
            type = ViewProxi.createProxi(type$Info,connectionKey);
            type.setToString(type$Info.getToString());
        }
        java.util.Vector<String> subAccounts_string = (java.util.Vector<String>)resultTable.get("subAccounts");
        java.util.Vector<AccountView> subAccounts = ViewProxi.getProxiVector(subAccounts_string, connectionKey);
        java.util.Vector<String> entries_string = (java.util.Vector<String>)resultTable.get("entries");
        java.util.Vector<MeasurementView> entries = ViewProxi.getProxiVector(entries_string, connectionKey);
        AccountView result$$ = new Account((InstanceObjectView)object,(MAccountTypeView)type,subAccounts,entries, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index == 0 && this.getObject() != null) return new ObjectQuantifObjectWrapper(this, originalIndex, (ViewRoot)this.getObject());
        if(this.getObject() != null) index = index - 1;
        if(index == 0 && this.getType() != null) return new TypeAccountWrapper(this, originalIndex, (ViewRoot)this.getType());
        if(this.getType() != null) index = index - 1;
        if(index < this.getSubAccounts().size()) return new SubAccountsAccountWrapper(this, originalIndex, (ViewRoot)this.getSubAccounts().get(index));
        index = index - this.getSubAccounts().size();
        if(index < this.getEntries().size()) return new EntriesAccountWrapper(this, originalIndex, (ViewRoot)this.getEntries().get(index));
        index = index - this.getEntries().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getObject() == null ? 0 : 1)
            + (this.getType() == null ? 0 : 1)
            + (this.getSubAccounts().size())
            + (this.getEntries().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getObject() == null ? true : false)
            && (this.getType() == null ? true : false)
            && (this.getSubAccounts().size() == 0)
            && (this.getEntries().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getObject() != null && this.getObject().equals(child)) return result;
        if(this.getObject() != null) result = result + 1;
        if(this.getType() != null && this.getType().equals(child)) return result;
        if(this.getType() != null) result = result + 1;
        java.util.Iterator<?> getSubAccountsIterator = this.getSubAccounts().iterator();
        while(getSubAccountsIterator.hasNext()){
            if(getSubAccountsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        java.util.Iterator<?> getEntriesIterator = this.getEntries().iterator();
        while(getEntriesIterator.hasNext()){
            if(getEntriesIterator.next().equals(child)) return result;
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
    public java.util.Vector<MeasurementView> getEntries() throws ModelException {
        return ((Account)this.getTheObject()).getEntries();
    }
    public void setEntries(java.util.Vector<MeasurementView> newValue) throws ModelException {
        ((Account)this.getTheObject()).setEntries(newValue);
    }
    
    public void accept(QuantifObjectVisitor visitor) throws ModelException {
        visitor.handleAccount(this);
    }
    public <R> R accept(QuantifObjectReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleAccount(this);
    }
    public <E extends UserException>  void accept(QuantifObjectExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleAccount(this);
    }
    public <R, E extends UserException> R accept(QuantifObjectReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleAccount(this);
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
