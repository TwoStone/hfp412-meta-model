package persistence;



public class RolleFacade{

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

	

	public RolleFacade() {
	}

    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 121)) return 121;
        if(Cache.getTheCache().contains(objectId, 122)) return 122;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void rolleFuerSet(long RolleId, PersistentAkteur rolleFuerVal) throws PersistenceException {
        
    }
    public void ThisSet(long RolleId, PersistentRolle ThisVal) throws PersistenceException {
        
    }
    public RolleSearchList inverseGetRolleFuer(long objectId, long classId)throws PersistenceException{
        RolleSearchList result = new RolleSearchList();
        java.util.Iterator candidates;
        candidates = Cache.getTheCache().iterator(121);
        while (candidates.hasNext()){
            PersistentRolle current = (PersistentRolle)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null && !current.isDltd() && current.getRolleFuer() != null){
                if (current.getRolleFuer().getClassId() == classId && current.getRolleFuer().getId() == objectId) {
                    PersistentRolle proxi = (PersistentRolle)PersistentProxi.createProxi(current.getId(), current.getClassId());
                    result.add((PersistentRolle)proxi.getThis());
                }
            }
        }
        candidates = Cache.getTheCache().iterator(122);
        while (candidates.hasNext()){
            PersistentRolle current = (PersistentRolle)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null && !current.isDltd() && current.getRolleFuer() != null){
                if (current.getRolleFuer().getClassId() == classId && current.getRolleFuer().getId() == objectId) {
                    PersistentRolle proxi = (PersistentRolle)PersistentProxi.createProxi(current.getId(), current.getClassId());
                    result.add((PersistentRolle)proxi.getThis());
                }
            }
        }
        return result;
    }

}

