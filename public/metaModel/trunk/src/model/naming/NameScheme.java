package model.naming;

import java.util.regex.Pattern;

import model.UserException;
import model.basic.MBoolean;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.MModelItemExceptionVisitor;
import model.visitor.MModelItemReturnExceptionVisitor;
import model.visitor.MModelItemReturnVisitor;
import model.visitor.MModelItemVisitor;
import persistence.*;
import utils.SearchLists;

/* Additional import section end */

public class NameScheme extends PersistentObject implements PersistentNameScheme{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentNameScheme getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theNameSchemeFacade.getClass(objectId);
        return (PersistentNameScheme)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentNameScheme createNameScheme(String regExpPattern,String name,PersistentMBoolean isIterable) throws PersistenceException{
        return createNameScheme(regExpPattern,name,isIterable,false);
    }
    
    public static PersistentNameScheme createNameScheme(String regExpPattern,String name,PersistentMBoolean isIterable,boolean delayed$Persistence) throws PersistenceException {
        if (regExpPattern == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if (name == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentNameScheme result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theNameSchemeFacade
                .newDelayedNameScheme(regExpPattern,name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theNameSchemeFacade
                .newNameScheme(regExpPattern,name,-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("regExpPattern", regExpPattern);
        final$$Fields.put("name", name);
        final$$Fields.put("isIterable", isIterable);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentNameScheme createNameScheme(String regExpPattern,String name,PersistentMBoolean isIterable,boolean delayed$Persistence,PersistentNameScheme This) throws PersistenceException {
        if (regExpPattern == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if (name == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentNameScheme result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theNameSchemeFacade
                .newDelayedNameScheme(regExpPattern,name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theNameSchemeFacade
                .newNameScheme(regExpPattern,name,-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("regExpPattern", regExpPattern);
        final$$Fields.put("name", name);
        final$$Fields.put("isIterable", isIterable);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("regExpPattern", this.getRegExpPattern());
            result.put("name", this.getName());
            AbstractPersistentRoot isIterable = (AbstractPersistentRoot)this.getIsIterable();
            if (isIterable != null) {
                result.put("isIterable", isIterable.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    isIterable.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && isIterable.hasEssentialFields())isIterable.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            result.put("names", this.getNames().getVector(allResults, (depth > 1 ? depth : depth + 1), essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
            AbstractPersistentRoot myCONCMModelItem = (AbstractPersistentRoot)this.getMyCONCMModelItem();
            if (myCONCMModelItem != null) {
                result.put("myCONCMModelItem", myCONCMModelItem.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    myCONCMModelItem.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    myCONCMModelItem.toHashtable(allResults, depth, essentialLevel + 1, forGUI, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public static NameSchemeSearchList getNameSchemeByName(String name) throws PersistenceException{
        return ConnectionHandler.getTheConnectionHandler().theNameSchemeFacade
            .getNameSchemeByName(name);
    }
    
    public NameScheme provideCopy() throws PersistenceException{
        NameScheme result = this;
        result = new NameScheme(this.regExpPattern, 
                                this.name, 
                                this.isIterable, 
                                this.This, 
                                this.myCONCMModelItem, 
                                this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return true;
    }
    protected String regExpPattern;
    protected String name;
    protected PersistentMBoolean isIterable;
    protected PersistentNameScheme This;
    protected PersistentMModelItem myCONCMModelItem;
    
    public NameScheme(String regExpPattern,String name,PersistentMBoolean isIterable,PersistentNameScheme This,PersistentMModelItem myCONCMModelItem,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.regExpPattern = regExpPattern;
        this.name = name;
        this.isIterable = isIterable;
        if (This != null && !(this.equals(This))) this.This = This;
        this.myCONCMModelItem = myCONCMModelItem;        
    }
    
    static public long getTypeId() {
        return 244;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 244) ConnectionHandler.getTheConnectionHandler().theNameSchemeFacade
            .newNameScheme(regExpPattern,name,this.getId());
        super.store();
        if(this.getIsIterable() != null){
            this.getIsIterable().store();
            ConnectionHandler.getTheConnectionHandler().theNameSchemeFacade.isIterableSet(this.getId(), getIsIterable());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theNameSchemeFacade.ThisSet(this.getId(), getThis());
        }
        if(this.getMyCONCMModelItem() != null){
            this.getMyCONCMModelItem().store();
            ConnectionHandler.getTheConnectionHandler().theNameSchemeFacade.myCONCMModelItemSet(this.getId(), getMyCONCMModelItem());
        }
        
    }
    
    public String getRegExpPattern() throws PersistenceException {
        return this.regExpPattern;
    }
    public void setRegExpPattern(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theNameSchemeFacade.regExpPatternSet(this.getId(), newValue);
        this.regExpPattern = newValue;
    }
    public String getName() throws PersistenceException {
        return this.name;
    }
    public void setName(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theNameSchemeFacade.nameSet(this.getId(), newValue);
        this.name = newValue;
    }
    public PersistentMBoolean getIsIterable() throws PersistenceException {
        return this.isIterable;
    }
    public void setIsIterable(PersistentMBoolean newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.isIterable)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.isIterable = (PersistentMBoolean)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theNameSchemeFacade.isIterableSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentNameScheme newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentNameScheme)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theNameSchemeFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentMModelItem getMyCONCMModelItem() throws PersistenceException {
        return this.myCONCMModelItem;
    }
    public void setMyCONCMModelItem(PersistentMModelItem newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.myCONCMModelItem)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.myCONCMModelItem = (PersistentMModelItem)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theNameSchemeFacade.myCONCMModelItemSet(this.getId(), newValue);
        }
    }
    public PersistentNameScheme getThis() throws PersistenceException {
        if(this.This == null){
            PersistentNameScheme result = new NameSchemeProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentNameScheme)this.This;
    }
    public void delete$Me() throws PersistenceException{
        super.delete$Me();
        this.getMyCONCMModelItem().delete$Me();
    }
    
    public void accept(MModelItemVisitor visitor) throws PersistenceException {
        visitor.handleNameScheme(this);
    }
    public <R> R accept(MModelItemReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNameScheme(this);
    }
    public <E extends UserException>  void accept(MModelItemExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNameScheme(this);
    }
    public <R, E extends UserException> R accept(MModelItemReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNameScheme(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleNameScheme(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNameScheme(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNameScheme(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNameScheme(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getIsIterable() != null) return 1;
        if (this.getNames().getLength() > 0) return 1;
        return 0;
    }
    
    
    public NameSchemeInstanceSearchList getNames() 
				throws PersistenceException{
        NameSchemeInstanceSearchList result = null;
		if (result == null) result = ConnectionHandler.getTheConnectionHandler().theNameSchemeInstanceFacade
							.inverseGetType(this.getId(), this.getClassId());
		return result;
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentNameScheme)This);
		if(this.equals(This)){
			PersistentCONCMModelItem myCONCMModelItem = model.CONCMModelItem.createCONCMModelItem(this.isDelayed$Persistence(), (PersistentNameScheme)This);
			this.setMyCONCMModelItem(myCONCMModelItem);
			this.setRegExpPattern((String)final$$Fields.get("regExpPattern"));
			this.setName((String)final$$Fields.get("name"));
			this.setIsIterable((PersistentMBoolean)final$$Fields.get("isIterable"));
		}
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
	}
    public void delete() 
				throws model.ConsistencyException, PersistenceException{
		// TODO Check delegation to abstract class and overwrite if necessary!
		this.getMyCONCMModelItem().delete();
	}
    public MModelItemSearchList fetchDependentItems() 
				throws PersistenceException{
		final MModelItemSearchList result = new MModelItemSearchList();
		SearchLists.addSecondToFirst(result, getThis().getNames());

		return result;
	}
    public void initializeOnCreation() 
				throws PersistenceException{
	}
    public void initializeOnInstantiation() 
				throws PersistenceException{
	}
    public PersistentMBoolean match(final String name) 
				throws PersistenceException{
		return MBoolean.createFromBoolean(Pattern.matches(getThis().getRegExpPattern(), name));
	}
    public void prepareForDeletion() 
				throws model.ConsistencyException, PersistenceException{
	}
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */
    
}
