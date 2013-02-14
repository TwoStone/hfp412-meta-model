package model.typeSystem;

import java.util.Iterator;

import model.basic.MFalse;
import persistence.Anything;
import persistence.MTypeSearchList;
import persistence.PersistenceException;
import persistence.PersistentMAbstractTypeDisjunction;
import persistence.PersistentMBoolean;
import persistence.PersistentMType;
import persistence.TDObserver;
import utils.SearchLists;

/* Additional import section end */

public abstract class MAbstractTypeDisjunction extends model.typeSystem.MComplexType implements PersistentMAbstractTypeDisjunction{
    
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public abstract MAbstractTypeDisjunction provideCopy() throws PersistenceException;
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public MAbstractTypeDisjunction(PersistentMType This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentMType)This,id);        
    }
    
    static public long getTypeId() {
        return 305;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        super.store();
        
    }
    
    public abstract PersistentMAbstractTypeDisjunction getThis() throws PersistenceException ;
    
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
	}
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
	}
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentMAbstractTypeDisjunction)This);
		if(this.equals(This)){
		}
    }
    public void initializeOnCreation() 
				throws PersistenceException{
	}
    public String fetchName() 
				throws PersistenceException{
		StringBuilder builder = new StringBuilder();

		builder.append("{");
		Iterator<PersistentMType> iterator = this.getContainedTypes().iterator();
		if (iterator.hasNext()) {
			builder.append(iterator.next().fetchName());
		}

		while (iterator.hasNext()) {
			PersistentMType persistentMType = iterator.next();
			builder.append(this.getThis().fetchTypeLinkOperator());
			builder.append(persistentMType.fetchName());
		}

		builder.append("}");

		return builder.toString();
	}
    public PersistentMBoolean isStructuralEquivalant(final PersistentMType other) 
				throws PersistenceException{
		if (other instanceof PersistentMAbstractTypeDisjunction) {
			return allChildrenAreStructuralEquivalent((PersistentMAbstractTypeDisjunction) other);
		}
		return MFalse.getTheMFalse();
	}
    public MTypeSearchList getContainedTypes() 
				throws PersistenceException{
		return SearchLists.toMTypeSearchList(fetchContainedTypes());
	}
    public String fetchTypeLinkOperator() 
				throws PersistenceException{
		return MAbstractTypeDisjunction.TYPE_LINK_OP;
	}
    public PersistentMBoolean isSingleton() 
				throws PersistenceException{
		// TODO: implement method: isSingleton
		try {
			throw new java.lang.UnsupportedOperationException("Method \"isSingleton\" not implemented yet.");
		} catch (java.lang.UnsupportedOperationException uoe) {
			uoe.printStackTrace();
			throw uoe;
		}
	}
    public PersistentMBoolean isAbstract() 
				throws PersistenceException{
		// TODO: implement method: isAbstract
		try {
			throw new java.lang.UnsupportedOperationException("Method \"isAbstract\" not implemented yet.");
		} catch (java.lang.UnsupportedOperationException uoe) {
			uoe.printStackTrace();
			throw uoe;
		}
	}

    /* Start of protected part that is not overridden by persistence generator */
	public static String TYPE_LINK_OP = "++";
	/* End of protected part that is not overridden by persistence generator */
    
}
