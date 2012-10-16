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
	public void handleCustomer(PersistentCustomer customer)
			throws PersistenceException {
		result = "Kunde";
	}
	@Override
	public void handleActorManager(PersistentActorManager actorManager)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleProduct(PersistentProduct product)
			throws PersistenceException {
		result = product.getName();
	}
	@Override
	public void handleJuristicPerson(PersistentJuristicPerson juristicPerson)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleOrder(PersistentOrder order) throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleNaturalPerson(PersistentNaturalPerson naturalPerson)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleSupplier(PersistentSupplier supplier)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleActor(PersistentActor actor) throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handlePosition(PersistentPosition position)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}


}
