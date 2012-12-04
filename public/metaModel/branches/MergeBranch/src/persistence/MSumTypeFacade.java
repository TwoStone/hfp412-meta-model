package persistence;

import model.*;

public class MSumTypeFacade{



	public MSumTypeFacade() {
	}

    public MSumTypeProxi newMSumType(long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (MSumTypeProxi)PersistentProxi.createProxi(createMinusStorePlus, 103);
        long id = ConnectionHandler.getTheConnectionHandler().theMComplexTypeFacade.getNextId();
        MSumType result = new MSumType(null,id);
        Cache.getTheCache().put(result);
        return (MSumTypeProxi)PersistentProxi.createProxi(id, 103);
    }
    
    public MSumTypeProxi newDelayedMSumType() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theMComplexTypeFacade.getNextId();
        MSumType result = new MSumType(null,id);
        Cache.getTheCache().put(result);
        return (MSumTypeProxi)PersistentProxi.createProxi(id, 103);
    }
    
    public MSumType getMSumType(long MSumTypeId) throws PersistenceException{
        return null; //All data is in the cache!
    }

}
