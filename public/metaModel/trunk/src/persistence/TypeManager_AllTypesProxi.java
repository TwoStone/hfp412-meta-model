package persistence;

import model.*;
import java.util.Hashtable;

public class TypeManager_AllTypesProxi {

	@SuppressWarnings("unused")
	private TypeManager owner;

	private Hashtable<PersistentMSumType, MType> data;

	public TypeManager_AllTypesProxi(TypeManager owner) {
		this.owner = owner;
		this.data = new Hashtable<PersistentMSumType, MType>();
	}

	public synchronized void put(PersistentMSumType key, MType entry) throws PersistenceException {
		if (key == null) throw new PersistenceException("Null not allowed for map keys!",0);
		if (entry == null) throw new PersistenceException("Null not allowed for map values!", 0);
		
		this.data.put(key, entry);
		
	}

	public synchronized MType get(PersistentMSumType key) throws PersistenceException {
		MType result = this.data.get(key);
		return result;
	}

	public synchronized void remove(PersistentMSumType key) throws PersistenceException {
		
		this.data.remove(key);
	}

	@SuppressWarnings("unchecked")
	public TypeManager_AllTypesProxi copy(TypeManager owner) throws PersistenceException {
		TypeManager_AllTypesProxi result = new TypeManager_AllTypesProxi(owner);
		result.data = (Hashtable<PersistentMSumType, MType>) this.data.clone();
		return result;
	}
	public MTypeSearchList getValues() throws PersistenceException {
		MTypeSearchList result = new MTypeSearchList();
		java.util.Iterator<MType> values = this.data.values().iterator();
		while (values.hasNext()) {
			MType current = values.next();
			result.add(current);
		}
		return result;
	}
	public void store(){}	
}
