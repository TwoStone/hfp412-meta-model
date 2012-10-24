package persistence;

public class ConversionRateListEntryProxi extends ConversionRateProxi implements PersistentConversionRateListEntryProxi {

  long entryId;

  public ConversionRateListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}