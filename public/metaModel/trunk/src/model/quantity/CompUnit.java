package model.quantity;

import model.UserException;
import model.visitor.AbsUnitExceptionVisitor;
import model.visitor.AbsUnitReturnExceptionVisitor;
import model.visitor.AbsUnitReturnVisitor;
import model.visitor.AbsUnitVisitor;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.Anything;
import persistence.CompUnitProxi;
import persistence.CompUnit_RefsProxi;
import persistence.ConnectionHandler;
import persistence.PersistenceException;
import persistence.PersistentAbsUnit;
import persistence.PersistentAbsUnitType;
import persistence.PersistentCompUnit;
import persistence.TDObserver;

/* Additional import section end */

public class CompUnit extends model.quantity.AbsUnit implements PersistentCompUnit{
    
    
    public static PersistentCompUnit createCompUnit(PersistentAbsUnitType type,String name) throws PersistenceException{
        return createCompUnit(type,name,false);
    }
    
    public static PersistentCompUnit createCompUnit(PersistentAbsUnitType type,String name,boolean delayed$Persistence) throws PersistenceException {
        PersistentCompUnit result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theCompUnitFacade
                .newDelayedCompUnit(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theCompUnitFacade
                .newCompUnit(name,-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("type", type);
        final$$Fields.put("name", name);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentCompUnit createCompUnit(PersistentAbsUnitType type,String name,boolean delayed$Persistence,PersistentCompUnit This) throws PersistenceException {
        PersistentCompUnit result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theCompUnitFacade
                .newDelayedCompUnit(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theCompUnitFacade
                .newCompUnit(name,-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("type", type);
        final$$Fields.put("name", name);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("refs", this.getRefs().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
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
        return 145;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 145) ConnectionHandler.getTheConnectionHandler().theCompUnitFacade
            .newCompUnit(name,this.getId());
        super.store();
        this.getRefs().store();
        
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
        if (this.getRefs().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
		// implement method: initializeOnInstantiation

	}
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
		// implement method: copyingPrivateUserAttributes

	}
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentCompUnit)This);
		if(this.equals(This)){
			this.setType((PersistentAbsUnitType)final$$Fields.get("type"));
			this.setName((String)final$$Fields.get("name"));
		}
    }
    public void initializeOnCreation() 
				throws PersistenceException{

	}
    public void checkExponents() 
				throws model.ExponentMatchingException, PersistenceException{
		// TODO: implement method: checkExponents

	}

    /* Start of protected part that is not overridden by persistence generator */
    
    
    

	
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
