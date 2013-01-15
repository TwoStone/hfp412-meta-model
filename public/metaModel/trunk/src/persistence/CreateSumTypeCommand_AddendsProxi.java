package persistence;

import model.meta.*;

import java.util.Iterator;

public class CreateSumTypeCommand_AddendsProxi extends PersistentListProxi<PersistentMType> {

  private MTypeList list;
  private CreateSumTypeCommand owner;

  public CreateSumTypeCommand_AddendsProxi(CreateSumTypeCommand owner) {
    this.owner = owner;
  }
  public MTypeList getList() throws PersistenceException{
    if (this.list == null) {
      if (this.owner.isDelayed$Persistence()) {
        this.list = new MTypeList();
      } else {
        this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theCreateSumTypeCommandFacade.addendsGet(this.owner.getId());
      }
    }
    return this.list;
  }
  public Iterator<PersistentMType> iterator() throws PersistenceException{
    return this.getList().iterator(this);
  }
  public long getLength() throws PersistenceException{
	  return this.getList().getLength();
  }
  public void add(PersistentMType entry) throws PersistenceException {
    if (entry != null) {
      MTypeList list = this.getList();
      long entryId = 0;
      if (!this.owner.isDelayed$Persistence()) {
        entry.store();  	
        entryId = ConnectionHandler.getTheConnectionHandler().theCreateSumTypeCommandFacade
                       .addendsAdd(owner.getId(), entry);
      }
      list.add((PersistentMType)PersistentProxi.createListEntryProxi(entry.getId(),
                               entry.getClassId(),
                               entryId));
      
    }
  }
  protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    if (!this.owner.isDelayed$Persistence()) {
      ConnectionHandler.getTheConnectionHandler().theCreateSumTypeCommandFacade.addendsRem(entry.getListEntryId());
    }
    
  }
  public CreateSumTypeCommand_AddendsProxi copy(CreateSumTypeCommand owner) throws PersistenceException {
  	CreateSumTypeCommand_AddendsProxi result = new CreateSumTypeCommand_AddendsProxi(owner);
  	result.list = this.getList().copy();
  	return result;
  } 
  public void store() throws PersistenceException {
  	java.util.Iterator<PersistentMType> entries = (this.list == null ? new java.util.Vector<PersistentMType>().iterator() : this.list.iterator(this));
  	while (entries.hasNext()){
  		PersistentMType current = entries.next();
  		current.store();
      	long entryId = ConnectionHandler.getTheConnectionHandler().theCreateSumTypeCommandFacade
                       .addendsAdd(owner.getId(), current);
        ((PersistentListEntryProxi)current).setListEntryId(entryId);
  	}
  }	
}
