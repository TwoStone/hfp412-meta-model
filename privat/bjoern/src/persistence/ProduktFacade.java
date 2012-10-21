package persistence;

import model.*;

public class ProduktFacade{

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

	

	public ProduktFacade() {
	}

    public ProduktProxi newProdukt(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theProduktFacade.getNextId();
        Produkt result = new Produkt(name,null,id);
        Cache.getTheCache().put(result);
        return (ProduktProxi)PersistentProxi.createProxi(id, 125);
    }
    
    public Produkt getProdukt(long ProduktId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 125)) return 125;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void nameSet(long ProduktId, String nameVal) throws PersistenceException {
        
    }
    public void ThisSet(long ProduktId, PersistentProdukt ThisVal) throws PersistenceException {
        
    }

}

