package model;

import persistence.*;

public class ToString$Visitor extends model.visitor.ToString$Visitor {

	private static final boolean DEBUG_MODE_ENABLED = true;
	
	private String result;
	
	public ToString$Visitor() {
	}
	public synchronized String toString(Anything anything) throws PersistenceException {
		this.result = null;
		anything.accept(this);
		if (this.result == null) {
			this.standardHandling(anything);
		}
		if (DEBUG_MODE_ENABLED) {
			this.result += " [# " + anything.getId() + " @ " + anything.getClassId() + "]";
		}
		return this.result;
	}
	protected void standardHandling(Anything anything) {
		this.result = anything.getClassId() + ";" + anything.getId();
	}
	@Override
	public void handleServer(PersistentServer server)
			throws PersistenceException {
		
	}
	@Override
	public void handleCustomer(PersistentCustomer customer)
			throws PersistenceException {
		this.result = "Kunde";
	}
	@Override
	public void handleActorManager(PersistentActorManager actorManager)
			throws PersistenceException {
		this.result = "Personenliste";
	}
	@Override
	public void handleProduct(PersistentProduct product)
			throws PersistenceException {
		this.result = "Produkt";
	}
	@Override
	public void handleJuristicPerson(PersistentJuristicPerson juristicPerson)
			throws PersistenceException {
		this.result = "Juristische Person";
	}
	@Override
	public void handleOrder(PersistentOrder order) throws PersistenceException {
		this.result = "Bestellung";
	}
	@Override
	public void handleNaturalPerson(PersistentNaturalPerson naturalPerson)
			throws PersistenceException {
		this.result = "Natürliche Person";
	}
	@Override
	public void handleSupplier(PersistentSupplier supplier)
			throws PersistenceException {
		this.result = "Lieferant";
	}
	@Override
	public void handleOrderItem(PersistentOrderItem position)
			throws PersistenceException {
		this.result = "Position";
	}
}
