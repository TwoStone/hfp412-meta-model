
package model;

import java.util.Iterator;

import persistence.*;


/* Additional import section end */

public abstract class MComplexType extends PersistentObject implements PersistentMComplexType{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentMComplexType getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theMComplexTypeFacade.getClass(objectId);
        return (PersistentMComplexType)PersistentProxi.createProxi(objectId, classId);
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("containedTypes", this.getContainedTypes().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false));
            result.put("TypeLinkOperator", this.getTypeLinkOperator());
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public abstract MComplexType provideCopy() throws PersistenceException;
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected MComplexType_ContainedTypesProxi containedTypes;
    protected PersistentMComplexType This;
    
    public MComplexType(PersistentMComplexType This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.containedTypes = new MComplexType_ContainedTypesProxi(this);
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 106;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        super.store();
        this.getContainedTypes().store();
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theMComplexTypeFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public MComplexType_ContainedTypesProxi getContainedTypes() throws PersistenceException {
        return this.containedTypes;
    }
    protected void setThis(PersistentMComplexType newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentMComplexType)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theMComplexTypeFacade.ThisSet(this.getId(), newValue);
        }
    }
    public abstract PersistentMComplexType getThis() throws PersistenceException ;
    
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentMComplexType)This);
		if(this.equals(This)){
		}
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }
    public String fetchName() 
				throws PersistenceException{
	StringBuilder result = new StringBuilder();
    	
    	Iterator<MType> i = getThis().getContainedTypes().iterator();
    	
    	while (i.hasNext()) {
    		MType currentSubType = i.next(); 
    		result.append(
    		currentSubType.accept(new model.visitor.MTypeReturnVisitor<String>() {

    			@Override
    			public String handleMProductType(PersistentMProductType mProductType)
    					throws PersistenceException {
    				return "("+mProductType.fetchName()+")";
    			}

    			@Override
    			public String handleMSumType(PersistentMSumType mSumType)
    					throws PersistenceException {
    				return "("+mSumType.fetchName()+")";
    			}

    			@Override
    			public String handleMAtomicType(PersistentMAtomicType mAtomicType)
    						throws PersistenceException {
    				return mAtomicType.fetchName();
    			}
    		}));
    		
    		if (i.hasNext()) {
    			result.append(" "+getThis().getTypeLinkOperator()+" ");
    		}
    	}
		return result.toString();
    }
    public MAssociationSearchList fetchAssociations() 
				throws PersistenceException{
    	SearchListRoot<PersistentMAssociation> result = AssociationManager.getTheAssociationManager().getAssociations().findAll(new Predcate<PersistentMAssociation>() {
			
			@Override
			public boolean test(PersistentMAssociation argument)
					throws PersistenceException {
				return getThis().isLessOrEqual(argument.getSource()).toBoolean();
			}
		});
    	return new MAssociationSearchList(result);
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
