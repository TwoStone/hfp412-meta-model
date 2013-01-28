
package model.abstractOperation;

import persistence.*;
import model.UserException;
import model.visitor.*;


/* Additional import section end */

public class Hierarchy extends PersistentObject implements PersistentHierarchy{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentHierarchy getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theHierarchyFacade.getClass(objectId);
        return (PersistentHierarchy)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentHierarchy createHierarchy(String name) throws PersistenceException{
        return createHierarchy(name,false);
    }
    
    public static PersistentHierarchy createHierarchy(String name,boolean delayed$Persistence) throws PersistenceException {
        if (name == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentHierarchy result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theHierarchyFacade
                .newDelayedHierarchy(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theHierarchyFacade
                .newHierarchy(name,-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("name", name);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentHierarchy createHierarchy(String name,boolean delayed$Persistence,PersistentHierarchy This) throws PersistenceException {
        if (name == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentHierarchy result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theHierarchyFacade
                .newDelayedHierarchy(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theHierarchyFacade
                .newHierarchy(name,-1);
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
            result.put("name", this.getName());
            result.put("associations", this.getAssociations().getVector(allResults, (depth > 1 ? depth : depth + 1), essentialLevel, forGUI, tdObserver, false));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public static HierarchySearchList getHierarchyByName(String name) throws PersistenceException{
        return ConnectionHandler.getTheConnectionHandler().theHierarchyFacade
            .getHierarchyByName(name);
    }
    
    public Hierarchy provideCopy() throws PersistenceException{
        Hierarchy result = this;
        result = new Hierarchy(this.name, 
                               this.This, 
                               this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected String name;
    protected PersistentHierarchy This;
    
    public Hierarchy(String name,PersistentHierarchy This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.name = name;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 163;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 163) ConnectionHandler.getTheConnectionHandler().theHierarchyFacade
            .newHierarchy(name,this.getId());
        super.store();
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theHierarchyFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public String getName() throws PersistenceException {
        return this.name;
    }
    public void setName(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theHierarchyFacade.nameSet(this.getId(), newValue);
        this.name = newValue;
    }
    protected void setThis(PersistentHierarchy newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentHierarchy)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theHierarchyFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentHierarchy getThis() throws PersistenceException {
        if(this.This == null){
            PersistentHierarchy result = new HierarchyProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentHierarchy)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleHierarchy(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleHierarchy(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleHierarchy(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleHierarchy(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + this.getAssociations().getLength());
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public AssociationSearchList getAssociations() 
				throws PersistenceException{
        AssociationSearchList result = null;
		if (result == null) result = ConnectionHandler.getTheConnectionHandler().theAssociationFacade
							.inverseGetHierarchies(this.getId(), this.getClassId());
		return result;
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentHierarchy)This);
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
