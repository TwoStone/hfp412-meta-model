package model.typeSystem;

import java.util.Iterator;

import model.basic.MFalse;
import model.basic.MTrue;
import persistence.Anything;
import persistence.PersistenceException;
import persistence.PersistentMBoolean;
import persistence.PersistentMNonEmptyProductType;
import persistence.PersistentMType;
import persistence.TDObserver;

/* Additional import section end */

public abstract class MNonEmptyProductType extends model.typeSystem.MAbstractProductType implements PersistentMNonEmptyProductType{
    
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public abstract MNonEmptyProductType provideCopy() throws PersistenceException;
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public MNonEmptyProductType(PersistentMType This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentMType)This,id);        
    }
    
    static public long getTypeId() {
        return 277;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        super.store();
        
    }
    
    public abstract PersistentMNonEmptyProductType getThis() throws PersistenceException ;
    
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
	}
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
	}
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentMNonEmptyProductType)This);
		if(this.equals(This)){
		}
    }
    public void initializeOnCreation() 
				throws PersistenceException{
	}
    public PersistentMBoolean isSingleton() 
				throws PersistenceException{
		Iterator<PersistentMType> i = getThis().getContainedTypes().iterator();

		while (i.hasNext()) {
			if (!i.next().isSingleton().toBoolean()) {
				return MFalse.getTheMFalse();
			}
		}
		return MTrue.getTheMTrue();
	}
    public PersistentMBoolean isAbstract() 
				throws PersistenceException{
		Iterator<PersistentMType> i = getThis().getContainedTypes().iterator();

		while (i.hasNext()) {
			if (i.next().isAbstract().toBoolean()) {
				return MTrue.getTheMTrue();
			}
		}
		return MFalse.getTheMFalse();

	}

    /* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */
    
}
