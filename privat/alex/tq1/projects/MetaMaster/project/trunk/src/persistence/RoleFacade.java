package persistence;



public class RoleFacade{

	static private Long sequencer = new Long(0);

	static protected long getTheNextId(){
		long result = -1;
		synchronized (sequencer) { 
			result = sequencer.longValue() + 1;
			sequencer = new Long(result);
		}
		return result;
	}

	protected long getNextId(){
		return getTheNextId();
	}

	

	public RoleFacade() {
	}

    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 101)) return 101;
        if(Cache.getTheCache().contains(objectId, 113)) return 113;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void ownerSet(long RoleId, PersistentActor ownerVal) throws PersistenceException {
        
    }
    public void ThisSet(long RoleId, PersistentRole ThisVal) throws PersistenceException {
        
    }
    public RoleSearchList inverseGetOwner(long objectId, long classId)throws PersistenceException{
        RoleSearchList result = new RoleSearchList();
        java.util.Iterator candidates;
        candidates = Cache.getTheCache().iterator(101);
        while (candidates.hasNext()){
            PersistentRole current = (PersistentRole)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null && !current.isDltd() && current.getOwner() != null){
                if (current.getOwner().getClassId() == classId && current.getOwner().getId() == objectId) {
                    PersistentRole proxi = (PersistentRole)PersistentProxi.createProxi(current.getId(), current.getClassId());
                    result.add((PersistentRole)proxi.getThis());
                }
            }
        }
        candidates = Cache.getTheCache().iterator(113);
        while (candidates.hasNext()){
            PersistentRole current = (PersistentRole)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null && !current.isDltd() && current.getOwner() != null){
                if (current.getOwner().getClassId() == classId && current.getOwner().getId() == objectId) {
                    PersistentRole proxi = (PersistentRole)PersistentProxi.createProxi(current.getId(), current.getClassId());
                    result.add((PersistentRole)proxi.getThis());
                }
            }
        }
        return result;
    }

}

