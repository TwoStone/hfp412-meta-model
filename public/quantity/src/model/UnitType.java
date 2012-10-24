
package model;

import persistence.*;


/* Additional import section end */

public class UnitType extends model.AbsUnitType implements PersistentUnitType{
    
    
    public static PersistentUnitType createUnitType(PersistentUnit defaultUnit) throws PersistenceException {
        PersistentUnitType result = ConnectionHandler.getTheConnectionHandler().theUnitTypeFacade
            .newUnitType();
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("defaultUnit", defaultUnit);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentUnitType createUnitType(PersistentUnit defaultUnit,PersistentUnitType This) throws PersistenceException {
        PersistentUnitType result = ConnectionHandler.getTheConnectionHandler().theUnitTypeFacade
            .newUnitType();
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("defaultUnit", defaultUnit);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot defaultUnit = (AbstractPersistentRoot)this.getDefaultUnit();
            if (defaultUnit != null) {
                result.put("defaultUnit", defaultUnit.createProxiInformation());
                if(depth > 1) {
                    defaultUnit.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && defaultUnit.hasEssentialFields())defaultUnit.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public UnitType provideCopy() throws PersistenceException{
        UnitType result = this;
        result = new UnitType(this.This, 
                              this.defaultUnit, 
                              this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentUnit defaultUnit;
    
    public UnitType(PersistentAbsUnitType This,PersistentUnit defaultUnit,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentAbsUnitType)This,id);
        this.defaultUnit = defaultUnit;        
    }
    
    static public long getTypeId() {
        return 117;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public PersistentUnit getDefaultUnit() throws PersistenceException {
        return this.defaultUnit;
    }
    public void setDefaultUnit(PersistentUnit newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.defaultUnit)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.defaultUnit = (PersistentUnit)PersistentProxi.createProxi(objectId, classId);
        ConnectionHandler.getTheConnectionHandler().theUnitTypeFacade.defaultUnitSet(this.getId(), newValue);
    }
    public PersistentUnitType getThis() throws PersistenceException {
        if(this.This == null){
            PersistentUnitType result = new UnitTypeProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentUnitType)this.This;
    }
    
    public void accept(model.visitor.AbsUnitTypeVisitor visitor) throws PersistenceException {
        visitor.handleUnitType(this);
    }
    public <R> R accept(model.visitor.AbsUnitTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUnitType(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AbsUnitTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUnitType(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AbsUnitTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUnitType(this);
    }
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleUnitType(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUnitType(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUnitType(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUnitType(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + (this.getDefaultUnit() == null ? 0 : 1));
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
        this.setThis((PersistentUnitType)This);
		if(this.equals(This)){
			this.setDefaultUnit((PersistentUnit)final$$Fields.get("defaultUnit"));
		}
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
