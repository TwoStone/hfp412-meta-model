package persistence;

import model.*;

import java.util.Iterator;

public class AkteurManager_AkteureProxi extends PersistentListProxi<PersistentAkteur> {

  private AkteurList list;
  private AkteurManager owner;

  public AkteurManager_AkteureProxi(AkteurManager owner) {
    this.owner = owner;
  }
  public AkteurList getList() throws PersistenceException{
    if (this.list == null) {
      this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theAkteurManagerFacade.akteureGet(this.owner.getId());
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
      long entryId = ConnectionHandler.getTheConnectionHandler().theAkteurManagerFacade
                       .akteureAdd(owner.getId(), entry);
      list.add((PersistentAkteur)PersistentProxi.createListEntryProxi(entry.getId(),
                               entry.getClassId(),
                               entryId));
      
    }
  }
  protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    ConnectionHandler.getTheConnectionHandler().theAkteurManagerFacade.akteureRem(entry.getListEntryId());
    
  }
  public AkteurManager_AkteureProxi copy(AkteurManager owner) throws PersistenceException {
  	AkteurManager_AkteureProxi result = new AkteurManager_AkteureProxi(owner);
  	result.list = this.getList().copy();
  	return result;
  } 

}
