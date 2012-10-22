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
	public void handleTransactionManager(
			PersistentTransactionManager transactionManager)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleAuftrag(PersistentAuftrag auftrag)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleServer(PersistentServer server)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleKunde(PersistentKunde kunde) throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleAkteur(PersistentAkteur akteur)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handlePosition(PersistentPosition position)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleLieferant(PersistentLieferant lieferant)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleProdukt(PersistentProdukt produkt)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}

}
