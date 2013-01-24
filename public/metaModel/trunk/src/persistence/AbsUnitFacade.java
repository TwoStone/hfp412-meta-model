package persistence;



public class AbsUnitFacade{

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

	

	public AbsUnitFacade() {
	}

    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 123)) return 123;
        if(Cache.getTheCache().contains(objectId, 143)) return 143;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public AbsUnitSearchList getAbsUnitByName(String name) throws PersistenceException {
        AbsUnitSearchList result = new AbsUnitSearchList();
        java.util.Iterator<?> candidates;
        candidates = Cache.getTheCache().iterator(123);
        while (candidates.hasNext()){
            PersistentAbsUnit current = (PersistentAbsUnit)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null && !current.isDltd() && current.getName().equals(name))
                result.add((PersistentAbsUnit)PersistentProxi.createProxi(current.getId(), current.getClassId()));
        }
        candidates = Cache.getTheCache().iterator(143);
        while (candidates.hasNext()){
            PersistentAbsUnit current = (PersistentAbsUnit)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null && !current.isDltd() && current.getName().equals(name))
                result.add((PersistentAbsUnit)PersistentProxi.createProxi(current.getId(), current.getClassId()));
        }
        return result;
    }
    public void typeSet(long AbsUnitId, PersistentAbsUnitType typeVal) throws PersistenceException {
        
    }
    public void nameSet(long AbsUnitId, String nameVal) throws PersistenceException {
        
    }
    public void ThisSet(long AbsUnitId, PersistentAbsUnit ThisVal) throws PersistenceException {
        
    }

}

