package persistence;



public class AbsUnitTypeFacade{

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

	

	public AbsUnitTypeFacade() {
	}

    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 165)) return 165;
        if(Cache.getTheCache().contains(objectId, 152)) return 152;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public AbsUnitTypeSearchList getAbsUnitTypeByName(String name) throws PersistenceException {
        AbsUnitTypeSearchList result = new AbsUnitTypeSearchList();
        java.util.Iterator<?> candidates;
        candidates = Cache.getTheCache().iterator(165);
        while (candidates.hasNext()){
            PersistentAbsUnitType current = (PersistentAbsUnitType)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null && !current.isDltd() && current.getName().equals(name))
                result.add((PersistentAbsUnitType)PersistentProxi.createProxi(current.getId(), current.getClassId()));
        }
        candidates = Cache.getTheCache().iterator(152);
        while (candidates.hasNext()){
            PersistentAbsUnitType current = (PersistentAbsUnitType)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null && !current.isDltd() && current.getName().equals(name))
                result.add((PersistentAbsUnitType)PersistentProxi.createProxi(current.getId(), current.getClassId()));
        }
        return result;
    }
    public void nameSet(long AbsUnitTypeId, String nameVal) throws PersistenceException {
        
    }
    public void ThisSet(long AbsUnitTypeId, PersistentAbsUnitType ThisVal) throws PersistenceException {
        
    }

}

