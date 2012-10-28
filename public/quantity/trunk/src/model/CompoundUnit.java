
package model;

import persistence.*;


/* Additional import section end */

public class CompoundUnit extends model.AbsUnit implements PersistentCompoundUnit{
    
    
    public static PersistentCompoundUnit createCompoundUnit(String name) throws PersistenceException {
        PersistentCompoundUnit result = ConnectionHandler.getTheConnectionHandler().theCompoundUnitFacade
            .newCompoundUnit(name);
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("name", name);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentCompoundUnit createCompoundUnit(String name,PersistentCompoundUnit This) throws PersistenceException {
        PersistentCompoundUnit result = ConnectionHandler.getTheConnectionHandler().theCompoundUnitFacade
            .newCompoundUnit(name);
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("name", name);
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
    
    public CompoundUnit provideCopy() throws PersistenceException{
        CompoundUnit result = this;
        result = new CompoundUnit(this.name, 
                                  this.This, 
                                  this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public CompoundUnit(String name,PersistentAbsUnit This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((String)name,(PersistentAbsUnit)This,id);        
    }
    
    static public long getTypeId() {
        return 122;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public PersistentCompoundUnit getThis() throws PersistenceException {
        if(this.This == null){
            PersistentCompoundUnit result = new CompoundUnitProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentCompoundUnit)this.This;
    }
    
    public void accept(model.visitor.AbsUnitVisitor visitor) throws PersistenceException {
        visitor.handleCompoundUnit(this);
    }
    public <R> R accept(model.visitor.AbsUnitReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompoundUnit(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AbsUnitExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompoundUnit(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AbsUnitReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompoundUnit(this);
    }
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCompoundUnit(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompoundUnit(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompoundUnit(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompoundUnit(this);
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
        this.setThis((PersistentCompoundUnit)This);
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
