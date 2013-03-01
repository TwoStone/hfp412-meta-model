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
import utils.SearchLists;

/* Additional import section end */

public class MMixedTypeDisjunction extends model.typeSystem.MAbstractTypeDisjunction implements
		PersistentMMixedTypeDisjunction {

	public static PersistentMMixedTypeDisjunction createMMixedTypeDisjunction() throws PersistenceException {
		return createMMixedTypeDisjunction(false);
	}

	public static PersistentMMixedTypeDisjunction createMMixedTypeDisjunction(final boolean delayed$Persistence)
			throws PersistenceException {
		PersistentMMixedTypeDisjunction result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theMMixedTypeDisjunctionFacade
					.newDelayedMMixedTypeDisjunction();
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theMMixedTypeDisjunctionFacade
					.newMMixedTypeDisjunction(-1);
		}
		final java.util.Hashtable<String, Object> final$$Fields = new java.util.Hashtable<String, Object>();
		result.initialize(result, final$$Fields);
		result.initializeOnCreation();
		return result;
	}

	public static PersistentMMixedTypeDisjunction createMMixedTypeDisjunction(final boolean delayed$Persistence,
			final PersistentMMixedTypeDisjunction This) throws PersistenceException {
		PersistentMMixedTypeDisjunction result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theMMixedTypeDisjunctionFacade
					.newDelayedMMixedTypeDisjunction();
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theMMixedTypeDisjunctionFacade
					.newMMixedTypeDisjunction(-1);
		}
		final java.util.Hashtable<String, Object> final$$Fields = new java.util.Hashtable<String, Object>();
		result.initialize(This, final$$Fields);
		result.initializeOnCreation();
		return result;
	}

	@Override
	public java.util.Hashtable<String, Object> toHashtable(final java.util.Hashtable<String, Object> allResults,
			final int depth, final int essentialLevel, final boolean forGUI, final boolean leaf,
			final TDObserver tdObserver) throws PersistenceException {
		java.util.Hashtable<String, Object> result = null;
		if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth) {
			result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
			result.put(
					"addends",
					this.getAddends().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false,
							essentialLevel == 0));
			final String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
			if (leaf && !allResults.contains(uniqueKey))
				allResults.put(uniqueKey, result);
		}
		return result;
	}

	@Override
	public MMixedTypeDisjunction provideCopy() throws PersistenceException {
		MMixedTypeDisjunction result = this;
		result = new MMixedTypeDisjunction(this.This, this.myCONCMModelItem, this.getId());
		result.addends = this.addends.copy(result);
		this.copyingPrivateUserAttributes(result);
		return result;
	}

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return true;
	}

	protected MMixedTypeDisjunction_AddendsProxi addends;

	public MMixedTypeDisjunction(final PersistentMType This, final PersistentMModelItem myCONCMModelItem, final long id)
			throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(This, myCONCMModelItem, id);
		this.addends = new MMixedTypeDisjunction_AddendsProxi(this);
	}

	static public long getTypeId() {
		return 312;
	}

	@Override
	public long getClassId() {
		return getTypeId();
	}

	@Override
	public void store() throws PersistenceException {
		if (!this.isDelayed$Persistence())
			return;
		if (this.getClassId() == 312)
			ConnectionHandler.getTheConnectionHandler().theMMixedTypeDisjunctionFacade.newMMixedTypeDisjunction(this
					.getId());
		super.store();
		this.getAddends().store();

	}

	@Override
	public MMixedTypeDisjunction_AddendsProxi getAddends() throws PersistenceException {
		return this.addends;
	}

	@Override
	public PersistentMMixedTypeDisjunction getThis() throws PersistenceException {
		if (this.This == null) {
			final PersistentMMixedTypeDisjunction result = new MMixedTypeDisjunctionProxi(this.getId());
			result.getTheObject();
			return result;
		}
		return (PersistentMMixedTypeDisjunction) this.This;
	}

	@Override
	public void accept(final MAbstractTypeDisjunctionVisitor visitor) throws PersistenceException {
		visitor.handleMMixedTypeDisjunction(this);
	}

	@Override
	public <R> R accept(final MAbstractTypeDisjunctionReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMMixedTypeDisjunction(this);
	}

	@Override
	public <E extends UserException> void accept(final MAbstractTypeDisjunctionExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleMMixedTypeDisjunction(this);
	}

	@Override
	public <R, E extends UserException> R accept(final MAbstractTypeDisjunctionReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMMixedTypeDisjunction(this);
	}

	@Override
	public void accept(final MComplexTypeVisitor visitor) throws PersistenceException {
		visitor.handleMMixedTypeDisjunction(this);
	}

	@Override
	public <R> R accept(final MComplexTypeReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMMixedTypeDisjunction(this);
	}

	@Override
	public <E extends UserException> void accept(final MComplexTypeExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleMMixedTypeDisjunction(this);
	}

	@Override
	public <R, E extends UserException> R accept(final MComplexTypeReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMMixedTypeDisjunction(this);
	}

	@Override
	public void accept(final MTypeVisitor visitor) throws PersistenceException {
		visitor.handleMMixedTypeDisjunction(this);
	}

	@Override
	public <R> R accept(final MTypeReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMMixedTypeDisjunction(this);
	}

	@Override
	public <E extends UserException> void accept(final MTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleMMixedTypeDisjunction(this);
	}

	@Override
	public <R, E extends UserException> R accept(final MTypeReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMMixedTypeDisjunction(this);
	}

	@Override
	public void accept(final MModelItemVisitor visitor) throws PersistenceException {
		visitor.handleMMixedTypeDisjunction(this);
	}

	@Override
	public <R> R accept(final MModelItemReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMMixedTypeDisjunction(this);
	}

	@Override
	public <E extends UserException> void accept(final MModelItemExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleMMixedTypeDisjunction(this);
	}

	@Override
	public <R, E extends UserException> R accept(final MModelItemReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMMixedTypeDisjunction(this);
	}

	@Override
	public void accept(final AnythingVisitor visitor) throws PersistenceException {
		visitor.handleMMixedTypeDisjunction(this);
	}

	@Override
	public <R> R accept(final AnythingReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMMixedTypeDisjunction(this);
	}

	@Override
	public <E extends UserException> void accept(final AnythingExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleMMixedTypeDisjunction(this);
	}

	@Override
	public <R, E extends UserException> R accept(final AnythingReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMMixedTypeDisjunction(this);
	}

	@Override
	public void accept(final MComplexTypeHierarchyHIERARCHYVisitor visitor) throws PersistenceException {
		visitor.handleMMixedTypeDisjunction(this);
	}

	@Override
	public <R> R accept(final MComplexTypeHierarchyHIERARCHYReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMMixedTypeDisjunction(this);
	}

	@Override
	public <E extends UserException> void accept(final MComplexTypeHierarchyHIERARCHYExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleMMixedTypeDisjunction(this);
	}

	@Override
	public <R, E extends UserException> R accept(
			final MComplexTypeHierarchyHIERARCHYReturnExceptionVisitor<R, E> visitor) throws PersistenceException, E {
		return visitor.handleMMixedTypeDisjunction(this);
	}

	@Override
	public int getLeafInfo() throws PersistenceException {
		if (this.getDependentItems().getLength() > 0)
			return 1;
		if (this.getMTDJContainingMe().getLength() > 0)
			return 1;
		if (this.getMTCContainingMe().getLength() > 0)
			return 1;
		if (this.getContainedTypes().getLength() > 0)
			return 1;
		if (this.getAddends().getLength() > 0)
			return 1;
		return 0;
	}

	@Override
	public boolean containsMComplexTypeHierarchy(final MComplexTypeHierarchyHIERARCHY part) throws PersistenceException {
		if (getThis().equals(part))
			return true;
		final java.util.Iterator iterator0 = getThis().getAddends().iterator();
		while (iterator0.hasNext())
			if (((MComplexTypeHierarchyHIERARCHY) iterator0.next()).containsMComplexTypeHierarchy(part))
				return true;
		return false;
	}

	// Start of section that contains operations that must be implemented.

	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String, Object> final$$Fields)
			throws PersistenceException {
		this.setThis((PersistentMMixedTypeDisjunction) This);
		if (this.equals(This)) {
			final PersistentCONCMModelItem myCONCMModelItem = model.CONCMModelItem.createCONCMModelItem(
					this.isDelayed$Persistence(), (PersistentMMixedTypeDisjunction) This);
			this.setMyCONCMModelItem(myCONCMModelItem);
		}
	}

	@Override
	public <T> T strategyMComplexTypeHierarchy(final T parameter,
			final MComplexTypeHierarchyHIERARCHYStrategy<T> strategy) throws PersistenceException {
		T result$$addends$$MMixedTypeDisjunction = strategy.initialize$$MMixedTypeDisjunction$$addends(getThis(),
				parameter);
		final java.util.Iterator iterator$$ = getThis().getAddends().iterator();
		while (iterator$$.hasNext()) {
			final PersistentMType current$$Field = (PersistentMType) iterator$$.next();
			final T current$$ = current$$Field.strategyMComplexTypeHierarchy(result$$addends$$MMixedTypeDisjunction,
					strategy);
			result$$addends$$MMixedTypeDisjunction = strategy.consolidate$$MMixedTypeDisjunction$$addends(getThis(),
					result$$addends$$MMixedTypeDisjunction, current$$);
		}
		return strategy.finalize$$MMixedTypeDisjunction(getThis(), parameter, result$$addends$$MMixedTypeDisjunction);
	}

	@Override
	public void copyingPrivateUserAttributes(final Anything copy) throws PersistenceException {
	}

	@Override
	public PersistentMDisjunctiveNormalForm fetchDisjunctiveNormalform() throws PersistenceException {
		final PersistentMNonEmptyDisjunctiveNormalForm result = MNonEmptyDisjunctiveNormalForm
				.createMNonEmptyDisjunctiveNormalForm(true);
		try {
			getThis().getAddends().applyToAllException(new ProcdureException<PersistentMType, CycleException>() {

				@Override
				public void doItTo(final PersistentMType argument) throws PersistenceException, CycleException {
					final PersistentMDisjunctiveNormalForm dnf = argument.fetchDisjunctiveNormalform();

					dnf.accept(new MDisjunctiveNormalFormExceptionVisitor<CycleException>() {

						@Override
						public void handleMNonEmptyDisjunctiveNormalForm(
								final PersistentMNonEmptyDisjunctiveNormalForm mNonEmptyDisjunctiveNormalForm)
								throws PersistenceException, CycleException {
							mNonEmptyDisjunctiveNormalForm.getAddends().applyToAllException(
									new ProcdureException<PersistentMAtomicTypeConjunction, CycleException>() {

										@Override
										public void doItTo(final PersistentMAtomicTypeConjunction argument)
												throws PersistenceException, CycleException {
											result.getAddends().add(argument);
										}
									});
						}

						@Override
						public void handleMEmptyTypeDisjunction(
								final PersistentMEmptyTypeDisjunction mEmptyTypeDisjunction)
								throws PersistenceException, CycleException {
						}
					});

				}

			});
		} catch (final CycleException e) {
			// TODO quatschException
			e.printStackTrace();
		}

		return result.getAddends().getLength() > 0 ? result : MEmptyTypeDisjunction.getTheMEmptyTypeDisjunction();
	}

	@Override
	public MTypeSearchList fetchTypesContainingThisDirectly() throws PersistenceException {
		final MTypeSearchList result = new MTypeSearchList();
		SearchLists.addSecondToFirst(result, getThis().getMTCContainingMe());
		SearchLists.addSecondToFirst(result, getThis().getMTDJContainingMe());
		return result;
	}

	@Override
	public MModelItemSearchList getDependentItems(final TDObserver observer) throws PersistenceException {
		final MModelItemSearchList result = getThis().getDependentItems();
		observer.updateTransientDerived(getThis(), "dependentItems", result);
		return result;
	}

	@Override
	public void initializeOnCreation() throws PersistenceException {
	}

	@Override
	public void initializeOnInstantiation() throws PersistenceException {
	}

	@Override
	public PersistentMBoolean isLessOrEqual(final PersistentMType other) throws PersistenceException {
		return getThis().fetchDisjunctiveNormalform().isLessOrEqual(other);
	}

	// Start of section that contains overridden operations only.
	/* Start of protected part that is not overridden by persistence generator */

	@Override
	public SearchListRoot<? extends PersistentMType> fetchContainedTypes() throws PersistenceException {
		return getThis().getAddends();
	}

	public static PersistentMMixedTypeDisjunction transientCreateMixedTypeDisj(final MTypeSearchList typeList)
			throws PersistenceException {
		final PersistentMMixedTypeDisjunction result = MMixedTypeDisjunction.createMMixedTypeDisjunction(true);
		typeList.applyToAll(new Procdure<PersistentMType>() {

			@Override
			public void doItTo(final PersistentMType argument) throws PersistenceException {
				try {
					result.getAddends().add(argument);
				} catch (final CycleException e) {
					// TODO should not occur
					e.printStackTrace();
				}

			}
		});
		return result;
	}

	/* End of protected part that is not overridden by persistence generator */

}
