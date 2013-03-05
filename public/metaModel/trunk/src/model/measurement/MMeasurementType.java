
package model.measurement;

import model.UserException;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.MQuantiObjectTypeExceptionVisitor;
import model.visitor.MQuantiObjectTypeReturnExceptionVisitor;
import model.visitor.MQuantiObjectTypeReturnVisitor;
import model.visitor.MQuantiObjectTypeVisitor;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.MMeasurementTypeProxi;
import persistence.PersistenceException;
import persistence.PersistentAbsUnitType;
import persistence.PersistentMMeasurementType;
import persistence.PersistentMQuantiObjectType;
import persistence.PersistentMType;
import persistence.TDObserver;


/* Additional import section end */

public class MMeasurementType extends model.measurement.MQuantiObjectType implements PersistentMMeasurementType{
    
    
    public static PersistentMMeasurementType createMMeasurementType(PersistentMType type,PersistentAbsUnitType unitType) throws PersistenceException{
        return createMMeasurementType(type,unitType,false);
    }
    
    public static PersistentMMeasurementType createMMeasurementType(PersistentMType type,PersistentAbsUnitType unitType,boolean delayed$Persistence) throws PersistenceException {
        PersistentMMeasurementType result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMMeasurementTypeFacade
                .newDelayedMMeasurementType();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMMeasurementTypeFacade
                .newMMeasurementType(-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("type", type);
        final$$Fields.put("unitType", unitType);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentMMeasurementType createMMeasurementType(PersistentMType type,PersistentAbsUnitType unitType,boolean delayed$Persistence,PersistentMMeasurementType This) throws PersistenceException {
        PersistentMMeasurementType result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMMeasurementTypeFacade
                .newDelayedMMeasurementType();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMMeasurementTypeFacade
                .newMMeasurementType(-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("type", type);
        final$$Fields.put("unitType", unitType);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public MMeasurementType provideCopy() throws PersistenceException{
        MMeasurementType result = this;
        result = new MMeasurementType(this.type, 
                                      this.unitType, 
                                      this.This, 
                                      this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public MMeasurementType(PersistentMType type,PersistentAbsUnitType unitType,PersistentMQuantiObjectType This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentMType)type,(PersistentAbsUnitType)unitType,(PersistentMQuantiObjectType)This,id);        
    }
    
    static public long getTypeId() {
        return 126;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 126) ConnectionHandler.getTheConnectionHandler().theMMeasurementTypeFacade
            .newMMeasurementType(this.getId());
        super.store();
        
    }
    
    public PersistentMMeasurementType getThis() throws PersistenceException {
        if(this.This == null){
            PersistentMMeasurementType result = new MMeasurementTypeProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentMMeasurementType)this.This;
    }
    
    public void accept(MQuantiObjectTypeVisitor visitor) throws PersistenceException {
        visitor.handleMMeasurementType(this);
    }
    public <R> R accept(MQuantiObjectTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMMeasurementType(this);
    }
    public <E extends UserException>  void accept(MQuantiObjectTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMMeasurementType(this);
    }
    public <R, E extends UserException> R accept(MQuantiObjectTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMMeasurementType(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMMeasurementType(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMMeasurementType(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMMeasurementType(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMMeasurementType(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getType() != null) return 1;
        if (this.getUnitType() != null) return 1;
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentMMeasurementType)This);
		if(this.equals(This)){
			this.setType((PersistentMType)final$$Fields.get("type"));
			this.setUnitType((PersistentAbsUnitType)final$$Fields.get("unitType"));
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    
    
    
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
