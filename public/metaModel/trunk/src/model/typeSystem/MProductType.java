package model.typeSystem;

import model.UserException;
import model.basic.MFalse;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.MAbstractProductTypeExceptionVisitor;
import model.visitor.MAbstractProductTypeReturnExceptionVisitor;
import model.visitor.MAbstractProductTypeReturnVisitor;
import model.visitor.MAbstractProductTypeVisitor;
import model.visitor.MComplexTypeExceptionVisitor;
import model.visitor.MComplexTypeHierarchyHIERARCHYExceptionVisitor;
import model.visitor.MComplexTypeHierarchyHIERARCHYReturnExceptionVisitor;
import model.visitor.MComplexTypeHierarchyHIERARCHYReturnVisitor;
import model.visitor.MComplexTypeHierarchyHIERARCHYVisitor;
import model.visitor.MComplexTypeReturnExceptionVisitor;
import model.visitor.MComplexTypeReturnVisitor;
import model.visitor.MComplexTypeVisitor;
import model.visitor.MTypeExceptionVisitor;
import model.visitor.MTypeReturnExceptionVisitor;
import model.visitor.MTypeReturnVisitor;
import model.visitor.MTypeVisitor;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.MComplexTypeHierarchyHIERARCHY;
import persistence.MComplexTypeHierarchyHIERARCHYStrategy;
import persistence.MProductTypeProxi;
import persistence.PersistenceException;
import persistence.PersistentMBoolean;
import persistence.PersistentMComplexType;
import persistence.PersistentMProductType;
import persistence.PersistentMType;
import persistence.TDObserver;

/* Additional import section end */

public class MProductType extends model.typeSystem.MAbstractProductType implements PersistentMProductType{
    
    
    public static PersistentMProductType createMProductType() throws PersistenceException{
        return createMProductType(false);
    }
    
    public static PersistentMProductType createMProductType(boolean delayed$Persistence) throws PersistenceException {
        PersistentMProductType result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMProductTypeFacade
                .newDelayedMProductType();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMProductTypeFacade
                .newMProductType(-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentMProductType createMProductType(boolean delayed$Persistence,PersistentMProductType This) throws PersistenceException {
        PersistentMProductType result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMProductTypeFacade
                .newDelayedMProductType();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMProductTypeFacade
                .newMProductType(-1);
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
    
    public MProductType provideCopy() throws PersistenceException{
        MProductType result = this;
        result = new MProductType(this.This, 
                                  this.getId());
        result.containedTypes = this.containedTypes.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public MProductType(PersistentMType This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentMType)This,id);        
    }
    
    static public long getTypeId() {
        return 114;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 114) ConnectionHandler.getTheConnectionHandler().theMProductTypeFacade
            .newMProductType(this.getId());
        super.store();
        
    }
    
    public PersistentMProductType getThis() throws PersistenceException {
        if(this.This == null){
            PersistentMProductType result = new MProductTypeProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentMProductType)this.This;
    }
    
    public void accept(MAbstractProductTypeVisitor visitor) throws PersistenceException {
        visitor.handleMProductType(this);
    }
    public <R> R accept(MAbstractProductTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMProductType(this);
    }
    public <E extends UserException>  void accept(MAbstractProductTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMProductType(this);
    }
    public <R, E extends UserException> R accept(MAbstractProductTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMProductType(this);
    }
    public void accept(MComplexTypeVisitor visitor) throws PersistenceException {
        visitor.handleMProductType(this);
    }
    public <R> R accept(MComplexTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMProductType(this);
    }
    public <E extends UserException>  void accept(MComplexTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMProductType(this);
    }
    public <R, E extends UserException> R accept(MComplexTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMProductType(this);
    }
    public void accept(MTypeVisitor visitor) throws PersistenceException {
        visitor.handleMProductType(this);
    }
    public <R> R accept(MTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMProductType(this);
    }
    public <E extends UserException>  void accept(MTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMProductType(this);
    }
    public <R, E extends UserException> R accept(MTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMProductType(this);
    }
    public void accept(MComplexTypeHierarchyHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleMProductType(this);
    }
    public <R> R accept(MComplexTypeHierarchyHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMProductType(this);
    }
    public <E extends UserException>  void accept(MComplexTypeHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMProductType(this);
    }
    public <R, E extends UserException> R accept(MComplexTypeHierarchyHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMProductType(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMProductType(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMProductType(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMProductType(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMProductType(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + this.getContainedTypes().getLength());
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
		// TODO: implement method: initializeOnInstantiation

	}
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
		// TODO: implement method: copyingPrivateUserAttributes

	}
    public boolean containsMComplexTypeHierarchy(final MComplexTypeHierarchyHIERARCHY part) 
				throws PersistenceException{
        if(getThis().equals(part)) return true;
		java.util.Iterator iterator0 = getThis().getContainedTypes().iterator();
		while(iterator0.hasNext())
			if(((MComplexTypeHierarchyHIERARCHY)iterator0.next()).containsMComplexTypeHierarchy(part)) return true; 
		return false;
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentMProductType)This);
		if(this.equals(This)){
		}
    }
    public PersistentMBoolean isStructuralEquivalant(final PersistentMType other) 
				throws PersistenceException{
		if (other instanceof PersistentMProductType) {
			return allChildrenAreStructuralEquivalent((PersistentMComplexType) other);
		}
		return MFalse.getTheMFalse();
	}
    public <T> T strategyMComplexTypeHierarchy(final T parameter, final MComplexTypeHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        T result$$containedTypes$$MProductType = strategy.initialize$$MProductType$$containedTypes(getThis(), parameter);
		java.util.Iterator iterator$$ = getThis().getContainedTypes().iterator();
		while (iterator$$.hasNext()){
			PersistentMType current$$Field = (PersistentMType)iterator$$.next();
			T current$$ = current$$Field.strategyMComplexTypeHierarchy(result$$containedTypes$$MProductType, strategy);
			result$$containedTypes$$MProductType = strategy.consolidate$$MProductType$$containedTypes(getThis(), result$$containedTypes$$MProductType, current$$);
		}
		return strategy.finalize$$MProductType(getThis(), parameter,result$$containedTypes$$MProductType);
    }
    public PersistentMBoolean isLessOrEqual(final PersistentMType other) 
				throws PersistenceException{
		// TODO: implement method: isLessOrEqual
		try {
			throw new java.lang.UnsupportedOperationException("Method \"isLessOrEqual\" not implemented yet.");
		} catch (java.lang.UnsupportedOperationException uoe) {
			uoe.printStackTrace();
			throw uoe;
		}
	}
    public void initializeOnCreation() 
				throws PersistenceException{
		// TODO: implement method: initializeOnCreation

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

	/* End of protected part that is not overridden by persistence generator */
    
}
