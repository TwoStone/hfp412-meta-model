package model.typeSystem;

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
import persistence.MDisjuncitveNFProxi;
import persistence.MDisjuncitveNF_AddendsProxi;
import persistence.MTypeSearchList;
import persistence.PersistenceException;
import persistence.PersistentMAbstractSumType;
import persistence.PersistentMAtomicTypeProduct;
import persistence.PersistentMBoolean;
import persistence.PersistentMDisjuncitveNF;
import persistence.PersistentMType;
import persistence.Procdure;
import persistence.TDObserver;

/* Additional import section end */

public class MDisjuncitveNF extends model.typeSystem.MNonEmptySumType implements PersistentMDisjuncitveNF {

	public static PersistentMDisjuncitveNF createMDisjuncitveNF() throws PersistenceException {
		return createMDisjuncitveNF(false);
	}

	public static PersistentMDisjuncitveNF createMDisjuncitveNF(boolean delayed$Persistence)
			throws PersistenceException {
		PersistentMDisjuncitveNF result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theMDisjuncitveNFFacade.newDelayedMDisjuncitveNF();
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theMDisjuncitveNFFacade.newMDisjuncitveNF(-1);
		}
		java.util.Hashtable<String, Object> final$$Fields = new java.util.Hashtable<String, Object>();
		result.initialize(result, final$$Fields);
		result.initializeOnCreation();
		return result;
	}

	public static PersistentMDisjuncitveNF createMDisjuncitveNF(boolean delayed$Persistence,
			PersistentMDisjuncitveNF This) throws PersistenceException {
		PersistentMDisjuncitveNF result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theMDisjuncitveNFFacade.newDelayedMDisjuncitveNF();
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theMDisjuncitveNFFacade.newMDisjuncitveNF(-1);
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
	public MDisjuncitveNF provideCopy() throws PersistenceException {
		MDisjuncitveNF result = this;
		result = new MDisjuncitveNF(this.This, this.getId());
		result.addends = this.addends.copy(result);
		this.copyingPrivateUserAttributes(result);
		return result;
	}

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return false;
	}

	protected MDisjuncitveNF_AddendsProxi addends;

	public MDisjuncitveNF(PersistentMType This, long id) throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(This, id);
		this.addends = new MDisjuncitveNF_AddendsProxi(this);
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
			ConnectionHandler.getTheConnectionHandler().theMDisjuncitveNFFacade.newMDisjuncitveNF(this.getId());
		super.store();
		this.getAddends().store();

	}

	@Override
	public MDisjuncitveNF_AddendsProxi getAddends() throws PersistenceException {
		return this.addends;
	}

	@Override
	public PersistentMDisjuncitveNF getThis() throws PersistenceException {
		if (this.This == null) {
			PersistentMDisjuncitveNF result = new MDisjuncitveNFProxi(this.getId());
			result.getTheObject();
			return result;
		}
		return (PersistentMDisjuncitveNF) this.This;
	}

	@Override
	public void accept(MNonEmptySumTypeVisitor visitor) throws PersistenceException {
		visitor.handleMDisjuncitveNF(this);
	}

	@Override
	public <R> R accept(MNonEmptySumTypeReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMDisjuncitveNF(this);
	}

	@Override
	public <E extends UserException> void accept(MNonEmptySumTypeExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleMDisjuncitveNF(this);
	}

	@Override
	public <R, E extends UserException> R accept(MNonEmptySumTypeReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMDisjuncitveNF(this);
	}

	@Override
	public void accept(MAbstractSumTypeVisitor visitor) throws PersistenceException {
		visitor.handleMDisjuncitveNF(this);
	}

	@Override
	public <R> R accept(MAbstractSumTypeReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMDisjuncitveNF(this);
	}

	@Override
	public <E extends UserException> void accept(MAbstractSumTypeExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleMDisjuncitveNF(this);
	}

	@Override
	public <R, E extends UserException> R accept(MAbstractSumTypeReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMDisjuncitveNF(this);
	}

	@Override
	public void accept(MComplexTypeVisitor visitor) throws PersistenceException {
		visitor.handleMDisjuncitveNF(this);
	}

	@Override
	public <R> R accept(MComplexTypeReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMDisjuncitveNF(this);
	}

	@Override
	public <E extends UserException> void accept(MComplexTypeExceptionVisitor<E> visitor) throws PersistenceException,
			E {
		visitor.handleMDisjuncitveNF(this);
	}

	@Override
	public <R, E extends UserException> R accept(MComplexTypeReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMDisjuncitveNF(this);
	}

	@Override
	public void accept(MTypeVisitor visitor) throws PersistenceException {
		visitor.handleMDisjuncitveNF(this);
	}

	@Override
	public <R> R accept(MTypeReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMDisjuncitveNF(this);
	}

	@Override
	public <E extends UserException> void accept(MTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleMDisjuncitveNF(this);
	}

	@Override
	public <R, E extends UserException> R accept(MTypeReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMDisjuncitveNF(this);
	}

	@Override
	public void accept(MComplexTypeHierarchyHIERARCHYVisitor visitor) throws PersistenceException {
		visitor.handleMDisjuncitveNF(this);
	}

	@Override
	public <R> R accept(MComplexTypeHierarchyHIERARCHYReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMDisjuncitveNF(this);
	}

	@Override
	public <E extends UserException> void accept(MComplexTypeHierarchyHIERARCHYExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleMDisjuncitveNF(this);
	}

	@Override
	public <R, E extends UserException> R accept(MComplexTypeHierarchyHIERARCHYReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMDisjuncitveNF(this);
	}

	@Override
	public void accept(AnythingVisitor visitor) throws PersistenceException {
		visitor.handleMDisjuncitveNF(this);
	}

	@Override
	public <R> R accept(AnythingReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMDisjuncitveNF(this);
	}

	@Override
	public <E extends UserException> void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleMDisjuncitveNF(this);
	}

	@Override
	public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMDisjuncitveNF(this);
	}

	@Override
	public int getLeafInfo() throws PersistenceException {
		return (int) (0 + this.getContainedTypes().getLength() + this.getAddends().getLength());
	}

	@Override
	public void initializeOnInstantiation() throws PersistenceException {
		// TODO: implement method: initializeOnInstantiation

	}

	@Override
	public void copyingPrivateUserAttributes(final Anything copy) throws PersistenceException {
		// TODO: implement method: copyingPrivateUserAttributes

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
		this.setThis((PersistentMDisjuncitveNF) This);
		if (this.equals(This)) {
		}
	}

	@Override
	public PersistentMBoolean isStructuralEquivalant(final PersistentMType other) throws PersistenceException {
		// TODO: implement method: isStructuralEquivalant
		try {
			throw new java.lang.UnsupportedOperationException("Method \"isStructuralEquivalant\" not implemented yet.");
		} catch (java.lang.UnsupportedOperationException uoe) {
			uoe.printStackTrace();
			throw uoe;
		}
	}

	@Override
	public <T> T strategyMComplexTypeHierarchy(final T parameter,
			final MComplexTypeHierarchyHIERARCHYStrategy<T> strategy) throws PersistenceException {
		T result$$addends$$MDisjuncitveNF = strategy.initialize$$MDisjuncitveNF$$addends(getThis(), parameter);
		java.util.Iterator iterator$$ = getThis().getAddends().iterator();
		while (iterator$$.hasNext()) {
			PersistentMAtomicTypeProduct current$$Field = (PersistentMAtomicTypeProduct) iterator$$.next();
			T current$$ = current$$Field.strategyMComplexTypeHierarchy(result$$addends$$MDisjuncitveNF, strategy);
			result$$addends$$MDisjuncitveNF = strategy.consolidate$$MDisjuncitveNF$$addends(getThis(),
					result$$addends$$MDisjuncitveNF, current$$);
		}
		return strategy.finalize$$MDisjuncitveNF(getThis(), parameter, result$$addends$$MDisjuncitveNF);
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
	public void initializeOnCreation() throws PersistenceException {
		// TODO: implement method: initializeOnCreation

	}

	@Override
	public PersistentMDisjuncitveNF fetchDisjunctiveNormalform() throws PersistenceException {
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
