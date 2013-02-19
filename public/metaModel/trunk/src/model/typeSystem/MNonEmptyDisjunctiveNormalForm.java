package model.typeSystem;

import java.util.Iterator;
import java.util.List;

import model.CycleException;
import model.UserException;
import model.basic.MBoolean;
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
import model.visitor.MTypeExceptionVisitor;
import model.visitor.MTypeReturnExceptionVisitor;
import model.visitor.MTypeReturnVisitor;
import model.visitor.MTypeVisitor;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.MComplexTypeHierarchyHIERARCHY;
import persistence.MComplexTypeHierarchyHIERARCHYStrategy;
import persistence.MNonEmptyDisjunctiveNormalFormProxi;
import persistence.MNonEmptyDisjunctiveNormalForm_AddendsProxi;
import persistence.PersistenceException;
import persistence.PersistentMAtomicType;
import persistence.PersistentMAtomicTypeConjunction;
import persistence.PersistentMBoolean;
import persistence.PersistentMDisjunctiveNormalForm;
import persistence.PersistentMEmptyTypeConjunction;
import persistence.PersistentMEmptyTypeDisjunction;
import persistence.PersistentMMixedConjunction;
import persistence.PersistentMMixedTypeDisjunction;
import persistence.PersistentMNonEmptyAtomicTypeConjunction;
import persistence.PersistentMNonEmptyDisjunctiveNormalForm;
import persistence.PersistentMType;
import persistence.Procdure;
import persistence.SearchListRoot;
import persistence.TDObserver;

/* Additional import section end */

public class MNonEmptyDisjunctiveNormalForm extends model.typeSystem.MDisjunctiveNormalForm implements
		PersistentMNonEmptyDisjunctiveNormalForm {

	public static PersistentMNonEmptyDisjunctiveNormalForm createMNonEmptyDisjunctiveNormalForm()
			throws PersistenceException {
		return createMNonEmptyDisjunctiveNormalForm(false);
	}

	public static PersistentMNonEmptyDisjunctiveNormalForm createMNonEmptyDisjunctiveNormalForm(
			boolean delayed$Persistence) throws PersistenceException {
		PersistentMNonEmptyDisjunctiveNormalForm result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theMNonEmptyDisjunctiveNormalFormFacade
					.newDelayedMNonEmptyDisjunctiveNormalForm();
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theMNonEmptyDisjunctiveNormalFormFacade
					.newMNonEmptyDisjunctiveNormalForm(-1);
		}
		java.util.Hashtable<String, Object> final$$Fields = new java.util.Hashtable<String, Object>();
		result.initialize(result, final$$Fields);
		result.initializeOnCreation();
		return result;
	}

	public static PersistentMNonEmptyDisjunctiveNormalForm createMNonEmptyDisjunctiveNormalForm(
			boolean delayed$Persistence, PersistentMNonEmptyDisjunctiveNormalForm This) throws PersistenceException {
		PersistentMNonEmptyDisjunctiveNormalForm result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theMNonEmptyDisjunctiveNormalFormFacade
					.newDelayedMNonEmptyDisjunctiveNormalForm();
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theMNonEmptyDisjunctiveNormalFormFacade
					.newMNonEmptyDisjunctiveNormalForm(-1);
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
			result.put("addends",
					this.getAddends().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false));
			String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
			if (leaf && !allResults.contains(uniqueKey))
				allResults.put(uniqueKey, result);
		}
		return result;
	}

	@Override
	public MNonEmptyDisjunctiveNormalForm provideCopy() throws PersistenceException {
		MNonEmptyDisjunctiveNormalForm result = this;
		result = new MNonEmptyDisjunctiveNormalForm(this.This, this.getId());
		result.addends = this.addends.copy(result);
		this.copyingPrivateUserAttributes(result);
		return result;
	}

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return false;
	}

	protected MNonEmptyDisjunctiveNormalForm_AddendsProxi addends;

	public MNonEmptyDisjunctiveNormalForm(PersistentMType This, long id) throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(This, id);
		this.addends = new MNonEmptyDisjunctiveNormalForm_AddendsProxi(this);
	}

	static public long getTypeId() {
		return 313;
	}

	@Override
	public long getClassId() {
		return getTypeId();
	}

	@Override
	public void store() throws PersistenceException {
		if (!this.isDelayed$Persistence())
			return;
		if (this.getClassId() == 313)
			ConnectionHandler.getTheConnectionHandler().theMNonEmptyDisjunctiveNormalFormFacade
					.newMNonEmptyDisjunctiveNormalForm(this.getId());
		super.store();
		this.getAddends().store();

	}

	@Override
	public MNonEmptyDisjunctiveNormalForm_AddendsProxi getAddends() throws PersistenceException {
		return this.addends;
	}

	@Override
	public PersistentMNonEmptyDisjunctiveNormalForm getThis() throws PersistenceException {
		if (this.This == null) {
			PersistentMNonEmptyDisjunctiveNormalForm result = new MNonEmptyDisjunctiveNormalFormProxi(this.getId());
			result.getTheObject();
			return result;
		}
		return (PersistentMNonEmptyDisjunctiveNormalForm) this.This;
	}

	@Override
	public void accept(MDisjunctiveNormalFormVisitor visitor) throws PersistenceException {
		visitor.handleMNonEmptyDisjunctiveNormalForm(this);
	}

	@Override
	public <R> R accept(MDisjunctiveNormalFormReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMNonEmptyDisjunctiveNormalForm(this);
	}

	@Override
	public <E extends UserException> void accept(MDisjunctiveNormalFormExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleMNonEmptyDisjunctiveNormalForm(this);
	}

	@Override
	public <R, E extends UserException> R accept(MDisjunctiveNormalFormReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMNonEmptyDisjunctiveNormalForm(this);
	}

	@Override
	public void accept(MAbstractTypeDisjunctionVisitor visitor) throws PersistenceException {
		visitor.handleMNonEmptyDisjunctiveNormalForm(this);
	}

	@Override
	public <R> R accept(MAbstractTypeDisjunctionReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMNonEmptyDisjunctiveNormalForm(this);
	}

	@Override
	public <E extends UserException> void accept(MAbstractTypeDisjunctionExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleMNonEmptyDisjunctiveNormalForm(this);
	}

	@Override
	public <R, E extends UserException> R accept(MAbstractTypeDisjunctionReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMNonEmptyDisjunctiveNormalForm(this);
	}

	@Override
	public void accept(MComplexTypeVisitor visitor) throws PersistenceException {
		visitor.handleMNonEmptyDisjunctiveNormalForm(this);
	}

	@Override
	public <R> R accept(MComplexTypeReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMNonEmptyDisjunctiveNormalForm(this);
	}

	@Override
	public <E extends UserException> void accept(MComplexTypeExceptionVisitor<E> visitor) throws PersistenceException,
			E {
		visitor.handleMNonEmptyDisjunctiveNormalForm(this);
	}

	@Override
	public <R, E extends UserException> R accept(MComplexTypeReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMNonEmptyDisjunctiveNormalForm(this);
	}

	@Override
	public void accept(MTypeVisitor visitor) throws PersistenceException {
		visitor.handleMNonEmptyDisjunctiveNormalForm(this);
	}

	@Override
	public <R> R accept(MTypeReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMNonEmptyDisjunctiveNormalForm(this);
	}

	@Override
	public <E extends UserException> void accept(MTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleMNonEmptyDisjunctiveNormalForm(this);
	}

	@Override
	public <R, E extends UserException> R accept(MTypeReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMNonEmptyDisjunctiveNormalForm(this);
	}

	@Override
	public void accept(MComplexTypeHierarchyHIERARCHYVisitor visitor) throws PersistenceException {
		visitor.handleMNonEmptyDisjunctiveNormalForm(this);
	}

	@Override
	public <R> R accept(MComplexTypeHierarchyHIERARCHYReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMNonEmptyDisjunctiveNormalForm(this);
	}

	@Override
	public <E extends UserException> void accept(MComplexTypeHierarchyHIERARCHYExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleMNonEmptyDisjunctiveNormalForm(this);
	}

	@Override
	public <R, E extends UserException> R accept(MComplexTypeHierarchyHIERARCHYReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMNonEmptyDisjunctiveNormalForm(this);
	}

	@Override
	public void accept(AnythingVisitor visitor) throws PersistenceException {
		visitor.handleMNonEmptyDisjunctiveNormalForm(this);
	}

	@Override
	public <R> R accept(AnythingReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMNonEmptyDisjunctiveNormalForm(this);
	}

	@Override
	public <E extends UserException> void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleMNonEmptyDisjunctiveNormalForm(this);
	}

	@Override
	public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMNonEmptyDisjunctiveNormalForm(this);
	}

	@Override
	public int getLeafInfo() throws PersistenceException {
		return (int) (0 + this.getContainedTypes().getLength() + this.getAddends().getLength());
	}

	@Override
	public PersistentMNonEmptyDisjunctiveNormalForm transientMultiplyNonEmpty(
			final PersistentMNonEmptyDisjunctiveNormalForm other) throws PersistenceException {
		final PersistentMNonEmptyDisjunctiveNormalForm result = MNonEmptyDisjunctiveNormalForm
				.createMNonEmptyDisjunctiveNormalForm(true);
		getThis().getAddends().applyToAll(new Procdure<PersistentMAtomicTypeConjunction>() {

			@Override
			public void doItTo(PersistentMAtomicTypeConjunction argument) throws PersistenceException {
				final PersistentMAtomicTypeConjunction firstFactor = argument;
				other.getAddends().applyToAll(new Procdure<PersistentMAtomicTypeConjunction>() {

					@Override
					public void doItTo(PersistentMAtomicTypeConjunction argument) throws PersistenceException {
						MNonEmptyDisjunctiveNormalForm.addAddendNormalize(result,
								firstFactor.transientMultiply(argument));
					}
				});

			}
		});
		return result;

	}

	@Override
	public void initializeOnInstantiation() throws PersistenceException {
	}

	@Override
	public void copyingPrivateUserAttributes(final Anything copy) throws PersistenceException {
	}

	@Override
	public boolean containsMComplexTypeHierarchy(final MComplexTypeHierarchyHIERARCHY part) throws PersistenceException {
		if (getThis().equals(part))
			return true;
		java.util.Iterator iterator0 = getThis().getAddends().iterator();
		while (iterator0.hasNext())
			if (((MComplexTypeHierarchyHIERARCHY) iterator0.next()).containsMComplexTypeHierarchy(part))
				return true;
		return false;
	}

	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String, Object> final$$Fields)
			throws PersistenceException {
		this.setThis((PersistentMNonEmptyDisjunctiveNormalForm) This);
		if (this.equals(This)) {
		}
	}

	@Override
	public <T> T strategyMComplexTypeHierarchy(final T parameter,
			final MComplexTypeHierarchyHIERARCHYStrategy<T> strategy) throws PersistenceException {
		T result$$addends$$MNonEmptyDisjunctiveNormalForm = strategy
				.initialize$$MNonEmptyDisjunctiveNormalForm$$addends(getThis(), parameter);
		java.util.Iterator iterator$$ = getThis().getAddends().iterator();
		while (iterator$$.hasNext()) {
			PersistentMAtomicTypeConjunction current$$Field = (PersistentMAtomicTypeConjunction) iterator$$.next();
			T current$$ = current$$Field.strategyMComplexTypeHierarchy(result$$addends$$MNonEmptyDisjunctiveNormalForm,
					strategy);
			result$$addends$$MNonEmptyDisjunctiveNormalForm = strategy
					.consolidate$$MNonEmptyDisjunctiveNormalForm$$addends(getThis(),
							result$$addends$$MNonEmptyDisjunctiveNormalForm, current$$);
		}
		return strategy.finalize$$MNonEmptyDisjunctiveNormalForm(getThis(), parameter,
				result$$addends$$MNonEmptyDisjunctiveNormalForm);
	}

	@Override
	public PersistentMBoolean isLessOrEqual(final PersistentMType other) throws PersistenceException {
		return MBoolean.createFromBoolean(other.accept(new MTypeReturnVisitor<Boolean>() {

			@Override
			public Boolean handleMMixedTypeDisjunction(PersistentMMixedTypeDisjunction mMixedTypeDisjunction)
					throws PersistenceException {
				return getThis().isLessOrEqual(mMixedTypeDisjunction.fetchDisjunctiveNormalform()).toBoolean();
			}

			@Override
			public Boolean handleMNonEmptyDisjunctiveNormalForm(
					PersistentMNonEmptyDisjunctiveNormalForm mNonEmptyDisjunctiveNormalForm)
					throws PersistenceException {
				Iterator<PersistentMAtomicTypeConjunction> myAddends = getThis().getAddends().iterator();
				while (myAddends.hasNext()) {
					if (!myAddends.next().isLessOrEqual(mNonEmptyDisjunctiveNormalForm).toBoolean()) {
						return false;
					}
				}
				return true;
			}

			@Override
			public Boolean handleMEmptyTypeDisjunction(PersistentMEmptyTypeDisjunction mEmptyTypeDisjunction)
					throws PersistenceException {
				return false;
			}

			@Override
			public Boolean handleMMixedConjunction(PersistentMMixedConjunction mMixedConjunction)
					throws PersistenceException {
				return getThis().isLessOrEqual(mMixedConjunction.fetchDisjunctiveNormalform()).toBoolean();
			}

			@Override
			public Boolean handleMNonEmptyAtomicTypeConjunction(
					PersistentMNonEmptyAtomicTypeConjunction mNonEmptyAtomicTypeConjunction)
					throws PersistenceException {
				Iterator<PersistentMAtomicTypeConjunction> myAddends = getThis().getAddends().iterator();
				while (myAddends.hasNext()) {
					if (!myAddends.next().isLessOrEqual(mNonEmptyAtomicTypeConjunction).toBoolean()) {
						return false;
					}
				}
				return true;
			}

			@Override
			public Boolean handleMEmptyTypeConjunction(PersistentMEmptyTypeConjunction mEmptyTypeConjunction)
					throws PersistenceException {
				return true;
			}

			@Override
			public Boolean handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException {
				Iterator<PersistentMAtomicTypeConjunction> myAddends = getThis().getAddends().iterator();
				while (myAddends.hasNext()) {
					if (!myAddends.next().isLessOrEqual(mAtomicType).toBoolean()) {
						return false;
					}
				}
				return true;
			}
		}));
	}

	@Override
	public void initializeOnCreation() throws PersistenceException {
	}

	@Override
	public PersistentMDisjunctiveNormalForm fetchDisjunctiveNormalform() throws PersistenceException {
		return getThis();
	}

	@Override
	public PersistentMDisjunctiveNormalForm transientMultiply(final PersistentMDisjunctiveNormalForm other)
			throws PersistenceException {
		return other.accept(new MDisjunctiveNormalFormReturnVisitor<PersistentMDisjunctiveNormalForm>() {

			@Override
			public PersistentMDisjunctiveNormalForm handleMNonEmptyDisjunctiveNormalForm(
					PersistentMNonEmptyDisjunctiveNormalForm mNonEmptyDisjunctiveNormalForm)
					throws PersistenceException {
				return getThis().transientMultiplyNonEmpty(mNonEmptyDisjunctiveNormalForm);
			}

			@Override
			public PersistentMDisjunctiveNormalForm handleMEmptyTypeDisjunction(
					PersistentMEmptyTypeDisjunction mEmptyTypeDisjunction) throws PersistenceException {
				return mEmptyTypeDisjunction;
			}
		});
	}

	/* Start of protected part that is not overridden by persistence generator */

	public static PersistentMNonEmptyDisjunctiveNormalForm transientCreateNEDNF(
			List<PersistentMAtomicTypeConjunction> conjunctions) throws PersistenceException {
		PersistentMNonEmptyDisjunctiveNormalForm result = MNonEmptyDisjunctiveNormalForm
				.createMNonEmptyDisjunctiveNormalForm(true);
		for (PersistentMAtomicTypeConjunction conj : conjunctions) {
			try {
				result.getAddends().add(conj);
			} catch (CycleException e) {
				// TODO Should not happen
				e.printStackTrace();
			}
		}
		return result;

	}

	protected static PersistentMNonEmptyDisjunctiveNormalForm transientCreateDNFromAtomicType(PersistentMAtomicType at)
			throws PersistenceException {
		PersistentMNonEmptyDisjunctiveNormalForm result = MNonEmptyDisjunctiveNormalForm
				.createMNonEmptyDisjunctiveNormalForm(true);
		PersistentMNonEmptyAtomicTypeConjunction addend = MNonEmptyAtomicTypeConjunction
				.createMNonEmptyAtomicTypeConjunction(true);
		try {
			addend.getFactors().add(at);
			result.getAddends().add(addend);
		} catch (CycleException e) {
			// TODO Can't occure exception
			e.printStackTrace();
		}
		return result;
	}

	protected static PersistentMNonEmptyDisjunctiveNormalForm transientCreateDNFFromAtomicTypeConjunction(
			PersistentMAtomicTypeConjunction conj) throws PersistenceException {
		PersistentMNonEmptyDisjunctiveNormalForm result = MNonEmptyDisjunctiveNormalForm
				.createMNonEmptyDisjunctiveNormalForm(true);
		try {
			result.getAddends().add(conj);
		} catch (CycleException e) {
			// TODO Can't occure exception
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public SearchListRoot<? extends PersistentMType> fetchContainedTypes() throws PersistenceException {
		return getThis().getAddends();
	}

	protected static void addAddendNormalize(PersistentMNonEmptyDisjunctiveNormalForm result,
			PersistentMAtomicTypeConjunction newAddend) throws PersistenceException {
		boolean addAddend = true;
		try {
			Iterator<PersistentMAtomicTypeConjunction> resultAddendI = result.getAddends().iterator();

			while (addAddend && resultAddendI.hasNext()) {
				PersistentMAtomicTypeConjunction currentResAddend = resultAddendI.next();
				if (newAddend.isLessOrEqual(currentResAddend).toBoolean()) {
					addAddend = false;
				} else if (currentResAddend.isLessOrEqual(newAddend).toBoolean()) {
					resultAddendI.remove();
				}
			}
			if (addAddend) {
				result.getAddends().add(newAddend);
			}
		} catch (CycleException e) {
			// TODO Should not happen
			e.printStackTrace();
		}
	}

	/* End of protected part that is not overridden by persistence generator */

}
