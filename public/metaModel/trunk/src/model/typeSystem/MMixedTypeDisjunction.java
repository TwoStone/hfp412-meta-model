package model.typeSystem;

import model.CycleException;
import model.UserException;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.MAbstractTypeDisjunctionExceptionVisitor;
import model.visitor.MAbstractTypeDisjunctionReturnExceptionVisitor;
import model.visitor.MAbstractTypeDisjunctionReturnVisitor;
import model.visitor.MAbstractTypeDisjunctionVisitor;
import model.visitor.MComplexTypeExceptionVisitor;
import model.visitor.MComplexTypeHierarchyHIERARCHYExceptionVisitor;
import model.visitor.MComplexTypeHierarchyHIERARCHYReturnExceptionVisitor;
import model.visitor.MComplexTypeHierarchyHIERARCHYReturnVisitor;
import model.visitor.MComplexTypeHierarchyHIERARCHYVisitor;
import model.visitor.MComplexTypeReturnExceptionVisitor;
import model.visitor.MComplexTypeReturnVisitor;
import model.visitor.MComplexTypeVisitor;
import model.visitor.MDisjunctiveNormalFormExceptionVisitor;
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
import persistence.MComplexTypeHierarchyHIERARCHY;
import persistence.MComplexTypeHierarchyHIERARCHYStrategy;
import persistence.MMixedTypeDisjunctionProxi;
import persistence.MMixedTypeDisjunction_AddendsProxi;
import persistence.MModelItemSearchList;
import persistence.MTypeSearchList;
import persistence.PersistenceException;
import persistence.PersistentCONCMModelItem;
import persistence.PersistentMAtomicTypeConjunction;
import persistence.PersistentMBoolean;
import persistence.PersistentMDisjunctiveNormalForm;
import persistence.PersistentMEmptyTypeDisjunction;
import persistence.PersistentMMixedTypeDisjunction;
import persistence.PersistentMModelItem;
import persistence.PersistentMNonEmptyDisjunctiveNormalForm;
import persistence.PersistentMType;
import persistence.Procdure;
import persistence.ProcdureException;
import persistence.SearchListRoot;
import persistence.TDObserver;

/* Additional import section end */

public class MMixedTypeDisjunction extends model.typeSystem.MAbstractTypeDisjunction implements PersistentMMixedTypeDisjunction{
    
    
    public static PersistentMMixedTypeDisjunction createMMixedTypeDisjunction() throws PersistenceException{
        return createMMixedTypeDisjunction(false);
    }
    
    public static PersistentMMixedTypeDisjunction createMMixedTypeDisjunction(boolean delayed$Persistence) throws PersistenceException {
        PersistentMMixedTypeDisjunction result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMMixedTypeDisjunctionFacade
                .newDelayedMMixedTypeDisjunction();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMMixedTypeDisjunctionFacade
                .newMMixedTypeDisjunction(-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentMMixedTypeDisjunction createMMixedTypeDisjunction(boolean delayed$Persistence,PersistentMMixedTypeDisjunction This) throws PersistenceException {
        PersistentMMixedTypeDisjunction result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMMixedTypeDisjunctionFacade
                .newDelayedMMixedTypeDisjunction();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMMixedTypeDisjunctionFacade
                .newMMixedTypeDisjunction(-1);
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
            result.put("addends", this.getAddends().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public MMixedTypeDisjunction provideCopy() throws PersistenceException{
        MMixedTypeDisjunction result = this;
        result = new MMixedTypeDisjunction(this.This, 
                                           this.myCONCMModelItem, 
                                           this.getId());
        result.addends = this.addends.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return true;
    }
    protected MMixedTypeDisjunction_AddendsProxi addends;
    
    public MMixedTypeDisjunction(PersistentMType This,PersistentMModelItem myCONCMModelItem,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentMType)This,(PersistentMModelItem)myCONCMModelItem,id);
        this.addends = new MMixedTypeDisjunction_AddendsProxi(this);        
    }
    
    static public long getTypeId() {
        return 312;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 312) ConnectionHandler.getTheConnectionHandler().theMMixedTypeDisjunctionFacade
            .newMMixedTypeDisjunction(this.getId());
        super.store();
        this.getAddends().store();
        
    }
    
    public MMixedTypeDisjunction_AddendsProxi getAddends() throws PersistenceException {
        return this.addends;
    }
    public PersistentMMixedTypeDisjunction getThis() throws PersistenceException {
        if(this.This == null){
            PersistentMMixedTypeDisjunction result = new MMixedTypeDisjunctionProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentMMixedTypeDisjunction)this.This;
    }
    
    public void accept(MAbstractTypeDisjunctionVisitor visitor) throws PersistenceException {
        visitor.handleMMixedTypeDisjunction(this);
    }
    public <R> R accept(MAbstractTypeDisjunctionReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMMixedTypeDisjunction(this);
    }
    public <E extends UserException>  void accept(MAbstractTypeDisjunctionExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMMixedTypeDisjunction(this);
    }
    public <R, E extends UserException> R accept(MAbstractTypeDisjunctionReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMMixedTypeDisjunction(this);
    }
    public void accept(MComplexTypeVisitor visitor) throws PersistenceException {
        visitor.handleMMixedTypeDisjunction(this);
    }
    public <R> R accept(MComplexTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMMixedTypeDisjunction(this);
    }
    public <E extends UserException>  void accept(MComplexTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMMixedTypeDisjunction(this);
    }
    public <R, E extends UserException> R accept(MComplexTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMMixedTypeDisjunction(this);
    }
    public void accept(MTypeVisitor visitor) throws PersistenceException {
        visitor.handleMMixedTypeDisjunction(this);
    }
    public <R> R accept(MTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMMixedTypeDisjunction(this);
    }
    public <E extends UserException>  void accept(MTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMMixedTypeDisjunction(this);
    }
    public <R, E extends UserException> R accept(MTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMMixedTypeDisjunction(this);
    }
    public void accept(MModelItemVisitor visitor) throws PersistenceException {
        visitor.handleMMixedTypeDisjunction(this);
    }
    public <R> R accept(MModelItemReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMMixedTypeDisjunction(this);
    }
    public <E extends UserException>  void accept(MModelItemExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMMixedTypeDisjunction(this);
    }
    public <R, E extends UserException> R accept(MModelItemReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMMixedTypeDisjunction(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMMixedTypeDisjunction(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMMixedTypeDisjunction(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMMixedTypeDisjunction(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMMixedTypeDisjunction(this);
    }
    public void accept(MComplexTypeHierarchyHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleMMixedTypeDisjunction(this);
    }
    public <R> R accept(MComplexTypeHierarchyHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMMixedTypeDisjunction(this);
    }
    public <E extends UserException>  void accept(MComplexTypeHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMMixedTypeDisjunction(this);
    }
    public <R, E extends UserException> R accept(MComplexTypeHierarchyHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMMixedTypeDisjunction(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + this.getDependentItems().getLength()
            + this.getContainedTypes().getLength()
            + this.getAddends().getLength());
    }
    
    
    public MModelItemSearchList getDependentItems(final TDObserver observer) 
				throws PersistenceException{
        MModelItemSearchList result = getThis().getDependentItems();
		observer.updateTransientDerived(getThis(), "dependentItems", result);
		return result;
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
	}
    public MModelItemSearchList getDependentItems() 
				throws PersistenceException{
		// TODO: implement method: getDependentItems
		try {
			throw new java.lang.UnsupportedOperationException("Method \"getDependentItems\" not implemented yet.");
		} catch (java.lang.UnsupportedOperationException uoe) {
			uoe.printStackTrace();
			throw uoe;
		}
	}
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
	}
    public boolean containsMComplexTypeHierarchy(final MComplexTypeHierarchyHIERARCHY part) 
				throws PersistenceException{
        if(getThis().equals(part)) return true;
		java.util.Iterator iterator0 = getThis().getAddends().iterator();
		while(iterator0.hasNext())
			if(((MComplexTypeHierarchyHIERARCHY)iterator0.next()).containsMComplexTypeHierarchy(part)) return true; 
		return false;
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentMMixedTypeDisjunction)This);
		if(this.equals(This)){
			PersistentCONCMModelItem myCONCMModelItem = model.CONCMModelItem.createCONCMModelItem(this.isDelayed$Persistence(), (PersistentMMixedTypeDisjunction)This);
			this.setMyCONCMModelItem(myCONCMModelItem);
		}
    }
    public void prepareForDeletion() 
				throws model.ConsistencyException, PersistenceException{
		// TODO: implement method: prepareForDeletion

	}
    public <T> T strategyMComplexTypeHierarchy(final T parameter, final MComplexTypeHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        T result$$addends$$MMixedTypeDisjunction = strategy.initialize$$MMixedTypeDisjunction$$addends(getThis(), parameter);
		java.util.Iterator iterator$$ = getThis().getAddends().iterator();
		while (iterator$$.hasNext()){
			PersistentMType current$$Field = (PersistentMType)iterator$$.next();
			T current$$ = current$$Field.strategyMComplexTypeHierarchy(result$$addends$$MMixedTypeDisjunction, strategy);
			result$$addends$$MMixedTypeDisjunction = strategy.consolidate$$MMixedTypeDisjunction$$addends(getThis(), result$$addends$$MMixedTypeDisjunction, current$$);
		}
		return strategy.finalize$$MMixedTypeDisjunction(getThis(), parameter,result$$addends$$MMixedTypeDisjunction);
    }
    public PersistentMBoolean isLessOrEqual(final PersistentMType other) 
				throws PersistenceException{
		return getThis().fetchDisjunctiveNormalform().isLessOrEqual(other);
	}
    public void initializeOnCreation() 
				throws PersistenceException{
	}
    public PersistentMDisjunctiveNormalForm fetchDisjunctiveNormalform() 
				throws PersistenceException{
		final PersistentMNonEmptyDisjunctiveNormalForm result = MNonEmptyDisjunctiveNormalForm
				.createMNonEmptyDisjunctiveNormalForm(true);
		try {
			getThis().getAddends().applyToAllException(new ProcdureException<PersistentMType, CycleException>() {

				@Override
				public void doItTo(PersistentMType argument) throws PersistenceException, CycleException {
					final PersistentMDisjunctiveNormalForm dnf = argument.fetchDisjunctiveNormalform();

					dnf.accept(new MDisjunctiveNormalFormExceptionVisitor<CycleException>() {

						@Override
						public void handleMNonEmptyDisjunctiveNormalForm(
								PersistentMNonEmptyDisjunctiveNormalForm mNonEmptyDisjunctiveNormalForm)
								throws PersistenceException, CycleException {
							mNonEmptyDisjunctiveNormalForm.getAddends().applyToAllException(
									new ProcdureException<PersistentMAtomicTypeConjunction, CycleException>() {

										@Override
										public void doItTo(PersistentMAtomicTypeConjunction argument)
												throws PersistenceException, CycleException {
											result.getAddends().add(argument);
										}
									});
						}

						@Override
						public void handleMEmptyTypeDisjunction(PersistentMEmptyTypeDisjunction mEmptyTypeDisjunction)
								throws PersistenceException, CycleException {
						}
					});

				}

			});
		} catch (CycleException e) {
			// TODO quatschException
			e.printStackTrace();
		}

		return result.getAddends().getLength() > 0 ? result : MEmptyTypeDisjunction.getTheMEmptyTypeDisjunction();
	}

    /* Start of protected part that is not overridden by persistence generator */
	@Override
	public SearchListRoot<? extends PersistentMType> fetchContainedTypes() throws PersistenceException {
		return getThis().getAddends();
	}

	public static PersistentMMixedTypeDisjunction transientCreateMixedTypeDisj(MTypeSearchList typeList)
			throws PersistenceException {
		final PersistentMMixedTypeDisjunction result = MMixedTypeDisjunction.createMMixedTypeDisjunction(true);
		typeList.applyToAll(new Procdure<PersistentMType>() {

			@Override
			public void doItTo(PersistentMType argument) throws PersistenceException {
				try {
					result.getAddends().add(argument);
				} catch (CycleException e) {
					// TODO should not occur
					e.printStackTrace();
				}

			}
		});
		return result;
	}
	/* End of protected part that is not overridden by persistence generator */
    
}
