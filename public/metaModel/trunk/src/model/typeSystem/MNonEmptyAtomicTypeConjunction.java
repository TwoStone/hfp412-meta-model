package model.typeSystem;

import java.util.Iterator;

import model.CycleException;
import model.UserException;
import model.basic.MBoolean;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.MAbstractTypeConjunctionExceptionVisitor;
import model.visitor.MAbstractTypeConjunctionReturnExceptionVisitor;
import model.visitor.MAbstractTypeConjunctionReturnVisitor;
import model.visitor.MAbstractTypeConjunctionVisitor;
import model.visitor.MAtomicTypeConjunctionExceptionVisitor;
import model.visitor.MAtomicTypeConjunctionReturnExceptionVisitor;
import model.visitor.MAtomicTypeConjunctionReturnVisitor;
import model.visitor.MAtomicTypeConjunctionVisitor;
import model.visitor.MComplexTypeExceptionVisitor;
import model.visitor.MComplexTypeHierarchyHIERARCHYExceptionVisitor;
import model.visitor.MComplexTypeHierarchyHIERARCHYReturnExceptionVisitor;
import model.visitor.MComplexTypeHierarchyHIERARCHYReturnVisitor;
import model.visitor.MComplexTypeHierarchyHIERARCHYVisitor;
import model.visitor.MComplexTypeReturnExceptionVisitor;
import model.visitor.MComplexTypeReturnVisitor;
import model.visitor.MComplexTypeVisitor;
import model.visitor.MModelItemExceptionVisitor;
import model.visitor.MModelItemReturnExceptionVisitor;
import model.visitor.MModelItemReturnVisitor;
import model.visitor.MModelItemVisitor;
import model.visitor.MTypeExceptionVisitor;
import model.visitor.MTypeReturnExceptionVisitor;
import model.visitor.MTypeReturnVisitor;
import model.visitor.MTypeVisitor;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.MAtomicTypeSearchList;
import persistence.MComplexTypeHierarchyHIERARCHY;
import persistence.MComplexTypeHierarchyHIERARCHYStrategy;
import persistence.MModelItemSearchList;
import persistence.MNonEmptyAtomicTypeConjunctionProxi;
import persistence.MNonEmptyAtomicTypeConjunction_FactorsProxi;
import persistence.MTypeSearchList;
import persistence.PersistenceException;
import persistence.PersistentCONCMModelItem;
import persistence.PersistentMAtomicType;
import persistence.PersistentMAtomicTypeConjunction;
import persistence.PersistentMBoolean;
import persistence.PersistentMDisjunctiveNormalForm;
import persistence.PersistentMEmptyTypeConjunction;
import persistence.PersistentMEmptyTypeDisjunction;
import persistence.PersistentMMixedConjunction;
import persistence.PersistentMMixedTypeDisjunction;
import persistence.PersistentMModelItem;
import persistence.PersistentMNonEmptyAtomicTypeConjunction;
import persistence.PersistentMNonEmptyDisjunctiveNormalForm;
import persistence.PersistentMType;
import persistence.Procdure;
import persistence.ProcdureException;
import persistence.SearchListRoot;
import persistence.TDObserver;
import utils.SearchLists;

/* Additional import section end */

public class MNonEmptyAtomicTypeConjunction extends model.typeSystem.MAtomicTypeConjunction implements PersistentMNonEmptyAtomicTypeConjunction{
    
    
    public static PersistentMNonEmptyAtomicTypeConjunction createMNonEmptyAtomicTypeConjunction() throws PersistenceException{
        return createMNonEmptyAtomicTypeConjunction(false);
    }
    
    public static PersistentMNonEmptyAtomicTypeConjunction createMNonEmptyAtomicTypeConjunction(boolean delayed$Persistence) throws PersistenceException {
        PersistentMNonEmptyAtomicTypeConjunction result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMNonEmptyAtomicTypeConjunctionFacade
                .newDelayedMNonEmptyAtomicTypeConjunction();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMNonEmptyAtomicTypeConjunctionFacade
                .newMNonEmptyAtomicTypeConjunction(-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentMNonEmptyAtomicTypeConjunction createMNonEmptyAtomicTypeConjunction(boolean delayed$Persistence,PersistentMNonEmptyAtomicTypeConjunction This) throws PersistenceException {
        PersistentMNonEmptyAtomicTypeConjunction result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMNonEmptyAtomicTypeConjunctionFacade
                .newDelayedMNonEmptyAtomicTypeConjunction();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMNonEmptyAtomicTypeConjunctionFacade
                .newMNonEmptyAtomicTypeConjunction(-1);
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
            result.put("factors", this.getFactors().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public MNonEmptyAtomicTypeConjunction provideCopy() throws PersistenceException{
        MNonEmptyAtomicTypeConjunction result = this;
        result = new MNonEmptyAtomicTypeConjunction(this.This, 
                                                    this.myCONCMModelItem, 
                                                    this.getId());
        result.factors = this.factors.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return true;
    }
    protected MNonEmptyAtomicTypeConjunction_FactorsProxi factors;
    
    public MNonEmptyAtomicTypeConjunction(PersistentMType This,PersistentMModelItem myCONCMModelItem,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentMType)This,(PersistentMModelItem)myCONCMModelItem,id);
        this.factors = new MNonEmptyAtomicTypeConjunction_FactorsProxi(this);        
    }
    
    static public long getTypeId() {
        return 318;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 318) ConnectionHandler.getTheConnectionHandler().theMNonEmptyAtomicTypeConjunctionFacade
            .newMNonEmptyAtomicTypeConjunction(this.getId());
        super.store();
        this.getFactors().store();
        
    }
    
    public MNonEmptyAtomicTypeConjunction_FactorsProxi getFactors() throws PersistenceException {
        return this.factors;
    }
    public PersistentMNonEmptyAtomicTypeConjunction getThis() throws PersistenceException {
        if(this.This == null){
            PersistentMNonEmptyAtomicTypeConjunction result = new MNonEmptyAtomicTypeConjunctionProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentMNonEmptyAtomicTypeConjunction)this.This;
    }
    
    public void accept(MAtomicTypeConjunctionVisitor visitor) throws PersistenceException {
        visitor.handleMNonEmptyAtomicTypeConjunction(this);
    }
    public <R> R accept(MAtomicTypeConjunctionReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMNonEmptyAtomicTypeConjunction(this);
    }
    public <E extends UserException>  void accept(MAtomicTypeConjunctionExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMNonEmptyAtomicTypeConjunction(this);
    }
    public <R, E extends UserException> R accept(MAtomicTypeConjunctionReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMNonEmptyAtomicTypeConjunction(this);
    }
    public void accept(MAbstractTypeConjunctionVisitor visitor) throws PersistenceException {
        visitor.handleMNonEmptyAtomicTypeConjunction(this);
    }
    public <R> R accept(MAbstractTypeConjunctionReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMNonEmptyAtomicTypeConjunction(this);
    }
    public <E extends UserException>  void accept(MAbstractTypeConjunctionExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMNonEmptyAtomicTypeConjunction(this);
    }
    public <R, E extends UserException> R accept(MAbstractTypeConjunctionReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMNonEmptyAtomicTypeConjunction(this);
    }
    public void accept(MComplexTypeVisitor visitor) throws PersistenceException {
        visitor.handleMNonEmptyAtomicTypeConjunction(this);
    }
    public <R> R accept(MComplexTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMNonEmptyAtomicTypeConjunction(this);
    }
    public <E extends UserException>  void accept(MComplexTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMNonEmptyAtomicTypeConjunction(this);
    }
    public <R, E extends UserException> R accept(MComplexTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMNonEmptyAtomicTypeConjunction(this);
    }
    public void accept(MTypeVisitor visitor) throws PersistenceException {
        visitor.handleMNonEmptyAtomicTypeConjunction(this);
    }
    public <R> R accept(MTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMNonEmptyAtomicTypeConjunction(this);
    }
    public <E extends UserException>  void accept(MTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMNonEmptyAtomicTypeConjunction(this);
    }
    public <R, E extends UserException> R accept(MTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMNonEmptyAtomicTypeConjunction(this);
    }
    public void accept(MModelItemVisitor visitor) throws PersistenceException {
        visitor.handleMNonEmptyAtomicTypeConjunction(this);
    }
    public <R> R accept(MModelItemReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMNonEmptyAtomicTypeConjunction(this);
    }
    public <E extends UserException>  void accept(MModelItemExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMNonEmptyAtomicTypeConjunction(this);
    }
    public <R, E extends UserException> R accept(MModelItemReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMNonEmptyAtomicTypeConjunction(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMNonEmptyAtomicTypeConjunction(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMNonEmptyAtomicTypeConjunction(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMNonEmptyAtomicTypeConjunction(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMNonEmptyAtomicTypeConjunction(this);
    }
    public void accept(MComplexTypeHierarchyHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleMNonEmptyAtomicTypeConjunction(this);
    }
    public <R> R accept(MComplexTypeHierarchyHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMNonEmptyAtomicTypeConjunction(this);
    }
    public <E extends UserException>  void accept(MComplexTypeHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMNonEmptyAtomicTypeConjunction(this);
    }
    public <R, E extends UserException> R accept(MComplexTypeHierarchyHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMNonEmptyAtomicTypeConjunction(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getFactors().getLength() > 0) return 1;
        return 0;
    }
    
    
    public boolean containsMComplexTypeHierarchy(final MComplexTypeHierarchyHIERARCHY part) 
				throws PersistenceException{
        if(getThis().equals(part)) return true;
		java.util.Iterator iterator0 = getThis().getFactors().iterator();
		while(iterator0.hasNext())
			if(((MComplexTypeHierarchyHIERARCHY)iterator0.next()).containsMComplexTypeHierarchy(part)) return true; 
		return false;
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentMNonEmptyAtomicTypeConjunction)This);
		if(this.equals(This)){
			PersistentCONCMModelItem myCONCMModelItem = model.CONCMModelItem.createCONCMModelItem(this.isDelayed$Persistence(), (PersistentMNonEmptyAtomicTypeConjunction)This);
			this.setMyCONCMModelItem(myCONCMModelItem);
		}
    }
    public <T> T strategyMComplexTypeHierarchy(final T parameter, final MComplexTypeHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        T result$$factors$$MNonEmptyAtomicTypeConjunction = strategy.initialize$$MNonEmptyAtomicTypeConjunction$$factors(getThis(), parameter);
		java.util.Iterator iterator$$ = getThis().getFactors().iterator();
		while (iterator$$.hasNext()){
			PersistentMAtomicType current$$Field = (PersistentMAtomicType)iterator$$.next();
			T current$$ = current$$Field.strategyMComplexTypeHierarchy(result$$factors$$MNonEmptyAtomicTypeConjunction, strategy);
			result$$factors$$MNonEmptyAtomicTypeConjunction = strategy.consolidate$$MNonEmptyAtomicTypeConjunction$$factors(getThis(), result$$factors$$MNonEmptyAtomicTypeConjunction, current$$);
		}
		return strategy.finalize$$MNonEmptyAtomicTypeConjunction(getThis(), parameter,result$$factors$$MNonEmptyAtomicTypeConjunction);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
	}
    public PersistentMDisjunctiveNormalForm fetchDisjunctiveNormalform() 
				throws PersistenceException{
		return MNonEmptyDisjunctiveNormalForm.transientCreateDNFFromAtomicTypeConjunction(getThis());
	}
    public MTypeSearchList fetchTypesContainingThisDirectly() 
				throws PersistenceException{
		final MTypeSearchList result = new MTypeSearchList();
		SearchLists.addSecondToFirst(result, getThis().getMTCContainingMe());
		SearchLists.addSecondToFirst(result, getThis().getMTDJContainingMe());
		SearchLists.addSecondToFirst(result, getThis().getNEDNFContainingMe());
		return result;
	}
    public void initializeOnCreation() 
				throws PersistenceException{
	}
    public void initializeOnInstantiation() 
				throws PersistenceException{
	}
    public PersistentMBoolean isLessOrEqual(final PersistentMType other) 
				throws PersistenceException{
		return MBoolean.createFromBoolean(other.accept(new MTypeReturnVisitor<Boolean>() {

			@Override
			public Boolean handleMMixedTypeDisjunction(final PersistentMMixedTypeDisjunction mMixedTypeDisjunction)
					throws PersistenceException {
				return getThis().isLessOrEqual(mMixedTypeDisjunction.fetchDisjunctiveNormalform()).toBoolean();
			}

			@Override
			public Boolean handleMNonEmptyDisjunctiveNormalForm(
					final PersistentMNonEmptyDisjunctiveNormalForm mNonEmptyDisjunctiveNormalForm)
					throws PersistenceException {
				final Iterator<PersistentMAtomicTypeConjunction> othersAddends = mNonEmptyDisjunctiveNormalForm
						.getAddends().iterator();
				while (othersAddends.hasNext()) {
					if (getThis().isLessOrEqual(othersAddends.next()).toBoolean()) {
						return true;
					}
				}
				return false;
			}

			@Override
			public Boolean handleMEmptyTypeDisjunction(final PersistentMEmptyTypeDisjunction mEmptyTypeDisjunction)
					throws PersistenceException {
				return false;
			}

			@Override
			public Boolean handleMMixedConjunction(final PersistentMMixedConjunction mMixedConjunction)
					throws PersistenceException {
				return getThis().isLessOrEqual(mMixedConjunction.fetchDisjunctiveNormalform()).toBoolean();
			}

			@Override
			public Boolean handleMNonEmptyAtomicTypeConjunction(
					final PersistentMNonEmptyAtomicTypeConjunction mNonEmptyAtomicTypeConjunction)
					throws PersistenceException {
				final Iterator<PersistentMAtomicType> othersFactors = mNonEmptyAtomicTypeConjunction.getFactors()
						.iterator();
				while (othersFactors.hasNext()) {
					if (!getThis().isLessOrEqual(othersFactors.next()).toBoolean()) {
						return false;
					}
				}
				return true;
			}

			@Override
			public Boolean handleMEmptyTypeConjunction(final PersistentMEmptyTypeConjunction mEmptyTypeConjunction)
					throws PersistenceException {
				return true;
			}

			@Override
			public Boolean handleMAtomicType(final PersistentMAtomicType mAtomicType) throws PersistenceException {
				final Iterator<PersistentMAtomicType> myFactors = getThis().getFactors().iterator();
				while (myFactors.hasNext()) {
					if (myFactors.next().isLessOrEqual(mAtomicType).toBoolean()) {
						return true;
					}
				}
				return false;
			}
		}));
	}
    public PersistentMNonEmptyAtomicTypeConjunction transientMultiplyNonEmpty(final PersistentMNonEmptyAtomicTypeConjunction other) 
				throws PersistenceException{
		final PersistentMNonEmptyAtomicTypeConjunction result = MNonEmptyAtomicTypeConjunction
				.createMNonEmptyAtomicTypeConjunction(true);
		try {
			getThis().getFactors().applyToAllException(new ProcdureException<PersistentMAtomicType, CycleException>() {

				@Override
				public void doItTo(final PersistentMAtomicType argument) throws PersistenceException, CycleException {
					result.getFactors().add(argument);
				}
			});

			other.getFactors().applyToAllException(new ProcdureException<PersistentMAtomicType, CycleException>() {

				@Override
				public void doItTo(final PersistentMAtomicType argument) throws PersistenceException, CycleException {
					result.getFactors().add(argument);
				}
			});
		} catch (final CycleException e) {
			// TODO Should not occur
			e.printStackTrace();
		}
		return result;
	}
    
    
    // Start of section that contains overridden operations only.
    
    public PersistentMAtomicTypeConjunction transientMultiply(final PersistentMAtomicTypeConjunction other) 
				throws PersistenceException{
		return other.accept(new MAtomicTypeConjunctionReturnVisitor<PersistentMAtomicTypeConjunction>() {

			@Override
			public PersistentMAtomicTypeConjunction handleMNonEmptyAtomicTypeConjunction(
					final PersistentMNonEmptyAtomicTypeConjunction mNonEmptyAtomicTypeConjunction)
					throws PersistenceException {
				return getThis().transientMultiplyNonEmpty(mNonEmptyAtomicTypeConjunction);
			}

			@Override
			public PersistentMAtomicTypeConjunction handleMEmptyTypeConjunction(
					final PersistentMEmptyTypeConjunction mEmptyTypeConjunction) throws PersistenceException {
				return getThis();
			}
		});
	}

    /* Start of protected part that is not overridden by persistence generator */
    
    
    

	@Override
	public SearchListRoot<? extends PersistentMType> obtainContainedTypes() throws PersistenceException {
		return getThis().getFactors();
	}

	public static PersistentMNonEmptyAtomicTypeConjunction transientCreateNETypeConj(final MAtomicTypeSearchList sl)
			throws PersistenceException {
		final PersistentMNonEmptyAtomicTypeConjunction result = MNonEmptyAtomicTypeConjunction
				.createMNonEmptyAtomicTypeConjunction(true);
		sl.applyToAll(new Procdure<PersistentMAtomicType>() {

			@Override
			public void doItTo(final PersistentMAtomicType argument) throws PersistenceException {
				try {
					result.getFactors().add(argument);
				} catch (final CycleException e) {
					// should not occur
					e.printStackTrace();
				}
			}
		});
		return result;
	}

	
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
