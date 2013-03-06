package utils;

import model.visitor.MTypeReturnVisitor;
import persistence.PersistenceException;
import persistence.PersistentMAtomicType;
import persistence.PersistentMEmptyTypeConjunction;
import persistence.PersistentMEmptyTypeDisjunction;
import persistence.PersistentMMixedConjunction;
import persistence.PersistentMMixedTypeDisjunction;
import persistence.PersistentMNonEmptyAtomicTypeConjunction;
import persistence.PersistentMNonEmptyDisjunctiveNormalForm;

/**
 * MTypeReturnVisitor zum Pruefen, ob es sich bei dem Typen um die leere Summe handelt.
 * 
 * @author tkoenig
 * 
 */
public class EmptySumTypeReturnBooleanVisitor implements MTypeReturnVisitor<Boolean> {

	@Override
	public Boolean handleMMixedTypeDisjunction(final PersistentMMixedTypeDisjunction mMixedTypeDisjunction)
			throws PersistenceException {
		return false;
	}

	@Override
	public Boolean handleMNonEmptyDisjunctiveNormalForm(
			final PersistentMNonEmptyDisjunctiveNormalForm mNonEmptyDisjunctiveNormalForm) throws PersistenceException {
		return false;
	}

	@Override
	public Boolean handleMEmptyTypeDisjunction(final PersistentMEmptyTypeDisjunction mEmptyTypeDisjunction)
			throws PersistenceException {
		return true;
	}

	@Override
	public Boolean handleMMixedConjunction(final PersistentMMixedConjunction mMixedConjunction)
			throws PersistenceException {
		return false;
	}

	@Override
	public Boolean handleMNonEmptyAtomicTypeConjunction(
			final PersistentMNonEmptyAtomicTypeConjunction mNonEmptyAtomicTypeConjunction) throws PersistenceException {
		return false;
	}

	@Override
	public Boolean handleMEmptyTypeConjunction(final PersistentMEmptyTypeConjunction mEmptyTypeConjunction)
			throws PersistenceException {
		return false;
	}

	@Override
	public Boolean handleMAtomicType(final PersistentMAtomicType mAtomicType) throws PersistenceException {
		return false;
	}
}
