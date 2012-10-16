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
		listProxiFactories = new ListProxiFactory[34];
        listProxiFactories[22] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CustomerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[23] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new ActorManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[13] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CommandExecuterListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[19] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new AddRoleCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[24] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new JuristicPersonListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[25] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new ProductListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[26] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new OrderListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[27] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateActorCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[0] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new ErrorDisplayListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[1] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new ServerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[28] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new NaturalPersonListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[29] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new SupplierListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[14] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CommandCoordinatorListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[30] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new ActorListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[15] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CommonDateListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[32] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new PositionListEntryProxi(objectId, entryId);
            }
        };
	}
	return listProxiFactories;
  }
  private static ProxiFactory [] getTheProxiFactories(){
	if (proxiFactories == null){
		proxiFactories = new ProxiFactory [34];
        proxiFactories[22] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CustomerProxi(objectId);
            }
        };
        proxiFactories[23] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new ActorManagerProxi(objectId);
            }
        };
        proxiFactories[13] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CommandExecuterProxi(objectId);
            }
        };
        proxiFactories[19] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new AddRoleCommandProxi(objectId);
            }
        };
        proxiFactories[24] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new JuristicPersonProxi(objectId);
            }
        };
        proxiFactories[25] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new ProductProxi(objectId);
            }
        };
        proxiFactories[26] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new OrderProxi(objectId);
            }
        };
        proxiFactories[27] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateActorCommandProxi(objectId);
            }
        };
        proxiFactories[0] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new ErrorDisplayProxi(objectId);
            }
        };
        proxiFactories[1] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new ServerProxi(objectId);
            }
        };
        proxiFactories[28] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new NaturalPersonProxi(objectId);
            }
        };
        proxiFactories[29] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new SupplierProxi(objectId);
            }
        };
        proxiFactories[14] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CommandCoordinatorProxi(objectId);
            }
        };
        proxiFactories[30] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new ActorProxi(objectId);
            }
        };
        proxiFactories[15] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CommonDateProxi(objectId);
            }
        };
        proxiFactories[32] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new PositionProxi(objectId);
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
