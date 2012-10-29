
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class CompUnitType extends model.AbsUnitType implements PersistentCompUnitType{
    
    
    public static PersistentCompUnitType createCompUnitType() throws PersistenceException {
        PersistentCompUnitType result = ConnectionHandler.getTheConnectionHandler().theCompUnitTypeFacade
            .newCompUnitType("");
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentCompUnitType createCompUnitType(PersistentCompUnitType This) throws PersistenceException {
        PersistentCompUnitType result = ConnectionHandler.getTheConnectionHandler().theCompUnitTypeFacade
            .newCompUnitType("");
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("refs", this.getRefs().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public CompUnitType provideCopy() throws PersistenceException{
        CompUnitType result = this;
        result = new CompUnitType(this.defaultUnit, 
                                  this.name, 
                                  this.This, 
                                  this.getId());
        result.refs = this.refs.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected CompUnitType_RefsProxi refs;
    
    public CompUnitType(PersistentAbsUnit defaultUnit,String name,PersistentAbsUnitType This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentAbsUnit)defaultUnit,(String)name,(PersistentAbsUnitType)This,id);
        this.refs = new CompUnitType_RefsProxi(this);        
    }
    
    static public long getTypeId() {
        return 120;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public CompUnitType_RefsProxi getRefs() throws PersistenceException {
        return this.refs;
    }
    public PersistentCompUnitType getThis() throws PersistenceException {
        if(this.This == null){
            PersistentCompUnitType result = new CompUnitTypeProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentCompUnitType)this.This;
    }
    
    public void accept(AbsUnitTypeVisitor visitor) throws PersistenceException {
        visitor.handleCompUnitType(this);
    }
    public <R> R accept(AbsUnitTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompUnitType(this);
    }
    public <E extends UserException>  void accept(AbsUnitTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompUnitType(this);
    }
    public <R, E extends UserException> R accept(AbsUnitTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompUnitType(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCompUnitType(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompUnitType(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompUnitType(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompUnitType(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + (this.getDefaultUnit() == null ? 0 : 1)
            + this.getRefs().getLength());
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
        this.setThis((PersistentCompUnitType)This);
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
