package model;

import persistence.*;

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
	protected void standardHandling(Anything anything) {
		result = anything.getClassId() + ";" + anything.getId();
	}
	@Override
	public void handleServer(PersistentServer server)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleFraction(PersistentFraction fraction)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleConversionRate(PersistentConversionRate conversionRate)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleQuantity(PersistentQuantity quantity)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleTypeReference(PersistentTypeReference typeReference)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleCompoundUnitType(
			PersistentCompoundUnitType compoundUnitType)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleCompoundUnit(PersistentCompoundUnit compoundUnit)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleUnit(PersistentUnit unit) throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleUnitReference(PersistentUnitReference unitReference)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleUnitType(PersistentUnitType unitType)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleComposedQuantity(
			PersistentComposedQuantity composedQuantity)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}

}
