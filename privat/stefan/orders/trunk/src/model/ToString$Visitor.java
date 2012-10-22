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
	public void handleCustomer(PersistentCustomer customer)
			throws PersistenceException {
		result = "Kunde";
		
	}
	@Override
	public void handleActorManager(PersistentActorManager actorManager)
			throws PersistenceException {
		result = "Akteure";
		
	}
	@Override
	public void handleSupplier(PersistentSupplier supplier)
			throws PersistenceException {
		result = "Lieferant";
		
	}
	@Override
	public void handleActor(PersistentActor actor) throws PersistenceException {
		result = actor.getName();
		
	}
	@Override
	public void handleServer(PersistentServer server)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}

}
