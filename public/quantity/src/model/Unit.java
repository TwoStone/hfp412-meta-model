
package model;

import persistence.*;


/* Additional import section end */

public class Unit extends model.AbsUnit implements PersistentUnit{
    
    
    public static PersistentUnit createUnit(String name,PersistentUnitType unitType) throws PersistenceException {
        PersistentUnit result = ConnectionHandler.getTheConnectionHandler().theUnitFacade
            .newUnit(name);
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("name", name);
        final$$Fields.put("unitType", unitType);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentUnit createUnit(String name,PersistentUnitType unitType,PersistentUnit This) throws PersistenceException {
        PersistentUnit result = ConnectionHandler.getTheConnectionHandler().theUnitFacade
            .newUnit(name);
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("name", name);
        final$$Fields.put("unitType", unitType);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot unitType = (AbstractPersistentRoot)this.getUnitType();
            if (unitType != null) {
                result.put("unitType", unitType.createProxiInformation());
                if(depth > 1) {
                    unitType.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && unitType.hasEssentialFields())unitType.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public Unit provideCopy() throws PersistenceException{
        Unit result = this;
        result = new Unit(this.name, 
                          this.This, 
                          this.unitType, 
                          this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentUnitType unitType;
    
    public Unit(String name,PersistentAbsUnit This,PersistentUnitType unitType,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((String)name,(PersistentAbsUnit)This,id);
        this.unitType = unitType;        
    }
    
    static public long getTypeId() {
        return 118;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public PersistentUnitType getUnitType() throws PersistenceException {
        return this.unitType;
    }
    public void setUnitType(PersistentUnitType newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.unitType)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.unitType = (PersistentUnitType)PersistentProxi.createProxi(objectId, classId);
        ConnectionHandler.getTheConnectionHandler().theUnitFacade.unitTypeSet(this.getId(), newValue);
    }
    public PersistentUnit getThis() throws PersistenceException {
        if(this.This == null){
            PersistentUnit result = new UnitProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentUnit)this.This;
    }
    
    public void accept(model.visitor.AbsUnitVisitor visitor) throws PersistenceException {
        visitor.handleUnit(this);
    }
    public <R> R accept(model.visitor.AbsUnitReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUnit(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AbsUnitExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUnit(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AbsUnitReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUnit(this);
    }
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleUnit(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUnit(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUnit(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUnit(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + (this.getUnitType() == null ? 0 : 1));
    }
    
    
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
        this.setThis((PersistentUnit)This);
		if(this.equals(This)){
			this.setName((String)final$$Fields.get("name"));
			this.setUnitType((PersistentUnitType)final$$Fields.get("unitType"));
		}
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
