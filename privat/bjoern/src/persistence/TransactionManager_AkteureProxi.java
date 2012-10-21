package persistence;

import model.*;

import java.util.Iterator;

public class TransactionManager_AkteureProxi extends PersistentListProxi<PersistentAkteur> {

  private AkteurList list;
  private TransactionManager owner;

  public TransactionManager_AkteureProxi(TransactionManager owner) {
    this.owner = owner;
  }
  public AkteurList getList() throws PersistenceException{
    if (this.list == null) {
      this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theTransactionManagerFacade.akteureGet(this.owner.getId());
    }
    return this.list;
  }
  public Iterator<PersistentAkteur> iterator() throws PersistenceException{
    return this.getList().iterator(this);
  }
  public long getLength() throws PersistenceException{
	  return this.getList().getLength();
  }
  public void add(PersistentAkteur entry) throws PersistenceException {
    if (entry != null) {
      AkteurList list = this.getList();
      long entryId = ConnectionHandler.getTheConnectionHandler().theTransactionManagerFacade
                       .akteureAdd(owner.getId(), entry);
      list.add((PersistentAkteur)PersistentProxi.createListEntryProxi(entry.getId(),
                               entry.getClassId(),
                               entryId));
      
    }
  }
  protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    ConnectionHandler.getTheConnectionHandler().theTransactionManagerFacade.akteureRem(entry.getListEntryId());
    
  }
  public TransactionManager_AkteureProxi copy(TransactionManager owner) throws PersistenceException {
  	TransactionManager_AkteureProxi result = new TransactionManager_AkteureProxi(owner);
  	result.list = this.getList().copy();
  	return result;
  } 

}
