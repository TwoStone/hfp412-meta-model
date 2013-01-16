package persistence;

import model.measurement.*;

import java.util.Iterator;

public class AccountTypeManager_AccountTypesProxi extends PersistentListProxi<PersistentMAccountType> {

  private MAccountTypeList list;
  private AccountTypeManager owner;

  public AccountTypeManager_AccountTypesProxi(AccountTypeManager owner) {
    this.owner = owner;
  }
  public MAccountTypeList getList() throws PersistenceException{
    if (this.list == null) {
      if (this.owner.isDelayed$Persistence()) {
        this.list = new MAccountTypeList();
      } else {
        this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theAccountTypeManagerFacade.accountTypesGet(this.owner.getId());
      }
    }
    return this.list;
  }
  public Iterator<PersistentMAccountType> iterator() throws PersistenceException{
    return this.getList().iterator(this);
  }
  public long getLength() throws PersistenceException{
	  return this.getList().getLength();
  }
  public void add(PersistentMAccountType entry) throws PersistenceException {
    if (entry != null) {
      MAccountTypeList list = this.getList();
      long entryId = 0;
      if (!this.owner.isDelayed$Persistence()) {
        entry.store();  	
        entryId = ConnectionHandler.getTheConnectionHandler().theAccountTypeManagerFacade
                       .accountTypesAdd(owner.getId(), entry);
      }
      list.add((PersistentMAccountType)PersistentProxi.createListEntryProxi(entry.getId(),
                               entry.getClassId(),
                               entryId));
      
    }
  }
  protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    if (!this.owner.isDelayed$Persistence()) {
      ConnectionHandler.getTheConnectionHandler().theAccountTypeManagerFacade.accountTypesRem(entry.getListEntryId());
    }
    
  }
  public AccountTypeManager_AccountTypesProxi copy(AccountTypeManager owner) throws PersistenceException {
  	AccountTypeManager_AccountTypesProxi result = new AccountTypeManager_AccountTypesProxi(owner);
  	result.list = this.getList().copy();
  	return result;
  } 
  public void store() throws PersistenceException {
  	java.util.Iterator<PersistentMAccountType> entries = (this.list == null ? new java.util.Vector<PersistentMAccountType>().iterator() : this.list.iterator(this));
  	while (entries.hasNext()){
  		PersistentMAccountType current = entries.next();
  		current.store();
      	long entryId = ConnectionHandler.getTheConnectionHandler().theAccountTypeManagerFacade
                       .accountTypesAdd(owner.getId(), current);
        ((PersistentListEntryProxi)current).setListEntryId(entryId);
  	}
  }	
}
