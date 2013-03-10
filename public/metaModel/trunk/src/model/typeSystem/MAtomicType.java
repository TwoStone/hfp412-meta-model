package model.typeSystem;

import java.util.Iterator;

import model.UserException;
import model.basic.MBoolean;
import model.basic.MFalse;
import model.basic.MTrue;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.MAtomicTypeHierarchyHIERARCHYExceptionVisitor;
import model.visitor.MAtomicTypeHierarchyHIERARCHYReturnExceptionVisitor;
import model.visitor.MAtomicTypeHierarchyHIERARCHYReturnVisitor;
import model.visitor.MAtomicTypeHierarchyHIERARCHYVisitor;
import model.visitor.MComplexTypeHierarchyHIERARCHYExceptionVisitor;
import model.visitor.MComplexTypeHierarchyHIERARCHYReturnExceptionVisitor;
import model.visitor.MComplexTypeHierarchyHIERARCHYReturnVisitor;
import model.visitor.MComplexTypeHierarchyHIERARCHYVisitor;
import model.visitor.MModelItemExceptionVisitor;
import model.visitor.MModelItemReturnExceptionVisitor;
import model.visitor.MModelItemReturnVisitor;
import model.visitor.MModelItemVisitor;
import model.visitor.MTypeExceptionVisitor;
import model.visitor.MTypeReturnExceptionVisitor;
import model.visitor.MTypeReturnVisitor;
import model.visitor.MTypeVisitor;
import persistence.AbstractPersistentRoot;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.MAspectSearchList;
import persistence.MAtomicTypeHierarchyHIERARCHY;
import persistence.MAtomicTypeHierarchyHIERARCHYStrategy;
import persistence.MAtomicTypeProxi;
import persistence.MAtomicTypeSearchList;
import persistence.MComplexTypeHierarchyHIERARCHY;
import persistence.MComplexTypeHierarchyHIERARCHYStrategy;
import persistence.MModelItemSearchList;
import persistence.MNonEmptyAtomicTypeConjunctionSearchList;
import persistence.MObjectSearchList;
import persistence.MTypeSearchList;
import persistence.NameSearchList;
import persistence.PersistenceException;
import persistence.PersistentCONCMModelItem;
import persistence.PersistentMAspect;
import persistence.PersistentMAtomicType;
import persistence.PersistentMAtomicTypeConjunction;
import persistence.PersistentMBoolean;
import persistence.PersistentMDisjunctiveNormalForm;
import persistence.PersistentMEmptyTypeConjunction;
import persistence.PersistentMEmptyTypeDisjunction;
import persistence.PersistentMMixedConjunction;
import persistence.PersistentMMixedTypeDisjunction;
import persistence.PersistentMModelItem;
import persistence.PersistentMNonEmptyAtomicTypeConjunction;
import persistence.PersistentMNonEmptyDisjunctiveNormalForm;
import persistence.PersistentMType;
import persistence.PersistentProxi;
import persistence.TDObserver;
import utils.SearchLists;

/* Additional import section end */

public class MAtomicType extends model.typeSystem.MType implements PersistentMAtomicType{
    
    
    public static PersistentMAtomicType createMAtomicType(String name,PersistentMBoolean singletonType,PersistentMBoolean abstractType,PersistentMAspect aspect) throws PersistenceException{
        return createMAtomicType(name,singletonType,abstractType,aspect,false);
    }
    
    public static PersistentMAtomicType createMAtomicType(String name,PersistentMBoolean singletonType,PersistentMBoolean abstractType,PersistentMAspect aspect,boolean delayed$Persistence) throws PersistenceException {
        if (name == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentMAtomicType result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMAtomicTypeFacade
                .newDelayedMAtomicType(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMAtomicTypeFacade
                .newMAtomicType(name,-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("name", name);
        final$$Fields.put("singletonType", singletonType);
        final$$Fields.put("abstractType", abstractType);
        final$$Fields.put("aspect", aspect);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentMAtomicType createMAtomicType(String name,PersistentMBoolean singletonType,PersistentMBoolean abstractType,PersistentMAspect aspect,boolean delayed$Persistence,PersistentMAtomicType This) throws PersistenceException {
        if (name == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentMAtomicType result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMAtomicTypeFacade
                .newDelayedMAtomicType(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMAtomicTypeFacade
                .newMAtomicType(name,-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("name", name);
        final$$Fields.put("singletonType", singletonType);
        final$$Fields.put("abstractType", abstractType);
        final$$Fields.put("aspect", aspect);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("name", this.getName());
            result.put("singletonType", this.singletonTypeAsString());
            result.put("abstractType", this.abstractTypeAsString());
            AbstractPersistentRoot aspect = (AbstractPersistentRoot)this.getAspect();
            if (aspect != null) {
                result.put("aspect", aspect.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    aspect.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && aspect.hasEssentialFields())aspect.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot superType = (AbstractPersistentRoot)this.getSuperType();
            if (superType != null) {
                result.put("superType", superType.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    superType.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && superType.hasEssentialFields())superType.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            result.put("nEATCContainingMe", this.getNEATCContainingMe().getVector(allResults, (depth > 1 ? depth : depth + 1), essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
            result.put("subTypes", this.getSubTypes().getVector(allResults, (depth > 1 ? depth : depth + 1), essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
            result.put("possibleNames", this.getPossibleNames().getVector(allResults, (depth > 1 ? depth : depth + 1), essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public static MAtomicTypeSearchList getMAtomicTypeByName(String name) throws PersistenceException{
        return ConnectionHandler.getTheConnectionHandler().theMAtomicTypeFacade
            .getMAtomicTypeByName(name);
    }
    
    public MAtomicType provideCopy() throws PersistenceException{
        MAtomicType result = this;
        result = new MAtomicType(this.This, 
                                 this.myCONCMModelItem, 
                                 this.name, 
                                 this.singletonType, 
                                 this.abstractType, 
                                 this.aspect, 
                                 this.superType, 
                                 this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return true;
    }
    protected String name;
    protected PersistentMBoolean singletonType;
    protected PersistentMBoolean abstractType;
    protected PersistentMAspect aspect;
    protected PersistentMAtomicType superType;
    
    public MAtomicType(PersistentMType This,PersistentMModelItem myCONCMModelItem,String name,PersistentMBoolean singletonType,PersistentMBoolean abstractType,PersistentMAspect aspect,PersistentMAtomicType superType,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentMType)This,(PersistentMModelItem)myCONCMModelItem,id);
        this.name = name;
        this.singletonType = singletonType;
        this.abstractType = abstractType;
        this.aspect = aspect;
        this.superType = superType;        
    }
    
    static public long getTypeId() {
        return 113;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 113) ConnectionHandler.getTheConnectionHandler().theMAtomicTypeFacade
            .newMAtomicType(name,this.getId());
        super.store();
        if(this.getSingletonType() != null){
            this.getSingletonType().store();
            ConnectionHandler.getTheConnectionHandler().theMAtomicTypeFacade.singletonTypeSet(this.getId(), getSingletonType());
        }
        if(this.getAbstractType() != null){
            this.getAbstractType().store();
            ConnectionHandler.getTheConnectionHandler().theMAtomicTypeFacade.abstractTypeSet(this.getId(), getAbstractType());
        }
        if(this.getAspect() != null){
            this.getAspect().store();
            ConnectionHandler.getTheConnectionHandler().theMAtomicTypeFacade.aspectSet(this.getId(), getAspect());
        }
        if(this.getSuperType() != null){
            this.getSuperType().store();
            ConnectionHandler.getTheConnectionHandler().theMAtomicTypeFacade.superTypeSet(this.getId(), getSuperType());
        }
        
    }
    
    public String getName() throws PersistenceException {
        return this.name;
    }
    public void setName(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theMAtomicTypeFacade.nameSet(this.getId(), newValue);
        this.name = newValue;
    }
    public PersistentMBoolean getSingletonType() throws PersistenceException {
        return this.singletonType;
    }
    public void setSingletonType(PersistentMBoolean newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.singletonType)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.singletonType = (PersistentMBoolean)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theMAtomicTypeFacade.singletonTypeSet(this.getId(), newValue);
        }
    }
    public PersistentMBoolean getAbstractType() throws PersistenceException {
        return this.abstractType;
    }
    public void setAbstractType(PersistentMBoolean newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.abstractType)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.abstractType = (PersistentMBoolean)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theMAtomicTypeFacade.abstractTypeSet(this.getId(), newValue);
        }
    }
    public PersistentMAspect getAspect() throws PersistenceException {
        return this.aspect;
    }
    public void setAspect(PersistentMAspect newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.aspect)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.aspect = (PersistentMAspect)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theMAtomicTypeFacade.aspectSet(this.getId(), newValue);
        }
    }
    public PersistentMAtomicType getSuperType() throws PersistenceException {
        return this.superType;
    }
    public void setSuperType(PersistentMAtomicType newValue) throws PersistenceException , model.CycleException{
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.containsMAtomicTypeHierarchy(getThis())) throw new model.CycleException("Cycle in MAtomicTypeHierarchy detected!");
        if(newValue.equals(this.superType)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.superType = (PersistentMAtomicType)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theMAtomicTypeFacade.superTypeSet(this.getId(), newValue);
        }
    }
    public PersistentMAtomicType getThis() throws PersistenceException {
        if(this.This == null){
            PersistentMAtomicType result = new MAtomicTypeProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentMAtomicType)this.This;
    }
    
    public void accept(MTypeVisitor visitor) throws PersistenceException {
        visitor.handleMAtomicType(this);
    }
    public <R> R accept(MTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMAtomicType(this);
    }
    public <E extends UserException>  void accept(MTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMAtomicType(this);
    }
    public <R, E extends UserException> R accept(MTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMAtomicType(this);
    }
    public void accept(MModelItemVisitor visitor) throws PersistenceException {
        visitor.handleMAtomicType(this);
    }
    public <R> R accept(MModelItemReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMAtomicType(this);
    }
    public <E extends UserException>  void accept(MModelItemExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMAtomicType(this);
    }
    public <R, E extends UserException> R accept(MModelItemReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMAtomicType(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMAtomicType(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMAtomicType(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMAtomicType(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMAtomicType(this);
    }
    public void accept(MComplexTypeHierarchyHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleMAtomicType(this);
    }
    public <R> R accept(MComplexTypeHierarchyHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMAtomicType(this);
    }
    public <E extends UserException>  void accept(MComplexTypeHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMAtomicType(this);
    }
    public <R, E extends UserException> R accept(MComplexTypeHierarchyHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMAtomicType(this);
    }
    public void accept(MAtomicTypeHierarchyHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleMAtomicType(this);
    }
    public <R> R accept(MAtomicTypeHierarchyHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMAtomicType(this);
    }
    public <E extends UserException>  void accept(MAtomicTypeHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMAtomicType(this);
    }
    public <R, E extends UserException> R accept(MAtomicTypeHierarchyHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMAtomicType(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getSingletonType() != null) return 1;
        if (this.getAbstractType() != null) return 1;
        if (this.getMTDJContainingMe().getLength() > 0) return 1;
        if (this.getMTCContainingMe().getLength() > 0) return 1;
        if (this.getNEATCContainingMe().getLength() > 0) return 1;
        if (this.getSubTypes().getLength() > 0) return 1;
        if (this.getPossibleNames().getLength() > 0) return 1;
        return 0;
    }
    
    
    public NameSearchList getPossibleNames() 
				throws PersistenceException{
        NameSearchList result = null;
		if (result == null) result = ConnectionHandler.getTheConnectionHandler().theNameFacade
							.inverseGetFromType(this.getId(), this.getClassId());
		return result;
    }
    public MModelItemSearchList fetchDependentItems() 
				throws PersistenceException{
		final MModelItemSearchList result = new MModelItemSearchList();
		SearchLists.addSecondToFirst(result, getThis().fetchTypesContainingThisDirectly());
		SearchLists.addSecondToFirst(result, getThis().inverseGetTypes());
		// TODO add other dependencies (assocs, MMTypes, etc)
		return result;
	}
    public boolean containsMComplexTypeHierarchy(final MComplexTypeHierarchyHIERARCHY part) 
				throws PersistenceException{
        if(getThis().equals(part)) return true;
		return false;
    }
    public void changeAbstract(final PersistentMBoolean newAbstractType) 
				throws model.ConsistencyException, PersistenceException{
		if (newAbstractType.toBoolean()) {
			if (getThis().inverseGetTypes().getLength() > 0) {
				throw new model.ConsistencyException("AtomicTypes with Objects may not be set abstract");
			}
		}
		getThis().setAbstractType(newAbstractType);
	}
    public <T> T strategyMComplexTypeHierarchy(final T parameter, final MComplexTypeHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        return strategy.finalize$$MAtomicType(getThis(), parameter);
    }
    public PersistentMBoolean isLessOrEqual(final PersistentMType other) 
				throws PersistenceException{
		return MBoolean.createFromBoolean(other.accept(new MTypeReturnVisitor<Boolean>() {

			@Override
			public Boolean handleMMixedTypeDisjunction(final PersistentMMixedTypeDisjunction mMixedTypeDisjunction)
					throws PersistenceException {
				final Iterator<PersistentMType> iterator = mMixedTypeDisjunction.getAddends().iterator();
				while (iterator.hasNext()) {
					if (getThis().isLessOrEqual(iterator.next()).toBoolean()) {
						return true;
					}
				}
				return false;
			}

			@Override
			public Boolean handleMEmptyTypeDisjunction(final PersistentMEmptyTypeDisjunction mEmptyTypeDisjunction)
					throws PersistenceException {
				return false;
			}

			@Override
			public Boolean handleMNonEmptyDisjunctiveNormalForm(
					final PersistentMNonEmptyDisjunctiveNormalForm mNonEmptyDisjunctiveNormalForm)
					throws PersistenceException {
				final Iterator<PersistentMAtomicTypeConjunction> iterator = mNonEmptyDisjunctiveNormalForm.getAddends()
						.iterator();
				while (iterator.hasNext()) {
					if (getThis().isLessOrEqual(iterator.next()).toBoolean()) {
						return true;
					}
				}
				return false;
			}

			@Override
			public Boolean handleMMixedConjunction(final PersistentMMixedConjunction mMixedConjunction)
					throws PersistenceException {
				final Iterator<PersistentMType> iterator = mMixedConjunction.getFactors().iterator();
				while (iterator.hasNext()) {
					if (!getThis().isLessOrEqual(iterator.next()).toBoolean()) {
						return false;
					}
				}
				return true;
			}

			@Override
			public Boolean handleMNonEmptyAtomicTypeConjunction(
					final PersistentMNonEmptyAtomicTypeConjunction mNonEmptyAtomicTypeConjunction)
					throws PersistenceException {
				final Iterator<PersistentMAtomicType> iterator = mNonEmptyAtomicTypeConjunction.getFactors().iterator();
				while (iterator.hasNext()) {
					if (!getThis().isLessOrEqual(iterator.next()).toBoolean()) {
						return false;
					}
				}
				return true;
			}

			@Override
			public Boolean handleMEmptyTypeConjunction(final PersistentMEmptyTypeConjunction mEmptyTypeConjunction)
					throws PersistenceException {
				return true;
			}

			@Override
			public Boolean handleMAtomicType(final PersistentMAtomicType mAtomicType) throws PersistenceException {
				return getThis().containsMAtomicTypeHierarchy(mAtomicType);
			}
		}));
	}
    public MAspectSearchList fetchAspects() 
				throws PersistenceException{
		final MAspectSearchList result = new MAspectSearchList();
		result.add(getThis().getAspect());
		return result;
	}
    public MAtomicTypeSearchList getSubTypes() 
				throws PersistenceException{
        MAtomicTypeSearchList result = null;
		if (result == null) result = ConnectionHandler.getTheConnectionHandler().theMAtomicTypeFacade
							.inverseGetSuperType(this.getId(), this.getClassId());
		return result;
    }
    public MTypeSearchList fetchTypesContainingThisDirectly() 
				throws PersistenceException{
		final MTypeSearchList result = new MTypeSearchList();
		SearchLists.addSecondToFirst(result, getThis().getMTCContainingMe());
		SearchLists.addSecondToFirst(result, getThis().getMTDJContainingMe());
		SearchLists.addSecondToFirst(result, getThis().getNEATCContainingMe());
		return result;
	}
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
	}
    public String abstractTypeAsString() 
				throws PersistenceException{
		return getThis().getAbstractType().toString();
	}
    public void prepareForDeletion() 
				throws model.ConsistencyException, PersistenceException{
		// TODO: prepare deletion entweder im manager oder hier
	}
    public MObjectSearchList inverseGetTypes() 
				throws PersistenceException{
        MObjectSearchList result = null;
		if (result == null) result = ConnectionHandler.getTheConnectionHandler().theMObjectFacade
							.inverseGetTypes(this.getId(), this.getClassId());
		return result;
    }
    public String singletonTypeAsString() 
				throws PersistenceException{
		return getThis().getSingletonType().toString();
	}
    public boolean containsMAtomicTypeHierarchy(final MAtomicTypeHierarchyHIERARCHY part) 
				throws PersistenceException{
        if(getThis().equals(part)) return true;
		if(getThis().getSuperType() != null && getThis().getSuperType().containsMAtomicTypeHierarchy(part)) return true;
		return false;
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
	}
    public PersistentMBoolean isStructuralEquivalant(final PersistentMType other) 
				throws PersistenceException{
		return MBoolean.createFromBoolean(getThis().equals(other));
	}
    public String fetchName() 
				throws PersistenceException{
		return this.getName();
	}
    public void initializeOnCreation() 
				throws PersistenceException{
	}
    public PersistentMBoolean hasConcreteSubType() 
				throws PersistenceException{
		final Iterator<PersistentMAtomicType> subTypesI = getThis().getSubTypes().iterator();
		while (subTypesI.hasNext()) {
			final PersistentMAtomicType currentType = subTypesI.next();
			if (!currentType.isAbstract().toBoolean() || currentType.hasConcreteSubType().toBoolean()) {
				return MTrue.getTheMTrue();
			}
		}
		return MFalse.getTheMFalse();
	}
    public MNonEmptyAtomicTypeConjunctionSearchList getNEATCContainingMe() 
				throws PersistenceException{
        MNonEmptyAtomicTypeConjunctionSearchList result = null;
		if (result == null) result = ConnectionHandler.getTheConnectionHandler().theMNonEmptyAtomicTypeConjunctionFacade
							.inverseGetFactors(this.getId(), this.getClassId());
		return result;
    }
    public <T> T strategyMAtomicTypeHierarchy(final T parameter, final MAtomicTypeHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        T result$$superType$$MAtomicType = strategy.initialize$$MAtomicType$$superType(getThis(), parameter);
		result$$superType$$MAtomicType = this.getSuperType().strategyMAtomicTypeHierarchy(result$$superType$$MAtomicType, strategy);
		return strategy.finalize$$MAtomicType(getThis(), parameter,result$$superType$$MAtomicType);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentMAtomicType)This);
		if(this.equals(This)){
			PersistentCONCMModelItem myCONCMModelItem = model.CONCMModelItem.createCONCMModelItem(this.isDelayed$Persistence(), (PersistentMAtomicType)This);
			this.setMyCONCMModelItem(myCONCMModelItem);
			this.setName((String)final$$Fields.get("name"));
			this.setSingletonType((PersistentMBoolean)final$$Fields.get("singletonType"));
			this.setAbstractType((PersistentMBoolean)final$$Fields.get("abstractType"));
			this.setAspect((PersistentMAspect)final$$Fields.get("aspect"));
		}
    }
    public PersistentMDisjunctiveNormalForm fetchDisjunctiveNormalform() 
				throws PersistenceException{
		return MNonEmptyDisjunctiveNormalForm.transientCreateDNFromAtomicType(getThis());
	}
    public PersistentMBoolean isSingleton() 
				throws PersistenceException{
		return getSingletonType();
		// return MBoolean.createFromBoolean(getThis().getSingletonType().toBoolean()
		// && !getThis().hasConcreteSubType().toBoolean());
	}
    public PersistentMBoolean isAbstract() 
				throws PersistenceException{
		return getThis().getAbstractType();
	}

    /* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */
    
}
