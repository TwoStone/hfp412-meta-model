package persistence;

import model.*;

public class AuftragFacade{

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

	

	public AuftragFacade() {
	}

    public AuftragProxi newAuftrag() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theAuftragFacade.getNextId();
        Auftrag result = new Auftrag(null,null,null,id);
        Cache.getTheCache().put(result);
        return (AuftragProxi)PersistentProxi.createProxi(id, 124);
    }
    
    public Auftrag getAuftrag(long AuftragId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 124)) return 124;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void auftraggeberSet(long AuftragId, PersistentKunde auftraggeberVal) throws PersistenceException {
        
    }
    public void auftragnehmerSet(long AuftragId, PersistentLieferant auftragnehmerVal) throws PersistenceException {
        
    }
    public long positionenAdd(long AuftragId, PersistentPosition positionenVal) throws PersistenceException {
        return 0;
    }
    public void positionenRem(long positionenId) throws PersistenceException {
        
    }
    public PositionList positionenGet(long AuftragId) throws PersistenceException {
        return new PositionList(); // remote access for initialization only!
    }
    public void ThisSet(long AuftragId, PersistentAuftrag ThisVal) throws PersistenceException {
        
    }

}

