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
        if(Cache.getTheCache().contains(objectId, 123)) return 123;
        if(Cache.getTheCache().contains(objectId, 130)) return 130;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void roleForSet(long RoleId, PersistentActor roleForVal) throws PersistenceException {
        
    }
    public void ThisSet(long RoleId, PersistentRole ThisVal) throws PersistenceException {
        
    }
    public RoleSearchList inverseGetRoleFor(long objectId, long classId)throws PersistenceException{
        RoleSearchList result = new RoleSearchList();
        java.util.Iterator candidates;
        candidates = Cache.getTheCache().iterator(123);
        while (candidates.hasNext()){
            PersistentRole current = (PersistentRole)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null && !current.isDltd() && current.getRoleFor() != null){
                if (current.getRoleFor().getClassId() == classId && current.getRoleFor().getId() == objectId) {
                    PersistentRole proxi = (PersistentRole)PersistentProxi.createProxi(current.getId(), current.getClassId());
                    result.add((PersistentRole)proxi.getThis());
                }
            }
        }
        candidates = Cache.getTheCache().iterator(130);
        while (candidates.hasNext()){
            PersistentRole current = (PersistentRole)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null && !current.isDltd() && current.getRoleFor() != null){
                if (current.getRoleFor().getClassId() == classId && current.getRoleFor().getId() == objectId) {
                    PersistentRole proxi = (PersistentRole)PersistentProxi.createProxi(current.getId(), current.getClassId());
                    result.add((PersistentRole)proxi.getThis());
                }
            }
        }
        return result;
    }

}

