package model.typeSystem;

import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.MNonEmptyDisjunctiveNormalFormSearchList;
import persistence.PersistenceException;
import persistence.PersistentCONCMModelItem;
import persistence.PersistentMAtomicTypeConjunction;
import persistence.PersistentMModelItem;
import persistence.PersistentMType;
import persistence.TDObserver;

/* Additional import section end */

public abstract class MAtomicTypeConjunction extends model.typeSystem.MAbstractTypeConjunction implements PersistentMAtomicTypeConjunction{
    
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("nEDNFContainingMe", this.getNEDNFContainingMe().getVector(allResults, (depth > 1 ? depth : depth + 1), essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public abstract MAtomicTypeConjunction provideCopy() throws PersistenceException;
    
    public boolean hasEssentialFields() throws PersistenceException{
        return true;
    }
    
    public MAtomicTypeConjunction(PersistentMType This,PersistentMModelItem myCONCMModelItem,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentMType)This,(PersistentMModelItem)myCONCMModelItem,id);        
    }
    
    static public long getTypeId() {
        return 311;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        super.store();
        
    }
    
    public abstract PersistentMAtomicTypeConjunction getThis() throws PersistenceException ;
    
    
    
    public MNonEmptyDisjunctiveNormalFormSearchList getNEDNFContainingMe() 
				throws PersistenceException{
        MNonEmptyDisjunctiveNormalFormSearchList result = null;
		if (result == null) result = ConnectionHandler.getTheConnectionHandler().theMNonEmptyDisjunctiveNormalFormFacade
							.inverseGetAddends(this.getId(), this.getClassId());
		return result;
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentMAtomicTypeConjunction)This);
		if(this.equals(This)){
			PersistentCONCMModelItem myCONCMModelItem = model.CONCMModelItem.createCONCMModelItem(this.isDelayed$Persistence(), (PersistentMAtomicTypeConjunction)This);
			this.setMyCONCMModelItem(myCONCMModelItem);
		}
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
	}
    public void initializeOnCreation() 
				throws PersistenceException{
	}
    public void initializeOnInstantiation() 
				throws PersistenceException{
	}
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */
    
}
