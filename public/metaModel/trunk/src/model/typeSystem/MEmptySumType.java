package model.typeSystem;

import model.UserException;
import model.basic.MBoolean;
import model.basic.MTrue;
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
import model.visitor.MTypeExceptionVisitor;
import model.visitor.MTypeReturnExceptionVisitor;
import model.visitor.MTypeReturnVisitor;
import model.visitor.MTypeVisitor;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.MComplexTypeHierarchyHIERARCHY;
import persistence.MComplexTypeHierarchyHIERARCHYStrategy;
import persistence.MEmptySumTypeProxi;
import persistence.PersistenceException;
import persistence.PersistentMAbstractSumType;
import persistence.PersistentMBoolean;
import persistence.PersistentMEmptySumType;
import persistence.PersistentMType;
import persistence.TDObserver;

/* Additional import section end */

public class MEmptySumType extends model.typeSystem.MAbstractSumType implements PersistentMEmptySumType {

	private static PersistentMEmptySumType theMEmptySumType = null;
	public static boolean reset$For$Test = false;
	private static final Object $$lock = new Object();

	public static PersistentMEmptySumType getTheMEmptySumType() throws PersistenceException {
		if (theMEmptySumType == null || reset$For$Test) {
			class Initializer implements Runnable {
				PersistenceException exception = null;

				@Override
				public void run() {
					try {
						MEmptySumTypeProxi proxi = null;
						synchronized ($$lock) {
							proxi = ConnectionHandler.getTheConnectionHandler().theMEmptySumTypeFacade
									.getTheMEmptySumType();
							theMEmptySumType = proxi;
						}
						if (proxi.getId() < 0) {
							proxi.setId(proxi.getId() * -1);
							proxi.initialize(proxi, new java.util.Hashtable<String, Object>());
							proxi.initializeOnCreation();
						}
					} catch (PersistenceException e) {
						exception = e;
					}
					synchronized ($$lock) {
						$$lock.notify();
					}
				}

				PersistentMEmptySumType getResult() throws PersistenceException {
					if (exception != null)
						throw exception;
					return theMEmptySumType;
				}
			}
			synchronized ($$lock) {
				reset$For$Test = false;
				Initializer initializer = new Initializer();
				new Thread(initializer).start();
				try {
					$$lock.wait();
				} catch (InterruptedException e) {
				} // Need not to be interrupted
				return initializer.getResult();
			}
		}
		return theMEmptySumType;
	}

	@Override
	public java.util.Hashtable<String, Object> toHashtable(java.util.Hashtable<String, Object> allResults, int depth,
			int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
		java.util.Hashtable<String, Object> result = null;
		if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth) {
			result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
			String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
			if (leaf && !allResults.contains(uniqueKey))
				allResults.put(uniqueKey, result);
		}
		return result;
	}

	@Override
	public MEmptySumType provideCopy() throws PersistenceException {
		MEmptySumType result = this;
		result = new MEmptySumType(this.This, this.getId());
		result.containedTypes = this.containedTypes.copy(result);
		this.copyingPrivateUserAttributes(result);
		return result;
	}

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return false;
	}

	public MEmptySumType(PersistentMType This, long id) throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(This, id);
	}

	static public long getTypeId() {
		return 187;
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
	public PersistentMEmptySumType getThis() throws PersistenceException {
		if (this.This == null) {
			PersistentMEmptySumType result = new MEmptySumTypeProxi(this.getId());
			result.getTheObject();
			return result;
		}
		return (PersistentMEmptySumType) this.This;
	}

	@Override
	public void accept(MAbstractSumTypeVisitor visitor) throws PersistenceException {
		visitor.handleMEmptySumType(this);
	}

	@Override
	public <R> R accept(MAbstractSumTypeReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMEmptySumType(this);
	}

	@Override
	public <E extends UserException> void accept(MAbstractSumTypeExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleMEmptySumType(this);
	}

	@Override
	public <R, E extends UserException> R accept(MAbstractSumTypeReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMEmptySumType(this);
	}

	@Override
	public void accept(MComplexTypeVisitor visitor) throws PersistenceException {
		visitor.handleMEmptySumType(this);
	}

	@Override
	public <R> R accept(MComplexTypeReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMEmptySumType(this);
	}

	@Override
	public <E extends UserException> void accept(MComplexTypeExceptionVisitor<E> visitor) throws PersistenceException,
			E {
		visitor.handleMEmptySumType(this);
	}

	@Override
	public <R, E extends UserException> R accept(MComplexTypeReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMEmptySumType(this);
	}

	@Override
	public void accept(MTypeVisitor visitor) throws PersistenceException {
		visitor.handleMEmptySumType(this);
	}

	@Override
	public <R> R accept(MTypeReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMEmptySumType(this);
	}

	@Override
	public <E extends UserException> void accept(MTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleMEmptySumType(this);
	}

	@Override
	public <R, E extends UserException> R accept(MTypeReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMEmptySumType(this);
	}

	@Override
	public void accept(MComplexTypeHierarchyHIERARCHYVisitor visitor) throws PersistenceException {
		visitor.handleMEmptySumType(this);
	}

	@Override
	public <R> R accept(MComplexTypeHierarchyHIERARCHYReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMEmptySumType(this);
	}

	@Override
	public <E extends UserException> void accept(MComplexTypeHierarchyHIERARCHYExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleMEmptySumType(this);
	}

	@Override
	public <R, E extends UserException> R accept(MComplexTypeHierarchyHIERARCHYReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMEmptySumType(this);
	}

	@Override
	public void accept(AnythingVisitor visitor) throws PersistenceException {
		visitor.handleMEmptySumType(this);
	}

	@Override
	public <R> R accept(AnythingReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMEmptySumType(this);
	}

	@Override
	public <E extends UserException> void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleMEmptySumType(this);
	}

	@Override
	public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMEmptySumType(this);
	}

	@Override
	public int getLeafInfo() throws PersistenceException {
		return (int) (0 + this.getContainedTypes().getLength());
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
		java.util.Iterator iterator0 = getThis().getContainedTypes().iterator();
		while (iterator0.hasNext())
			if (((MComplexTypeHierarchyHIERARCHY) iterator0.next()).containsMComplexTypeHierarchy(part))
				return true;
		return false;
	}

	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String, Object> final$$Fields)
			throws PersistenceException {
		this.setThis((PersistentMEmptySumType) This);
		if (this.equals(This)) {
		}
	}

	@Override
	public PersistentMBoolean isStructuralEquivalant(final PersistentMType other) throws PersistenceException {
		return MBoolean.createFromBoolean(getThis().equals(other));
	}

	@Override
	public PersistentMBoolean isLessOrEqual(final PersistentMType other) throws PersistenceException {
		// TODO: implement method: isLessOrEqual
		try {
			throw new java.lang.UnsupportedOperationException("Method \"isLessOrEqual\" not implemented yet.");
		} catch (java.lang.UnsupportedOperationException uoe) {
			uoe.printStackTrace();
			throw uoe;
		}
	}

	@Override
	public <T> T strategyMComplexTypeHierarchy(final T parameter,
			final MComplexTypeHierarchyHIERARCHYStrategy<T> strategy) throws PersistenceException {
		T result$$containedTypes$$MEmptySumType = strategy.initialize$$MEmptySumType$$containedTypes(getThis(),
				parameter);
		java.util.Iterator iterator$$ = getThis().getContainedTypes().iterator();
		while (iterator$$.hasNext()) {
			PersistentMType current$$Field = (PersistentMType) iterator$$.next();
			T current$$ = current$$Field.strategyMComplexTypeHierarchy(result$$containedTypes$$MEmptySumType, strategy);
			result$$containedTypes$$MEmptySumType = strategy.consolidate$$MEmptySumType$$containedTypes(getThis(),
					result$$containedTypes$$MEmptySumType, current$$);
		}
		return strategy.finalize$$MEmptySumType(getThis(), parameter, result$$containedTypes$$MEmptySumType);
	}

	@Override
	public void initializeOnCreation() throws PersistenceException {
	}

	@Override
	public PersistentMBoolean isSingleton() throws PersistenceException {
		return MTrue.getTheMTrue();
	}

	@Override
	public PersistentMAbstractSumType fetchDisjunctiveNormalform() throws PersistenceException {
		return this.getThis();
	}

	@Override
	public PersistentMBoolean isAbstract() throws PersistenceException {
		return MTrue.getTheMTrue();
	}

	@Override
	public String fetchName() throws PersistenceException {
		return "[Empty Sum]";
	}

	/* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */

}
