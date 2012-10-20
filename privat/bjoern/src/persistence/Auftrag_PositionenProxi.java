package persistence;

import model.*;

import java.util.Iterator;

public class Auftrag_PositionenProxi extends PersistentListProxi<PersistentPosition> {

  private PositionList list;
  private Auftrag owner;

  public Auftrag_PositionenProxi(Auftrag owner) {
    this.owner = owner;
  }
  public PositionList getList() throws PersistenceException{
    if (this.list == null) {
      this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theAuftragFacade.positionenGet(this.owner.getId());
    }
    return this.list;
  }
  public Iterator<PersistentPosition> iterator() throws PersistenceException{
    return this.getList().iterator(this);
  }
  public long getLength() throws PersistenceException{
	  return this.getList().getLength();
  }
  public void add(PersistentPosition entry) throws PersistenceException {
    if (entry != null) {
      PositionList list = this.getList();
      long entryId = ConnectionHandler.getTheConnectionHandler().theAuftragFacade
                       .positionenAdd(owner.getId(), entry);
      list.add((PersistentPosition)PersistentProxi.createListEntryProxi(entry.getId(),
                               entry.getClassId(),
                               entryId));
      
    }
  }
  protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    ConnectionHandler.getTheConnectionHandler().theAuftragFacade.positionenRem(entry.getListEntryId());
    
  }
  public Auftrag_PositionenProxi copy(Auftrag owner) throws PersistenceException {
  	Auftrag_PositionenProxi result = new Auftrag_PositionenProxi(owner);
  	result.list = this.getList().copy();
  	return result;
  } 

}
