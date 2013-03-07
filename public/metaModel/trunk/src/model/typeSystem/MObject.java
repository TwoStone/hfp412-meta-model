package model.typeSystem;

import java.util.Iterator;
import java.util.Set;

import model.ConsistencyException;
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
import model.visitor.MModelItemExceptionVisitor;
import model.visitor.MModelItemReturnExceptionVisitor;
import model.visitor.MModelItemReturnVisitor;
import model.visitor.MModelItemVisitor;
import model.visitor.MessageOrLinkVisitor;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.HierarchySearchList;
import persistence.LinkSearchList;
import persistence.MModelItemSearchList;
import persistence.MObjectProxi;
import persistence.MObject_TypesProxi;
import persistence.MObservationSearchList;
import persistence.MessageOrLinkSearchList;
import persistence.NameInstanceSearchList;
import persistence.NameSearchList;
import persistence.PersistenceException;
import persistence.PersistentAbstractObject;
import persistence.PersistentCONCMModelItem;
import persistence.PersistentHierarchy;
import persistence.PersistentLink;
import persistence.PersistentMAspect;
import persistence.PersistentMAtomicType;
import persistence.PersistentMBoolean;
import persistence.PersistentMModelItem;
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

public class MObject extends model.typeSystem.AbstractObject implements PersistentMObject{
    
    
    public static PersistentMObject createMObject() throws PersistenceException{
        return createMObject(false);
    }
    
    public static PersistentMObject createMObject(boolean delayed$Persistence) throws PersistenceException {
        PersistentMObject result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMObjectFacade
                .newDelayedMObject();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMObjectFacade
                .newMObject(-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentMObject createMObject(boolean delayed$Persistence,PersistentMObject This) throws PersistenceException {
        PersistentMObject result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMObjectFacade
                .newDelayedMObject();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMObjectFacade
                .newMObject(-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("types", this.getTypes().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
            result.put("linksFromMe", this.getLinksFromMe(tdObserver).getVector(allResults, (depth > 1 ? depth : depth + 1), essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
            result.put("linksToMe", this.getLinksToMe(tdObserver).getVector(allResults, (depth > 1 ? depth : depth + 1), essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
            result.put("names", this.getNames().getVector(allResults, (depth > 1 ? depth : depth + 1), essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public MObject provideCopy() throws PersistenceException{
        MObject result = this;
        result = new MObject(this.This, 
                             this.myCONCMModelItem, 
                             this.getId());
        result.types = this.types.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return true;
    }
    protected MObject_TypesProxi types;
    
    public MObject(PersistentAbstractObject This,PersistentMModelItem myCONCMModelItem,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentAbstractObject)This,(PersistentMModelItem)myCONCMModelItem,id);
        this.types = new MObject_TypesProxi(this);        
    }
    
    static public long getTypeId() {
        return 151;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 151) ConnectionHandler.getTheConnectionHandler().theMObjectFacade
            .newMObject(this.getId());
        super.store();
        this.getTypes().store();
        
    }
    
    public MObject_TypesProxi getTypes() throws PersistenceException {
        return this.types;
    }
    public PersistentMObject getThis() throws PersistenceException {
        if(this.This == null){
            PersistentMObject result = new MObjectProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentMObject)this.This;
    }
    
    public void accept(AbstractObjectVisitor visitor) throws PersistenceException {
        visitor.handleMObject(this);
    }
    public <R> R accept(AbstractObjectReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMObject(this);
    }
    public <E extends UserException>  void accept(AbstractObjectExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMObject(this);
    }
    public <R, E extends UserException> R accept(AbstractObjectReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMObject(this);
    }
    public void accept(MModelItemVisitor visitor) throws PersistenceException {
        visitor.handleMObject(this);
    }
    public <R> R accept(MModelItemReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMObject(this);
    }
    public <E extends UserException>  void accept(MModelItemExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMObject(this);
    }
    public <R, E extends UserException> R accept(MModelItemReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMObject(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMObject(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMObject(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMObject(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMObject(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getProductType() != null) return 1;
        if (this.getDependentItems().getLength() > 0) return 1;
        if (this.getPossibleNames().getLength() > 0) return 1;
        if (this.getTypes().getLength() > 0) return 1;
        if (this.getLinksFromMe().getLength() > 0) return 1;
        if (this.getLinksToMe().getLength() > 0) return 1;
        if (this.getNames().getLength() > 0) return 1;
        return 0;
    }
    
    
    public NameInstanceSearchList getNames() 
				throws PersistenceException{
        NameInstanceSearchList result = null;
		if (result == null) result = ConnectionHandler.getTheConnectionHandler().theNameInstanceFacade
							.inverseGetFromObject(this.getId(), this.getClassId());
		return result;
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentMObject)This);
		if(this.equals(This)){
			PersistentCONCMModelItem myCONCMModelItem = model.CONCMModelItem.createCONCMModelItem(this.isDelayed$Persistence(), (PersistentMObject)This);
			this.setMyCONCMModelItem(myCONCMModelItem);
		}
    }
    public QuantifObjectSearchList inverseGetObject() 
				throws PersistenceException{
        QuantifObjectSearchList result = null;
		if (result == null) result = ConnectionHandler.getTheConnectionHandler().theQuantifObjectFacade
							.inverseGetObject(this.getId(), this.getClassId());
		return result;
    }
    public MessageOrLinkSearchList inverseGetSource() 
				throws PersistenceException{
        MessageOrLinkSearchList result = null;
		if (result == null) result = ConnectionHandler.getTheConnectionHandler().theMessageOrLinkFacade
							.inverseGetSource(this.getId(), this.getClassId());
		return result;
    }
    public MessageOrLinkSearchList inverseGetTarget() 
				throws PersistenceException{
        MessageOrLinkSearchList result = null;
		if (result == null) result = ConnectionHandler.getTheConnectionHandler().theMessageOrLinkFacade
							.inverseGetTarget(this.getId(), this.getClassId());
		return result;
    }
    public MObservationSearchList inverseGetTheObsObject() 
				throws PersistenceException{
        MObservationSearchList result = null;
		if (result == null) result = ConnectionHandler.getTheConnectionHandler().theMObservationFacade
							.inverseGetTheObsObject(this.getId(), this.getClassId());
		return result;
    }
    public void addType(final PersistentMAtomicType newType) 
				throws model.ConsistencyException, PersistenceException{
		if (newType.isAbstract().toBoolean()) {
			throw new ConsistencyException("Objekte dürfen nur in konkreten Typen klassifiziert werden!");
		}

		if (newType.isSingleton().toBoolean()) {
			throw new ConsistencyException("Objekte dürfen nur in nicht-singleton Typen klassifiziert werden!");
		}

		if (this.getAspects().contains(newType.getAspect())) {
			throw new ConsistencyException(String.format(
					"Das Objekt kann nur in nur einem Typen pro Aspekt klassifiziert werden! Aspekt: %s", newType
							.getAspect().getName()));
		}
		this.getThis().getTypes().add(newType);
	}
    public PersistentMBoolean containsInHierarchies(final PersistentMObject obj, final HierarchySearchList hieracs) 
				throws PersistenceException{
		if (getThis().equals(obj) && hieracs.getLength() > 0) {
			return MTrue.getTheMTrue();
		}
		final SearchListRoot<PersistentLink> allHieracLinks = getThis().getLinksFromMe().findAll(
				new Predcate<PersistentLink>() {

					@Override
					public boolean test(final PersistentLink argument) throws PersistenceException {
						final Iterator<PersistentHierarchy> iteratorOuter = hieracs.iterator();
						while (iteratorOuter.hasNext()) {
							final PersistentHierarchy nextOuter = iteratorOuter.next();
							final Iterator<PersistentHierarchy> iteratorInner = argument.getType().getHierarchies()
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
		final Iterator<PersistentLink> iteratorHieracLinks = allHieracLinks.iterator();
		while (iteratorHieracLinks.hasNext()) {
			if (iteratorHieracLinks.next().getTarget().containsInHierarchies(obj, hieracs).toBoolean()) {
				return MTrue.getTheMTrue();
			}
		}
		return MFalse.getTheMFalse();
	}
    public PersistentMBoolean containsInHierarchy(final PersistentMObject obj, final PersistentHierarchy hierac) 
				throws PersistenceException{

		final HierarchySearchList listOfHierarchies = new HierarchySearchList();
		listOfHierarchies.add(hierac);

		return getThis().containsInHierarchies(obj, listOfHierarchies);
	}
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{

	}
    public MModelItemSearchList getDependentItems() 
				throws PersistenceException{
		// TODO: implement method: getDependentItems
		try {
			throw new java.lang.UnsupportedOperationException("Method \"getDependentItems\" not implemented yet.");
		} catch (final java.lang.UnsupportedOperationException uoe) {
			uoe.printStackTrace();
			throw uoe;
		}
	}
    public MModelItemSearchList getDependentItems(final TDObserver observer) 
				throws PersistenceException{
        MModelItemSearchList result = getThis().getDependentItems();
		observer.updateTransientDerived(getThis(), "dependentItems", result);
		return result;
    }
    public LinkSearchList getLinksFromMe() 
				throws PersistenceException{
		final LinkSearchList result = new LinkSearchList();
		final Iterator<PersistentMessageOrLink> iMOL = getThis().inverseGetSource().iterator();
		while (iMOL.hasNext()) {
			iMOL.next().accept(new MessageOrLinkVisitor() {

				@Override
				public void handleMessage(final PersistentMessage message) throws PersistenceException {
					// IGNORE
				}

				@Override
				public void handleLink(final PersistentLink link) throws PersistenceException {
					result.add(link);
				}
			});
		}
		return result;
	}
    public LinkSearchList getLinksFromMe(final TDObserver observer) 
				throws PersistenceException{
        LinkSearchList result = getThis().getLinksFromMe();
		observer.updateTransientDerived(getThis(), "linksFromMe", result);
		return result;
    }
    public LinkSearchList getLinksToMe() 
				throws PersistenceException{
		final LinkSearchList result = new LinkSearchList();
		final Iterator<PersistentMessageOrLink> iMOL = getThis().inverseGetTarget().iterator();
		while (iMOL.hasNext()) {
			iMOL.next().accept(new MessageOrLinkVisitor() {

				@Override
				public void handleMessage(final PersistentMessage message) throws PersistenceException {
					// IGNORE
				}

				@Override
				public void handleLink(final PersistentLink link) throws PersistenceException {
					result.add(link);
				}
			});
		}
		return result;
	}
    public LinkSearchList getLinksToMe(final TDObserver observer) 
				throws PersistenceException{
        LinkSearchList result = getThis().getLinksToMe();
		observer.updateTransientDerived(getThis(), "linksToMe", result);
		return result;
    }
    public void initializeOnCreation() 
				throws PersistenceException{
	}
    public void initializeOnInstantiation() 
				throws PersistenceException{
	}
    public void prepareForDeletion() 
				throws model.ConsistencyException, PersistenceException{
		// TODO: implement method: prepareForDeletion

	}
    public void removeType(final PersistentMAtomicType oldType) 
				throws model.ConsistencyException, PersistenceException{
		if (this.getThis().getTypes().getLength() <= 1) {
			throw new ConsistencyException(
					"Das Objekt muss in mindestens einem Typen klassifiziert! F??gen sie einen weiteren Typen hinzu bevor Sie diesen entfernen!");
		}
		this.getThis().getTypes().removeFirstSuccess(new Predcate<PersistentMAtomicType>() {

			@Override
			public boolean test(final PersistentMAtomicType argument) throws PersistenceException {
				return argument.equals(oldType);
			}
		});

	}
    public void replaceType(final PersistentMAtomicType oldType, final PersistentMAtomicType newType) 
				throws model.ConsistencyException, PersistenceException{
		if (this.getAspects().contains(newType.getAspect()) && !oldType.getAspect().equals(newType.getAspect())) {
			throw new ConsistencyException(String.format(
					"Das Objekt kann nur in nur einem Typen pro Aspekt klassifiziert werden! Aspekt: %s", newType
							.getAspect().getName()));
		}
		this.getThis().getTypes().removeFirstSuccess(new Predcate<PersistentMAtomicType>() {

			@Override
			public boolean test(final PersistentMAtomicType argument) throws PersistenceException {
				return argument.equals(oldType);
			}
		});

		this.getThis().getTypes().add(newType);
	}
    
    
    // Start of section that contains overridden operations only.
    
    public NameSearchList getPossibleNames() 
				throws PersistenceException{
		final NameSearchList list = new NameSearchList();

		this.getThis().getTypes().applyToAll(new Procdure<PersistentMAtomicType>() {

			@Override
			public void doItTo(final PersistentMAtomicType argument) throws PersistenceException {
				list.add(argument.getPossibleNames());
			}
		});

		return list;
	}
    public PersistentMNonEmptyAtomicTypeConjunction getProductType() 
				throws PersistenceException{
		return MNonEmptyAtomicTypeConjunction.transientCreateNETypeConj(getThis().getTypes().getList());
	}

    /* Start of protected part that is not overridden by persistence generator */

	private Set<PersistentMAspect> getAspects() throws PersistenceException {
		return Sets.transform(this.getThis().getTypes().getList(),
				new Lists.FunctionWithResult<PersistentMAtomicType, PersistentMAspect>() {

					@Override
					public PersistentMAspect apply(final PersistentMAtomicType element) {
						try {
							return element.getAspect();
						} catch (final PersistenceException e) {
							throw new RuntimeException(e);
						}
					}
				});
	}
	/* End of protected part that is not overridden by persistence generator */
    
}
