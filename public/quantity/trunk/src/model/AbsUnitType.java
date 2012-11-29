
package model;

import persistence.*;


/* Additional import section end */

public abstract class AbsUnitType extends PersistentObject implements PersistentAbsUnitType{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentAbsUnitType getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theAbsUnitTypeFacade.getClass(objectId);
        return (PersistentAbsUnitType)PersistentProxi.createProxi(objectId, classId);
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot defaultUnit = (AbstractPersistentRoot)this.getDefaultUnit();
            if (defaultUnit != null) {
                result.put("defaultUnit", defaultUnit.createProxiInformation(false));
                if(depth > 1) {
                    defaultUnit.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && defaultUnit.hasEssentialFields())defaultUnit.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            result.put("name", this.getName());
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public static AbsUnitTypeSearchList getAbsUnitTypeByName(String name) throws PersistenceException{
        return ConnectionHandler.getTheConnectionHandler().theAbsUnitTypeFacade
            .getAbsUnitTypeByName(name);
    }
    
    public abstract AbsUnitType provideCopy() throws PersistenceException;
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentAbsUnit defaultUnit;
    protected String name;
    protected PersistentAbsUnitType This;
    
    public AbsUnitType(PersistentAbsUnit defaultUnit,String name,PersistentAbsUnitType This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.defaultUnit = defaultUnit;
        this.name = name;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 105;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        super.store();
        if(this.getDefaultUnit() != null){
            this.getDefaultUnit().store();
            ConnectionHandler.getTheConnectionHandler().theAbsUnitTypeFacade.defaultUnitSet(this.getId(), getDefaultUnit());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theAbsUnitTypeFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public PersistentAbsUnit getDefaultUnit() throws PersistenceException {
        return this.defaultUnit;
    }
    public void setDefaultUnit(PersistentAbsUnit newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.defaultUnit)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.defaultUnit = (PersistentAbsUnit)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAbsUnitTypeFacade.defaultUnitSet(this.getId(), newValue);
        }
    }
    public String getName() throws PersistenceException {
        return this.name;
    }
    public void setName(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theAbsUnitTypeFacade.nameSet(this.getId(), newValue);
        this.name = newValue;
    }
    protected void setThis(PersistentAbsUnitType newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentAbsUnitType)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAbsUnitTypeFacade.ThisSet(this.getId(), newValue);
        }
    }
    public abstract PersistentAbsUnitType getThis() throws PersistenceException ;
    
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentAbsUnitType)This);
		if(this.equals(This)){
			this.setName((String)final$$Fields.get("name"));
		}
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
