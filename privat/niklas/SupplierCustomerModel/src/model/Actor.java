
package model;

import model.meta.RoleSwitchPARAMETER;
import model.meta.StringFACTORY;
import persistence.*;


/* Additional import section end */

public class Actor extends PersistentObject implements PersistentActor{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentActor getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theActorFacade.getClass(objectId);
        return (PersistentActor)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentActor createActor(String name) throws PersistenceException {
        if (name == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentActor result = ConnectionHandler.getTheConnectionHandler().theActorFacade
            .newActor(name);
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("name", name);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentActor createActor(String name,PersistentActor This) throws PersistenceException {
        if (name == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentActor result = ConnectionHandler.getTheConnectionHandler().theActorFacade
            .newActor(name);
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
            result.put("name", this.getName());
            result.put("roles", this.getRoles().getVector(allResults, depth, essentialLevel, forGUI, tdObserver));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public static ActorSearchList getActorByName(String index) throws PersistenceException{
        return ConnectionHandler.getTheConnectionHandler().theActorFacade
            .getActorByName(index);
    }
    
    public Actor provideCopy() throws PersistenceException{
        Actor result = this;
        result = new Actor(this.name, 
                           this.This, 
                           this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected String name;
    protected Actor_RolesProxi roles;
    protected PersistentActor This;
    
    public Actor(String name,PersistentActor This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.name = name;
        this.roles = new Actor_RolesProxi(this);
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 112;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public String getName() throws PersistenceException {
        return this.name;
    }
    public void setName(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        ConnectionHandler.getTheConnectionHandler().theActorFacade.nameSet(this.getId(), newValue);
        this.name = newValue;
    }
    public Actor_RolesProxi getRoles() throws PersistenceException {
        return this.roles;
    }
    protected void setThis(PersistentActor newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentActor)PersistentProxi.createProxi(objectId, classId);
        ConnectionHandler.getTheConnectionHandler().theActorFacade.ThisSet(this.getId(), newValue);
    }
    public PersistentActor getThis() throws PersistenceException {
        if(this.This == null){
            PersistentActor result = new ActorProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentActor)this.This;
    }
    
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleActor(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleActor(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleActor(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleActor(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + this.getRoles().getLength());
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{        
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentActor)This);
		if(this.equals(This)){
			this.setName((String)final$$Fields.get("name"));
		}
    }
    public void addRole(final String roleName) 
				throws PersistenceException{
        PersistentRole role = StringFACTORY.createObjectBySubTypeNameForRole(roleName, new RoleSwitchPARAMETER() {
			
			@Override
			public PersistentSupplier handleSupplier() throws PersistenceException {
				return Supplier.createSupplier();
			}
			
			@Override
			public PersistentCustomer handleCustomer() throws PersistenceException {
				return Customer.createCustomer();
			}
		});
        this.getRoles().add(role);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
    }
    public void changeName(final String newName) 
				throws PersistenceException{
        //TODO: implement method: changeName
        
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
