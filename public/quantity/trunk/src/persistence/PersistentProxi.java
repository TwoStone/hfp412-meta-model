package persistence;

import java.util.Hashtable;

abstract class ProxiFactory {
	  abstract PersistentProxi create(long objectId);
}
abstract class ListProxiFactory {
	  abstract PersistentListEntryProxi create(long objectId, long entryId);
}

public abstract class PersistentProxi extends PersistentRoot {

  private static ProxiFactory [] proxiFactories;
  private static ListProxiFactory [] listProxiFactories;
	
  private static ListProxiFactory [] getTheListProxiFactories(){
	if (listProxiFactories == null){
		listProxiFactories = new ListProxiFactory[44];
        listProxiFactories[0] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new ConversionManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[1] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new ReferenceTypeListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[3] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new QuantityManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[4] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new ErrorDisplayListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[7] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateUnitTypeCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[5] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new UnitListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[6] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new UnitTypeListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[8] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateConversionCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[10] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateUnitCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[11] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CommandCoordinatorListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[43] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateCompUnitTypeCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[38] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new BooleanTrueListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[12] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CommonDateListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[13] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateQuantityCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[14] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CommandExecuterListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[41] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new AddReferenceTypeCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[15] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new QuantityListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[16] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CompoundQuantityListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[17] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new UnitTypeManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[18] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new AddDefaultUnitCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[42] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new FunctionListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[39] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new BooleanFalseListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[20] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new ServerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[37] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new FractionManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[21] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CompUnitListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[22] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new ReferenceListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[23] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new ConversionListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[24] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CompUnitTypeListEntryProxi(objectId, entryId);
            }
        };
	}
	return listProxiFactories;
  }
  private static ProxiFactory [] getTheProxiFactories(){
	if (proxiFactories == null){
		proxiFactories = new ProxiFactory [44];
        proxiFactories[0] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new ConversionManagerProxi(objectId);
            }
        };
        proxiFactories[1] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new ReferenceTypeProxi(objectId);
            }
        };
        proxiFactories[3] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new QuantityManagerProxi(objectId);
            }
        };
        proxiFactories[4] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new ErrorDisplayProxi(objectId);
            }
        };
        proxiFactories[7] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateUnitTypeCommandProxi(objectId);
            }
        };
        proxiFactories[5] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new UnitProxi(objectId);
            }
        };
        proxiFactories[6] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new UnitTypeProxi(objectId);
            }
        };
        proxiFactories[8] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateConversionCommandProxi(objectId);
            }
        };
        proxiFactories[10] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateUnitCommandProxi(objectId);
            }
        };
        proxiFactories[11] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CommandCoordinatorProxi(objectId);
            }
        };
        proxiFactories[43] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateCompUnitTypeCommandProxi(objectId);
            }
        };
        proxiFactories[38] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new BooleanTrueProxi(objectId);
            }
        };
        proxiFactories[12] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CommonDateProxi(objectId);
            }
        };
        proxiFactories[13] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateQuantityCommandProxi(objectId);
            }
        };
        proxiFactories[14] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CommandExecuterProxi(objectId);
            }
        };
        proxiFactories[41] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new AddReferenceTypeCommandProxi(objectId);
            }
        };
        proxiFactories[15] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new QuantityProxi(objectId);
            }
        };
        proxiFactories[16] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CompoundQuantityProxi(objectId);
            }
        };
        proxiFactories[17] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new UnitTypeManagerProxi(objectId);
            }
        };
        proxiFactories[18] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new AddDefaultUnitCommandProxi(objectId);
            }
        };
        proxiFactories[42] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new FunctionProxi(objectId);
            }
        };
        proxiFactories[39] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new BooleanFalseProxi(objectId);
            }
        };
        proxiFactories[20] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new ServerProxi(objectId);
            }
        };
        proxiFactories[37] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new FractionManagerProxi(objectId);
            }
        };
        proxiFactories[21] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CompUnitProxi(objectId);
            }
        };
        proxiFactories[22] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new ReferenceProxi(objectId);
            }
        };
        proxiFactories[23] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new ConversionProxi(objectId);
            }
        };
        proxiFactories[24] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CompUnitTypeProxi(objectId);
            }
        };
	}
	return proxiFactories;
  }

  public static PersistentProxi createProxi(common.ProxiInformation proxi) throws PersistenceException{
	  if (proxi.isDecorator()){
		  Decoratees resultDecoratee = (Decoratees) createProxi(proxi.getDecorateeObjectId(), proxi.getDecorateeClassId());
		  PersistentProxi resultDecorator = (PersistentProxi) resultDecoratee.createDecorator();
		  resultDecorator.setId(proxi.getObjectId());
		  return resultDecorator;
	  } else {
		  return createProxi(proxi.getObjectId(), proxi.getClassId());
	  }
  }

  public static PersistentProxi createProxi(long objectId, long classId) throws PersistenceException {
    int index = (int) classId;
	if (index < 0) index = index * -1;
    index = index - 101;
    if (index > getTheProxiFactories().length) throw new PersistenceException("Unknown class :" + Long.toString(classId),0);
    ProxiFactory factory = getTheProxiFactories()[index];
    if (factory == null)  throw new PersistenceException("Unknown class :" + Long.toString(classId),0);
    PersistentProxi result =  factory.create(objectId);
    result.getTheObject();
    return result;
  }
  public static PersistentListEntryProxi createListEntryProxi(long objectId, long classId, long entryId) throws PersistenceException {
    int index = (int) classId;
	if (index < 0) index = index * -1;
    index = index - 101;
    if (index > getTheListProxiFactories().length) throw new PersistenceException("Unknown class :" + Long.toString(classId),0);
    ListProxiFactory factory = getTheListProxiFactories()[index];
    if (factory == null)  throw new PersistenceException("Unknown class :" + Long.toString(classId),0);
    PersistentListEntryProxi result =  factory.create(objectId,entryId);
    result.getTheObject();
    return result;
  }

	private PersistentInCacheProxi object;

	protected PersistentProxi(long id) {
		super(id);
		this.object = null;
	}

	protected PersistentProxi(PersistentInCacheProxi object) {
		//TODO Check if used anywhere!?
		super(object.getId());
		this.object = object;
	}
	public boolean isDelayed$Persistence() throws PersistenceException {
		return this.getTheObject().isDelayed$Persistence();
	}

	public void setDelayed$Persistence(boolean b) throws PersistenceException {
		this.getTheObject().setDelayed$Persistence(b);
	}
	public void store() throws PersistenceException{
		this.getTheObject().store();
	}
	public void setId(long id) {
		super.setId(id);
		try {
			this.getTheObject().setId(id);
		} catch (PersistenceException e) {
			throw new PersistenceError(e);
		}
	}

	protected void setObject(PersistentRoot object) {
		if (this.object == null)
			this.object = (PersistentInCacheProxi)object;
	}

	public Hashtable<String,Object> toHashtable(int depth, int essentialLevel, boolean forGUI, TDObserver tdObserver) throws PersistenceException {
		PersistentRoot iCRroxi = this.getTheObject();
		if (iCRroxi == null) return null;
		return iCRroxi.toHashtable(depth, essentialLevel, forGUI, tdObserver);
	}
	public Hashtable<String, Object> toHashtable(Hashtable<String, Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
		PersistentRoot iCRroxi = this.getTheObject();
		if (iCRroxi == null) return null;
		return iCRroxi.toHashtable(allResults, depth, essentialLevel, forGUI, leaf, tdObserver);
	}

	public PersistentRoot getTheObject() throws PersistenceException {
		if (this.object == null) {
			this.object = Cache.getTheCache().get(this);
			this.object.incrementUserCount();
		}
		return this.object;
	}
	public boolean hasEssentialFields() throws PersistenceException{
		return this.getTheObject().hasEssentialFields();
	}
	public int getIconInfo() throws PersistenceException {
		return this.getTheObject().getIconInfo();
	}
	public int getLeafInfo() throws PersistenceException {
		return this.getTheObject().getLeafInfo();
	}
	
	public String toString() {
		try {
			return this.getTheObject().toString();
		} catch (PersistenceException pe) {
			throw new PersistenceError(pe);
		}
	}
	public String toString(boolean inner)throws PersistenceException{
		try {
			return this.getTheObject().toString(inner);
		} catch (PersistenceException pe) {
			throw new PersistenceError(pe);
		}		
	}
	public void delete$Me() throws PersistenceException {
		this.getTheObject().delete$Me();
	}
	
    protected void setDltd() throws PersistenceException{
        this.getTheObject().setDltd();
    }
    public boolean isDltd() throws PersistenceException {
        return this.getTheObject().isDltd();
    }
	
	
//	public void finalize(){
//		if (this.object != null)this.object.decrementUserCount();
//	}
}
