
package model;

import java.util.Iterator;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class MSumType extends model.MComplexType implements PersistentMSumType{
    
    
    public static PersistentMSumType createMSumType() throws PersistenceException{
        return createMSumType(false);
    }
    
    public static PersistentMSumType createMSumType(boolean delayed$Persistence) throws PersistenceException {
        PersistentMSumType result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMSumTypeFacade
                .newDelayedMSumType();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMSumTypeFacade
                .newMSumType(-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentMSumType createMSumType(boolean delayed$Persistence,PersistentMSumType This) throws PersistenceException {
        PersistentMSumType result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMSumTypeFacade
                .newDelayedMSumType();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMSumTypeFacade
                .newMSumType(-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public MSumType provideCopy() throws PersistenceException{
        MSumType result = this;
        result = new MSumType(this.This, 
                              this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public MSumType(PersistentMComplexType This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentMComplexType)This,id);        
    }
    
    static public long getTypeId() {
        return 103;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 103) ConnectionHandler.getTheConnectionHandler().theMSumTypeFacade
            .newMSumType(this.getId());
        super.store();
        
    }
    
    public PersistentMSumType getThis() throws PersistenceException {
        if(this.This == null){
            PersistentMSumType result = new MSumTypeProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentMSumType)this.This;
    }
    
    public void accept(MComplexTypeVisitor visitor) throws PersistenceException {
        visitor.handleMSumType(this);
    }
    public <R> R accept(MComplexTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMSumType(this);
    }
    public <E extends UserException>  void accept(MComplexTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMSumType(this);
    }
    public <R, E extends UserException> R accept(MComplexTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMSumType(this);
    }
    public void accept(MComplexTypeHierarchyHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleMSumType(this);
    }
    public <R> R accept(MComplexTypeHierarchyHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMSumType(this);
    }
    public <E extends UserException>  void accept(MComplexTypeHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMSumType(this);
    }
    public <R, E extends UserException> R accept(MComplexTypeHierarchyHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMSumType(this);
    }
    public void accept(MTypeVisitor visitor) throws PersistenceException {
        visitor.handleMSumType(this);
    }
    public <R> R accept(MTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMSumType(this);
    }
    public <E extends UserException>  void accept(MTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMSumType(this);
    }
    public <R, E extends UserException> R accept(MTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMSumType(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMSumType(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMSumType(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMSumType(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMSumType(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + this.getContainedTypes().getLength());
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public PersistentMBoolean contains(final MType otherType) 
				throws PersistenceException{
      
    	if(otherType == null) {
    		return MFalse.getTheMFalse();
    	}
    	
    	return otherType.accept(new MTypeReturnVisitor<PersistentMBoolean>() {

				@Override
				public PersistentMBoolean handleMProductType(PersistentMProductType mProductType) throws PersistenceException {
					// Wenn unsere Summe das ganze Produkt als Summanden enthaelt => true
					
					Iterator<MType> iterator = getThis().getContainedTypes().iterator();
					MType current = null;
					
					while(iterator.hasNext()) {
						current = iterator.next();
						
						if(current.contains(mProductType).equals(MTrue.getTheMTrue())) {
							return MTrue.getTheMTrue();
						}
					}
					
					return MFalse.getTheMFalse();
				}

				@Override
				public PersistentMBoolean handleMSumType(PersistentMSumType mSumType) throws PersistenceException {
					// True bei: Identitaet, wenn unsere Summe jeden Summanden der anderen Summe enthaelt
					
					if(getThis().equals(mSumType)) {
						return MTrue.getTheMTrue();
					}
					
					Iterator<MType> iterator = getThis().getContainedTypes().iterator();
					MType current = null;
					
					while(iterator.hasNext()) {
						current = iterator.next();
						
						if(current.contains(mSumType).equals(MFalse.getTheMFalse())) {
							return MFalse.getTheMFalse();
						}
					}
					
					return MTrue.getTheMTrue();
				}

				@Override
				public PersistentMBoolean handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException {
					// true, wenn einer unserer containedTypes den atomicType enthaelt
					
					Iterator<MType> iterator = getThis().getContainedTypes().iterator();
					MType current = null;
					
					while(iterator.hasNext()) {
						current = iterator.next();
						
						if(current.contains(mAtomicType).equals(MTrue.getTheMTrue())) {
							return MTrue.getTheMTrue();
						}
					}
					return MFalse.getTheMFalse();
				}
    		
			});
    	
    	
    }
    public boolean containsMComplexTypeHierarchy(final MComplexTypeHierarchyHIERARCHY part) 
				throws PersistenceException{
        if(getThis().equals(part)) return true;
		java.util.Iterator iterator0 = getThis().getContainedTypes().iterator();
		while(iterator0.hasNext())
			if(((MComplexTypeHierarchyHIERARCHY)iterator0.next()).containsMComplexTypeHierarchy(part)) return true; 
		return false;
    }
    public PersistentMBoolean isStructuralEqual(final MType otherType) 
				throws PersistenceException{
        
    	return otherType.accept(new MTypeReturnVisitor<PersistentMBoolean>() {

				@Override
				public PersistentMBoolean handleMProductType(PersistentMProductType mProductType) throws PersistenceException {
					return MFalse.getTheMFalse();
				}

				@Override
				public PersistentMBoolean handleMSumType(PersistentMSumType mSumType) throws PersistenceException {
					
					if(getThis().getContainedTypes().getLength() != mSumType.getContainedTypes().getLength()) {
						return MFalse.getTheMFalse();
					}
					
					// Alle Teile aus meinen ContainedTypes muessen in mProductType sein und mehr nicht.
					Iterator<MType> myIterator = getThis().getContainedTypes().iterator();
					while(myIterator.hasNext()) {
						if(otherType.contains(myIterator.next()).equals(MFalse.getTheMFalse())) {
							return MFalse.getTheMFalse();
						}
					}
					
					return MTrue.getTheMTrue();
				}

				@Override
				public PersistentMBoolean handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException {
					return mAtomicType.isStructuralEqual(getThis()); 
				}
			});
    	
        
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentMSumType)This);
		if(this.equals(This)){
		}
    }
    public <T> T strategyMComplexTypeHierarchy(final T parameter, final MComplexTypeHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        T result$$containedTypes$$MSumType = strategy.initialize$$MSumType$$containedTypes(getThis(), parameter);
		java.util.Iterator iterator$$ = getThis().getContainedTypes().iterator();
		while (iterator$$.hasNext()){
			MType current$$Field = (MType)iterator$$.next();
			T current$$ = current$$Field.strategyMComplexTypeHierarchy(result$$containedTypes$$MSumType, strategy);
			result$$containedTypes$$MSumType = strategy.consolidate$$MSumType$$containedTypes(getThis(), result$$containedTypes$$MSumType, current$$);
		}
		return strategy.finalize$$MSumType(getThis(), parameter,result$$containedTypes$$MSumType);
    }
    public PersistentMBoolean isLessOrEqual(final MType otherType) 
				throws PersistenceException{
    	
		if (otherType == null) {
			return MFalse.getTheMFalse();
		}
		
		
		return otherType.accept(new MTypeReturnVisitor<PersistentMBoolean>() {

			@Override
			public PersistentMBoolean handleMProductType(PersistentMProductType mProductType) throws PersistenceException {
				return isLessOrEqualInternal();
			}

			@Override
			public PersistentMBoolean handleMSumType(PersistentMSumType mSumType) throws PersistenceException {

				if (getThis().equals(otherType)) {
					return MTrue.getTheMTrue();
				}
				
				return isLessOrEqualInternal();
			}

			@Override
			public PersistentMBoolean handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException {
				return isLessOrEqualInternal();
			}
			
			private PersistentMBoolean isLessOrEqualInternal() throws PersistenceException {
				Iterator<MType> iterator = getThis().getContainedTypes().iterator();

				while(iterator.hasNext()) {
					// Wenn alle Elemente kleiner als der uebergebene Typ sind => return true
					if(iterator.next().isLessOrEqual(otherType).equals(MFalse.getTheMFalse())) {
						return MFalse.getTheMFalse();
					}
				}
				return MTrue.getTheMTrue();
			}
			
		});
		
		
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }
    public PersistentMBoolean isSingleton() 
				throws PersistenceException{
        //TODO: implement method: isSingleton
        try{
            throw new java.lang.UnsupportedOperationException("Method \"isSingleton\" not implemented yet.");
        } catch (java.lang.UnsupportedOperationException uoe){
            uoe.printStackTrace();
            throw uoe;
        }
    }
    public PersistentMBoolean allObjectsOfTypeAreSingleton() 
				throws PersistenceException{
    	return getThis().getContainedTypes().getLength() == 1 ? 
    			getThis().getContainedTypes().iterator().next().allObjectsOfTypeAreSingleton() : 
    				MFalse.getTheMFalse(); 
    }
    public PersistentMBoolean isAbstract() 
				throws PersistenceException{	
    	long subTypeCount = getThis().getContainedTypes().getLength();
    	return subTypeCount == 0 ? 
    				MTrue.getTheMTrue() : 
    				subTypeCount == 1 ?
    						getThis().getContainedTypes().iterator().next().isAbstract() : 
    						MTrue.getTheMTrue(); 
    }
    public String fetchName() 
				throws PersistenceException{
        //TODO: implement method: fetchName
        try{
            throw new java.lang.UnsupportedOperationException("Method \"fetchName\" not implemented yet.");
        } catch (java.lang.UnsupportedOperationException uoe){
            uoe.printStackTrace();
            throw uoe;
        }
    }
    public String getTypeLinkOperator() 
				throws PersistenceException{
		return TYPE_LINK_OPERATOR;
	}

    /* Start of protected part that is not overridden by persistence generator */
    
	private static final String TYPE_LINK_OPERATOR = "*";
    
    /* End of protected part that is not overridden by persistence generator */
    
}
