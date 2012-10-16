package persistence;

import model.*;

import java.util.Iterator;

public class Order_PositionsProxi extends PersistentListProxi<PersistentPosition> {

  private PositionList list;
  private Order owner;

  public Order_PositionsProxi(Order owner) {
    this.owner = owner;
  }
  public PositionList getList() throws PersistenceException{
    if (this.list == null) {
      this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theOrderFacade.positionsGet(this.owner.getId());
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
      long entryId = ConnectionHandler.getTheConnectionHandler().theOrderFacade
                       .positionsAdd(owner.getId(), entry);
      list.add((PersistentPosition)PersistentProxi.createListEntryProxi(entry.getId(),
                               entry.getClassId(),
                               entryId));
      
    }
  }
  protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    ConnectionHandler.getTheConnectionHandler().theOrderFacade.positionsRem(entry.getListEntryId());
    
  }
  public Order_PositionsProxi copy(Order owner) throws PersistenceException {
  	Order_PositionsProxi result = new Order_PositionsProxi(owner);
  	result.list = this.getList().copy();
  	return result;
  } 

}
