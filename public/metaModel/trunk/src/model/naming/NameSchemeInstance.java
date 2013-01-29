
package model.naming;

import persistence.*;
import model.UserException;
import model.visitor.*;


/* Additional import section end */

public class NameSchemeInstance extends PersistentObject implements PersistentNameSchemeInstance{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentNameSchemeInstance getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theNameSchemeInstanceFacade.getClass(objectId);
        return (PersistentNameSchemeInstance)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentNameSchemeInstance createNameSchemeInstance(String name,PersistentNameScheme type) throws PersistenceException{
        return createNameSchemeInstance(name,type,false);
    }
    
    public static PersistentNameSchemeInstance createNameSchemeInstance(String name,PersistentNameScheme type,boolean delayed$Persistence) throws PersistenceException {
        if (name == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentNameSchemeInstance result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theNameSchemeInstanceFacade
                .newDelayedNameSchemeInstance(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theNameSchemeInstanceFacade
                .newNameSchemeInstance(name,-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("name", name);
        final$$Fields.put("type", type);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentNameSchemeInstance createNameSchemeInstance(String name,PersistentNameScheme type,boolean delayed$Persistence,PersistentNameSchemeInstance This) throws PersistenceException {
        if (name == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentNameSchemeInstance result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theNameSchemeInstanceFacade
                .newDelayedNameSchemeInstance(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theNameSchemeInstanceFacade
                .newNameSchemeInstance(name,-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("name", name);
        final$$Fields.put("type", type);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("name", this.getName());
            AbstractPersistentRoot type = (AbstractPersistentRoot)this.getType();
            if (type != null) {
                result.put("type", type.createProxiInformation(false));
                if(depth > 1) {
                    type.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && type.hasEssentialFields())type.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public NameSchemeInstance provideCopy() throws PersistenceException{
        NameSchemeInstance result = this;
        result = new NameSchemeInstance(this.name, 
                                        this.type, 
                                        this.This, 
                                        this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected String name;
    protected PersistentNameScheme type;
    protected PersistentNameSchemeInstance This;
    
    public NameSchemeInstance(String name,PersistentNameScheme type,PersistentNameSchemeInstance This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.name = name;
        this.type = type;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 241;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 241) ConnectionHandler.getTheConnectionHandler().theNameSchemeInstanceFacade
            .newNameSchemeInstance(name,this.getId());
        super.store();
        if(this.getType() != null){
            this.getType().store();
            ConnectionHandler.getTheConnectionHandler().theNameSchemeInstanceFacade.typeSet(this.getId(), getType());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theNameSchemeInstanceFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public String getName() throws PersistenceException {
        return this.name;
    }
    public void setName(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theNameSchemeInstanceFacade.nameSet(this.getId(), newValue);
        this.name = newValue;
    }
    public PersistentNameScheme getType() throws PersistenceException {
        return this.type;
    }
    public void setType(PersistentNameScheme newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.type)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.type = (PersistentNameScheme)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theNameSchemeInstanceFacade.typeSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentNameSchemeInstance newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentNameSchemeInstance)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theNameSchemeInstanceFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentNameSchemeInstance getThis() throws PersistenceException {
        if(this.This == null){
            PersistentNameSchemeInstance result = new NameSchemeInstanceProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentNameSchemeInstance)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleNameSchemeInstance(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNameSchemeInstance(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNameSchemeInstance(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNameSchemeInstance(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + (this.getType() == null ? 0 : 1));
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
        this.setThis((PersistentNameSchemeInstance)This);
		if(this.equals(This)){
			this.setName((String)final$$Fields.get("name"));
			this.setType((PersistentNameScheme)final$$Fields.get("type"));
		}
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
