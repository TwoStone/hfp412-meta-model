package model.typeSystem;

import java.util.Iterator;

import model.CycleException;
import model.UserException;
import model.basic.MBoolean;
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
import model.visitor.MNonEmptyProductTypeExceptionVisitor;
import model.visitor.MNonEmptyProductTypeReturnExceptionVisitor;
import model.visitor.MNonEmptyProductTypeReturnVisitor;
import model.visitor.MNonEmptyProductTypeVisitor;
import model.visitor.MTypeExceptionVisitor;
import model.visitor.MTypeReturnExceptionVisitor;
import model.visitor.MTypeReturnVisitor;
import model.visitor.MTypeVisitor;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.MAtomicTypeProductProxi;
import persistence.MAtomicTypeProduct_FactorsProxi;
import persistence.MComplexTypeHierarchyHIERARCHY;
import persistence.MComplexTypeHierarchyHIERARCHYStrategy;
import persistence.MTypeSearchList;
import persistence.PersistenceException;
import persistence.PersistentMAbstractSumType;
import persistence.PersistentMAtomicType;
import persistence.PersistentMAtomicTypeProduct;
import persistence.PersistentMBoolean;
import persistence.PersistentMDisjuncitveNF;
import persistence.PersistentMEmptyProductType;
import persistence.PersistentMEmptySumType;
import persistence.PersistentMProductType;
import persistence.PersistentMSumType;
import persistence.PersistentMType;
import persistence.Procdure;
import persistence.TDObserver;

/* Additional import section end */

public class MAtomicTypeProduct extends model.typeSystem.MNonEmptyProductType implements PersistentMAtomicTypeProduct{
    
    
    public static PersistentMAtomicTypeProduct createMAtomicTypeProduct() throws PersistenceException{
        return createMAtomicTypeProduct(false);
    }
    
    public static PersistentMAtomicTypeProduct createMAtomicTypeProduct(boolean delayed$Persistence) throws PersistenceException {
        PersistentMAtomicTypeProduct result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMAtomicTypeProductFacade
                .newDelayedMAtomicTypeProduct();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMAtomicTypeProductFacade
                .newMAtomicTypeProduct(-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentMAtomicTypeProduct createMAtomicTypeProduct(boolean delayed$Persistence,PersistentMAtomicTypeProduct This) throws PersistenceException {
        PersistentMAtomicTypeProduct result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMAtomicTypeProductFacade
                .newDelayedMAtomicTypeProduct();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMAtomicTypeProductFacade
                .newMAtomicTypeProduct(-1);
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
            result.put("factors", this.getFactors().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public MAtomicTypeProduct provideCopy() throws PersistenceException{
        MAtomicTypeProduct result = this;
        result = new MAtomicTypeProduct(this.This, 
                                        this.getId());
        result.factors = this.factors.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected MAtomicTypeProduct_FactorsProxi factors;
    
    public MAtomicTypeProduct(PersistentMType This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentMType)This,id);
        this.factors = new MAtomicTypeProduct_FactorsProxi(this);        
    }
    
    static public long getTypeId() {
        return 276;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 276) ConnectionHandler.getTheConnectionHandler().theMAtomicTypeProductFacade
            .newMAtomicTypeProduct(this.getId());
        super.store();
        this.getFactors().store();
        
    }
    
    public MAtomicTypeProduct_FactorsProxi getFactors() throws PersistenceException {
        return this.factors;
    }
    public PersistentMAtomicTypeProduct getThis() throws PersistenceException {
        if(this.This == null){
            PersistentMAtomicTypeProduct result = new MAtomicTypeProductProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentMAtomicTypeProduct)this.This;
    }
    
    public void accept(MNonEmptyProductTypeVisitor visitor) throws PersistenceException {
        visitor.handleMAtomicTypeProduct(this);
    }
    public <R> R accept(MNonEmptyProductTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMAtomicTypeProduct(this);
    }
    public <E extends UserException>  void accept(MNonEmptyProductTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMAtomicTypeProduct(this);
    }
    public <R, E extends UserException> R accept(MNonEmptyProductTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMAtomicTypeProduct(this);
    }
    public void accept(MAbstractProductTypeVisitor visitor) throws PersistenceException {
        visitor.handleMAtomicTypeProduct(this);
    }
    public <R> R accept(MAbstractProductTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMAtomicTypeProduct(this);
    }
    public <E extends UserException>  void accept(MAbstractProductTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMAtomicTypeProduct(this);
    }
    public <R, E extends UserException> R accept(MAbstractProductTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMAtomicTypeProduct(this);
    }
    public void accept(MComplexTypeVisitor visitor) throws PersistenceException {
        visitor.handleMAtomicTypeProduct(this);
    }
    public <R> R accept(MComplexTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMAtomicTypeProduct(this);
    }
    public <E extends UserException>  void accept(MComplexTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMAtomicTypeProduct(this);
    }
    public <R, E extends UserException> R accept(MComplexTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMAtomicTypeProduct(this);
    }
    public void accept(MTypeVisitor visitor) throws PersistenceException {
        visitor.handleMAtomicTypeProduct(this);
    }
    public <R> R accept(MTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMAtomicTypeProduct(this);
    }
    public <E extends UserException>  void accept(MTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMAtomicTypeProduct(this);
    }
    public <R, E extends UserException> R accept(MTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMAtomicTypeProduct(this);
    }
    public void accept(MComplexTypeHierarchyHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleMAtomicTypeProduct(this);
    }
    public <R> R accept(MComplexTypeHierarchyHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMAtomicTypeProduct(this);
    }
    public <E extends UserException>  void accept(MComplexTypeHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMAtomicTypeProduct(this);
    }
    public <R, E extends UserException> R accept(MComplexTypeHierarchyHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMAtomicTypeProduct(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMAtomicTypeProduct(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMAtomicTypeProduct(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMAtomicTypeProduct(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMAtomicTypeProduct(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + this.getContainedTypes().getLength()
            + this.getFactors().getLength());
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
	}
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
	}
    public boolean containsMComplexTypeHierarchy(final MComplexTypeHierarchyHIERARCHY part) 
				throws PersistenceException{
        if(getThis().equals(part)) return true;
		java.util.Iterator iterator0 = getThis().getFactors().iterator();
		while(iterator0.hasNext())
			if(((MComplexTypeHierarchyHIERARCHY)iterator0.next()).containsMComplexTypeHierarchy(part)) return true; 
		return false;
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentMAtomicTypeProduct)This);
		if(this.equals(This)){
		}
    }
    public <T> T strategyMComplexTypeHierarchy(final T parameter, final MComplexTypeHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        T result$$factors$$MAtomicTypeProduct = strategy.initialize$$MAtomicTypeProduct$$factors(getThis(), parameter);
		java.util.Iterator iterator$$ = getThis().getFactors().iterator();
		while (iterator$$.hasNext()){
			PersistentMAtomicType current$$Field = (PersistentMAtomicType)iterator$$.next();
			T current$$ = current$$Field.strategyMComplexTypeHierarchy(result$$factors$$MAtomicTypeProduct, strategy);
			result$$factors$$MAtomicTypeProduct = strategy.consolidate$$MAtomicTypeProduct$$factors(getThis(), result$$factors$$MAtomicTypeProduct, current$$);
		}
		return strategy.finalize$$MAtomicTypeProduct(getThis(), parameter,result$$factors$$MAtomicTypeProduct);
    }
    public PersistentMBoolean isLessOrEqual(final PersistentMType other) 
				throws PersistenceException{
		return MBoolean.createFromBoolean(other.accept(new MTypeReturnVisitor<Boolean>() {

			@Override
			public Boolean handleMEmptySumType(PersistentMEmptySumType mEmptySumType) throws PersistenceException {
				// TODO Empty Sum handling
				return false;
			}

			@Override
			public Boolean handleMDisjuncitveNF(PersistentMDisjuncitveNF mDisjuncitveNF) throws PersistenceException {
				Iterator<PersistentMAtomicTypeProduct> othersAddendsI = mDisjuncitveNF.getAddends().iterator();
				while (othersAddendsI.hasNext()) {
					if (getThis().isLessOrEqual(othersAddendsI.next()).toBoolean()) {
						return true;
					}
				}
				return false;
			}

			@Override
			public Boolean handleMSumType(PersistentMSumType mSumType) throws PersistenceException {
				return getThis().isLessOrEqual(mSumType.fetchDisjunctiveNormalform()).toBoolean();
			}

			@Override
			public Boolean handleMEmptyProductType(PersistentMEmptyProductType mEmptyProductType)
					throws PersistenceException {
				return false;
			}

			@Override
			public Boolean handleMAtomicTypeProduct(PersistentMAtomicTypeProduct mAtomicTypeProduct)
					throws PersistenceException {
				Iterator<PersistentMAtomicType> othersFactorsI = mAtomicTypeProduct.getFactors().iterator();
				while (othersFactorsI.hasNext()) {
					if (!getThis().isLessOrEqual(othersFactorsI.next()).toBoolean()) {
						return false;
					}
				}
				return true;
			}

			@Override
			public Boolean handleMProductType(PersistentMProductType mProductType) throws PersistenceException {

				return getThis().isLessOrEqual(mProductType.fetchDisjunctiveNormalform()).toBoolean();
			}

			@Override
			public Boolean handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException {
				Iterator<PersistentMAtomicType> myFactorsI = getThis().getFactors().iterator();
				while (myFactorsI.hasNext()) {
					if (myFactorsI.next().isLessOrEqual(mAtomicType).toBoolean()) {
						return true;
					}
				}
				return false;
			}
		}));
	}
    public void initializeOnCreation() 
				throws PersistenceException{
		// TODO: implement method: initializeOnCreation

	}
    public PersistentMDisjuncitveNF fetchDisjunctiveNormalform() 
				throws PersistenceException{
		PersistentMDisjuncitveNF result = MDisjuncitveNF.createMDisjuncitveNF(true);
		try {
			result.getAddends().add(getThis());
		} catch (CycleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
    public PersistentMAbstractSumType fetchDisjunctiveNormalform_old() 
				throws PersistenceException{
		// TODO: implement method: fetchDisjunctiveNormalform
		try {
			throw new java.lang.UnsupportedOperationException(
					"Method \"fetchDisjunctiveNormalform\" not implemented yet.");
		} catch (java.lang.UnsupportedOperationException uoe) {
			uoe.printStackTrace();
			throw uoe;
		}
	}
    public PersistentMAtomicTypeProduct transientMultiply(final PersistentMAtomicTypeProduct other) 
				throws PersistenceException{
		final PersistentMAtomicTypeProduct result = MAtomicTypeProduct.createMAtomicTypeProduct(true);
		getThis().getFactors().applyToAll(new Procdure<PersistentMAtomicType>() {

			@Override
			public void doItTo(PersistentMAtomicType argument) throws PersistenceException {
				try {
					result.getFactors().add(argument);
				} catch (CycleException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		other.getFactors().applyToAll(new Procdure<PersistentMAtomicType>() {

			@Override
			public void doItTo(PersistentMAtomicType argument) throws PersistenceException {
				try {
					result.getFactors().add(argument);
				} catch (CycleException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		return result;
	}
    public MTypeSearchList getContainedTypes() 
				throws PersistenceException{
		final MTypeSearchList result = new MTypeSearchList();
		getThis().getFactors().applyToAll(new Procdure<PersistentMAtomicType>() {

			@Override
			public void doItTo(PersistentMAtomicType argument) throws PersistenceException {
				result.add(argument);
			}
		});
		return result;
	}

    /* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */
    
}
