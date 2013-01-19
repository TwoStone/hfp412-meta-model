package persistence;



public class AbsOperationFacade{

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

	

	public AbsOperationFacade() {
	}

    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 146)) return 146;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public AbsOperationSearchList getAbsOperationByName(String name) throws PersistenceException {
        AbsOperationSearchList result = new AbsOperationSearchList();
        java.util.Iterator<?> candidates;
        candidates = Cache.getTheCache().iterator(146);
        while (candidates.hasNext()){
            PersistentAbsOperation current = (PersistentAbsOperation)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null && !current.isDltd() && current.getName().equals(name))
                result.add((PersistentAbsOperation)PersistentProxi.createProxi(current.getId(), current.getClassId()));
        }
        return result;
    }
    public void nameSet(long AbsOperationId, String nameVal) throws PersistenceException {
        
    }
    public void sourceSet(long AbsOperationId, PersistentMType sourceVal) throws PersistenceException {
        
    }
    public void targetSet(long AbsOperationId, PersistentMType targetVal) throws PersistenceException {
        
    }
    public long parametersAdd(long AbsOperationId, PersistentFormalParameter parametersVal) throws PersistenceException {
        return 0;
    }
    public void parametersRem(long parametersId) throws PersistenceException {
        
    }
    public FormalParameterList parametersGet(long AbsOperationId) throws PersistenceException {
        return new FormalParameterList(); // remote access for initialization only!
    }
    public void ThisSet(long AbsOperationId, PersistentAbsOperation ThisVal) throws PersistenceException {
        
    }

}

