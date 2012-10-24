
package model;

import persistence.*;


/* Additional import section end */

public class ConversionRate extends PersistentObject implements PersistentConversionRate{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentConversionRate getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theConversionRateFacade.getClass(objectId);
        return (PersistentConversionRate)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentConversionRate createConversionRate(PersistentUnit fromUnit,PersistentUnit toUnit,PersistentFraction conversionRate) throws PersistenceException {
        PersistentConversionRate result = ConnectionHandler.getTheConnectionHandler().theConversionRateFacade
            .newConversionRate();
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("fromUnit", fromUnit);
        final$$Fields.put("toUnit", toUnit);
        final$$Fields.put("conversionRate", conversionRate);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentConversionRate createConversionRate(PersistentUnit fromUnit,PersistentUnit toUnit,PersistentFraction conversionRate,PersistentConversionRate This) throws PersistenceException {
        PersistentConversionRate result = ConnectionHandler.getTheConnectionHandler().theConversionRateFacade
            .newConversionRate();
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("fromUnit", fromUnit);
        final$$Fields.put("toUnit", toUnit);
        final$$Fields.put("conversionRate", conversionRate);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot fromUnit = (AbstractPersistentRoot)this.getFromUnit();
            if (fromUnit != null) {
                result.put("fromUnit", fromUnit.createProxiInformation());
                if(depth > 1) {
                    fromUnit.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && fromUnit.hasEssentialFields())fromUnit.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot toUnit = (AbstractPersistentRoot)this.getToUnit();
            if (toUnit != null) {
                result.put("toUnit", toUnit.createProxiInformation());
                if(depth > 1) {
                    toUnit.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && toUnit.hasEssentialFields())toUnit.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot conversionRate = (AbstractPersistentRoot)this.getConversionRate();
            if (conversionRate != null) {
                result.put("conversionRate", conversionRate.createProxiInformation());
                if(depth > 1) {
                    conversionRate.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && conversionRate.hasEssentialFields())conversionRate.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public ConversionRate provideCopy() throws PersistenceException{
        ConversionRate result = this;
        result = new ConversionRate(this.fromUnit, 
                                    this.toUnit, 
                                    this.conversionRate, 
                                    this.This, 
                                    this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentUnit fromUnit;
    protected PersistentUnit toUnit;
    protected PersistentFraction conversionRate;
    protected PersistentConversionRate This;
    
    public ConversionRate(PersistentUnit fromUnit,PersistentUnit toUnit,PersistentFraction conversionRate,PersistentConversionRate This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.fromUnit = fromUnit;
        this.toUnit = toUnit;
        this.conversionRate = conversionRate;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 120;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public PersistentUnit getFromUnit() throws PersistenceException {
        return this.fromUnit;
    }
    public void setFromUnit(PersistentUnit newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.fromUnit)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.fromUnit = (PersistentUnit)PersistentProxi.createProxi(objectId, classId);
        ConnectionHandler.getTheConnectionHandler().theConversionRateFacade.fromUnitSet(this.getId(), newValue);
    }
    public PersistentUnit getToUnit() throws PersistenceException {
        return this.toUnit;
    }
    public void setToUnit(PersistentUnit newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.toUnit)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.toUnit = (PersistentUnit)PersistentProxi.createProxi(objectId, classId);
        ConnectionHandler.getTheConnectionHandler().theConversionRateFacade.toUnitSet(this.getId(), newValue);
    }
    public PersistentFraction getConversionRate() throws PersistenceException {
        return this.conversionRate;
    }
    public void setConversionRate(PersistentFraction newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.conversionRate)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.conversionRate = (PersistentFraction)PersistentProxi.createProxi(objectId, classId);
        ConnectionHandler.getTheConnectionHandler().theConversionRateFacade.conversionRateSet(this.getId(), newValue);
    }
    protected void setThis(PersistentConversionRate newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentConversionRate)PersistentProxi.createProxi(objectId, classId);
        ConnectionHandler.getTheConnectionHandler().theConversionRateFacade.ThisSet(this.getId(), newValue);
    }
    public PersistentConversionRate getThis() throws PersistenceException {
        if(this.This == null){
            PersistentConversionRate result = new ConversionRateProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentConversionRate)this.This;
    }
    
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleConversionRate(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleConversionRate(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleConversionRate(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleConversionRate(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + (this.getFromUnit() == null ? 0 : 1)
            + (this.getToUnit() == null ? 0 : 1)
            + (this.getConversionRate() == null ? 0 : 1));
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
        this.setThis((PersistentConversionRate)This);
		if(this.equals(This)){
			this.setFromUnit((PersistentUnit)final$$Fields.get("fromUnit"));
			this.setToUnit((PersistentUnit)final$$Fields.get("toUnit"));
			this.setConversionRate((PersistentFraction)final$$Fields.get("conversionRate"));
		}
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
