package persistence;

import model.abstractOperation.*;

public class FormalParameterFacade{

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

	

	public FormalParameterFacade() {
	}

    public FormalParameterProxi newFormalParameter(String name,long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (FormalParameterProxi)PersistentProxi.createProxi(createMinusStorePlus, 119);
        long id = ConnectionHandler.getTheConnectionHandler().theFormalParameterFacade.getNextId();
        FormalParameter result = new FormalParameter(null,name,null,id);
        Cache.getTheCache().put(result);
        return (FormalParameterProxi)PersistentProxi.createProxi(id, 119);
    }
    
    public FormalParameterProxi newDelayedFormalParameter(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theFormalParameterFacade.getNextId();
        FormalParameter result = new FormalParameter(null,name,null,id);
        Cache.getTheCache().put(result);
        return (FormalParameterProxi)PersistentProxi.createProxi(id, 119);
    }
    
    public FormalParameter getFormalParameter(long FormalParameterId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 119)) return 119;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public FormalParameterSearchList getFormalParameterByName(String name) throws PersistenceException {
        FormalParameterSearchList result = new FormalParameterSearchList();
        java.util.Iterator<?> candidates;
        candidates = Cache.getTheCache().iterator(119);
        while (candidates.hasNext()){
            PersistentFormalParameter current = (PersistentFormalParameter)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null && !current.isDltd() && current.getName().equals(name))
                result.add((PersistentFormalParameter)PersistentProxi.createProxi(current.getId(), current.getClassId()));
        }
        return result;
    }
    public void ofTypeSet(long FormalParameterId, PersistentMType ofTypeVal) throws PersistenceException {
        
    }
    public void nameSet(long FormalParameterId, String nameVal) throws PersistenceException {
        
    }
    public void ThisSet(long FormalParameterId, PersistentFormalParameter ThisVal) throws PersistenceException {
        
    }

}

