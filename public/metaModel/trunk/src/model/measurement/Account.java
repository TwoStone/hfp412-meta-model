
package model.measurement;

import persistence.*;
import model.UserException;
import model.visitor.*;


/* Additional import section end */

public class Account extends model.measurement.QuantifObject implements PersistentAccount{
    
    
    public static PersistentAccount createAccount(PersistentInstanceObject object,PersistentMAccountType type) throws PersistenceException{
        return createAccount(object,type,false);
    }
    
    public static PersistentAccount createAccount(PersistentInstanceObject object,PersistentMAccountType type,boolean delayed$Persistence) throws PersistenceException {
        PersistentAccount result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAccountFacade
                .newDelayedAccount();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAccountFacade
                .newAccount(-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("object", object);
        final$$Fields.put("type", type);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentAccount createAccount(PersistentInstanceObject object,PersistentMAccountType type,boolean delayed$Persistence,PersistentAccount This) throws PersistenceException {
        PersistentAccount result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAccountFacade
                .newDelayedAccount();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAccountFacade
                .newAccount(-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("object", object);
        final$$Fields.put("type", type);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot type = (AbstractPersistentRoot)this.getType();
            if (type != null) {
                result.put("type", type.createProxiInformation(false));
                if(depth > 1) {
                    type.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && type.hasEssentialFields())type.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            result.put("subAccounts", this.getSubAccounts().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false));
            result.put("entries", this.getEntries().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public Account provideCopy() throws PersistenceException{
        Account result = this;
        result = new Account(this.object, 
                             this.This, 
                             this.type, 
                             this.getId());
        result.subAccounts = this.subAccounts.copy(result);
        result.entries = this.entries.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentMAccountType type;
    protected Account_SubAccountsProxi subAccounts;
    protected Account_EntriesProxi entries;
    
    public Account(PersistentInstanceObject object,PersistentQuantifObject This,PersistentMAccountType type,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentInstanceObject)object,(PersistentQuantifObject)This,id);
        this.type = type;
        this.subAccounts = new Account_SubAccountsProxi(this);
        this.entries = new Account_EntriesProxi(this);        
    }
    
    static public long getTypeId() {
        return 181;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 181) ConnectionHandler.getTheConnectionHandler().theAccountFacade
            .newAccount(this.getId());
        super.store();
        if(this.getType() != null){
            this.getType().store();
            ConnectionHandler.getTheConnectionHandler().theAccountFacade.typeSet(this.getId(), getType());
        }
        this.getSubAccounts().store();
        this.getEntries().store();
        
    }
    
    public PersistentMAccountType getType() throws PersistenceException {
        return this.type;
    }
    public void setType(PersistentMAccountType newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.type)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.type = (PersistentMAccountType)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAccountFacade.typeSet(this.getId(), newValue);
        }
    }
    public Account_SubAccountsProxi getSubAccounts() throws PersistenceException {
        return this.subAccounts;
    }
    public Account_EntriesProxi getEntries() throws PersistenceException {
        return this.entries;
    }
    public PersistentAccount getThis() throws PersistenceException {
        if(this.This == null){
            PersistentAccount result = new AccountProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentAccount)this.This;
    }
    
    public void accept(QuantifObjectVisitor visitor) throws PersistenceException {
        visitor.handleAccount(this);
    }
    public <R> R accept(QuantifObjectReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccount(this);
    }
    public <E extends UserException>  void accept(QuantifObjectExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccount(this);
    }
    public <R, E extends UserException> R accept(QuantifObjectReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccount(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAccount(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccount(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccount(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccount(this);
    }
    public void accept(AccountHierarchyHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleAccount(this);
    }
    public <R> R accept(AccountHierarchyHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccount(this);
    }
    public <E extends UserException>  void accept(AccountHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccount(this);
    }
    public <R, E extends UserException> R accept(AccountHierarchyHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccount(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + (this.getObject() == null ? 0 : 1)
            + (this.getType() == null ? 0 : 1)
            + this.getSubAccounts().getLength()
            + this.getEntries().getLength());
    }
    
    
    public boolean containsAccountHierarchy(final AccountHierarchyHIERARCHY part) 
				throws PersistenceException{
        if(getThis().equals(part)) return true;
		java.util.Iterator iterator0 = getThis().getSubAccounts().iterator();
		while(iterator0.hasNext())
			if(((AccountHierarchyHIERARCHY)iterator0.next()).containsAccountHierarchy(part)) return true; 
		return false;
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public <T> T strategyAccountHierarchy(final T parameter, final AccountHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        T result$$subAccounts$$Account = strategy.initialize$$Account$$subAccounts(getThis(), parameter);
		java.util.Iterator iterator$$ = getThis().getSubAccounts().iterator();
		while (iterator$$.hasNext()){
			PersistentAccount current$$Field = (PersistentAccount)iterator$$.next();
			T current$$ = current$$Field.strategyAccountHierarchy(result$$subAccounts$$Account, strategy);
			result$$subAccounts$$Account = strategy.consolidate$$Account$$subAccounts(getThis(), result$$subAccounts$$Account, current$$);
		}
		return strategy.finalize$$Account(getThis(), parameter,result$$subAccounts$$Account);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentAccount)This);
		if(this.equals(This)){
			this.setObject((PersistentInstanceObject)final$$Fields.get("object"));
			this.setType((PersistentMAccountType)final$$Fields.get("type"));
		}
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}