package model.typeSystem;

import java.util.Iterator;

import model.CycleException;
import model.UserException;
import model.basic.MBoolean;
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
import persistence.MDisjunctiveNFProxi;
import persistence.MDisjunctiveNF_AddendsProxi;
import persistence.MTypeSearchList;
import persistence.PersistenceException;
import persistence.PersistentMAbstractSumType;
import persistence.PersistentMAtomicType;
import persistence.PersistentMAtomicTypeProduct;
import persistence.PersistentMBoolean;
import persistence.PersistentMDisjunctiveNF;
import persistence.PersistentMEmptyProductType;
import persistence.PersistentMEmptySumType;
import persistence.PersistentMProductType;
import persistence.PersistentMSumType;
import persistence.PersistentMType;
import persistence.Procdure;
import persistence.TDObserver;

/* Additional import section end */

public class MDisjunctiveNF extends model.typeSystem.MNonEmptySumType implements PersistentMDisjunctiveNF {

	public static PersistentMDisjunctiveNF createMDisjunctiveNF() throws PersistenceException {
		return createMDisjunctiveNF(false);
	}

	public static PersistentMDisjunctiveNF createMDisjunctiveNF(boolean delayed$Persistence)
			throws PersistenceException {
		PersistentMDisjunctiveNF result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theMDisjunctiveNFFacade.newDelayedMDisjunctiveNF();
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theMDisjunctiveNFFacade.newMDisjunctiveNF(-1);
		}
		java.util.Hashtable<String, Object> final$$Fields = new java.util.Hashtable<String, Object>();
		result.initialize(result, final$$Fields);
		result.initializeOnCreation();
		return result;
	}

	public static PersistentMDisjunctiveNF createMDisjunctiveNF(boolean delayed$Persistence,
			PersistentMDisjunctiveNF This) throws PersistenceException {
		PersistentMDisjunctiveNF result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theMDisjunctiveNFFacade.newDelayedMDisjunctiveNF();
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theMDisjunctiveNFFacade.newMDisjunctiveNF(-1);
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
	public MDisjunctiveNF provideCopy() throws PersistenceException {
		MDisjunctiveNF result = this;
		result = new MDisjunctiveNF(this.This, this.getId());
		result.addends = this.addends.copy(result);
		this.copyingPrivateUserAttributes(result);
		return result;
	}

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return false;
	}

	protected MDisjunctiveNF_AddendsProxi addends;

	public MDisjunctiveNF(PersistentMType This, long id) throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(This, id);
		this.addends = new MDisjunctiveNF_AddendsProxi(this);
	}

	static public long getTypeId() {
		return 277;
	}

	@Override
	public long getClassId() {
		return getTypeId();
	}

	@Override
	public void store() throws PersistenceException {
		if (!this.isDelayed$Persistence())
			return;
		if (this.getClassId() == 277)
			ConnectionHandler.getTheConnectionHandler().theMDisjunctiveNFFacade.newMDisjunctiveNF(this.getId());
		super.store();
		this.getAddends().store();

	}

	@Override
	public MDisjunctiveNF_AddendsProxi getAddends() throws PersistenceException {
		return this.addends;
	}

	@Override
	public PersistentMDisjunctiveNF getThis() throws PersistenceException {
		if (this.This == null) {
			PersistentMDisjunctiveNF result = new MDisjunctiveNFProxi(this.getId());
			result.getTheObject();
			return result;
		}
		return (PersistentMDisjunctiveNF) this.This;
	}

	@Override
	public void accept(MNonEmptySumTypeVisitor visitor) throws PersistenceException {
		visitor.handleMDisjunctiveNF(this);
	}

	@Override
	public <R> R accept(MNonEmptySumTypeReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMDisjunctiveNF(this);
	}

	@Override
	public <E extends UserException> void accept(MNonEmptySumTypeExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleMDisjunctiveNF(this);
	}

	@Override
	public <R, E extends UserException> R accept(MNonEmptySumTypeReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMDisjunctiveNF(this);
	}

	@Override
	public void accept(MAbstractSumTypeVisitor visitor) throws PersistenceException {
		visitor.handleMDisjunctiveNF(this);
	}

	@Override
	public <R> R accept(MAbstractSumTypeReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMDisjunctiveNF(this);
	}

	@Override
	public <E extends UserException> void accept(MAbstractSumTypeExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleMDisjunctiveNF(this);
	}

	@Override
	public <R, E extends UserException> R accept(MAbstractSumTypeReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMDisjunctiveNF(this);
	}

	@Override
	public void accept(MComplexTypeVisitor visitor) throws PersistenceException {
		visitor.handleMDisjunctiveNF(this);
	}

	@Override
	public <R> R accept(MComplexTypeReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMDisjunctiveNF(this);
	}

	@Override
	public <E extends UserException> void accept(MComplexTypeExceptionVisitor<E> visitor) throws PersistenceException,
			E {
		visitor.handleMDisjunctiveNF(this);
	}

	@Override
	public <R, E extends UserException> R accept(MComplexTypeReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMDisjunctiveNF(this);
	}

	@Override
	public void accept(MTypeVisitor visitor) throws PersistenceException {
		visitor.handleMDisjunctiveNF(this);
	}

	@Override
	public <R> R accept(MTypeReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMDisjunctiveNF(this);
	}

	@Override
	public <E extends UserException> void accept(MTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleMDisjunctiveNF(this);
	}

	@Override
	public <R, E extends UserException> R accept(MTypeReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMDisjunctiveNF(this);
	}

	@Override
	public void accept(MComplexTypeHierarchyHIERARCHYVisitor visitor) throws PersistenceException {
		visitor.handleMDisjunctiveNF(this);
	}

	@Override
	public <R> R accept(MComplexTypeHierarchyHIERARCHYReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMDisjunctiveNF(this);
	}

	@Override
	public <E extends UserException> void accept(MComplexTypeHierarchyHIERARCHYExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleMDisjunctiveNF(this);
	}

	@Override
	public <R, E extends UserException> R accept(MComplexTypeHierarchyHIERARCHYReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMDisjunctiveNF(this);
	}

	@Override
	public void accept(AnythingVisitor visitor) throws PersistenceException {
		visitor.handleMDisjunctiveNF(this);
	}

	@Override
	public <R> R accept(AnythingReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMDisjunctiveNF(this);
	}

	@Override
	public <E extends UserException> void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleMDisjunctiveNF(this);
	}

	@Override
	public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMDisjunctiveNF(this);
	}

	@Override
	public int getLeafInfo() throws PersistenceException {
		return (int) (0 + this.getContainedTypes().getLength() + this.getAddends().getLength());
	}

	@Override
	public void initializeOnInstantiation() throws PersistenceException {
	}

	@Override
	public PersistentMDisjunctiveNF transientMultiply(final PersistentMDisjunctiveNF other) throws PersistenceException {
		final PersistentMDisjunctiveNF result = MDisjunctiveNF.createMDisjunctiveNF(true);
		getThis().getAddends().applyToAll(new Procdure<PersistentMAtomicTypeProduct>() {

			@Override
			public void doItTo(PersistentMAtomicTypeProduct argument) throws PersistenceException {
				final PersistentMAtomicTypeProduct firstFactor = argument;
				other.getAddends().applyToAll(new Procdure<PersistentMAtomicTypeProduct>() {

					@Override
					public void doItTo(PersistentMAtomicTypeProduct argument) throws PersistenceException {
						try {
							result.getAddends().add(firstFactor.transientMultiply(argument));
						} catch (CycleException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});

			}
		});
		return result;
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
		this.setThis((PersistentMDisjunctiveNF) This);
		if (this.equals(This)) {
		}
	}

	@Override
	public <T> T strategyMComplexTypeHierarchy(final T parameter,
			final MComplexTypeHierarchyHIERARCHYStrategy<T> strategy) throws PersistenceException {
		T result$$addends$$MDisjunctiveNF = strategy.initialize$$MDisjunctiveNF$$addends(getThis(), parameter);
		java.util.Iterator iterator$$ = getThis().getAddends().iterator();
		while (iterator$$.hasNext()) {
			PersistentMAtomicTypeProduct current$$Field = (PersistentMAtomicTypeProduct) iterator$$.next();
			T current$$ = current$$Field.strategyMComplexTypeHierarchy(result$$addends$$MDisjunctiveNF, strategy);
			result$$addends$$MDisjunctiveNF = strategy.consolidate$$MDisjunctiveNF$$addends(getThis(),
					result$$addends$$MDisjunctiveNF, current$$);
		}
		return strategy.finalize$$MDisjunctiveNF(getThis(), parameter, result$$addends$$MDisjunctiveNF);
	}

	@Override
	public PersistentMBoolean isLessOrEqual(final PersistentMType other) throws PersistenceException {
		return MBoolean.createFromBoolean(other.accept(new MTypeReturnVisitor<Boolean>() {

			@Override
			public Boolean handleMEmptySumType(PersistentMEmptySumType mEmptySumType) throws PersistenceException {
				return false;
			}

			@Override
			public Boolean handleMDisjunctiveNF(PersistentMDisjunctiveNF mDisjunctiveNF) throws PersistenceException {
				Iterator<PersistentMAtomicTypeProduct> myAddendsI = getThis().getAddends().iterator();
				while (myAddendsI.hasNext()) {
					if (!myAddendsI.next().isLessOrEqual(mDisjunctiveNF).toBoolean()) {
						return false;
					}
				}
				return true;
			}

			@Override
			public Boolean handleMSumType(PersistentMSumType mSumType) throws PersistenceException {
				return getThis().isLessOrEqual(mSumType.fetchDisjunctiveNormalform()).toBoolean();
			}

			@Override
			public Boolean handleMEmptyProductType(PersistentMEmptyProductType mEmptyProductType) {
				return false;
			}

			@Override
			public Boolean handleMAtomicTypeProduct(PersistentMAtomicTypeProduct mAtomicTypeProduct)
					throws PersistenceException {
				Iterator<PersistentMAtomicTypeProduct> myAddendsI = getThis().getAddends().iterator();
				while (myAddendsI.hasNext()) {
					if (!myAddendsI.next().isLessOrEqual(mAtomicTypeProduct).toBoolean()) {
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
				Iterator<PersistentMAtomicTypeProduct> myAddendsI = getThis().getAddends().iterator();
				while (myAddendsI.hasNext()) {
					if (!myAddendsI.next().isLessOrEqual(mAtomicType).toBoolean()) {
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
	public PersistentMDisjunctiveNF fetchDisjunctiveNormalform() throws PersistenceException {
		return getThis();
	}

	@Override
	public PersistentMAbstractSumType fetchDisjunctiveNormalform_old() throws PersistenceException {
		// TODO: implement method: fetchDisjunctiveNormalform
		try {
			throw new java.lang.UnsupportedOperationException(
					"Method \"fetchDisjunctiveNormalform\" not implemented yet.");
		} catch (java.lang.UnsupportedOperationException uoe) {
			uoe.printStackTrace();
			throw uoe;
		}
	}

	@Override
	public MTypeSearchList getContainedTypes() throws PersistenceException {
		final MTypeSearchList result = new MTypeSearchList();
		getThis().getAddends().applyToAll(new Procdure<PersistentMAtomicTypeProduct>() {

			@Override
			public void doItTo(PersistentMAtomicTypeProduct argument) throws PersistenceException {
				result.add(argument);
			}
		});
		return result;
	}

	/* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */

}
