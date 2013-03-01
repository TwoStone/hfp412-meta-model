package model.typeSystem;

import model.ConsistencyException;
import model.UserException;
import model.basic.MTrue;
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
import model.visitor.MDisjunctiveNormalFormReturnExceptionVisitor;
import model.visitor.MDisjunctiveNormalFormReturnVisitor;
import model.visitor.MDisjunctiveNormalFormVisitor;
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
import persistence.MEmptyTypeDisjunctionProxi;
import persistence.MModelItemSearchList;
import persistence.MTypeSearchList;
import persistence.PersistenceException;
import persistence.PersistentCONCMModelItem;
import persistence.PersistentMBoolean;
import persistence.PersistentMDisjunctiveNormalForm;
import persistence.PersistentMEmptyTypeDisjunction;
import persistence.PersistentMModelItem;
import persistence.PersistentMType;
import persistence.SearchListRoot;
import persistence.TDObserver;
import utils.SearchLists;

/* Additional import section end */

public class MEmptyTypeDisjunction extends model.typeSystem.MDisjunctiveNormalForm implements
		PersistentMEmptyTypeDisjunction {

	private static PersistentMEmptyTypeDisjunction theMEmptyTypeDisjunction = null;
	public static boolean reset$For$Test = false;
	private static final Object $$lock = new Object();

	public static PersistentMEmptyTypeDisjunction getTheMEmptyTypeDisjunction() throws PersistenceException {
		if (theMEmptyTypeDisjunction == null || reset$For$Test) {
			class Initializer implements Runnable {
				PersistenceException exception = null;

				@Override
				public void run() {
					try {
						MEmptyTypeDisjunctionProxi proxi = null;
						synchronized ($$lock) {
							proxi = ConnectionHandler.getTheConnectionHandler().theMEmptyTypeDisjunctionFacade
									.getTheMEmptyTypeDisjunction();
							theMEmptyTypeDisjunction = proxi;
						}
						if (proxi.getId() < 0) {
							proxi.setId(proxi.getId() * -1);
							proxi.initialize(proxi, new java.util.Hashtable<String, Object>());
							proxi.initializeOnCreation();
						}
					} catch (final PersistenceException e) {
						exception = e;
					}
					synchronized ($$lock) {
						$$lock.notify();
					}
				}

				PersistentMEmptyTypeDisjunction getResult() throws PersistenceException {
					if (exception != null)
						throw exception;
					return theMEmptyTypeDisjunction;
				}
			}
			synchronized ($$lock) {
				reset$For$Test = false;
				final Initializer initializer = new Initializer();
				new Thread(initializer).start();
				try {
					$$lock.wait();
				} catch (final InterruptedException e) {
				} // Need not to be interrupted
				return initializer.getResult();
			}
		}
		return theMEmptyTypeDisjunction;
	}

	@Override
	public java.util.Hashtable<String, Object> toHashtable(final java.util.Hashtable<String, Object> allResults,
			final int depth, final int essentialLevel, final boolean forGUI, final boolean leaf,
			final TDObserver tdObserver) throws PersistenceException {
		java.util.Hashtable<String, Object> result = null;
		if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth) {
			result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
			final String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
			if (leaf && !allResults.contains(uniqueKey))
				allResults.put(uniqueKey, result);
		}
		return result;
	}

	@Override
	public MEmptyTypeDisjunction provideCopy() throws PersistenceException {
		MEmptyTypeDisjunction result = this;
		result = new MEmptyTypeDisjunction(this.This, this.myCONCMModelItem, this.getId());
		this.copyingPrivateUserAttributes(result);
		return result;
	}

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return true;
	}

	public MEmptyTypeDisjunction(final PersistentMType This, final PersistentMModelItem myCONCMModelItem, final long id)
			throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(This, myCONCMModelItem, id);
	}

	static public long getTypeId() {
		return 307;
	}

	@Override
	public long getClassId() {
		return getTypeId();
	}

	@Override
	public void store() throws PersistenceException {
		// Singletons cannot be delayed!
	}

	@Override
	public PersistentMEmptyTypeDisjunction getThis() throws PersistenceException {
		if (this.This == null) {
			final PersistentMEmptyTypeDisjunction result = new MEmptyTypeDisjunctionProxi(this.getId());
			result.getTheObject();
			return result;
		}
		return (PersistentMEmptyTypeDisjunction) this.This;
	}

	@Override
	public void accept(final MDisjunctiveNormalFormVisitor visitor) throws PersistenceException {
		visitor.handleMEmptyTypeDisjunction(this);
	}

	@Override
	public <R> R accept(final MDisjunctiveNormalFormReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMEmptyTypeDisjunction(this);
	}

	@Override
	public <E extends UserException> void accept(final MDisjunctiveNormalFormExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleMEmptyTypeDisjunction(this);
	}

	@Override
	public <R, E extends UserException> R accept(final MDisjunctiveNormalFormReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMEmptyTypeDisjunction(this);
	}

	@Override
	public void accept(final MAbstractTypeDisjunctionVisitor visitor) throws PersistenceException {
		visitor.handleMEmptyTypeDisjunction(this);
	}

	@Override
	public <R> R accept(final MAbstractTypeDisjunctionReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMEmptyTypeDisjunction(this);
	}

	@Override
	public <E extends UserException> void accept(final MAbstractTypeDisjunctionExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleMEmptyTypeDisjunction(this);
	}

	@Override
	public <R, E extends UserException> R accept(final MAbstractTypeDisjunctionReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMEmptyTypeDisjunction(this);
	}

	@Override
	public void accept(final MComplexTypeVisitor visitor) throws PersistenceException {
		visitor.handleMEmptyTypeDisjunction(this);
	}

	@Override
	public <R> R accept(final MComplexTypeReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMEmptyTypeDisjunction(this);
	}

	@Override
	public <E extends UserException> void accept(final MComplexTypeExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleMEmptyTypeDisjunction(this);
	}

	@Override
	public <R, E extends UserException> R accept(final MComplexTypeReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMEmptyTypeDisjunction(this);
	}

	@Override
	public void accept(final MTypeVisitor visitor) throws PersistenceException {
		visitor.handleMEmptyTypeDisjunction(this);
	}

	@Override
	public <R> R accept(final MTypeReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMEmptyTypeDisjunction(this);
	}

	@Override
	public <E extends UserException> void accept(final MTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleMEmptyTypeDisjunction(this);
	}

	@Override
	public <R, E extends UserException> R accept(final MTypeReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMEmptyTypeDisjunction(this);
	}

	@Override
	public void accept(final MModelItemVisitor visitor) throws PersistenceException {
		visitor.handleMEmptyTypeDisjunction(this);
	}

	@Override
	public <R> R accept(final MModelItemReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMEmptyTypeDisjunction(this);
	}

	@Override
	public <E extends UserException> void accept(final MModelItemExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleMEmptyTypeDisjunction(this);
	}

	@Override
	public <R, E extends UserException> R accept(final MModelItemReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMEmptyTypeDisjunction(this);
	}

	@Override
	public void accept(final AnythingVisitor visitor) throws PersistenceException {
		visitor.handleMEmptyTypeDisjunction(this);
	}

	@Override
	public <R> R accept(final AnythingReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMEmptyTypeDisjunction(this);
	}

	@Override
	public <E extends UserException> void accept(final AnythingExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleMEmptyTypeDisjunction(this);
	}

	@Override
	public <R, E extends UserException> R accept(final AnythingReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMEmptyTypeDisjunction(this);
	}

	@Override
	public void accept(final MComplexTypeHierarchyHIERARCHYVisitor visitor) throws PersistenceException {
		visitor.handleMEmptyTypeDisjunction(this);
	}

	@Override
	public <R> R accept(final MComplexTypeHierarchyHIERARCHYReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMEmptyTypeDisjunction(this);
	}

	@Override
	public <E extends UserException> void accept(final MComplexTypeHierarchyHIERARCHYExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleMEmptyTypeDisjunction(this);
	}

	@Override
	public <R, E extends UserException> R accept(
			final MComplexTypeHierarchyHIERARCHYReturnExceptionVisitor<R, E> visitor) throws PersistenceException, E {
		return visitor.handleMEmptyTypeDisjunction(this);
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
		return 0;
	}

	@Override
	public boolean containsMComplexTypeHierarchy(final MComplexTypeHierarchyHIERARCHY part) throws PersistenceException {
		if (getThis().equals(part))
			return true;
		return false;
	}

	// Start of section that contains operations that must be implemented.

	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String, Object> final$$Fields)
			throws PersistenceException {
		this.setThis((PersistentMEmptyTypeDisjunction) This);
		if (this.equals(This)) {
			final PersistentCONCMModelItem myCONCMModelItem = model.CONCMModelItem.createCONCMModelItem(
					this.isDelayed$Persistence(), (PersistentMEmptyTypeDisjunction) This);
			this.setMyCONCMModelItem(myCONCMModelItem);
		}
	}

	@Override
	public <T> T strategyMComplexTypeHierarchy(final T parameter,
			final MComplexTypeHierarchyHIERARCHYStrategy<T> strategy) throws PersistenceException {
		return strategy.finalize$$MEmptyTypeDisjunction(getThis(), parameter);
	}

	@Override
	public void copyingPrivateUserAttributes(final Anything copy) throws PersistenceException {
	}

	@Override
	public PersistentMDisjunctiveNormalForm fetchDisjunctiveNormalform() throws PersistenceException {
		return getThis();
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
		return MTrue.getTheMTrue();
	}

	@Override
	public PersistentMDisjunctiveNormalForm transientMultiply(final PersistentMDisjunctiveNormalForm other)
			throws PersistenceException {
		return getThis();
	}

	// Start of section that contains overridden operations only.

	@Override
	public void delete() throws model.ConsistencyException, PersistenceException {
		throw new ConsistencyException("The Nothing may not be deleted.");
	}

	@Override
	public String fetchName() throws PersistenceException {
		return "Nothing";
	}

	/* Start of protected part that is not overridden by persistence generator */

	@Override
	public SearchListRoot<? extends PersistentMType> fetchContainedTypes() {
		return new MTypeSearchList();
	}

	/* End of protected part that is not overridden by persistence generator */

}
