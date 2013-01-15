
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class MFormalParameter extends PersistentObject implements PersistentMFormalParameter{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentMFormalParameter getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theMFormalParameterFacade.getClass(objectId);
        return (PersistentMFormalParameter)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentMFormalParameter createMFormalParameter(MType ofType,String name) throws PersistenceException{
        return createMFormalParameter(ofType,name,false);
    }
    
    public static PersistentMFormalParameter createMFormalParameter(MType ofType,String name,boolean delayed$Persistence) throws PersistenceException {
        if (name == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentMFormalParameter result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMFormalParameterFacade
                .newDelayedMFormalParameter(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMFormalParameterFacade
                .newMFormalParameter(name,-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("ofType", ofType);
        final$$Fields.put("name", name);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentMFormalParameter createMFormalParameter(MType ofType,String name,boolean delayed$Persistence,PersistentMFormalParameter This) throws PersistenceException {
        if (name == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentMFormalParameter result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMFormalParameterFacade
                .newDelayedMFormalParameter(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMFormalParameterFacade
                .newMFormalParameter(name,-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("ofType", ofType);
        final$$Fields.put("name", name);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot ofType = (AbstractPersistentRoot)this.getOfType();
            if (ofType != null) {
                result.put("ofType", ofType.createProxiInformation(false));
                if(depth > 1) {
                    ofType.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && ofType.hasEssentialFields())ofType.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            result.put("name", this.getName());
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public static MFormalParameterSearchList getMFormalParameterByName(String name) throws PersistenceException{
        return ConnectionHandler.getTheConnectionHandler().theMFormalParameterFacade
            .getMFormalParameterByName(name);
    }
    
    public MFormalParameter provideCopy() throws PersistenceException{
        MFormalParameter result = this;
        result = new MFormalParameter(this.ofType, 
                                      this.name, 
                                      this.This, 
                                      this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected MType ofType;
    protected String name;
    protected PersistentMFormalParameter This;
    
    public MFormalParameter(MType ofType,String name,PersistentMFormalParameter This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.ofType = ofType;
        this.name = name;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 195;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 195) ConnectionHandler.getTheConnectionHandler().theMFormalParameterFacade
            .newMFormalParameter(name,this.getId());
        super.store();
        if(this.getOfType() != null){
            this.getOfType().store();
            ConnectionHandler.getTheConnectionHandler().theMFormalParameterFacade.ofTypeSet(this.getId(), getOfType());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theMFormalParameterFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public MType getOfType() throws PersistenceException {
        return this.ofType;
    }
    public void setOfType(MType newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.ofType)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.ofType = (MType)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theMFormalParameterFacade.ofTypeSet(this.getId(), newValue);
        }
    }
    public String getName() throws PersistenceException {
        return this.name;
    }
    public void setName(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theMFormalParameterFacade.nameSet(this.getId(), newValue);
        this.name = newValue;
    }
    protected void setThis(PersistentMFormalParameter newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentMFormalParameter)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theMFormalParameterFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentMFormalParameter getThis() throws PersistenceException {
        if(this.This == null){
            PersistentMFormalParameter result = new MFormalParameterProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentMFormalParameter)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMFormalParameter(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMFormalParameter(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMFormalParameter(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMFormalParameter(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + (this.getOfType() == null ? 0 : 1));
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
        this.setThis((PersistentMFormalParameter)This);
		if(this.equals(This)){
			this.setOfType((MType)final$$Fields.get("ofType"));
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
