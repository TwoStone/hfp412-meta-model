package persistence;



public class MComplexTypeFacade{



	public MComplexTypeFacade() {
	}

    public long containedTypesAdd(long MComplexTypeId, PersistentMType containedTypesVal) throws PersistenceException {
        return 0;
    }
    public void containedTypesRem(long containedTypesId) throws PersistenceException {
        
    }
    public MTypeList containedTypesGet(long MComplexTypeId) throws PersistenceException {
        return new MTypeList(); // remote access for initialization only!
    }

}

