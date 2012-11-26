package model;

import persistence.Anything;
import persistence.PersistenceException;
import persistence.PersistentAspectManager;
import persistence.PersistentAssociationManager;
import persistence.PersistentMAHierarchy;
import persistence.PersistentMAspect;
import persistence.PersistentMAssociation;
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
	
	private static final String APPENDIX_OF_PROXIES = "Proxi";
	
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
			result = this.formatClassNameForDebug(anything) + result;
		}
		return result;
	}
	
	private String formatClassNameForDebug(Object anything) {
		if (anything == null)
			return "[null] ";
		
		String className = anything.getClass().getSimpleName();
		
		if (className == null)
			return "[null] ";
		
		if (className.contains("Manager"))
			return "";
		
		if (className.endsWith(APPENDIX_OF_PROXIES)) {
			className = className.substring(0, className.length() - APPENDIX_OF_PROXIES.length());
		}

		return "[" + className + "] ";
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
		result = server.getUser();
	}
	@Override
	public void handleTypeManager(PersistentTypeManager typeManager)
			throws PersistenceException {
		result = "Liste der Typen";
	}
	@Override
	public void handleAspectManager(PersistentAspectManager aspectManager)
			throws PersistenceException {
		result = "Liste der Aspekte";
		
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
		result = "boolean";
	}
	
	@Override
	public void handleMTrue(PersistentMTrue mTrue) throws PersistenceException {
		result = "true";
	}
	@Override
	public void handleAssociationManager(
			PersistentAssociationManager associationManager)
			throws PersistenceException {
		result = "[AM]";
	}
	@Override
	public void handleMAHierarchy(PersistentMAHierarchy mAHierarchy)
			throws PersistenceException {
		result = mAHierarchy.getName();
	}
	@Override
	public void handleMAssociation(PersistentMAssociation mAssociation)
			throws PersistenceException {
		result = mAssociation.getName() + " (" + mAssociation.getSource().fetchName() + ")";  
	}
}
