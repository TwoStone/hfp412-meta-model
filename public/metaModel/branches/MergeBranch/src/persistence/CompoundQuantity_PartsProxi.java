package persistence;

import model.quantity.*;

import java.util.Iterator;

public class CompoundQuantity_PartsProxi extends PersistentListProxi<PersistentQuantity> {

  private QuantityList list;
  private CompoundQuantity owner;

  public CompoundQuantity_PartsProxi(CompoundQuantity owner) {
    this.owner = owner;
  }
  public QuantityList getList() throws PersistenceException{
    if (this.list == null) {
      if (this.owner.isDelayed$Persistence()) {
        this.list = new QuantityList();
      } else {
        this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theCompoundQuantityFacade.partsGet(this.owner.getId());
      }
    }
    return this.list;
  }
  public Iterator<PersistentQuantity> iterator() throws PersistenceException{
    return this.getList().iterator(this);
  }
  public long getLength() throws PersistenceException{
	  return this.getList().getLength();
  }
  public void add(PersistentQuantity entry) throws PersistenceException {
    if (entry != null) {
      QuantityList list = this.getList();
      long entryId = 0;
      if (!this.owner.isDelayed$Persistence()) {
        entry.store();  	
        entryId = ConnectionHandler.getTheConnectionHandler().theCompoundQuantityFacade
                       .partsAdd(owner.getId(), entry);
      }
      list.add((PersistentQuantity)PersistentProxi.createListEntryProxi(entry.getId(),
                               entry.getClassId(),
                               entryId));
      
    }
  }
  protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    if (!this.owner.isDelayed$Persistence()) {
      ConnectionHandler.getTheConnectionHandler().theCompoundQuantityFacade.partsRem(entry.getListEntryId());
    }
    
  }
  public CompoundQuantity_PartsProxi copy(CompoundQuantity owner) throws PersistenceException {
  	CompoundQuantity_PartsProxi result = new CompoundQuantity_PartsProxi(owner);
  	result.list = this.getList().copy();
  	return result;
  } 
  public void store() throws PersistenceException {
  	java.util.Iterator<PersistentQuantity> entries = (this.list == null ? new java.util.Vector<PersistentQuantity>().iterator() : this.list.iterator(this));
  	while (entries.hasNext()){
  		PersistentQuantity current = entries.next();
  		current.store();
      	long entryId = ConnectionHandler.getTheConnectionHandler().theCompoundQuantityFacade
                       .partsAdd(owner.getId(), current);
        ((PersistentListEntryProxi)current).setListEntryId(entryId);
  	}
  }	
}
