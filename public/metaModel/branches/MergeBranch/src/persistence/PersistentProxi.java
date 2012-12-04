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
		listProxiFactories = new ListProxiFactory[48];
        listProxiFactories[0] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new MProductTypeListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[17] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new TypeManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[18] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CommandExecuterListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[43] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateHierarchyCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[25] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new AspectManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[44] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new AddToHierarchyCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[3] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new ErrorDisplayListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[32] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new AddSubTypeCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[35] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new MFalseListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[4] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new ServerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[40] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new AssociationManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[1] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new MAtomicTypeListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[38] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateAspectCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[39] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateAtomicTypeCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[41] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new MAHierarchyListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[19] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CommandCoordinatorListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[26] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new MAspectListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[20] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CommonDateListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[2] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new MSumTypeListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[42] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new MAssociationListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[45] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateAssociationCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[34] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateSubTypeCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[36] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new MBooleanListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[37] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new MTrueListEntryProxi(objectId, entryId);
            }
        };
	}
	return listProxiFactories;
  }
  private static ProxiFactory [] getTheProxiFactories(){
	if (proxiFactories == null){
		proxiFactories = new ProxiFactory [48];
        proxiFactories[0] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new MProductTypeProxi(objectId);
            }
        };
        proxiFactories[17] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new TypeManagerProxi(objectId);
            }
        };
        proxiFactories[18] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CommandExecuterProxi(objectId);
            }
        };
        proxiFactories[43] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateHierarchyCommandProxi(objectId);
            }
        };
        proxiFactories[25] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new AspectManagerProxi(objectId);
            }
        };
        proxiFactories[44] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new AddToHierarchyCommandProxi(objectId);
            }
        };
        proxiFactories[3] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new ErrorDisplayProxi(objectId);
            }
        };
        proxiFactories[32] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new AddSubTypeCommandProxi(objectId);
            }
        };
        proxiFactories[35] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new MFalseProxi(objectId);
            }
        };
        proxiFactories[4] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new ServerProxi(objectId);
            }
        };
        proxiFactories[40] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new AssociationManagerProxi(objectId);
            }
        };
        proxiFactories[1] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new MAtomicTypeProxi(objectId);
            }
        };
        proxiFactories[38] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateAspectCommandProxi(objectId);
            }
        };
        proxiFactories[39] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateAtomicTypeCommandProxi(objectId);
            }
        };
        proxiFactories[41] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new MAHierarchyProxi(objectId);
            }
        };
        proxiFactories[19] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CommandCoordinatorProxi(objectId);
            }
        };
        proxiFactories[26] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new MAspectProxi(objectId);
            }
        };
        proxiFactories[20] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CommonDateProxi(objectId);
            }
        };
        proxiFactories[2] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new MSumTypeProxi(objectId);
            }
        };
        proxiFactories[42] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new MAssociationProxi(objectId);
            }
        };
        proxiFactories[45] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateAssociationCommandProxi(objectId);
            }
        };
        proxiFactories[34] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateSubTypeCommandProxi(objectId);
            }
        };
        proxiFactories[36] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new MBooleanProxi(objectId);
            }
        };
        proxiFactories[37] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new MTrueProxi(objectId);
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
