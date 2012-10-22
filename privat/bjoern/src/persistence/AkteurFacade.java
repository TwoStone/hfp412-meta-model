package persistence;

import model.*;

public class AkteurFacade{

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

	

	public AkteurFacade() {
	}

    public AkteurProxi newAkteur(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theAkteurFacade.getNextId();
        Akteur result = new Akteur(name,null,id);
        Cache.getTheCache().put(result);
        return (AkteurProxi)PersistentProxi.createProxi(id, 111);
    }
    
    public Akteur getAkteur(long AkteurId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 111)) return 111;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public AkteurSearchList getAkteurByName(String name) throws PersistenceException {
        AkteurSearchList result = new AkteurSearchList();
        java.util.Iterator candidates;
        candidates = Cache.getTheCache().iterator(111);
        while (candidates.hasNext()){
            PersistentAkteur current = (PersistentAkteur)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null && !current.isDltd() && current.getName().equals(name))
                result.add((PersistentAkteur)PersistentProxi.createProxi(current.getId(), current.getClassId()));
        }
        return result;
    }
    public void nameSet(long AkteurId, String nameVal) throws PersistenceException {
        
    }
    public void ThisSet(long AkteurId, PersistentAkteur ThisVal) throws PersistenceException {
        
    }

}

