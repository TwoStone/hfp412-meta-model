package persistence;

import model.measurement.*;

import java.util.Iterator;

public class MeasurementTypeManager_MeasurementTypesProxi extends PersistentListProxi<PersistentMMeasurementType> {

  private MMeasurementTypeList list;
  private MeasurementTypeManager owner;

  public MeasurementTypeManager_MeasurementTypesProxi(MeasurementTypeManager owner) {
    this.owner = owner;
  }
  public MMeasurementTypeList getList() throws PersistenceException{
    if (this.list == null) {
      if (this.owner.isDelayed$Persistence()) {
        this.list = new MMeasurementTypeList();
      } else {
        this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theMeasurementTypeManagerFacade.measurementTypesGet(this.owner.getId());
      }
    }
    return this.list;
  }
  public Iterator<PersistentMMeasurementType> iterator() throws PersistenceException{
    return this.getList().iterator(this);
  }
  public long getLength() throws PersistenceException{
	  return this.getList().getLength();
  }
  public void add(PersistentMMeasurementType entry) throws PersistenceException {
    if (entry != null) {
      MMeasurementTypeList list = this.getList();
      long entryId = 0;
      if (!this.owner.isDelayed$Persistence()) {
        entry.store();  	
        entryId = ConnectionHandler.getTheConnectionHandler().theMeasurementTypeManagerFacade
                       .measurementTypesAdd(owner.getId(), entry);
      }
      list.add((PersistentMMeasurementType)PersistentProxi.createListEntryProxi(entry.getId(),
                               entry.getClassId(),
                               entryId));
      
    }
  }
  protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    if (!this.owner.isDelayed$Persistence()) {
      ConnectionHandler.getTheConnectionHandler().theMeasurementTypeManagerFacade.measurementTypesRem(entry.getListEntryId());
    }
    
  }
  public MeasurementTypeManager_MeasurementTypesProxi copy(MeasurementTypeManager owner) throws PersistenceException {
  	MeasurementTypeManager_MeasurementTypesProxi result = new MeasurementTypeManager_MeasurementTypesProxi(owner);
  	result.list = this.getList().copy();
  	return result;
  } 
  public void store() throws PersistenceException {
  	java.util.Iterator<PersistentMMeasurementType> entries = (this.list == null ? new java.util.Vector<PersistentMMeasurementType>().iterator() : this.list.iterator(this));
  	while (entries.hasNext()){
  		PersistentMMeasurementType current = entries.next();
  		current.store();
      	long entryId = ConnectionHandler.getTheConnectionHandler().theMeasurementTypeManagerFacade
                       .measurementTypesAdd(owner.getId(), current);
        ((PersistentListEntryProxi)current).setListEntryId(entryId);
  	}
  }	
}
