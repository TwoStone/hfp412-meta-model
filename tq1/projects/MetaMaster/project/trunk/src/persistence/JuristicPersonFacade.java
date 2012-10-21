package persistence;

import model.*;

public class JuristicPersonFacade{



	public JuristicPersonFacade() {
	}

    public JuristicPersonProxi newJuristicPerson(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theActorFacade.getNextId();
        JuristicPerson result = new JuristicPerson(name,null,id);
        Cache.getTheCache().put(result);
        return (JuristicPersonProxi)PersistentProxi.createProxi(id, 106);
    }
    
    public JuristicPerson getJuristicPerson(long JuristicPersonId) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

