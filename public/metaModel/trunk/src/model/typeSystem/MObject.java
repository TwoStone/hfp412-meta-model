package model.typeSystem;

import java.util.Set;

import model.ConsistencyException;
import model.UserException;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.*;
import utils.Lists;
import utils.Sets;

/* Additional import section end */

public class MObject extends PersistentObject implements PersistentMObject{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentMObject getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theMObjectFacade.getClass(objectId);
        return (PersistentMObject)PersistentProxi.createProxi(objectId, classId);
    }
    
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
            result.put("types", this.getTypes().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false));
            result.put("names", this.getNames().getVector(allResults, (depth > 1 ? depth : depth + 1), essentialLevel, forGUI, tdObserver, false));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public MObject provideCopy() throws PersistenceException{
        MObject result = this;
        result = new MObject(this.This, 
                             this.getId());
        result.types = this.types.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected MObject_TypesProxi types;
    protected PersistentMObject This;
    
    public MObject(PersistentMObject This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.types = new MObject_TypesProxi(this);
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 130;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 130) ConnectionHandler.getTheConnectionHandler().theMObjectFacade
            .newMObject(this.getId());
        super.store();
        this.getTypes().store();
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theMObjectFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public MObject_TypesProxi getTypes() throws PersistenceException {
        return this.types;
    }
    protected void setThis(PersistentMObject newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentMObject)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theMObjectFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentMObject getThis() throws PersistenceException {
        if(this.This == null){
            PersistentMObject result = new MObjectProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentMObject)this.This;
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
        return (int) (0 
            + this.getTypes().getLength()
            + this.getNames().getLength());
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
	}
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
	}
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentMObject)This);
		if(this.equals(This)){
		}
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
			public boolean test(PersistentMAtomicType argument) throws PersistenceException {
				return argument.equals(oldType);
			}
		});

		this.getThis().getTypes().add(newType);
	}
    public void addType(final PersistentMAtomicType newType) 
				throws model.ConsistencyException, PersistenceException{
		if (newType.isAbstract().toBoolean()) {
			throw new ConsistencyException("Objekte dürfen nur in konkreten Typen klassifiziert werden!");
		}

		if (this.getAspects().contains(newType.getAspect())) {
			throw new ConsistencyException(String.format(
					"Das Objekt kann nur in nur einem Typen pro Aspekt klassifiziert werden! Aspekt: %s", newType
							.getAspect().getName()));
		}
		this.getThis().getTypes().add(newType);
	}
    public void initializeOnCreation() 
				throws PersistenceException{
	}
    public void removeType(final PersistentMAtomicType oldType) 
				throws model.ConsistencyException, PersistenceException{
		if (this.getThis().getTypes().getLength() <= 1) {
			throw new ConsistencyException(
					"Das Objekt muss in mindestens einem Typen klassifiziert! Fügen sie einen weiteren Typen hinzu bevor Sie diesen entfernen!");
		}
		this.getThis().getTypes().removeFirstSuccess(new Predcate<PersistentMAtomicType>() {

			@Override
			public boolean test(PersistentMAtomicType argument) throws PersistenceException {
				return argument.equals(oldType);
			}
		});

	}
    public NameInstanceSearchList getNames() 
				throws PersistenceException{
        NameInstanceSearchList result = null;
		if (result == null) result = ConnectionHandler.getTheConnectionHandler().theNameInstanceFacade
							.inverseGetFromObject(this.getId(), this.getClassId());
		return result;
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
	/* End of protected part that is not overridden by persistence generator */
    
}
