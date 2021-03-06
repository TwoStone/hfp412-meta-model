package model.typeSystem;

import java.util.Iterator;

import model.basic.MBoolean;
import model.basic.MFalse;
import persistence.Anything;
import persistence.MAspectSearchList;
import persistence.MModelItemSearchList;
import persistence.MTypeSearchList;
import persistence.PersistenceException;
import persistence.PersistentCONCMModelItem;
import persistence.PersistentMBoolean;
import persistence.PersistentMComplexType;
import persistence.PersistentMModelItem;
import persistence.PersistentMType;
import persistence.Procdure;
import persistence.SearchListRoot;
import persistence.TDObserver;
import utils.SearchLists;

/* Additional import section end */

public abstract class MComplexType extends model.typeSystem.MType implements PersistentMComplexType{
    
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public abstract MComplexType provideCopy() throws PersistenceException;
    
    public boolean hasEssentialFields() throws PersistenceException{
        return true;
    }
    
    public MComplexType(PersistentMType This,PersistentMModelItem myCONCMModelItem,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentMType)This,(PersistentMModelItem)myCONCMModelItem,id);        
    }
    
    static public long getTypeId() {
        return 103;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        super.store();
        
    }
    
    public abstract PersistentMComplexType getThis() throws PersistenceException ;
    
    
    
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentMComplexType)This);
		if(this.equals(This)){
			PersistentCONCMModelItem myCONCMModelItem = model.CONCMModelItem.createCONCMModelItem(this.isDelayed$Persistence(), (PersistentMComplexType)This);
			this.setMyCONCMModelItem(myCONCMModelItem);
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
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
    
    public MModelItemSearchList fetchAdditionalDependentItems() 
				throws PersistenceException{
		return new MModelItemSearchList();
	}
    public MAspectSearchList fetchAspects() 
				throws PersistenceException{
		final MAspectSearchList result = new MAspectSearchList();
		fetchContainedTypes().applyToAll(new Procdure<PersistentMType>() {

			@Override
			public void doItTo(final PersistentMType argument) throws PersistenceException {
				result.add(argument.fetchAspects());
			}
		});
		return result;
	}
    public MTypeSearchList fetchContainedTypes() 
				throws PersistenceException{
		return SearchLists.toMTypeSearchList(obtainContainedTypes());
	}
    public String fetchName() 
				throws PersistenceException{
		final StringBuilder builder = new StringBuilder();

		builder.append("(");
		final Iterator<PersistentMType> iterator = this.fetchContainedTypes().iterator();
		if (iterator.hasNext()) {
			builder.append(iterator.next().fetchName());
		}

		while (iterator.hasNext()) {
			final PersistentMType persistentMType = iterator.next();
			builder.append(this.getThis().fetchTypeLinkOperator());
			builder.append(persistentMType.fetchName());
		}

		builder.append(")");

		return builder.toString();
	}
    public void prepareForDeletion() 
				throws model.ConsistencyException, PersistenceException{
		// TODO: implement method: prepareForDeletion

	}

    /* Start of protected part that is not overridden by persistence generator */

	protected PersistentMBoolean allChildrenAreStructuralEquivalent(final PersistentMComplexType other) throws PersistenceException {
		final Iterator<PersistentMType> thisI = getThis().fetchContainedTypes().iterator();
		final Iterator<PersistentMType> otherI = other.fetchContainedTypes().iterator();
		while (thisI.hasNext()) {
			if (!otherI.hasNext()) {
				return MFalse.getTheMFalse();
			}
			if (!thisI.next().isStructuralEquivalant(otherI.next()).toBoolean()) {
				return MFalse.getTheMFalse();
			}
		}
		return MBoolean.createFromBoolean(!otherI.hasNext());
	}

	public abstract SearchListRoot<? extends PersistentMType> obtainContainedTypes() throws PersistenceException;

	/* End of protected part that is not overridden by persistence generator */
    
}
