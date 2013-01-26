
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class Account extends view.objects.QuantifObject implements AccountView{
    
    protected MAccountTypeView type;
    protected java.util.Vector<AccountView> subAccounts;
    protected java.util.Vector<MeasurementView> entries;
    
    public Account(InstanceObjectView object,MAccountTypeView type,java.util.Vector<AccountView> subAccounts,java.util.Vector<MeasurementView> entries,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super((InstanceObjectView)object,id, classId);
        this.type = type;
        this.subAccounts = subAccounts;
        this.entries = entries;        
    }
    
    static public long getTypeId() {
        return 196;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public MAccountTypeView getType() throws ModelException {
        return this.type;
    }
    public void setType(MAccountTypeView newValue) throws ModelException {
        this.type = newValue;
    }
    public java.util.Vector<AccountView> getSubAccounts() throws ModelException {
        return this.subAccounts;
    }
    public void setSubAccounts(java.util.Vector<AccountView> newValue) throws ModelException {
        this.subAccounts = newValue;
    }
    public java.util.Vector<MeasurementView> getEntries() throws ModelException {
        return this.entries;
    }
    public void setEntries(java.util.Vector<MeasurementView> newValue) throws ModelException {
        this.entries = newValue;
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
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        InstanceObjectView object = this.getObject();
        if (object != null) {
            ((ViewProxi)object).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(object.getClassId(), object.getId())));
        }
        MAccountTypeView type = this.getType();
        if (type != null) {
            ((ViewProxi)type).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(type.getClassId(), type.getId())));
        }
        java.util.Vector<?> subAccounts = this.getSubAccounts();
        if (subAccounts != null) {
            ViewObject.resolveVectorProxies(subAccounts, resultTable);
        }
        java.util.Vector<?> entries = this.getEntries();
        if (entries != null) {
            ViewObject.resolveVectorProxies(entries, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
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
        super.setIcon(renderer);
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
