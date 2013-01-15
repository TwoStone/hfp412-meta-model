package persistence;

import model.measurement.*;

public class MMeasurementTypeFacade{



	public MMeasurementTypeFacade() {
	}

    public MMeasurementTypeProxi newMMeasurementType(long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (MMeasurementTypeProxi)PersistentProxi.createProxi(createMinusStorePlus, 193);
        long id = ConnectionHandler.getTheConnectionHandler().theMQuantiObjectTypeFacade.getNextId();
        MMeasurementType result = new MMeasurementType(null,null,null,id);
        Cache.getTheCache().put(result);
        return (MMeasurementTypeProxi)PersistentProxi.createProxi(id, 193);
    }
    
    public MMeasurementTypeProxi newDelayedMMeasurementType() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theMQuantiObjectTypeFacade.getNextId();
        MMeasurementType result = new MMeasurementType(null,null,null,id);
        Cache.getTheCache().put(result);
        return (MMeasurementTypeProxi)PersistentProxi.createProxi(id, 193);
    }
    
    public MMeasurementType getMMeasurementType(long MMeasurementTypeId) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

