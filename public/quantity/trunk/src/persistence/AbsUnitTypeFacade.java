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
        if(Cache.getTheCache().contains(objectId, 112)) return 112;
        if(Cache.getTheCache().contains(objectId, 120)) return 120;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public AbsUnitTypeSearchList getAbsUnitTypeByName(String name) throws PersistenceException {
        AbsUnitTypeSearchList result = new AbsUnitTypeSearchList();
        java.util.Iterator<?> candidates;
        candidates = Cache.getTheCache().iterator(112);
        while (candidates.hasNext()){
            PersistentAbsUnitType current = (PersistentAbsUnitType)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null && !current.isDltd() && current.getName().equals(name))
                result.add((PersistentAbsUnitType)PersistentProxi.createProxi(current.getId(), current.getClassId()));
        }
        candidates = Cache.getTheCache().iterator(120);
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

