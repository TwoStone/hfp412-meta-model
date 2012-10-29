package persistence;

import model.*;

import java.util.Iterator;

public class CompUnit_RefsProxi extends PersistentListProxi<PersistentReference> {

  private ReferenceList list;
  private CompUnit owner;

  public CompUnit_RefsProxi(CompUnit owner) {
    this.owner = owner;
  }
  public ReferenceList getList() throws PersistenceException{
    if (this.list == null) {
      this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theCompUnitFacade.refsGet(this.owner.getId());
    }
    return this.list;
  }
  public Iterator<PersistentReference> iterator() throws PersistenceException{
    return this.getList().iterator(this);
  }
  public long getLength() throws PersistenceException{
	  return this.getList().getLength();
  }
  public void add(PersistentReference entry) throws PersistenceException {
    if (entry != null) {
      ReferenceList list = this.getList();
      long entryId = ConnectionHandler.getTheConnectionHandler().theCompUnitFacade
                       .refsAdd(owner.getId(), entry);
      list.add((PersistentReference)PersistentProxi.createListEntryProxi(entry.getId(),
                               entry.getClassId(),
                               entryId));
      
    }
  }
  protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    ConnectionHandler.getTheConnectionHandler().theCompUnitFacade.refsRem(entry.getListEntryId());
    
  }
  public CompUnit_RefsProxi copy(CompUnit owner) throws PersistenceException {
  	CompUnit_RefsProxi result = new CompUnit_RefsProxi(owner);
  	result.list = this.getList().copy();
  	return result;
  } 

}
