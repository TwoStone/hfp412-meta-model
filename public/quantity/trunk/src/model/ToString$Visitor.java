package model;

import persistence.Anything;
import persistence.PersistenceException;
import persistence.PersistentCompUnit;
import persistence.PersistentCompUnitType;
import persistence.PersistentCompoundQuantity;
import persistence.PersistentConversion;
import persistence.PersistentConversionManager;
import persistence.PersistentFunction;
import persistence.PersistentQuantity;
import persistence.PersistentQuantityManager;
import persistence.PersistentReference;
import persistence.PersistentReferenceType;
import persistence.PersistentServer;
import persistence.PersistentTransactionFcde;
import persistence.PersistentTypeManager;
import persistence.PersistentUnit;
import persistence.PersistentUnitManager;
import persistence.PersistentUnitType;

public class ToString$Visitor extends model.visitor.ToString$Visitor {

	private String result;
	
	public ToString$Visitor() {
	}
	public synchronized String toString(Anything anything) throws PersistenceException {
		result = null;
		anything.accept(this);
		if (result == null) {
			this.standardHandling(anything);
		}
		return result;
	}
	@Override
	protected void standardHandling(Anything anything) {
		result = anything.getClassId() + ";" + anything.getId();
	}
	@Override
	public void handleTypeManager(PersistentTypeManager typeManager)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleQuantity(PersistentQuantity quantity)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleConversionManager(
			PersistentConversionManager conversionManager)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleTransactionFcde(PersistentTransactionFcde transactionFcde)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleCompoundQuantity(
			PersistentCompoundQuantity compoundQuantity)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleReferenceType(PersistentReferenceType referenceType)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleQuantityManager(PersistentQuantityManager quantityManager)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleUnitType(PersistentUnitType unitType)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleUnit(PersistentUnit unit) throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleServer(PersistentServer server)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleReference(PersistentReference reference)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleConversion(PersistentConversion conversion)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleCompUnit(PersistentCompUnit compUnit)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleUnitManager(PersistentUnitManager unitManager)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleCompUnitType(PersistentCompUnitType compUnitType)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleFunction(PersistentFunction function)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}

}
