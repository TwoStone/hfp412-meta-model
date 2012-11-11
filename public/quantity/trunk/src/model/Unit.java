
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class Unit extends model.AbsUnit implements PersistentUnit{
    
    
    public static PersistentUnit createUnit() throws PersistenceException{
        return createUnit(false);
    }
    
    public static PersistentUnit createUnit(boolean delayed$Persistence) throws PersistenceException {
        PersistentUnit result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theUnitFacade
                .newDelayedUnit("");
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theUnitFacade
                .newUnit("",-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentUnit createUnit(boolean delayed$Persistence,PersistentUnit This) throws PersistenceException {
        PersistentUnit result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theUnitFacade
                .newDelayedUnit("");
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theUnitFacade
                .newUnit("",-1);
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
            AbstractPersistentRoot myConversion = (AbstractPersistentRoot)this.getMyConversion();
            if (myConversion != null) {
                result.put("myConversion", myConversion.createProxiInformation(false));
                if(depth > 1) {
                    myConversion.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && myConversion.hasEssentialFields())myConversion.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public Unit provideCopy() throws PersistenceException{
        Unit result = this;
        result = new Unit(this.type, 
                          this.name, 
                          this.This, 
                          this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public Unit(PersistentAbsUnitType type,String name,PersistentAbsUnit This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentAbsUnitType)type,(String)name,(PersistentAbsUnit)This,id);        
    }
    
    static public long getTypeId() {
        return 113;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 113) ConnectionHandler.getTheConnectionHandler().theUnitFacade
            .newUnit("",this.getId());
        super.store();
        
    }
    
    public PersistentUnit getThis() throws PersistenceException {
        if(this.This == null){
            PersistentUnit result = new UnitProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentUnit)this.This;
    }
    
    public void accept(AbsUnitVisitor visitor) throws PersistenceException {
        visitor.handleUnit(this);
    }
    public <R> R accept(AbsUnitReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUnit(this);
    }
    public <E extends UserException>  void accept(AbsUnitExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUnit(this);
    }
    public <R, E extends UserException> R accept(AbsUnitReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUnit(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleUnit(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUnit(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUnit(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUnit(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + (this.getType() == null ? 0 : 1)
            + (this.getMyConversion() == null ? 0 : 1));
    }
    
    
    public PersistentConversion getMyConversion() 
				throws PersistenceException{
        PersistentConversion result = null;
		try {
			if (result == null) result = (PersistentConversion)ConnectionHandler.getTheConnectionHandler().theConversionFacade
							.inverseGetSource(this.getId(), this.getClassId()).iterator().next();
		} catch (java.util.NoSuchElementException nsee){}
		return result;
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
		}
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
