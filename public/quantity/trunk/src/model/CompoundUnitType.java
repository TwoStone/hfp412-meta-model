
package model;

import persistence.*;


/* Additional import section end */

public class CompoundUnitType extends model.AbsUnitType implements PersistentCompoundUnitType{
    
    
    public static PersistentCompoundUnitType createCompoundUnitType() throws PersistenceException {
        PersistentCompoundUnitType result = ConnectionHandler.getTheConnectionHandler().theCompoundUnitTypeFacade
            .newCompoundUnitType();
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentCompoundUnitType createCompoundUnitType(PersistentCompoundUnitType This) throws PersistenceException {
        PersistentCompoundUnitType result = ConnectionHandler.getTheConnectionHandler().theCompoundUnitTypeFacade
            .newCompoundUnitType();
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
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
    
    public CompoundUnitType provideCopy() throws PersistenceException{
        CompoundUnitType result = this;
        result = new CompoundUnitType(this.This, 
                                      this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public CompoundUnitType(PersistentAbsUnitType This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentAbsUnitType)This,id);        
    }
    
    static public long getTypeId() {
        return 114;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public PersistentCompoundUnitType getThis() throws PersistenceException {
        if(this.This == null){
            PersistentCompoundUnitType result = new CompoundUnitTypeProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentCompoundUnitType)this.This;
    }
    
    public void accept(model.visitor.AbsUnitTypeVisitor visitor) throws PersistenceException {
        visitor.handleCompoundUnitType(this);
    }
    public <R> R accept(model.visitor.AbsUnitTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompoundUnitType(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AbsUnitTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompoundUnitType(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AbsUnitTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompoundUnitType(this);
    }
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCompoundUnitType(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompoundUnitType(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompoundUnitType(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompoundUnitType(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
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
        this.setThis((PersistentCompoundUnitType)This);
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
