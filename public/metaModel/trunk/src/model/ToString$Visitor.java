package model;

import persistence.Anything;
import persistence.PersistenceException;
import persistence.PersistentAspectManager;
import persistence.PersistentMAspect;
import persistence.PersistentMAtomicType;
import persistence.PersistentMBoolean;
import persistence.PersistentMFalse;
import persistence.PersistentMProductType;
import persistence.PersistentMSumType;
import persistence.PersistentMTrue;
import persistence.PersistentServer;
import persistence.PersistentTypeManager;

public class ToString$Visitor extends model.visitor.ToString$Visitor {

	private static final boolean DEBUG_MODE_ON = true;
	
	private String result;
	
	public ToString$Visitor() {
	}
	public synchronized String toString(Anything anything) throws PersistenceException {
		result = null;
		anything.accept(this);
		if (result == null) {
			this.standardHandling(anything);
		}
		if (DEBUG_MODE_ON) {
			result = "[" + anything.getClass().getName() + "] " + result;
		}
		return result;
	}
	@Override
	protected void standardHandling(Anything anything) {
		result = anything.getClassId() + ";" + anything.getId();
	}
	@Override
	public void handleMAtomicType(PersistentMAtomicType mAtomicType)
			throws PersistenceException {
		result = mAtomicType.fetchName();
	}
	@Override
	public void handleMProductType(PersistentMProductType mProductType)
			throws PersistenceException {
		result = mProductType.fetchName(); 
		
	}
	@Override
	public void handleMSumType(PersistentMSumType mSumType)
			throws PersistenceException {
		result = mSumType.fetchName();
	}
	@Override
	public void handleServer(PersistentServer server)
			throws PersistenceException {
		// TODO Auto-generated method stub
	}
	@Override
	public void handleTypeManager(PersistentTypeManager typeManager)
			throws PersistenceException {
		result = "TypeManager";
	}
	@Override
	public void handleAspectManager(PersistentAspectManager aspectManager)
			throws PersistenceException {
		result = "AspectManager";
		
	}
	@Override
	public void handleMAspect(PersistentMAspect mAspect)
			throws PersistenceException {
		result = mAspect.getName();
	}
	@Override
	public void handleMFalse(PersistentMFalse mFalse)
			throws PersistenceException {
		result = "false";
	}

	@Override
	public void handleMBoolean(PersistentMBoolean mBoolean)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void handleMTrue(PersistentMTrue mTrue) throws PersistenceException {
		result = "true";
	}

}
