package persistence;

import model.*;

public class TypeReferenceFacade{



	public TypeReferenceFacade() {
	}

    public TypeReferenceProxi newTypeReference() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theAbsUnitTypeFacade.getNextId();
        TypeReference result = new TypeReference(null,id);
        Cache.getTheCache().put(result);
        return (TypeReferenceProxi)PersistentProxi.createProxi(id, 113);
    }
    
    public TypeReference getTypeReference(long TypeReferenceId) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

