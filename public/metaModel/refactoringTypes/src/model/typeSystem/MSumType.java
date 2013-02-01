package model.typeSystem;

import model.CycleException;
import model.UserException;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.MAbstractSumTypeExceptionVisitor;
import model.visitor.MAbstractSumTypeReturnExceptionVisitor;
import model.visitor.MAbstractSumTypeReturnVisitor;
import model.visitor.MAbstractSumTypeVisitor;
import model.visitor.MComplexTypeExceptionVisitor;
import model.visitor.MComplexTypeHierarchyHIERARCHYExceptionVisitor;
import model.visitor.MComplexTypeHierarchyHIERARCHYReturnExceptionVisitor;
import model.visitor.MComplexTypeHierarchyHIERARCHYReturnVisitor;
import model.visitor.MComplexTypeHierarchyHIERARCHYVisitor;
import model.visitor.MComplexTypeReturnExceptionVisitor;
import model.visitor.MComplexTypeReturnVisitor;
import model.visitor.MComplexTypeVisitor;
import model.visitor.MNonEmptySumTypeExceptionVisitor;
import model.visitor.MNonEmptySumTypeReturnExceptionVisitor;
import model.visitor.MNonEmptySumTypeReturnVisitor;
import model.visitor.MNonEmptySumTypeVisitor;
import model.visitor.MTypeExceptionVisitor;
import model.visitor.MTypeReturnExceptionVisitor;
import model.visitor.MTypeReturnVisitor;
import model.visitor.MTypeVisitor;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.MComplexTypeHierarchyHIERARCHY;
import persistence.MComplexTypeHierarchyHIERARCHYStrategy;
import persistence.MSumTypeProxi;
import persistence.MSumType_AddendsProxi;
import persistence.MTypeSearchList;
import persistence.PersistenceException;
import persistence.PersistentMAbstractSumType;
import persistence.PersistentMAtomicTypeProduct;
import persistence.PersistentMBoolean;
import persistence.PersistentMDisjuncitveNF;
import persistence.PersistentMSumType;
import persistence.PersistentMType;
import persistence.Procdure;
import persistence.ProcdureException;
import persistence.TDObserver;

/* Additional import section end */

public class MSumType extends model.typeSystem.MNonEmptySumType implements PersistentMSumType {

	public static PersistentMSumType createMSumType() throws PersistenceException {
		return createMSumType(false);
	}

	public static PersistentMSumType createMSumType(boolean delayed$Persistence) throws PersistenceException {
		PersistentMSumType result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theMSumTypeFacade.newDelayedMSumType();
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theMSumTypeFacade.newMSumType(-1);
		}
		java.util.Hashtable<String, Object> final$$Fields = new java.util.Hashtable<String, Object>();
		result.initialize(result, final$$Fields);
		result.initializeOnCreation();
		return result;
	}

	public static PersistentMSumType createMSumType(boolean delayed$Persistence, PersistentMSumType This)
			throws PersistenceException {
		PersistentMSumType result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theMSumTypeFacade.newDelayedMSumType();
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theMSumTypeFacade.newMSumType(-1);
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
	public MSumType provideCopy() throws PersistenceException {
		MSumType result = this;
		result = new MSumType(this.This, this.getId());
		result.addends = this.addends.copy(result);
		this.copyingPrivateUserAttributes(result);
		return result;
	}

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return false;
	}

	protected MSumType_AddendsProxi addends;

	public MSumType(PersistentMType This, long id) throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(This, id);
		this.addends = new MSumType_AddendsProxi(this);
	}

	static public long getTypeId() {
		return 144;
	}

	@Override
	public long getClassId() {
		return getTypeId();
	}

	@Override
	public void store() throws PersistenceException {
		if (!this.isDelayed$Persistence())
			return;
		if (this.getClassId() == 144)
			ConnectionHandler.getTheConnectionHandler().theMSumTypeFacade.newMSumType(this.getId());
		super.store();
		this.getAddends().store();

	}

	@Override
	public MSumType_AddendsProxi getAddends() throws PersistenceException {
		return this.addends;
	}

	@Override
	public PersistentMSumType getThis() throws PersistenceException {
		if (this.This == null) {
			PersistentMSumType result = new MSumTypeProxi(this.getId());
			result.getTheObject();
			return result;
		}
		return (PersistentMSumType) this.This;
	}

	@Override
	public void accept(MNonEmptySumTypeVisitor visitor) throws PersistenceException {
		visitor.handleMSumType(this);
	}

	@Override
	public <R> R accept(MNonEmptySumTypeReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMSumType(this);
	}

	@Override
	public <E extends UserException> void accept(MNonEmptySumTypeExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleMSumType(this);
	}

	@Override
	public <R, E extends UserException> R accept(MNonEmptySumTypeReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMSumType(this);
	}

	@Override
	public void accept(MAbstractSumTypeVisitor visitor) throws PersistenceException {
		visitor.handleMSumType(this);
	}

	@Override
	public <R> R accept(MAbstractSumTypeReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMSumType(this);
	}

	@Override
	public <E extends UserException> void accept(MAbstractSumTypeExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleMSumType(this);
	}

	@Override
	public <R, E extends UserException> R accept(MAbstractSumTypeReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMSumType(this);
	}

	@Override
	public void accept(MComplexTypeVisitor visitor) throws PersistenceException {
		visitor.handleMSumType(this);
	}

	@Override
	public <R> R accept(MComplexTypeReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMSumType(this);
	}

	@Override
	public <E extends UserException> void accept(MComplexTypeExceptionVisitor<E> visitor) throws PersistenceException,
			E {
		visitor.handleMSumType(this);
	}

	@Override
	public <R, E extends UserException> R accept(MComplexTypeReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMSumType(this);
	}

	@Override
	public void accept(MTypeVisitor visitor) throws PersistenceException {
		visitor.handleMSumType(this);
	}

	@Override
	public <R> R accept(MTypeReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMSumType(this);
	}

	@Override
	public <E extends UserException> void accept(MTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleMSumType(this);
	}

	@Override
	public <R, E extends UserException> R accept(MTypeReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMSumType(this);
	}

	@Override
	public void accept(MComplexTypeHierarchyHIERARCHYVisitor visitor) throws PersistenceException {
		visitor.handleMSumType(this);
	}

	@Override
	public <R> R accept(MComplexTypeHierarchyHIERARCHYReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMSumType(this);
	}

	@Override
	public <E extends UserException> void accept(MComplexTypeHierarchyHIERARCHYExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleMSumType(this);
	}

	@Override
	public <R, E extends UserException> R accept(MComplexTypeHierarchyHIERARCHYReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMSumType(this);
	}

	@Override
	public void accept(AnythingVisitor visitor) throws PersistenceException {
		visitor.handleMSumType(this);
	}

	@Override
	public <R> R accept(AnythingReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMSumType(this);
	}

	@Override
	public <E extends UserException> void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleMSumType(this);
	}

	@Override
	public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMSumType(this);
	}

	@Override
	public int getLeafInfo() throws PersistenceException {
		return (int) (0 + this.getContainedTypes().getLength() + this.getAddends().getLength());
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
		this.setThis((PersistentMSumType) This);
		if (this.equals(This)) {
		}
	}

	@Override
	public <T> T strategyMComplexTypeHierarchy(final T parameter,
			final MComplexTypeHierarchyHIERARCHYStrategy<T> strategy) throws PersistenceException {
		T result$$addends$$MSumType = strategy.initialize$$MSumType$$addends(getThis(), parameter);
		java.util.Iterator iterator$$ = getThis().getAddends().iterator();
		while (iterator$$.hasNext()) {
			PersistentMType current$$Field = (PersistentMType) iterator$$.next();
			T current$$ = current$$Field.strategyMComplexTypeHierarchy(result$$addends$$MSumType, strategy);
			result$$addends$$MSumType = strategy.consolidate$$MSumType$$addends(getThis(), result$$addends$$MSumType,
					current$$);
		}
		return strategy.finalize$$MSumType(getThis(), parameter, result$$addends$$MSumType);
	}

	@Override
	public PersistentMBoolean isLessOrEqual(final PersistentMType other) throws PersistenceException {
		return getThis().fetchDisjunctiveNormalform().isLessOrEqual(other);
	}

	@Override
	public void initializeOnCreation() throws PersistenceException {
	}

	@Override
	public PersistentMDisjuncitveNF fetchDisjunctiveNormalform() throws PersistenceException {
		final PersistentMDisjuncitveNF result = MDisjuncitveNF.createMDisjuncitveNF(true);
		try {
			getThis().getAddends().applyToAllException(new ProcdureException<PersistentMType, CycleException>() {

				@Override
				public void doItTo(PersistentMType argument) throws PersistenceException, CycleException {
					PersistentMDisjuncitveNF dnf = argument.fetchDisjunctiveNormalform();
					dnf.getAddends().applyToAllException(
							new ProcdureException<PersistentMAtomicTypeProduct, CycleException>() {

								@Override
								public void doItTo(PersistentMAtomicTypeProduct argument) throws PersistenceException,
										CycleException {
									result.getAddends().add(argument);
								}

							});
				}
			});
		} catch (CycleException e) {
			// TODO Exception behandeln. Was m??ssen wir dann hier eigentlich machen?
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public PersistentMAbstractSumType fetchDisjunctiveNormalform_old() throws PersistenceException {
		final PersistentMSumType sumType = MSumType.createMSumType(true);

		try {
			this.getThis().getContainedTypes()
					.applyToAllException(new ProcdureException<PersistentMType, CycleException>() {

						@Override
						public void doItTo(PersistentMType argument) throws PersistenceException, CycleException {
							PersistentMAbstractSumType dnf = argument.fetchDisjunctiveNormalform();
							dnf.getContainedTypes().applyToAllException(
									new ProcdureException<PersistentMType, CycleException>() {

										@Override
										public void doItTo(PersistentMType product) throws PersistenceException,
												CycleException {
											sumType.getContainedTypes().add(product);
										}
									});
						}
					});
		} catch (CycleException e) {
			// TODO Exception behandeln. Was m??ssen wir dann hier eigentlich machen?
			e.printStackTrace();
		}

		return sumType;
	}

	@Override
	public MTypeSearchList getContainedTypes() throws PersistenceException {
		final MTypeSearchList result = new MTypeSearchList();
		getThis().getAddends().applyToAll(new Procdure<PersistentMType>() {

			@Override
			public void doItTo(PersistentMType argument) throws PersistenceException {
				result.add(argument);
			}
		});
		return result;
	}

	/* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */

}
