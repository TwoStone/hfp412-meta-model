package persistence;

import model.*;

public class LieferantFacade{



	public LieferantFacade() {
	}

    public LieferantProxi newLieferant() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theRolleFacade.getNextId();
        Lieferant result = new Lieferant(null,null,id);
        Cache.getTheCache().put(result);
        return (LieferantProxi)PersistentProxi.createProxi(id, 121);
    }
    
    public Lieferant getLieferant(long LieferantId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long portfolioAdd(long LieferantId, PersistentProdukt portfolioVal) throws PersistenceException {
        return 0;
    }
    public void portfolioRem(long portfolioId) throws PersistenceException {
        
    }
    public ProduktList portfolioGet(long LieferantId) throws PersistenceException {
        return new ProduktList(); // remote access for initialization only!
    }

}

