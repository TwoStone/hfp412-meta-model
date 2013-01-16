package persistence;

import model.measurement.*;

import java.util.Iterator;

public class AccountManager_AccountsProxi extends PersistentListProxi<PersistentAccount> {

  private AccountList list;
  private AccountManager owner;

  public AccountManager_AccountsProxi(AccountManager owner) {
    this.owner = owner;
  }
  public AccountList getList() throws PersistenceException{
    if (this.list == null) {
      if (this.owner.isDelayed$Persistence()) {
        this.list = new AccountList();
      } else {
        this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theAccountManagerFacade.accountsGet(this.owner.getId());
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
  public void add(PersistentAccount entry) throws PersistenceException {
    if (entry != null) {
      AccountList list = this.getList();
      long entryId = 0;
      if (!this.owner.isDelayed$Persistence()) {
        entry.store();  	
        entryId = ConnectionHandler.getTheConnectionHandler().theAccountManagerFacade
                       .accountsAdd(owner.getId(), entry);
      }
      list.add((PersistentAccount)PersistentProxi.createListEntryProxi(entry.getId(),
                               entry.getClassId(),
                               entryId));
      
    }
  }
  protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    if (!this.owner.isDelayed$Persistence()) {
      ConnectionHandler.getTheConnectionHandler().theAccountManagerFacade.accountsRem(entry.getListEntryId());
    }
    
  }
  public AccountManager_AccountsProxi copy(AccountManager owner) throws PersistenceException {
  	AccountManager_AccountsProxi result = new AccountManager_AccountsProxi(owner);
  	result.list = this.getList().copy();
  	return result;
  } 
  public void store() throws PersistenceException {
  	java.util.Iterator<PersistentAccount> entries = (this.list == null ? new java.util.Vector<PersistentAccount>().iterator() : this.list.iterator(this));
  	while (entries.hasNext()){
  		PersistentAccount current = entries.next();
  		current.store();
      	long entryId = ConnectionHandler.getTheConnectionHandler().theAccountManagerFacade
                       .accountsAdd(owner.getId(), current);
        ((PersistentListEntryProxi)current).setListEntryId(entryId);
  	}
  }	
}
