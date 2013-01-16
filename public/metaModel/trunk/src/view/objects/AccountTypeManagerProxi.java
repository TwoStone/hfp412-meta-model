package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class AccountTypeManagerProxi extends ViewProxi implements AccountTypeManagerView{
    
    public AccountTypeManagerProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public AccountTypeManagerView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> accountTypes_string = (java.util.Vector<String>)resultTable.get("accountTypes");
        java.util.Vector<MAccountTypeView> accountTypes = ViewProxi.getProxiVector(accountTypes_string, connectionKey);
        AccountTypeManagerView result$$ = new AccountTypeManager(accountTypes, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index < this.getAccountTypes().size()) return new AccountTypesAccountTypeManagerWrapper(this, originalIndex, (ViewRoot)this.getAccountTypes().get(index));
        index = index - this.getAccountTypes().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getAccountTypes().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getAccountTypes().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getAccountTypesIterator = this.getAccountTypes().iterator();
        while(getAccountTypesIterator.hasNext()){
            if(getAccountTypesIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<MAccountTypeView> getAccountTypes() throws ModelException {
        return ((AccountTypeManager)this.getTheObject()).getAccountTypes();
    }
    public void setAccountTypes(java.util.Vector<MAccountTypeView> newValue) throws ModelException {
        ((AccountTypeManager)this.getTheObject()).setAccountTypes(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleAccountTypeManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleAccountTypeManager(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleAccountTypeManager(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleAccountTypeManager(this);
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
