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
        if(Cache.getTheCache().contains(objectId, 113)) return 113;
        if(Cache.getTheCache().contains(objectId, 182)) return 182;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public AbsUnitTypeSearchList getAbsUnitTypeByName(String name) throws PersistenceException {
        AbsUnitTypeSearchList result = new AbsUnitTypeSearchList();
        java.util.Iterator<?> candidates;
        candidates = Cache.getTheCache().iterator(113);
        while (candidates.hasNext()){
            PersistentAbsUnitType current = (PersistentAbsUnitType)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null && !current.isDltd() && current.getName().equals(name))
                result.add((PersistentAbsUnitType)PersistentProxi.createProxi(current.getId(), current.getClassId()));
        }
        candidates = Cache.getTheCache().iterator(182);
        while (candidates.hasNext()){
            PersistentAbsUnitType current = (PersistentAbsUnitType)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null && !current.isDltd() && current.getName().equals(name))
                result.add((PersistentAbsUnitType)PersistentProxi.createProxi(current.getId(), current.getClassId()));
        }
        return result;
    }
    public void defaultUnitSet(long AbsUnitTypeId, PersistentAbsUnit defaultUnitVal) throws PersistenceException {
        
    }
    public void nameSet(long AbsUnitTypeId, String nameVal) throws PersistenceException {
        
    }
    public void ThisSet(long AbsUnitTypeId, PersistentAbsUnitType ThisVal) throws PersistenceException {
        
    }

}
