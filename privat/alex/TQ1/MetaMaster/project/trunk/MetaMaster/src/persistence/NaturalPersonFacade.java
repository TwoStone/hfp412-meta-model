package persistence;

import model.*;

public class NaturalPersonFacade{



	public NaturalPersonFacade() {
	}

    public NaturalPersonProxi newNaturalPerson(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theActorFacade.getNextId();
        NaturalPerson result = new NaturalPerson(name,null,id);
        Cache.getTheCache().put(result);
        return (NaturalPersonProxi)PersistentProxi.createProxi(id, 119);
    }
    
    public NaturalPerson getNaturalPerson(long NaturalPersonId) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

