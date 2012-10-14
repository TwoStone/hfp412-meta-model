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
        if(Cache.getTheCache().contains(objectId, 111)) return 111;
        if(Cache.getTheCache().contains(objectId, 120)) return 120;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void roleOwnerSet(long RoleId, PersistentActor roleOwnerVal) throws PersistenceException {
        
    }
    public void ThisSet(long RoleId, PersistentRole ThisVal) throws PersistenceException {
        
    }
    public RoleSearchList inverseGetRoleOwner(long objectId, long classId)throws PersistenceException{
        RoleSearchList result = new RoleSearchList();
        java.util.Iterator candidates;
        candidates = Cache.getTheCache().iterator(111);
        while (candidates.hasNext()){
            PersistentRole current = (PersistentRole)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null && !current.isDltd() && current.getRoleOwner() != null){
                if (current.getRoleOwner().getClassId() == classId && current.getRoleOwner().getId() == objectId) {
                    PersistentRole proxi = (PersistentRole)PersistentProxi.createProxi(current.getId(), current.getClassId());
                    result.add((PersistentRole)proxi.getThis());
                }
            }
        }
        candidates = Cache.getTheCache().iterator(120);
        while (candidates.hasNext()){
            PersistentRole current = (PersistentRole)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null && !current.isDltd() && current.getRoleOwner() != null){
                if (current.getRoleOwner().getClassId() == classId && current.getRoleOwner().getId() == objectId) {
                    PersistentRole proxi = (PersistentRole)PersistentProxi.createProxi(current.getId(), current.getClassId());
                    result.add((PersistentRole)proxi.getThis());
                }
            }
        }
        return result;
    }

}

