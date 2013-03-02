package model.typeSystem;

import java.util.Iterator;
import java.util.List;

import model.basic.MBoolean;
import model.basic.MFalse;
import model.basic.MTrue;
import model.visitor.MTypeStandardVisitor;
import persistence.Anything;
import persistence.MAtomicTypeSearchList;
import persistence.MTypeSearchList;
import persistence.PersistenceException;
import persistence.PersistentCONCMModelItem;
import persistence.PersistentMAbstractTypeDisjunction;
import persistence.PersistentMAtomicType;
import persistence.PersistentMAtomicTypeConjunction;
import persistence.PersistentMBoolean;
import persistence.PersistentMEmptyTypeConjunction;
import persistence.PersistentMEmptyTypeDisjunction;
import persistence.PersistentMMixedTypeDisjunction;
import persistence.PersistentMModelItem;
import persistence.PersistentMNonEmptyAtomicTypeConjunction;
import persistence.PersistentMNonEmptyDisjunctiveNormalForm;
import persistence.PersistentMType;
import persistence.Procdure;
import persistence.TDObserver;
import utils.Lists;
import utils.SearchLists;
import utils.TruePredcate;

/* Additional import section end */

public abstract class MAbstractTypeDisjunction extends model.typeSystem.MComplexType implements PersistentMAbstractTypeDisjunction{
    
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public abstract MAbstractTypeDisjunction provideCopy() throws PersistenceException;
    
    public boolean hasEssentialFields() throws PersistenceException{
        return true;
    }
    
    public MAbstractTypeDisjunction(PersistentMType This,PersistentMModelItem myCONCMModelItem,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentMType)This,(PersistentMModelItem)myCONCMModelItem,id);        
    }
    
    static public long getTypeId() {
        return 305;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        super.store();
        
    }
    
    public abstract PersistentMAbstractTypeDisjunction getThis() throws PersistenceException ;
    
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
	}
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
	}
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentMAbstractTypeDisjunction)This);
		if(this.equals(This)){
			PersistentCONCMModelItem myCONCMModelItem = model.CONCMModelItem.createCONCMModelItem(this.isDelayed$Persistence(), (PersistentMAbstractTypeDisjunction)This);
			this.setMyCONCMModelItem(myCONCMModelItem);
		}
    }
    public void initializeOnCreation() 
				throws PersistenceException{
	}
    public String fetchName() 
				throws PersistenceException{
		StringBuilder builder = new StringBuilder();

		builder.append("{");
		Iterator<PersistentMType> iterator = this.getContainedTypes().iterator();
		if (iterator.hasNext()) {
			builder.append(iterator.next().fetchName());
		}

		while (iterator.hasNext()) {
			PersistentMType persistentMType = iterator.next();
			builder.append(this.getThis().fetchTypeLinkOperator());
			builder.append(persistentMType.fetchName());
		}

		builder.append("}");

		return builder.toString();
	}
    public PersistentMBoolean isStructuralEquivalant(final PersistentMType other) 
				throws PersistenceException{
		if (other instanceof PersistentMAbstractTypeDisjunction) {
			PersistentMAbstractTypeDisjunction disjOther = (PersistentMAbstractTypeDisjunction) other;
			Iterator<PersistentMType> iteratorThis = getThis().getContainedTypes().iterator();
			Iterator<PersistentMType> iteratorOther = disjOther.getContainedTypes().iterator();
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
    public MTypeSearchList getContainedTypes() 
				throws PersistenceException{
		return SearchLists.toMTypeSearchList(fetchContainedTypes());
	}
    public String fetchTypeLinkOperator() 
				throws PersistenceException{
		return MAbstractTypeDisjunction.TYPE_LINK_OP;
	}
    public PersistentMBoolean isSingleton() 
				throws PersistenceException{
		if (getThis().getContainedTypes().getLength() == 1) {
			return getThis().getContainedTypes().findFirst(new TruePredcate<PersistentMType>()).isSingleton();
		}
		return MFalse.getTheMFalse();
	}
    public PersistentMBoolean isAbstract() 
				throws PersistenceException{
		if (getThis().getContainedTypes().getLength() == 1) {
			return getThis().getContainedTypes().findFirst(new TruePredcate<PersistentMType>()).isAbstract();
		}
		return MTrue.getTheMTrue();
	}

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
	public static String TYPE_LINK_OP = "++";

	public static PersistentMAbstractTypeDisjunction transientCreateAbstrTypeDisj(MTypeSearchList addends)
			throws PersistenceException {
		MTypeSearchList normalizedTypeList = MAbstractTypeDisjunction.normalizeTypeList(addends);

		if (normalizedTypeList.getLength() == 0) {
			return MEmptyTypeDisjunction.getTheMEmptyTypeDisjunction();
		}

		List<PersistentMAtomicTypeConjunction> atomicTypeConjunctions = MAbstractTypeDisjunction
				.filterAtomicTypeConjunctions(normalizedTypeList);

		if (atomicTypeConjunctions.size() == normalizedTypeList.getLength()) {
			return MNonEmptyDisjunctiveNormalForm.transientCreateNEDNF(atomicTypeConjunctions);
		}

		return MMixedTypeDisjunction.transientCreateMixedTypeDisj(normalizedTypeList);
	}

	private static MTypeSearchList normalizeTypeList(MTypeSearchList types) throws PersistenceException {
		final MTypeSearchList result = new MTypeSearchList();
		types.applyToAll(new Procdure<PersistentMType>() {

			@Override
			public void doItTo(PersistentMType argument) throws PersistenceException {
				argument.accept(new MTypeStandardVisitor() {

					@Override
					protected void standardHandling(PersistentMType mType) throws PersistenceException {
						MAbstractTypeDisjunction.addNormalizedToTypeList(result, mType);
					}

					@Override
					public void handleMNonEmptyDisjunctiveNormalForm(
							PersistentMNonEmptyDisjunctiveNormalForm mNonEmptyDisjunctiveNormalForm)
							throws PersistenceException {
						mNonEmptyDisjunctiveNormalForm.getAddends().applyToAll(
								new Procdure<PersistentMAtomicTypeConjunction>() {

									@Override
									public void doItTo(PersistentMAtomicTypeConjunction argument)
											throws PersistenceException {
										MAbstractTypeDisjunction.addNormalizedToTypeList(result, argument);

									}
								});

					}

					@Override
					public void handleMEmptyTypeDisjunction(PersistentMEmptyTypeDisjunction mEmptyTypeDisjunction)
							throws PersistenceException {
						// NEUTRAL ELEMENT
					}

					@Override
					public void handleMMixedTypeDisjunction(PersistentMMixedTypeDisjunction mMixedTypeDisjunction)
							throws PersistenceException {
						mMixedTypeDisjunction.getAddends().applyToAll(new Procdure<PersistentMType>() {

							@Override
							public void doItTo(PersistentMType argument) throws PersistenceException {
								MAbstractTypeDisjunction.addNormalizedToTypeList(result, argument);
							}
						});

					}
				});
			}
		});
		return result;
	}

	private static void addNormalizedToTypeList(MTypeSearchList container, PersistentMType addend)
			throws PersistenceException {
		boolean addType = true;
		Iterator<PersistentMType> iterator = container.iterator();
		while (iterator.hasNext() && addType) {
			PersistentMType currentListType = iterator.next();
			if (addend.isLessOrEqual(currentListType).toBoolean()) {
				addType = false;
			} else if (currentListType.isLessOrEqual(addend).toBoolean()) {
				iterator.remove();
			}
		}
		if (addType) {
			container.add(addend);
		}
	}

	private static List<PersistentMAtomicTypeConjunction> filterAtomicTypeConjunctions(MTypeSearchList typeList)
			throws PersistenceException {
		final List<PersistentMAtomicTypeConjunction> result = Lists.newArrayList();

		typeList.applyToAll(new Procdure<PersistentMType>() {

			@Override
			public void doItTo(PersistentMType argument) throws PersistenceException {
				argument.accept(new MTypeStandardVisitor() {

					@Override
					public void handleMNonEmptyAtomicTypeConjunction(
							PersistentMNonEmptyAtomicTypeConjunction mNonEmptyAtomicTypeConjunction)
							throws PersistenceException {
						result.add(mNonEmptyAtomicTypeConjunction);

					}

					@Override
					public void handleMEmptyTypeConjunction(PersistentMEmptyTypeConjunction mEmptyTypeConjunction)
							throws PersistenceException {
						result.add(mEmptyTypeConjunction);

					}

					@Override
					public void handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException {
						MAtomicTypeSearchList sl = new MAtomicTypeSearchList();
						sl.add(mAtomicType);
						result.add(MNonEmptyAtomicTypeConjunction.transientCreateNETypeConj(sl));

					}

					@Override
					protected void standardHandling(PersistentMType mType) throws PersistenceException {
						// Do not add
					}
				});
			}
		});
		return result;
	}
	
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
