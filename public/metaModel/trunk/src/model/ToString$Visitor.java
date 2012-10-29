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
	public void handleMAtomicType(PersistentMAtomicType mAtomicType)
			throws PersistenceException {
		result = "[AtomicType]: " + mAtomicType.fetchName();
	}
	@Override
	public void handleMProductType(PersistentMProductType mProductType)
			throws PersistenceException {
		result = "[ProductType]: " + mProductType.fetchName(); 
		
	}
	@Override
	public void handleMSumType(PersistentMSumType mSumType)
			throws PersistenceException {
		result = "[SumType]: " + mSumType.fetchName();
	}
	@Override
	public void handleServer(PersistentServer server)
			throws PersistenceException {
		// TODO Auto-generated method stub
	}
	@Override
	public void handleTypeManager(PersistentTypeManager typeManager)
			throws PersistenceException {
		result= "[TypeManager]";
	}

}
