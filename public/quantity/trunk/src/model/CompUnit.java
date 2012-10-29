
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class CompUnit extends model.AbsUnit implements PersistentCompUnit{
    
    
    public static PersistentCompUnit createCompUnit() throws PersistenceException {
        PersistentCompUnit result = ConnectionHandler.getTheConnectionHandler().theCompUnitFacade
            .newCompUnit("");
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentCompUnit createCompUnit(PersistentCompUnit This) throws PersistenceException {
        PersistentCompUnit result = ConnectionHandler.getTheConnectionHandler().theCompUnitFacade
            .newCompUnit("");
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
    
    public CompUnit provideCopy() throws PersistenceException{
        CompUnit result = this;
        result = new CompUnit(this.type, 
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
    protected CompUnit_RefsProxi refs;
    
    public CompUnit(PersistentAbsUnitType type,String name,PersistentAbsUnit This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentAbsUnitType)type,(String)name,(PersistentAbsUnit)This,id);
        this.refs = new CompUnit_RefsProxi(this);        
    }
    
    static public long getTypeId() {
        return 118;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public CompUnit_RefsProxi getRefs() throws PersistenceException {
        return this.refs;
    }
    public PersistentCompUnit getThis() throws PersistenceException {
        if(this.This == null){
            PersistentCompUnit result = new CompUnitProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentCompUnit)this.This;
    }
    
    public void accept(AbsUnitVisitor visitor) throws PersistenceException {
        visitor.handleCompUnit(this);
    }
    public <R> R accept(AbsUnitReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompUnit(this);
    }
    public <E extends UserException>  void accept(AbsUnitExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompUnit(this);
    }
    public <R, E extends UserException> R accept(AbsUnitReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompUnit(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCompUnit(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompUnit(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompUnit(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompUnit(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + (this.getType() == null ? 0 : 1)
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
        this.setThis((PersistentCompUnit)This);
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
