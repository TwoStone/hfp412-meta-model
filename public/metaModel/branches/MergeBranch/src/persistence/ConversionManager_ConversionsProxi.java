package persistence;

import model.quantity.*;

import java.util.Iterator;

public class ConversionManager_ConversionsProxi extends PersistentListProxi<PersistentConversion> {

  private ConversionList list;
  private ConversionManager owner;

  public ConversionManager_ConversionsProxi(ConversionManager owner) {
    this.owner = owner;
  }
  public ConversionList getList() throws PersistenceException{
    if (this.list == null) {
      if (this.owner.isDelayed$Persistence()) {
        this.list = new ConversionList();
      } else {
        this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theConversionManagerFacade.conversionsGet(this.owner.getId());
      }
    }
    return this.list;
  }
  public Iterator<PersistentConversion> iterator() throws PersistenceException{
    return this.getList().iterator(this);
  }
  public long getLength() throws PersistenceException{
	  return this.getList().getLength();
  }
  public void add(PersistentConversion entry) throws PersistenceException {
    if (entry != null) {
      ConversionList list = this.getList();
      long entryId = 0;
      if (!this.owner.isDelayed$Persistence()) {
        entry.store();  	
        entryId = ConnectionHandler.getTheConnectionHandler().theConversionManagerFacade
                       .conversionsAdd(owner.getId(), entry);
      }
      list.add((PersistentConversion)PersistentProxi.createListEntryProxi(entry.getId(),
                               entry.getClassId(),
                               entryId));
      
    }
  }
  protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    if (!this.owner.isDelayed$Persistence()) {
      ConnectionHandler.getTheConnectionHandler().theConversionManagerFacade.conversionsRem(entry.getListEntryId());
    }
    
  }
  public ConversionManager_ConversionsProxi copy(ConversionManager owner) throws PersistenceException {
  	ConversionManager_ConversionsProxi result = new ConversionManager_ConversionsProxi(owner);
  	result.list = this.getList().copy();
  	return result;
  } 
  public void store() throws PersistenceException {
  	java.util.Iterator<PersistentConversion> entries = (this.list == null ? new java.util.Vector<PersistentConversion>().iterator() : this.list.iterator(this));
  	while (entries.hasNext()){
  		PersistentConversion current = entries.next();
  		current.store();
      	long entryId = ConnectionHandler.getTheConnectionHandler().theConversionManagerFacade
                       .conversionsAdd(owner.getId(), current);
        ((PersistentListEntryProxi)current).setListEntryId(entryId);
  	}
  }	
}
