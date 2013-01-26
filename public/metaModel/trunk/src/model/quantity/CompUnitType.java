
package model.quantity;

import model.basic.*;
import model.UserException;
import model.visitor.AbsUnitTypeExceptionVisitor;
import model.visitor.AbsUnitTypeReturnExceptionVisitor;
import model.visitor.AbsUnitTypeReturnVisitor;
import model.visitor.AbsUnitTypeVisitor;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.AbstractPersistentRoot;
import persistence.Anything;
import persistence.CompUnitTypeProxi;
import persistence.CompUnitType_RefsProxi;
import persistence.ConnectionHandler;
import persistence.PersistenceException;
import persistence.PersistentAbsUnit;
import persistence.PersistentAbsUnitType;
import persistence.PersistentCompUnitType;
import persistence.PersistentMBoolean;
import persistence.PersistentProxi;
import persistence.TDObserver;


/* Additional import section end */

public class CompUnitType extends model.quantity.AbsUnitType implements PersistentCompUnitType{
    
    
    public static PersistentCompUnitType createCompUnitType(String name) throws PersistenceException{
        return createCompUnitType(name,false);
    }
    
    public static PersistentCompUnitType createCompUnitType(String name,boolean delayed$Persistence) throws PersistenceException {
        PersistentCompUnitType result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theCompUnitTypeFacade
                .newDelayedCompUnitType(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theCompUnitTypeFacade
                .newCompUnitType(name,-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("name", name);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentCompUnitType createCompUnitType(String name,boolean delayed$Persistence,PersistentCompUnitType This) throws PersistenceException {
        PersistentCompUnitType result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theCompUnitTypeFacade
                .newDelayedCompUnitType(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theCompUnitTypeFacade
                .newCompUnitType(name,-1);
        }
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
            result.put("refs", this.getRefs().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false));
            AbstractPersistentRoot isFinal = (AbstractPersistentRoot)this.getIsFinal();
            if (isFinal != null) {
                result.put("isFinal", isFinal.createProxiInformation(false));
                if(depth > 1) {
                    isFinal.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && isFinal.hasEssentialFields())isFinal.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public CompUnitType provideCopy() throws PersistenceException{
        CompUnitType result = this;
        result = new CompUnitType(this.name, 
                                  this.This, 
                                  this.isFinal, 
                                  this.getId());
        result.refs = this.refs.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected CompUnitType_RefsProxi refs;
    protected PersistentMBoolean isFinal;
    
    public CompUnitType(String name,PersistentAbsUnitType This,PersistentMBoolean isFinal,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((String)name,(PersistentAbsUnitType)This,id);
        this.refs = new CompUnitType_RefsProxi(this);
        this.isFinal = isFinal;        
    }
    
    static public long getTypeId() {
        return 114;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 114) ConnectionHandler.getTheConnectionHandler().theCompUnitTypeFacade
            .newCompUnitType(name,this.getId());
        super.store();
        this.getRefs().store();
        if(this.getIsFinal() != null){
            this.getIsFinal().store();
            ConnectionHandler.getTheConnectionHandler().theCompUnitTypeFacade.isFinalSet(this.getId(), getIsFinal());
        }
        
    }
    
    public CompUnitType_RefsProxi getRefs() throws PersistenceException {
        return this.refs;
    }
    public PersistentMBoolean getIsFinal() throws PersistenceException {
        return this.isFinal;
    }
    public void setIsFinal(PersistentMBoolean newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.isFinal)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.isFinal = (PersistentMBoolean)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theCompUnitTypeFacade.isFinalSet(this.getId(), newValue);
        }
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
            + this.getRefs().getLength());
    }
    
    
    public PersistentMBoolean isFinal() 
				throws PersistenceException{
        return getThis().getIsFinal();
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
			this.setName((String)final$$Fields.get("name"));
		}
    }
    public void initializeOnCreation() 
				throws PersistenceException{
    	getThis().setIsFinal(MFalse.getTheMFalse());
    }
    public void finishModeling() 
				throws model.AlreadyFinalizedException, PersistenceException{
        this.setIsFinal(MTrue.getTheMTrue());
        
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
