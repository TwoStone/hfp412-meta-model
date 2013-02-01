package model.typeSystem;

import model.UserException;
import model.basic.MFalse;
import model.basic.MTrue;
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
import persistence.MEmptyProductTypeProxi;
import persistence.MTypeSearchList;
import persistence.PersistenceException;
import persistence.PersistentMAbstractSumType;
import persistence.PersistentMBoolean;
import persistence.PersistentMDisjuncitveNF;
import persistence.PersistentMEmptyProductType;
import persistence.PersistentMType;
import persistence.TDObserver;

/* Additional import section end */

public class MEmptyProductType extends model.typeSystem.MAbstractProductType implements PersistentMEmptyProductType {

	private static PersistentMEmptyProductType theMEmptyProductType = null;
	public static boolean reset$For$Test = false;
	private static final Object $$lock = new Object();

	public static PersistentMEmptyProductType getTheMEmptyProductType() throws PersistenceException {
		if (theMEmptyProductType == null || reset$For$Test) {
			class Initializer implements Runnable {
				PersistenceException exception = null;

				@Override
				public void run() {
					try {
						MEmptyProductTypeProxi proxi = null;
						synchronized ($$lock) {
							proxi = ConnectionHandler.getTheConnectionHandler().theMEmptyProductTypeFacade
									.getTheMEmptyProductType();
							theMEmptyProductType = proxi;
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

				PersistentMEmptyProductType getResult() throws PersistenceException {
					if (exception != null)
						throw exception;
					return theMEmptyProductType;
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
		return theMEmptyProductType;
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
	public MEmptyProductType provideCopy() throws PersistenceException {
		MEmptyProductType result = this;
		result = new MEmptyProductType(this.This, this.getId());
		this.copyingPrivateUserAttributes(result);
		return result;
	}

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return false;
	}

	public MEmptyProductType(PersistentMType This, long id) throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(This, id);
	}

	static public long getTypeId() {
		return 238;
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
	public PersistentMEmptyProductType getThis() throws PersistenceException {
		if (this.This == null) {
			PersistentMEmptyProductType result = new MEmptyProductTypeProxi(this.getId());
			result.getTheObject();
			return result;
		}
		return (PersistentMEmptyProductType) this.This;
	}

	@Override
	public void accept(MAbstractProductTypeVisitor visitor) throws PersistenceException {
		visitor.handleMEmptyProductType(this);
	}

	@Override
	public <R> R accept(MAbstractProductTypeReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMEmptyProductType(this);
	}

	@Override
	public <E extends UserException> void accept(MAbstractProductTypeExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleMEmptyProductType(this);
	}

	@Override
	public <R, E extends UserException> R accept(MAbstractProductTypeReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMEmptyProductType(this);
	}

	@Override
	public void accept(MComplexTypeVisitor visitor) throws PersistenceException {
		visitor.handleMEmptyProductType(this);
	}

	@Override
	public <R> R accept(MComplexTypeReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMEmptyProductType(this);
	}

	@Override
	public <E extends UserException> void accept(MComplexTypeExceptionVisitor<E> visitor) throws PersistenceException,
			E {
		visitor.handleMEmptyProductType(this);
	}

	@Override
	public <R, E extends UserException> R accept(MComplexTypeReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMEmptyProductType(this);
	}

	@Override
	public void accept(MTypeVisitor visitor) throws PersistenceException {
		visitor.handleMEmptyProductType(this);
	}

	@Override
	public <R> R accept(MTypeReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMEmptyProductType(this);
	}

	@Override
	public <E extends UserException> void accept(MTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleMEmptyProductType(this);
	}

	@Override
	public <R, E extends UserException> R accept(MTypeReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMEmptyProductType(this);
	}

	@Override
	public void accept(MComplexTypeHierarchyHIERARCHYVisitor visitor) throws PersistenceException {
		visitor.handleMEmptyProductType(this);
	}

	@Override
	public <R> R accept(MComplexTypeHierarchyHIERARCHYReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMEmptyProductType(this);
	}

	@Override
	public <E extends UserException> void accept(MComplexTypeHierarchyHIERARCHYExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleMEmptyProductType(this);
	}

	@Override
	public <R, E extends UserException> R accept(MComplexTypeHierarchyHIERARCHYReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMEmptyProductType(this);
	}

	@Override
	public void accept(AnythingVisitor visitor) throws PersistenceException {
		visitor.handleMEmptyProductType(this);
	}

	@Override
	public <R> R accept(AnythingReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMEmptyProductType(this);
	}

	@Override
	public <E extends UserException> void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleMEmptyProductType(this);
	}

	@Override
	public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMEmptyProductType(this);
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
		return false;
	}

	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String, Object> final$$Fields)
			throws PersistenceException {
		this.setThis((PersistentMEmptyProductType) This);
		if (this.equals(This)) {
		}
	}

	@Override
	public <T> T strategyMComplexTypeHierarchy(final T parameter,
			final MComplexTypeHierarchyHIERARCHYStrategy<T> strategy) throws PersistenceException {
		return strategy.finalize$$MEmptyProductType(getThis(), parameter);
	}

	@Override
	public PersistentMBoolean isLessOrEqual(final PersistentMType other) throws PersistenceException {
		return MTrue.getTheMTrue();
	}

	@Override
	public void initializeOnCreation() throws PersistenceException {
	}

	@Override
	public PersistentMDisjuncitveNF fetchDisjunctiveNormalform() throws PersistenceException {
		return MDisjuncitveNF.createMDisjuncitveNF(); // TODO
	}

	@Override
	public PersistentMBoolean isSingleton() throws PersistenceException {
		return MTrue.getTheMTrue();
	}

	@Override
	public PersistentMAbstractSumType fetchDisjunctiveNormalform_old() throws PersistenceException {
		// TODO: implement method: fetchDisjunctiveNormalform_old
		try {
			throw new java.lang.UnsupportedOperationException(
					"Method \"fetchDisjunctiveNormalform_old\" not implemented yet.");
		} catch (java.lang.UnsupportedOperationException uoe) {
			uoe.printStackTrace();
			throw uoe;
		}

		/*
		 * PersistentMSumType sumType = MSumType.createMSumType(true); try {
		 * sumType.getContainedTypes().add(this.getThis()); } catch (CycleException e) { // This will hopefully never
		 * happen! When this happens run and pray! }
		 * 
		 * return sumType;
		 */
	}

	@Override
	public PersistentMBoolean isAbstract() throws PersistenceException {
		return MFalse.getTheMFalse();
	}

	@Override
	public String fetchName() throws PersistenceException {
		return "[Empty Product]";
	}

	@Override
	public MTypeSearchList getContainedTypes() throws PersistenceException {
		return new MTypeSearchList();
	}

	/* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */

}
