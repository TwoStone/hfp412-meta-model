package model.typeSystem;

import java.util.Iterator;

import model.ConsistencyException;
import model.basic.MBoolean;
import model.basic.MFalse;
import model.basic.MTrue;
import model.visitor.MTypeVisitor;
import persistence.Aggregtion;
import persistence.Anything;
import persistence.MAspectSearchList;
import persistence.MAtomicTypeSearchList;
import persistence.MTypeSearchList;
import persistence.PersistenceException;
import persistence.PersistentCONCMModelItem;
import persistence.PersistentMAbstractTypeConjunction;
import persistence.PersistentMAspect;
import persistence.PersistentMAtomicType;
import persistence.PersistentMBoolean;
import persistence.PersistentMEmptyTypeConjunction;
import persistence.PersistentMEmptyTypeDisjunction;
import persistence.PersistentMMixedConjunction;
import persistence.PersistentMMixedTypeDisjunction;
import persistence.PersistentMModelItem;
import persistence.PersistentMNonEmptyAtomicTypeConjunction;
import persistence.PersistentMNonEmptyDisjunctiveNormalForm;
import persistence.PersistentMType;
import persistence.Predcate;
import persistence.Procdure;
import persistence.ProcdureException;
import persistence.SearchListRoot;
import persistence.TDObserver;

/* Additional import section end */

public abstract class MAbstractTypeConjunction extends model.typeSystem.MComplexType implements
		PersistentMAbstractTypeConjunction {

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
	public abstract MAbstractTypeConjunction provideCopy() throws PersistenceException;

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return true;
	}

	public MAbstractTypeConjunction(final PersistentMType This, final PersistentMModelItem myCONCMModelItem,
			final long id) throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(This, myCONCMModelItem, id);
	}

	static public long getTypeId() {
		return 316;
	}

	@Override
	public long getClassId() {
		return getTypeId();
	}

	@Override
	public void store() throws PersistenceException {
		if (!this.isDelayed$Persistence())
			return;
		super.store();

	}

	@Override
	public abstract PersistentMAbstractTypeConjunction getThis() throws PersistenceException;

	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String, Object> final$$Fields)
			throws PersistenceException {
		this.setThis((PersistentMAbstractTypeConjunction) This);
		if (this.equals(This)) {
			final PersistentCONCMModelItem myCONCMModelItem = model.CONCMModelItem.createCONCMModelItem(
					this.isDelayed$Persistence(), (PersistentMAbstractTypeConjunction) This);
			this.setMyCONCMModelItem(myCONCMModelItem);
		}
	}

	// Start of section that contains operations that must be implemented.

	@Override
	public void copyingPrivateUserAttributes(final Anything copy) throws PersistenceException {
	}

	@Override
	public void initializeOnCreation() throws PersistenceException {
	}

	@Override
	public void initializeOnInstantiation() throws PersistenceException {
	}

	// Start of section that contains overridden operations only.

	@Override
	public String fetchTypeLinkOperator() throws PersistenceException {
		return MAbstractTypeConjunction.TYPE_LINK_OP;
	}

	@Override
	public PersistentMBoolean isAbstract() throws PersistenceException {
		if (getThis().equals(MEmptyTypeConjunction.getTheMEmptyTypeConjunction())) {
			return MTrue.getTheMTrue();
		}

		return MBoolean.createFromBoolean(getThis().getContainedTypes().aggregate(
				new Aggregtion<PersistentMType, Boolean>() {

					@Override
					public Boolean neutral() throws PersistenceException {
						return false;
					}

					@Override
					public Boolean compose(final Boolean result, final PersistentMType argument)
							throws PersistenceException {
						return result || argument.isAbstract().toBoolean();
					}
				}));
	}

	@Override
	public PersistentMBoolean isSingleton() throws PersistenceException {
		return getThis().getContainedTypes().getLength() == 0 ? MFalse.getTheMFalse() : MBoolean
				.createFromBoolean(getThis().getContainedTypes().aggregate(new Aggregtion<PersistentMType, Boolean>() {

					@Override
					public Boolean neutral() throws PersistenceException {
						return true;
					}

					@Override
					public Boolean compose(final Boolean result, final PersistentMType argument)
							throws PersistenceException {
						return result && argument.isSingleton().toBoolean();
					}
				}));
	}

	@Override
	public PersistentMBoolean isStructuralEquivalant(final PersistentMType other) throws PersistenceException {
		if (other instanceof PersistentMAbstractTypeConjunction) {
			final PersistentMAbstractTypeConjunction conjOther = (PersistentMAbstractTypeConjunction) other;
			final Iterator<PersistentMType> iteratorThis = getThis().getContainedTypes().iterator();
			final Iterator<PersistentMType> iteratorOther = conjOther.getContainedTypes().iterator();
			while (iteratorThis.hasNext()) {
				if (iteratorOther.hasNext()) {
					if (!iteratorThis.next().isStructuralEquivalant(iteratorOther.next()).toBoolean()) {
						return MFalse.getTheMFalse();
					}
				} else {
					return MFalse.getTheMFalse();
				}
			}
			return MBoolean.createFromBoolean(!iteratorOther.hasNext());
		}

		return MFalse.getTheMFalse();
	}

	/* Start of protected part that is not overridden by persistence generator */

	public static String TYPE_LINK_OP = "**";

	public static PersistentMAbstractTypeConjunction transientCreateAbstractTypeConj(final MTypeSearchList factors)
			throws PersistenceException, ConsistencyException {
		final MTypeSearchList normalizedTypeList = MAbstractTypeConjunction.normalizeTypeList(factors);

		if (normalizedTypeList.getLength() == 0) {
			return MEmptyTypeConjunction.getTheMEmptyTypeConjunction();
		}

		MAbstractTypeConjunction.checkAspectsAreUnique(normalizedTypeList);
		MAbstractTypeConjunction.checkNoSingletonsContained(normalizedTypeList);

		final MAtomicTypeSearchList atomicTypes = MAbstractTypeConjunction.filterAtomicTypes(normalizedTypeList);
		if (atomicTypes.getLength() == normalizedTypeList.getLength()) {
			return MNonEmptyAtomicTypeConjunction.transientCreateNETypeConj(atomicTypes);
		}
		return MMixedConjunction.transientCreateMixedTypeConj(normalizedTypeList);
	}

	/**
	 * Normalisiert die Typenliste <tt>types</tt>: F??r jede Konjunktion werden deren Faktoren verwendet, f??r jede
	 * Disjunktion die komplette Disjunktion. Alle Paare von Typen A,B werden bzgl. <= verglichen: Bei A <= B wird nur A
	 * ??bernommen. Stehen A und B nicht bzgl. <= in Relation werden beide ??bernommen
	 * 
	 * @param types
	 *            Typenliste
	 * @return normalisierte Typenliste
	 * @throws PersistenceException
	 */
	private static MTypeSearchList normalizeTypeList(final SearchListRoot<PersistentMType> types)
			throws PersistenceException {
		final MTypeSearchList result = new MTypeSearchList();
		types.applyToAll(new Procdure<PersistentMType>() {

			@Override
			public void doItTo(final PersistentMType argument) throws PersistenceException {
				addNormalizedToTypeList(result, argument);
			}
		});
		return result;
	}

	private static void addNormalizedToTypeList(final MTypeSearchList result, final PersistentMType addend)
			throws PersistenceException {
		addend.accept(new MTypeVisitor() {

			@Override
			public void handleMNonEmptyAtomicTypeConjunction(
					final PersistentMNonEmptyAtomicTypeConjunction mNonEmptyAtomicTypeConjunction)
					throws PersistenceException {
				mNonEmptyAtomicTypeConjunction.getFactors().applyToAll(new Procdure<PersistentMAtomicType>() {

					@Override
					public void doItTo(final PersistentMAtomicType argument) throws PersistenceException {
						MAbstractTypeConjunction.addNormalizedToTypeList(result, argument);
					}
				});
			}

			@Override
			public void handleMEmptyTypeConjunction(final PersistentMEmptyTypeConjunction mEmptyTypeConjunction)
					throws PersistenceException {
				// Neutral Element => IGNORE
			}

			@Override
			public void handleMMixedConjunction(final PersistentMMixedConjunction mMixedConjunction)
					throws PersistenceException {
				mMixedConjunction.getFactors().applyToAll(new Procdure<PersistentMType>() {

					@Override
					public void doItTo(final PersistentMType argument) throws PersistenceException {
						MAbstractTypeConjunction.addNormalizedToTypeList(result, argument);
					}
				});
			}

			@Override
			public void handleMNonEmptyDisjunctiveNormalForm(
					final PersistentMNonEmptyDisjunctiveNormalForm mNonEmptyDisjunctiveNormalForm)
					throws PersistenceException {
				MAbstractTypeConjunction.addNormalizedToTypeListLE(result, mNonEmptyDisjunctiveNormalForm);
			}

			@Override
			public void handleMEmptyTypeDisjunction(final PersistentMEmptyTypeDisjunction mEmptyTypeDisjunction)
					throws PersistenceException {
				MAbstractTypeConjunction.addNormalizedToTypeListLE(result, mEmptyTypeDisjunction);
			}

			@Override
			public void handleMMixedTypeDisjunction(final PersistentMMixedTypeDisjunction mMixedTypeDisjunction)
					throws PersistenceException {
				MAbstractTypeConjunction.addNormalizedToTypeListLE(result, mMixedTypeDisjunction);
			}

			@Override
			public void handleMAtomicType(final PersistentMAtomicType mAtomicType) throws PersistenceException {
				MAbstractTypeConjunction.addNormalizedToTypeListLE(result, mAtomicType);
			}
		});
	}

	/**
	 * Vergleicht <tt>addend</tt> mit jedem Typen in <tt>container</tt>. Wenn <tt>addend</tt> <= A ???
	 * <tt>container</tt>, wird A entfernt. Wenn ein oder mehrere A ??? <tt>container</tt> <= <tt>addend</tt>, werden
	 * alle A entfernt.
	 * 
	 * @param container
	 * @param addend
	 * @throws PersistenceException
	 */
	private static void addNormalizedToTypeListLE(final MTypeSearchList container, final PersistentMType addend)
			throws PersistenceException {
		boolean addType = true;
		final Iterator<PersistentMType> iterator = container.iterator();
		while (iterator.hasNext() && addType) {
			final PersistentMType currentListType = iterator.next();
			if (currentListType.isLessOrEqual(addend).toBoolean()) {
				addType = false;
			} else if (addend.isLessOrEqual(currentListType).toBoolean()) {
				iterator.remove();
			}
		}
		if (addType) {
			container.add(addend);
		}
	}

	private static void checkAspectsAreUnique(final MTypeSearchList typeList) throws ConsistencyException,
			PersistenceException {
		final Iterator<PersistentMType> iterator = typeList.iterator();
		final MAspectSearchList currentMergeList = new MAspectSearchList();
		if (iterator.hasNext()) {
			currentMergeList.add(iterator.next().fetchAspects());
		}
		while (iterator.hasNext()) {
			MAbstractTypeConjunction.mergeAspectListsUnique(currentMergeList, iterator.next().fetchAspects());
		}
	}

	private static void checkNoSingletonsContained(final MTypeSearchList typeList) throws ConsistencyException,
			PersistenceException {
		final PersistentMType findFirst = typeList.findFirst(new Predcate<PersistentMType>() {

			@Override
			public boolean test(final PersistentMType argument) throws PersistenceException {
				return argument.isSingleton().toBoolean();
			}
		});
		if (findFirst != null) {
			throw new ConsistencyException("Types in TypeConjunctions may not be Singleton");
		}
	}

	private static MAspectSearchList mergeAspectListsUnique(final MAspectSearchList listA, final MAspectSearchList listB)
			throws ConsistencyException, PersistenceException {
		final MAspectSearchList result = new MAspectSearchList(listA);
		listB.applyToAllException(new ProcdureException<PersistentMAspect, ConsistencyException>() {

			@Override
			public void doItTo(final PersistentMAspect argument) throws PersistenceException, ConsistencyException {
				final PersistentMAspect currentBAspect = argument;
				result.applyToAllException(new ProcdureException<PersistentMAspect, ConsistencyException>() {

					@Override
					public void doItTo(final PersistentMAspect argument) throws PersistenceException,
							ConsistencyException {
						if (argument.equals(currentBAspect)) {
							throw new ConsistencyException("Aspects in TypeConjunctions must be unique.");
						}
					}
				});
				result.add(currentBAspect);
			}
		});
		return result;
	}

	private static MAtomicTypeSearchList filterAtomicTypes(final MTypeSearchList typeList) throws PersistenceException {
		final MAtomicTypeSearchList result = new MAtomicTypeSearchList();
		typeList.applyToAll(new Procdure<PersistentMType>() {

			@Override
			public void doItTo(final PersistentMType argument) throws PersistenceException {
				argument.accept(new MTypeVisitor() {

					@Override
					public void handleMNonEmptyAtomicTypeConjunction(
							final PersistentMNonEmptyAtomicTypeConjunction mNonEmptyAtomicTypeConjunction)
							throws PersistenceException {
						// DO NOTHING
					}

					@Override
					public void handleMEmptyTypeConjunction(final PersistentMEmptyTypeConjunction mEmptyTypeConjunction)
							throws PersistenceException {
					}

					@Override
					public void handleMMixedConjunction(final PersistentMMixedConjunction mMixedConjunction)
							throws PersistenceException {
					}

					@Override
					public void handleMNonEmptyDisjunctiveNormalForm(
							final PersistentMNonEmptyDisjunctiveNormalForm mNonEmptyDisjunctiveNormalForm)
							throws PersistenceException {
					}

					@Override
					public void handleMEmptyTypeDisjunction(final PersistentMEmptyTypeDisjunction mEmptyTypeDisjunction)
							throws PersistenceException {
					}

					@Override
					public void handleMMixedTypeDisjunction(final PersistentMMixedTypeDisjunction mMixedTypeDisjunction)
							throws PersistenceException {
					}

					@Override
					public void handleMAtomicType(final PersistentMAtomicType mAtomicType) throws PersistenceException {
						result.add(mAtomicType);

					}
				});
			}
		});
		return result;
	}

	/* End of protected part that is not overridden by persistence generator */

}
