package model.typeSystem;

import java.util.Iterator;
import java.util.Set;

import model.UserException;
import model.basic.MFalse;
import model.basic.MTrue;
import model.visitor.AbstractObjectExceptionVisitor;
import model.visitor.AbstractObjectReturnExceptionVisitor;
import model.visitor.AbstractObjectReturnVisitor;
import model.visitor.AbstractObjectVisitor;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.MessageOrLinkVisitor;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.HierarchySearchList;
import persistence.LinkSearchList;
import persistence.MObjectProxi;
import persistence.MObject_TypesProxi;
import persistence.MessageOrLinkSearchList;
import persistence.NameInstanceSearchList;
import persistence.NameSearchList;
import persistence.PersistenceException;
import persistence.PersistentAbstractObject;
import persistence.PersistentHierarchy;
import persistence.PersistentLink;
import persistence.PersistentMAspect;
import persistence.PersistentMAtomicType;
import persistence.PersistentMBoolean;
import persistence.PersistentMNonEmptyAtomicTypeConjunction;
import persistence.PersistentMObject;
import persistence.PersistentMessage;
import persistence.PersistentMessageOrLink;
import persistence.Predcate;
import persistence.Procdure;
import persistence.QuantifObjectSearchList;
import persistence.SearchListRoot;
import persistence.TDObserver;
import utils.Lists;
import utils.Sets;

/* Additional import section end */

public class MObject extends model.typeSystem.AbstractObject implements PersistentMObject {

	public static PersistentMObject createMObject() throws PersistenceException {
		return createMObject(false);
	}

	public static PersistentMObject createMObject(boolean delayed$Persistence) throws PersistenceException {
		PersistentMObject result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theMObjectFacade.newDelayedMObject();
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theMObjectFacade.newMObject(-1);
		}
		java.util.Hashtable<String, Object> final$$Fields = new java.util.Hashtable<String, Object>();
		result.initialize(result, final$$Fields);
		result.initializeOnCreation();
		return result;
	}

	public static PersistentMObject createMObject(boolean delayed$Persistence, PersistentMObject This)
			throws PersistenceException {
		PersistentMObject result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theMObjectFacade.newDelayedMObject();
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theMObjectFacade.newMObject(-1);
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
			result.put("types", this.getTypes().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false));
			result.put(
					"linksFromMe",
					this.getLinksFromMe(tdObserver).getVector(allResults, (depth > 1 ? depth : depth + 1),
							essentialLevel, forGUI, tdObserver, false));
			result.put(
					"linksToMe",
					this.getLinksToMe(tdObserver).getVector(allResults, (depth > 1 ? depth : depth + 1),
							essentialLevel, forGUI, tdObserver, false));
			result.put(
					"names",
					this.getNames().getVector(allResults, (depth > 1 ? depth : depth + 1), essentialLevel, forGUI,
							tdObserver, false));
			String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
			if (leaf && !allResults.contains(uniqueKey))
				allResults.put(uniqueKey, result);
		}
		return result;
	}

	@Override
	public MObject provideCopy() throws PersistenceException {
		MObject result = this;
		result = new MObject(this.This, this.getId());
		result.types = this.types.copy(result);
		this.copyingPrivateUserAttributes(result);
		return result;
	}

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return false;
	}

	protected MObject_TypesProxi types;

	public MObject(PersistentAbstractObject This, long id) throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(This, id);
		this.types = new MObject_TypesProxi(this);
	}

	static public long getTypeId() {
		return 130;
	}

	@Override
	public long getClassId() {
		return getTypeId();
	}

	@Override
	public void store() throws PersistenceException {
		if (!this.isDelayed$Persistence())
			return;
		if (this.getClassId() == 130)
			ConnectionHandler.getTheConnectionHandler().theMObjectFacade.newMObject(this.getId());
		super.store();
		this.getTypes().store();

	}

	@Override
	public MObject_TypesProxi getTypes() throws PersistenceException {
		return this.types;
	}

	@Override
	public PersistentMObject getThis() throws PersistenceException {
		if (this.This == null) {
			PersistentMObject result = new MObjectProxi(this.getId());
			result.getTheObject();
			return result;
		}
		return (PersistentMObject) this.This;
	}

	@Override
	public void accept(AbstractObjectVisitor visitor) throws PersistenceException {
		visitor.handleMObject(this);
	}

	@Override
	public <R> R accept(AbstractObjectReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMObject(this);
	}

	@Override
	public <E extends UserException> void accept(AbstractObjectExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleMObject(this);
	}

	@Override
	public <R, E extends UserException> R accept(AbstractObjectReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMObject(this);
	}

	@Override
	public void accept(AnythingVisitor visitor) throws PersistenceException {
		visitor.handleMObject(this);
	}

	@Override
	public <R> R accept(AnythingReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMObject(this);
	}

	@Override
	public <E extends UserException> void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleMObject(this);
	}

	@Override
	public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMObject(this);
	}

	@Override
	public int getLeafInfo() throws PersistenceException {
		return (int) (0 + this.getPossibleNames().getLength() + (this.getProductType() == null ? 0 : 1)
				+ this.getTypes().getLength() + this.getLinksFromMe().getLength() + this.getLinksToMe().getLength() + this
				.getNames().getLength());
	}

	@Override
	public LinkSearchList getLinksToMe(final TDObserver observer) throws PersistenceException {
		LinkSearchList result = getThis().getLinksToMe();
		observer.updateTransientDerived(getThis(), "linksToMe", result);
		return result;
	}

	@Override
	public PersistentMBoolean containsInHierarchies(final PersistentMObject obj, final HierarchySearchList hieracs)
			throws PersistenceException {
		if (getThis().equals(obj)) {
			return MTrue.getTheMTrue();
		}
		SearchListRoot<PersistentLink> allHieracLinks = getThis().getLinksFromMe().findAll(
				new Predcate<PersistentLink>() {

					@Override
					public boolean test(PersistentLink argument) throws PersistenceException {
						Iterator<PersistentHierarchy> iteratorOuter = hieracs.iterator();
						while (iteratorOuter.hasNext()) {
							final PersistentHierarchy nextOuter = iteratorOuter.next();
							Iterator<PersistentHierarchy> iteratorInner = argument.getType().getHierarchies()
									.iterator();
							while (iteratorInner.hasNext()) {
								if (nextOuter.equals(iteratorInner.next())) {
									return true;
								}
							}
						}

						return false;
					}
				});
		Iterator<PersistentLink> iteratorHieracLinks = allHieracLinks.iterator();
		while (iteratorHieracLinks.hasNext()) {
			if (iteratorHieracLinks.next().getTarget().containsInHierarchies(obj, hieracs).toBoolean()) {
				return MTrue.getTheMTrue();
			}
		}
		return MFalse.getTheMFalse();
	}

	@Override
	public void initializeOnInstantiation() throws PersistenceException {
	}

	@Override
	public QuantifObjectSearchList inverseGetObject() throws PersistenceException {
		QuantifObjectSearchList result = null;
		if (result == null)
			result = ConnectionHandler.getTheConnectionHandler().theQuantifObjectFacade.inverseGetObject(this.getId(),
					this.getClassId());
		return result;
	}

	@Override
	public void addType(final PersistentMAtomicType newType) throws model.ConsistencyException, PersistenceException {
		// TODO: implement method: addType

	}

	@Override
	public void initializeOnCreation() throws PersistenceException {
	}

	@Override
	public LinkSearchList getLinksFromMe() throws PersistenceException {
		final LinkSearchList result = new LinkSearchList();
		Iterator<PersistentMessageOrLink> iMOL = getThis().inverseGetSource().iterator();
		while (iMOL.hasNext()) {
			iMOL.next().accept(new MessageOrLinkVisitor() {

				@Override
				public void handleMessage(PersistentMessage message) throws PersistenceException {
					// IGNORE
				}

				@Override
				public void handleLink(PersistentLink link) throws PersistenceException {
					result.add(link);
				}
			});
		}
		return result;
	}

	@Override
	public void removeType(final PersistentMAtomicType oldType) throws model.ConsistencyException, PersistenceException {
		// TODO: implement method: removeType

	}

	@Override
	public NameInstanceSearchList getNames() throws PersistenceException {
		NameInstanceSearchList result = null;
		if (result == null)
			result = ConnectionHandler.getTheConnectionHandler().theNameInstanceFacade.inverseGetFromObject(
					this.getId(), this.getClassId());
		return result;
	}

	@Override
	public MessageOrLinkSearchList inverseGetTarget() throws PersistenceException {
		MessageOrLinkSearchList result = null;
		if (result == null)
			result = ConnectionHandler.getTheConnectionHandler().theMessageOrLinkFacade.inverseGetTarget(this.getId(),
					this.getClassId());
		return result;
	}

	@Override
	public void copyingPrivateUserAttributes(final Anything copy) throws PersistenceException {
		// TODO: implement method: copyingPrivateUserAttributes

	}

	@Override
	public LinkSearchList getLinksFromMe(final TDObserver observer) throws PersistenceException {
		LinkSearchList result = getThis().getLinksFromMe();
		observer.updateTransientDerived(getThis(), "linksFromMe", result);
		return result;
	}

	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String, Object> final$$Fields)
			throws PersistenceException {
		this.setThis((PersistentMObject) This);
		if (this.equals(This)) {
		}
	}

	@Override
	public void replaceType(final PersistentMAtomicType oldType, final PersistentMAtomicType newType)
			throws model.ConsistencyException, PersistenceException {
		// TODO: implement method: replaceType

	}

	@Override
	public LinkSearchList getLinksToMe() throws PersistenceException {
		final LinkSearchList result = new LinkSearchList();
		Iterator<PersistentMessageOrLink> iMOL = getThis().inverseGetTarget().iterator();
		while (iMOL.hasNext()) {
			iMOL.next().accept(new MessageOrLinkVisitor() {

				@Override
				public void handleMessage(PersistentMessage message) throws PersistenceException {
					// IGNORE
				}

				@Override
				public void handleLink(PersistentLink link) throws PersistenceException {
					result.add(link);
				}
			});
		}
		return result;
	}

	@Override
	public MessageOrLinkSearchList inverseGetSource() throws PersistenceException {
		MessageOrLinkSearchList result = null;
		if (result == null)
			result = ConnectionHandler.getTheConnectionHandler().theMessageOrLinkFacade.inverseGetSource(this.getId(),
					this.getClassId());
		return result;
	}

	@Override
	public NameSearchList getPossibleNames() throws PersistenceException {
		final NameSearchList list = new NameSearchList();

		this.getThis().getTypes().applyToAll(new Procdure<PersistentMAtomicType>() {

			@Override
			public void doItTo(PersistentMAtomicType argument) throws PersistenceException {
				list.add(argument.getPossibleNames());
			}
		});

		return list;
	}

	@Override
	public PersistentMNonEmptyAtomicTypeConjunction getProductType() throws PersistenceException {
		return MNonEmptyAtomicTypeConjunction.transientCreateNETypeConj(getThis().getTypes().getList());
	}

	/* Start of protected part that is not overridden by persistence generator */
	private Set<PersistentMAspect> getAspects() throws PersistenceException {
		return Sets.transform(this.getThis().getTypes().getList(),
				new Lists.FunctionWithResult<PersistentMAtomicType, PersistentMAspect>() {

					@Override
					public PersistentMAspect apply(PersistentMAtomicType element) {
						try {
							return element.getAspect();
						} catch (PersistenceException e) {
							throw new RuntimeException(e);
						}
					}
				});
	}

	/**
	 * Ermittelt ausgehend von einem Typen alle Objekte dazugehoerigen, die ueber einen Link erreichbar sein sollen.
	 * 
	 * @param type
	 * @return
	 * @throws PersistenceException
	 */
	// private MObjectSearchList getPossibleLinkTargets(PersistentMType type) throws PersistenceException {
	// final MObjectSearchList possibleLinkTargets = new MObjectSearchList();
	//
	// type.accept(new MTypeVisitor() {
	//
	// @Override
	// public void handleMProductType(PersistentMProductType mProductType) throws PersistenceException {
	// // Wird schon ueber AtomicType erledigt, oder?
	// }
	//
	// @Override
	// public void handleMEmptyProductType(PersistentMEmptyProductType mEmptyProductType)
	// throws PersistenceException {
	// // Kommt beabsichtigt nicht mit rein
	// }
	//
	// @Override
	// public void handleMSumType(PersistentMSumType mSumType) throws PersistenceException {
	// // Durch alle Elemente des Summentypen iterieren und alle Objekte zu den Elementen mit aufnehmen
	// mSumType.getContainedTypes().applyToAll(new Procdure<PersistentMType>() {
	//
	// @Override
	// public void doItTo(PersistentMType argument) throws PersistenceException {
	// possibleLinkTargets.add(getPossibleLinkTargets(argument));
	// }
	// });
	// }
	//
	// @Override
	// public void handleMEmptySumType(PersistentMEmptySumType mEmptySumType) throws PersistenceException {
	// // Beabsichtigt leer
	// }
	//
	// @Override
	// public void handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException {
	// // Alle Objekte aufnehmen
	// possibleLinkTargets.add(mAtomicType.inverseGetTypes());
	// }
	// });
	//
	// return possibleLinkTargets;
	// }

	/* End of protected part that is not overridden by persistence generator */

}
