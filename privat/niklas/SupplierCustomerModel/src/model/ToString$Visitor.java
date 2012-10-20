package model;

import persistence.*;

public class ToString$Visitor extends model.visitor.ToString$Visitor {

	private String result;

	public ToString$Visitor() {
	}
	public synchronized String toString(final Anything anything) throws PersistenceException {
		this.result = null;
		anything.accept(this);
		if (this.result == null) {
			this.standardHandling(anything);
		}
		return this.result;
	}
	@Override
	protected void standardHandling(final Anything anything) {
		this.result = anything.getClassId() + ";" + anything.getId();
	}
	@Override
	public void handleCustomer(final PersistentCustomer customer)
			throws PersistenceException {
		this.result = "Kunde";
	}
	@Override
	public void handleActorManager(final PersistentActorManager actorManager)
			throws PersistenceException {
	}
	@Override
	public void handleProduct(final PersistentProduct product)
			throws PersistenceException {
		this.result = product.getName();
	}
	@Override
	public void handleOrder(final PersistentOrder order) throws PersistenceException {
		this.result = "Auftrag";
	}
	@Override
	public void handleServer(final PersistentServer server)
			throws PersistenceException {
	}
	@Override
	public void handleSupplier(final PersistentSupplier supplier)
			throws PersistenceException {
		this.result = "Lieferant";
	}
	@Override
	public void handleActor(final PersistentActor actor) throws PersistenceException {
		this.result = actor.getName();
	}
	@Override
	public void handlePosition(final PersistentPosition position)
			throws PersistenceException {
		this.result = String.format("%dx %s", position.getQuantity(), position.getProduct().toString(true));
	}

}
