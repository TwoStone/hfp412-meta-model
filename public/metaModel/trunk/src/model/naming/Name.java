
package model.naming;

import model.UserException;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.AbstractPersistentRoot;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.NameProxi;
import persistence.PersistenceException;
import persistence.PersistentMAtomicType;
import persistence.PersistentName;
import persistence.PersistentNameScheme;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.TDObserver;


/* Additional import section end */

public class Name extends PersistentObject implements PersistentName{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentName getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theNameFacade.getClass(objectId);
        return (PersistentName)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentName createName(PersistentMAtomicType fromType,PersistentNameScheme nameScheme) throws PersistenceException{
        return createName(fromType,nameScheme,false);
    }
    
    public static PersistentName createName(PersistentMAtomicType fromType,PersistentNameScheme nameScheme,boolean delayed$Persistence) throws PersistenceException {
        PersistentName result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theNameFacade
                .newDelayedName();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theNameFacade
                .newName(-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("fromType", fromType);
        final$$Fields.put("nameScheme", nameScheme);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentName createName(PersistentMAtomicType fromType,PersistentNameScheme nameScheme,boolean delayed$Persistence,PersistentName This) throws PersistenceException {
        PersistentName result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theNameFacade
                .newDelayedName();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theNameFacade
                .newName(-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("fromType", fromType);
        final$$Fields.put("nameScheme", nameScheme);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot fromType = (AbstractPersistentRoot)this.getFromType();
            if (fromType != null) {
                result.put("fromType", fromType.createProxiInformation(false));
                if(depth > 1) {
                    fromType.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && fromType.hasEssentialFields())fromType.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot nameScheme = (AbstractPersistentRoot)this.getNameScheme();
            if (nameScheme != null) {
                result.put("nameScheme", nameScheme.createProxiInformation(false));
                if(depth > 1) {
                    nameScheme.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && nameScheme.hasEssentialFields())nameScheme.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public Name provideCopy() throws PersistenceException{
        Name result = this;
        result = new Name(this.fromType, 
                          this.nameScheme, 
                          this.This, 
                          this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentMAtomicType fromType;
    protected PersistentNameScheme nameScheme;
    protected PersistentName This;
    
    public Name(PersistentMAtomicType fromType,PersistentNameScheme nameScheme,PersistentName This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.fromType = fromType;
        this.nameScheme = nameScheme;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 252;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 252) ConnectionHandler.getTheConnectionHandler().theNameFacade
            .newName(this.getId());
        super.store();
        if(this.getFromType() != null){
            this.getFromType().store();
            ConnectionHandler.getTheConnectionHandler().theNameFacade.fromTypeSet(this.getId(), getFromType());
        }
        if(this.getNameScheme() != null){
            this.getNameScheme().store();
            ConnectionHandler.getTheConnectionHandler().theNameFacade.nameSchemeSet(this.getId(), getNameScheme());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theNameFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public PersistentMAtomicType getFromType() throws PersistenceException {
        return this.fromType;
    }
    public void setFromType(PersistentMAtomicType newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.fromType)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.fromType = (PersistentMAtomicType)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theNameFacade.fromTypeSet(this.getId(), newValue);
        }
    }
    public PersistentNameScheme getNameScheme() throws PersistenceException {
        return this.nameScheme;
    }
    public void setNameScheme(PersistentNameScheme newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.nameScheme)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.nameScheme = (PersistentNameScheme)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theNameFacade.nameSchemeSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentName newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentName)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theNameFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentName getThis() throws PersistenceException {
        if(this.This == null){
            PersistentName result = new NameProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentName)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleName(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleName(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleName(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleName(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + (this.getFromType() == null ? 0 : 1)
            + (this.getNameScheme() == null ? 0 : 1));
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
        this.setThis((PersistentName)This);
		if(this.equals(This)){
			this.setFromType((PersistentMAtomicType)final$$Fields.get("fromType"));
			this.setNameScheme((PersistentNameScheme)final$$Fields.get("nameScheme"));
		}
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
