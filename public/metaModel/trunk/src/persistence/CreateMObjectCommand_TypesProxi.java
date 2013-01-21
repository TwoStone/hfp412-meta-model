package persistence;

import model.meta.*;

import java.util.Iterator;

public class CreateMObjectCommand_TypesProxi extends PersistentListProxi<PersistentMAtomicType> {

  private MAtomicTypeList list;
  private CreateMObjectCommand owner;

  public CreateMObjectCommand_TypesProxi(CreateMObjectCommand owner) {
    this.owner = owner;
  }
  public MAtomicTypeList getList() throws PersistenceException{
    if (this.list == null) {
      if (this.owner.isDelayed$Persistence()) {
        this.list = new MAtomicTypeList();
      } else {
        this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theCreateMObjectCommandFacade.typesGet(this.owner.getId());
      }
    }
    return this.list;
  }
  public Iterator<PersistentMAtomicType> iterator() throws PersistenceException{
    return this.getList().iterator(this);
  }
  public long getLength() throws PersistenceException{
	  return this.getList().getLength();
  }
  public void add(PersistentMAtomicType entry) throws PersistenceException {
    if (entry != null) {
      MAtomicTypeList list = this.getList();
      long entryId = 0;
      if (!this.owner.isDelayed$Persistence()) {
        entry.store();  	
        entryId = ConnectionHandler.getTheConnectionHandler().theCreateMObjectCommandFacade
                       .typesAdd(owner.getId(), entry);
      }
      list.add((PersistentMAtomicType)PersistentProxi.createListEntryProxi(entry.getId(),
                               entry.getClassId(),
                               entryId));
      
    }
  }
  protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    if (!this.owner.isDelayed$Persistence()) {
      ConnectionHandler.getTheConnectionHandler().theCreateMObjectCommandFacade.typesRem(entry.getListEntryId());
    }
    
  }
  public CreateMObjectCommand_TypesProxi copy(CreateMObjectCommand owner) throws PersistenceException {
  	CreateMObjectCommand_TypesProxi result = new CreateMObjectCommand_TypesProxi(owner);
  	result.list = this.getList().copy();
  	return result;
  } 
  public void store() throws PersistenceException {
  	java.util.Iterator<PersistentMAtomicType> entries = (this.list == null ? new java.util.Vector<PersistentMAtomicType>().iterator() : this.list.iterator(this));
  	while (entries.hasNext()){
  		PersistentMAtomicType current = entries.next();
  		current.store();
      	long entryId = ConnectionHandler.getTheConnectionHandler().theCreateMObjectCommandFacade
                       .typesAdd(owner.getId(), current);
        ((PersistentListEntryProxi)current).setListEntryId(entryId);
  	}
  }	
}
