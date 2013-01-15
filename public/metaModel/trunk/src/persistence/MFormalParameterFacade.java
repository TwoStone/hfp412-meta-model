package persistence;

import model.*;

public class MFormalParameterFacade{

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

	

	public MFormalParameterFacade() {
	}

    public MFormalParameterProxi newMFormalParameter(String name,long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (MFormalParameterProxi)PersistentProxi.createProxi(createMinusStorePlus, 201);
        long id = ConnectionHandler.getTheConnectionHandler().theMFormalParameterFacade.getNextId();
        MFormalParameter result = new MFormalParameter(null,name,null,id);
        Cache.getTheCache().put(result);
        return (MFormalParameterProxi)PersistentProxi.createProxi(id, 201);
    }
    
    public MFormalParameterProxi newDelayedMFormalParameter(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theMFormalParameterFacade.getNextId();
        MFormalParameter result = new MFormalParameter(null,name,null,id);
        Cache.getTheCache().put(result);
        return (MFormalParameterProxi)PersistentProxi.createProxi(id, 201);
    }
    
    public MFormalParameter getMFormalParameter(long MFormalParameterId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 201)) return 201;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public MFormalParameterSearchList getMFormalParameterByName(String name) throws PersistenceException {
        MFormalParameterSearchList result = new MFormalParameterSearchList();
        java.util.Iterator<?> candidates;
        candidates = Cache.getTheCache().iterator(201);
        while (candidates.hasNext()){
            PersistentMFormalParameter current = (PersistentMFormalParameter)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null && !current.isDltd() && current.getName().equals(name))
                result.add((PersistentMFormalParameter)PersistentProxi.createProxi(current.getId(), current.getClassId()));
        }
        return result;
    }
    public void ofTypeSet(long MFormalParameterId, PersistentMType ofTypeVal) throws PersistenceException {
        
    }
    public void nameSet(long MFormalParameterId, String nameVal) throws PersistenceException {
        
    }
    public void ThisSet(long MFormalParameterId, PersistentMFormalParameter ThisVal) throws PersistenceException {
        
    }

}

