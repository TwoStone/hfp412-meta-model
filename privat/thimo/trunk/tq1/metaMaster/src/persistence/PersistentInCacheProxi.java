package persistence;

import java.util.Hashtable;

abstract class ICProxiFactory {
	  abstract PersistentInCacheProxi create(long objectId);
}

public abstract class PersistentInCacheProxi extends PersistentRoot {

	  private static ICProxiFactory [] iCProxiFactories;
		
	  private static ICProxiFactory [] getTheICProxiFactories(){
		if (iCProxiFactories == null){
			iCProxiFactories = new ICProxiFactory[34];
        iCProxiFactories[22] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CustomerICProxi(objectId);
            }
        };
        iCProxiFactories[23] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ActorManagerICProxi(objectId);
            }
        };
        iCProxiFactories[13] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CommandExecuterICProxi(objectId);
            }
        };
        iCProxiFactories[19] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new AddRoleCommandICProxi(objectId);
            }
        };
        iCProxiFactories[24] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new JuristicPersonICProxi(objectId);
            }
        };
        iCProxiFactories[25] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ProductICProxi(objectId);
            }
        };
        iCProxiFactories[26] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new OrderICProxi(objectId);
            }
        };
        iCProxiFactories[27] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CreateActorCommandICProxi(objectId);
            }
        };
        iCProxiFactories[0] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ErrorDisplayICProxi(objectId);
            }
        };
        iCProxiFactories[1] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ServerICProxi(objectId);
            }
        };
        iCProxiFactories[28] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new NaturalPersonICProxi(objectId);
            }
        };
        iCProxiFactories[29] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new SupplierICProxi(objectId);
            }
        };
        iCProxiFactories[14] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CommandCoordinatorICProxi(objectId);
            }
        };
        iCProxiFactories[30] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ActorICProxi(objectId);
            }
        };
        iCProxiFactories[15] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CommonDateICProxi(objectId);
            }
        };
        iCProxiFactories[32] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new PositionICProxi(objectId);
            }
        };
		}
		return iCProxiFactories;
	  }

	public static PersistentInCacheProxi createInCacheProxi(long objectId, long classId) throws PersistenceException {
	    int index = (int) classId;
		if (index < 0) index = index * -1;
	    index = index - 101;
	    if (index > getTheICProxiFactories().length) throw new PersistenceException("Unknown class :" + Long.toString(classId),0);
	    ICProxiFactory factory = getTheICProxiFactories()[index];
	    if (factory == null)  throw new PersistenceException("Unknown class :" + Long.toString(classId),0);
	    PersistentInCacheProxi result =  factory.create(objectId);
	    return result;
	}

	protected PersistentObject object;
  	public int userCount;
	
	protected PersistentInCacheProxi(long id) {
		super(id);
		this.userCount = 0;
	}

	public PersistentInCacheProxi(PersistentObject object) {
		this(object.getId());
	}
	
	public void setId(long id) {
		super.setId(id);
		try {
			this.getTheObject().setId(id);
		} catch (PersistenceException e) {
			throw new PersistenceError(e);
		}
	}
	public Hashtable<String,Object> toHashtable(int depth, int essentialLevel, boolean forGUI, TDObserver tdObserver) throws PersistenceException {
		PersistentRoot object = this.getTheObject();
		if (object == null) return null;
		return object.toHashtable(depth, essentialLevel, forGUI, tdObserver);
	}
	public Hashtable<String, Object> toHashtable(Hashtable<String, Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
		PersistentRoot object = this.getTheObject();
		if (object == null) return null;
		return object.toHashtable(allResults, depth, essentialLevel, forGUI, leaf, tdObserver);
	}

	protected abstract PersistentObject getRemote() throws PersistenceException;

	public synchronized PersistentRoot getTheObject() throws PersistenceException {
		if (this.object == null) this.object = getRemote();
		return this.object;
	}		
	protected synchronized void setObject(PersistentObject object) throws PersistenceException {
		this.object = object;
	}
	protected synchronized void clear() throws PersistenceException {
		this.object = null;
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

	public synchronized void incrementUserCount() {
		this.userCount++;
	}

	public synchronized void decrementUserCount() {
		this.userCount--;
		if (this.isRemovable())Cache.getTheCache().remove(this);
	}

	protected boolean isRemovable() {
		return this.userCount == 0 ;
	}
	public synchronized void tryBreak() {
		this.object = null;
	}
	public boolean hasEssentialFields() throws PersistenceException{
		return this.getTheObject().hasEssentialFields();
	}
	public void delete$Me() throws PersistenceException {
		this.getTheObject().delete$Me();
	}
	
    protected void setDltd() throws PersistenceException {
        this.getTheObject().setDltd();
    }
    public boolean isDltd() throws PersistenceException {
        return this.getTheObject().isDltd();
    }

}
