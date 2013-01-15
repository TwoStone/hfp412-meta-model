package persistence;

import model.measurement.*;

import java.util.Iterator;

public class Account_SubAccountsProxi extends PersistentListProxi<PersistentAccount> {

  private AccountList list;
  private Account owner;

  public Account_SubAccountsProxi(Account owner) {
    this.owner = owner;
  }
  public AccountList getList() throws PersistenceException{
    if (this.list == null) {
      if (this.owner.isDelayed$Persistence()) {
        this.list = new AccountList();
      } else {
        this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theAccountFacade.subAccountsGet(this.owner.getId());
      }
    }
    return this.list;
  }
  public Iterator<PersistentAccount> iterator() throws PersistenceException{
    return this.getList().iterator(this);
  }
  public long getLength() throws PersistenceException{
	  return this.getList().getLength();
  }
  public void add(PersistentAccount entry) throws PersistenceException , model.CycleException{
    if (entry != null) {
      if (entry.containsAccountHierarchy(this.owner)) throw new model.CycleException("Cycle in AccountHierarchy detected!");
      AccountList list = this.getList();
      long entryId = 0;
      if (!this.owner.isDelayed$Persistence()) {
        entry.store();  	
        entryId = ConnectionHandler.getTheConnectionHandler().theAccountFacade
                       .subAccountsAdd(owner.getId(), entry);
      }
      list.add((PersistentAccount)PersistentProxi.createListEntryProxi(entry.getId(),
                               entry.getClassId(),
                               entryId));
      
    }
  }
  protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    if (!this.owner.isDelayed$Persistence()) {
      ConnectionHandler.getTheConnectionHandler().theAccountFacade.subAccountsRem(entry.getListEntryId());
    }
    
  }
  public Account_SubAccountsProxi copy(Account owner) throws PersistenceException {
  	Account_SubAccountsProxi result = new Account_SubAccountsProxi(owner);
  	result.list = this.getList().copy();
  	return result;
  } 
  public void store() throws PersistenceException {
  	java.util.Iterator<PersistentAccount> entries = (this.list == null ? new java.util.Vector<PersistentAccount>().iterator() : this.list.iterator(this));
  	while (entries.hasNext()){
  		PersistentAccount current = entries.next();
  		current.store();
      	long entryId = ConnectionHandler.getTheConnectionHandler().theAccountFacade
                       .subAccountsAdd(owner.getId(), current);
        ((PersistentListEntryProxi)current).setListEntryId(entryId);
  	}
  }	
}
