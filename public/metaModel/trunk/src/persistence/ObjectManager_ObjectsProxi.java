package persistence;

import model.typeSystem.*;

import java.util.Iterator;

public class ObjectManager_ObjectsProxi extends PersistentListProxi<PersistentMObject> {

  private MObjectList list;
  private ObjectManager owner;

  public ObjectManager_ObjectsProxi(ObjectManager owner) {
    this.owner = owner;
  }
  public MObjectList getList() throws PersistenceException{
    if (this.list == null) {
      if (this.owner.isDelayed$Persistence()) {
        this.list = new MObjectList();
      } else {
        this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theObjectManagerFacade.objectsGet(this.owner.getId());
      }
    }
    return this.list;
  }
  public Iterator<PersistentMObject> iterator() throws PersistenceException{
    return this.getList().iterator(this);
  }
  public long getLength() throws PersistenceException{
	  return this.getList().getLength();
  }
  public void add(PersistentMObject entry) throws PersistenceException {
    if (entry != null) {
      MObjectList list = this.getList();
      long entryId = 0;
      if (!this.owner.isDelayed$Persistence()) {
        entry.store();  	
        entryId = ConnectionHandler.getTheConnectionHandler().theObjectManagerFacade
                       .objectsAdd(owner.getId(), entry);
      }
      list.add((PersistentMObject)PersistentProxi.createListEntryProxi(entry.getId(),
                               entry.getClassId(),
                               entryId));
      
    }
  }
  protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    if (!this.owner.isDelayed$Persistence()) {
      ConnectionHandler.getTheConnectionHandler().theObjectManagerFacade.objectsRem(entry.getListEntryId());
    }
    
  }
  public ObjectManager_ObjectsProxi copy(ObjectManager owner) throws PersistenceException {
  	ObjectManager_ObjectsProxi result = new ObjectManager_ObjectsProxi(owner);
  	result.list = this.getList().copy();
  	return result;
  } 
  public void store() throws PersistenceException {
  	java.util.Iterator<PersistentMObject> entries = (this.list == null ? new java.util.Vector<PersistentMObject>().iterator() : this.list.iterator(this));
  	while (entries.hasNext()){
  		PersistentMObject current = entries.next();
  		current.store();
      	long entryId = ConnectionHandler.getTheConnectionHandler().theObjectManagerFacade
                       .objectsAdd(owner.getId(), current);
        ((PersistentListEntryProxi)current).setListEntryId(entryId);
  	}
  }	
}
