package model.typeSystem;

import java.util.Iterator;
import java.util.List;

import model.CycleException;
import model.UserException;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.MAbstractTypeConjunctionExceptionVisitor;
import model.visitor.MAbstractTypeConjunctionReturnExceptionVisitor;
import model.visitor.MAbstractTypeConjunctionReturnVisitor;
import model.visitor.MAbstractTypeConjunctionVisitor;
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
import persistence.MComplexTypeHierarchyHIERARCHY;
import persistence.MComplexTypeHierarchyHIERARCHYStrategy;
import persistence.MMixedConjunctionProxi;
import persistence.MMixedConjunction_FactorsProxi;
import persistence.MModelItemSearchList;
import persistence.MTypeSearchList;
import persistence.PersistenceException;
import persistence.PersistentCONCMModelItem;
import persistence.PersistentMBoolean;
import persistence.PersistentMDisjunctiveNormalForm;
import persistence.PersistentMMixedConjunction;
import persistence.PersistentMModelItem;
import persistence.PersistentMType;
import persistence.Procdure;
import persistence.SearchListRoot;
import persistence.TDObserver;
import utils.Lists;

/* Additional import section end */

public class MMixedConjunction extends model.typeSystem.MAbstractTypeConjunction implements PersistentMMixedConjunction {

	public static PersistentMMixedConjunction createMMixedConjunction() throws PersistenceException {
		return createMMixedConjunction(false);
	}

	public static PersistentMMixedConjunction createMMixedConjunction(boolean delayed$Persistence)
			throws PersistenceException {
		PersistentMMixedConjunction result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theMMixedConjunctionFacade
					.newDelayedMMixedConjunction();
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theMMixedConjunctionFacade.newMMixedConjunction(-1);
		}
		java.util.Hashtable<String, Object> final$$Fields = new java.util.Hashtable<String, Object>();
		result.initialize(result, final$$Fields);
		result.initializeOnCreation();
		return result;
	}

	public static PersistentMMixedConjunction createMMixedConjunction(boolean delayed$Persistence,
			PersistentMMixedConjunction This) throws PersistenceException {
		PersistentMMixedConjunction result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theMMixedConjunctionFacade
					.newDelayedMMixedConjunction();
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theMMixedConjunctionFacade.newMMixedConjunction(-1);
		}
		java.util.Hashtable<String, Object> final$$Fields = new java.util.Hashtable<String, Object>();
		result.initialize(This, final$$Fields);
		result.initializeOnCreation();
		return result;
	}

	@Override
	public java.util.Hashtable<String, Object> toHashtable(java.util.Hashtable<String, Object> allResults, int depth,
			int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
		java.util.Hashtable<String, Object> result = null;
		if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth) {
			result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
			result.put("factors",
					this.getFactors().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false));
			String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
			if (leaf && !allResults.contains(uniqueKey))
				allResults.put(uniqueKey, result);
		}
		return result;
	}

	@Override
	public MMixedConjunction provideCopy() throws PersistenceException {
		MMixedConjunction result = this;
		result = new MMixedConjunction(this.This, this.myCONCMModelItem, this.getId());
		result.factors = this.factors.copy(result);
		this.copyingPrivateUserAttributes(result);
		return result;
	}

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return true;
	}

	protected MMixedConjunction_FactorsProxi factors;

	public MMixedConjunction(PersistentMType This, PersistentMModelItem myCONCMModelItem, long id)
			throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(This, myCONCMModelItem, id);
		this.factors = new MMixedConjunction_FactorsProxi(this);
	}

	static public long getTypeId() {
		return 308;
	}

	@Override
	public long getClassId() {
		return getTypeId();
	}

	@Override
	public void store() throws PersistenceException {
		if (!this.isDelayed$Persistence())
			return;
		if (this.getClassId() == 308)
			ConnectionHandler.getTheConnectionHandler().theMMixedConjunctionFacade.newMMixedConjunction(this.getId());
		super.store();
		this.getFactors().store();

	}

	@Override
	public MMixedConjunction_FactorsProxi getFactors() throws PersistenceException {
		return this.factors;
	}

	@Override
	public PersistentMMixedConjunction getThis() throws PersistenceException {
		if (this.This == null) {
			PersistentMMixedConjunction result = new MMixedConjunctionProxi(this.getId());
			result.getTheObject();
			return result;
		}
		return (PersistentMMixedConjunction) this.This;
	}

	@Override
	public void accept(MAbstractTypeConjunctionVisitor visitor) throws PersistenceException {
		visitor.handleMMixedConjunction(this);
	}

	@Override
	public <R> R accept(MAbstractTypeConjunctionReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMMixedConjunction(this);
	}

	@Override
	public <E extends UserException> void accept(MAbstractTypeConjunctionExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleMMixedConjunction(this);
	}

	@Override
	public <R, E extends UserException> R accept(MAbstractTypeConjunctionReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMMixedConjunction(this);
	}

	@Override
	public void accept(MComplexTypeVisitor visitor) throws PersistenceException {
		visitor.handleMMixedConjunction(this);
	}

	@Override
	public <R> R accept(MComplexTypeReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMMixedConjunction(this);
	}

	@Override
	public <E extends UserException> void accept(MComplexTypeExceptionVisitor<E> visitor) throws PersistenceException,
			E {
		visitor.handleMMixedConjunction(this);
	}

	@Override
	public <R, E extends UserException> R accept(MComplexTypeReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMMixedConjunction(this);
	}

	@Override
	public void accept(MTypeVisitor visitor) throws PersistenceException {
		visitor.handleMMixedConjunction(this);
	}

	@Override
	public <R> R accept(MTypeReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMMixedConjunction(this);
	}

	@Override
	public <E extends UserException> void accept(MTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleMMixedConjunction(this);
	}

	@Override
	public <R, E extends UserException> R accept(MTypeReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMMixedConjunction(this);
	}

	@Override
	public void accept(MModelItemVisitor visitor) throws PersistenceException {
		visitor.handleMMixedConjunction(this);
	}

	@Override
	public <R> R accept(MModelItemReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMMixedConjunction(this);
	}

	@Override
	public <E extends UserException> void accept(MModelItemExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleMMixedConjunction(this);
	}

	@Override
	public <R, E extends UserException> R accept(MModelItemReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMMixedConjunction(this);
	}

	@Override
	public void accept(AnythingVisitor visitor) throws PersistenceException {
		visitor.handleMMixedConjunction(this);
	}

	@Override
	public <R> R accept(AnythingReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMMixedConjunction(this);
	}

	@Override
	public <E extends UserException> void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleMMixedConjunction(this);
	}

	@Override
	public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMMixedConjunction(this);
	}

	@Override
	public void accept(MComplexTypeHierarchyHIERARCHYVisitor visitor) throws PersistenceException {
		visitor.handleMMixedConjunction(this);
	}

	@Override
	public <R> R accept(MComplexTypeHierarchyHIERARCHYReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMMixedConjunction(this);
	}

	@Override
	public <E extends UserException> void accept(MComplexTypeHierarchyHIERARCHYExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleMMixedConjunction(this);
	}

	@Override
	public <R, E extends UserException> R accept(MComplexTypeHierarchyHIERARCHYReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMMixedConjunction(this);
	}

	@Override
	public int getLeafInfo() throws PersistenceException {
		return (int) (0 + this.getDependentItems().getLength() + this.getContainedTypes().getLength() + this
				.getFactors().getLength());
	}

	@Override
	public MModelItemSearchList getDependentItems(final TDObserver observer) throws PersistenceException {
		MModelItemSearchList result = getThis().getDependentItems();
		observer.updateTransientDerived(getThis(), "dependentItems", result);
		return result;
	}

	@Override
	public void initializeOnInstantiation() throws PersistenceException {
	}

	@Override
	public MModelItemSearchList getDependentItems() throws PersistenceException {
		// TODO: implement method: getDependentItems
		try {
			throw new java.lang.UnsupportedOperationException("Method \"getDependentItems\" not implemented yet.");
		} catch (java.lang.UnsupportedOperationException uoe) {
			uoe.printStackTrace();
			throw uoe;
		}
	}

	@Override
	public void copyingPrivateUserAttributes(final Anything copy) throws PersistenceException {

	}

	@Override
	public boolean containsMComplexTypeHierarchy(final MComplexTypeHierarchyHIERARCHY part) throws PersistenceException {
		if (getThis().equals(part))
			return true;
		java.util.Iterator iterator0 = getThis().getFactors().iterator();
		while (iterator0.hasNext())
			if (((MComplexTypeHierarchyHIERARCHY) iterator0.next()).containsMComplexTypeHierarchy(part))
				return true;
		return false;
	}

	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String, Object> final$$Fields)
			throws PersistenceException {
		this.setThis((PersistentMMixedConjunction) This);
		if (this.equals(This)) {
			PersistentCONCMModelItem myCONCMModelItem = model.CONCMModelItem.createCONCMModelItem(
					this.isDelayed$Persistence(), (PersistentMMixedConjunction) This);
			this.setMyCONCMModelItem(myCONCMModelItem);
		}
	}

	@Override
	public void prepareForDeletion() throws model.ConsistencyException, PersistenceException {
	}

	@Override
	public void delete() throws model.ConsistencyException, PersistenceException {
		// TODO: implement method: delete

	}

	@Override
	public <T> T strategyMComplexTypeHierarchy(final T parameter,
			final MComplexTypeHierarchyHIERARCHYStrategy<T> strategy) throws PersistenceException {
		T result$$factors$$MMixedConjunction = strategy.initialize$$MMixedConjunction$$factors(getThis(), parameter);
		java.util.Iterator iterator$$ = getThis().getFactors().iterator();
		while (iterator$$.hasNext()) {
			PersistentMType current$$Field = (PersistentMType) iterator$$.next();
			T current$$ = current$$Field.strategyMComplexTypeHierarchy(result$$factors$$MMixedConjunction, strategy);
			result$$factors$$MMixedConjunction = strategy.consolidate$$MMixedConjunction$$factors(getThis(),
					result$$factors$$MMixedConjunction, current$$);
		}
		return strategy.finalize$$MMixedConjunction(getThis(), parameter, result$$factors$$MMixedConjunction);
	}

	@Override
	public PersistentMBoolean isLessOrEqual(final PersistentMType other) throws PersistenceException {
		return getThis().fetchDisjunctiveNormalform().isLessOrEqual(other);
	}

	@Override
	public void initializeOnCreation() throws PersistenceException {
	}

	@Override
	public PersistentMDisjunctiveNormalForm fetchDisjunctiveNormalform() throws PersistenceException {
		PersistentMDisjunctiveNormalForm result = MEmptyTypeDisjunction.getTheMEmptyTypeDisjunction();

		final List<PersistentMDisjunctiveNormalForm> dnfsOfChildren = Lists.newArrayList();

		getThis().getFactors().applyToAll(new Procdure<PersistentMType>() {
			@Override
			public void doItTo(PersistentMType argument) throws PersistenceException {
				dnfsOfChildren.add(argument.fetchDisjunctiveNormalform());
			}
		});

		Iterator<PersistentMDisjunctiveNormalForm> childDnfI = dnfsOfChildren.iterator();

		if (childDnfI.hasNext()) {
			result = childDnfI.next();
		}

		while (childDnfI.hasNext()) {
			result = result.transientMultiply(childDnfI.next());
		}
		return result;
	}

	/* Start of protected part that is not overridden by persistence generator */
	@Override
	public SearchListRoot<? extends PersistentMType> fetchContainedTypes() throws PersistenceException {
		return getThis().getFactors();
	}

	public static PersistentMMixedConjunction transientCreateMixedTypeConj(MTypeSearchList containedTypes)
			throws PersistenceException {
		final PersistentMMixedConjunction result = MMixedConjunction.createMMixedConjunction(true);

		containedTypes.applyToAll(new Procdure<PersistentMType>() {

			@Override
			public void doItTo(PersistentMType argument) throws PersistenceException {
				try {
					result.getFactors().add(argument);
				} catch (CycleException e) {
					// TODO CANT OCCUR
					e.printStackTrace();
				}
			}
		});
		return result;
	}

	/* End of protected part that is not overridden by persistence generator */

}
