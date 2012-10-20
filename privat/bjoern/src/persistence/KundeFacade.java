package persistence;

import model.*;

public class KundeFacade{



	public KundeFacade() {
	}

    public KundeProxi newKunde() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theRolleFacade.getNextId();
        Kunde result = new Kunde(null,null,id);
        Cache.getTheCache().put(result);
        return (KundeProxi)PersistentProxi.createProxi(id, 122);
    }
    
    public Kunde getKunde(long KundeId) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

