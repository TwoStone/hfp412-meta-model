package model.typeSystem;

import persistence.Anything;
import persistence.PersistenceException;
import persistence.PersistentMAbstractSumType;
import persistence.PersistentMType;
import persistence.TDObserver;

/* Additional import section end */

public abstract class MAbstractSumType extends model.typeSystem.MComplexType implements PersistentMAbstractSumType{
    
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public abstract MAbstractSumType provideCopy() throws PersistenceException;
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public MAbstractSumType(PersistentMType This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentMType)This,id);        
    }
    
    static public long getTypeId() {
        return 104;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        super.store();
        
    }
    
    public abstract PersistentMAbstractSumType getThis() throws PersistenceException ;
    
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
		// TODO: implement method: initializeOnInstantiation

	}
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
		// TODO: implement method: copyingPrivateUserAttributes

	}
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentMAbstractSumType)This);
		if(this.equals(This)){
		}
    }
    public void initializeOnCreation() 
				throws PersistenceException{
		// TODO: implement method: initializeOnCreation

	}
    public String fetchTypeLinkOperator() 
				throws PersistenceException{
		return MAbstractSumType.TYPE_LINK_OPERATOR;
	}

    /* Start of protected part that is not overridden by persistence generator */
	public static String TYPE_LINK_OPERATOR = "++";
	/* End of protected part that is not overridden by persistence generator */
    
}
