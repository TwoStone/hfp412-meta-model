package persistence;



public class MAbsOperationFacade{

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

	

	public MAbsOperationFacade() {
	}

    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 197)) return 197;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public MAbsOperationSearchList getMAbsOperationByName(String name) throws PersistenceException {
        MAbsOperationSearchList result = new MAbsOperationSearchList();
        java.util.Iterator<?> candidates;
        candidates = Cache.getTheCache().iterator(197);
        while (candidates.hasNext()){
            PersistentMAbsOperation current = (PersistentMAbsOperation)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null && !current.isDltd() && current.getName().equals(name))
                result.add((PersistentMAbsOperation)PersistentProxi.createProxi(current.getId(), current.getClassId()));
        }
        return result;
    }
    public void nameSet(long MAbsOperationId, String nameVal) throws PersistenceException {
        
    }
    public void sourceSet(long MAbsOperationId, PersistentMType sourceVal) throws PersistenceException {
        
    }
    public void targetSet(long MAbsOperationId, PersistentMType targetVal) throws PersistenceException {
        
    }
    public long parametersAdd(long MAbsOperationId, PersistentMFormalParameter parametersVal) throws PersistenceException {
        return 0;
    }
    public void parametersRem(long parametersId) throws PersistenceException {
        
    }
    public MFormalParameterList parametersGet(long MAbsOperationId) throws PersistenceException {
        return new MFormalParameterList(); // remote access for initialization only!
    }
    public void ThisSet(long MAbsOperationId, PersistentMAbsOperation ThisVal) throws PersistenceException {
        
    }

}

