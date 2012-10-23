
package model;

import persistence.*;


/* Additional import section end */

public class MetaHierarchy extends model.NamedEntity implements PersistentMetaHierarchy{
    
    
    public static PersistentMetaHierarchy createMetaHierarchy(String name) throws PersistenceException {
        PersistentMetaHierarchy result = ConnectionHandler.getTheConnectionHandler().theMetaHierarchyFacade
            .newMetaHierarchy(name);
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("name", name);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentMetaHierarchy createMetaHierarchy(String name,PersistentMetaHierarchy This) throws PersistenceException {
        PersistentMetaHierarchy result = ConnectionHandler.getTheConnectionHandler().theMetaHierarchyFacade
            .newMetaHierarchy(name);
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
    
    public MetaHierarchy provideCopy() throws PersistenceException{
        MetaHierarchy result = this;
        result = new MetaHierarchy(this.name, 
                                   this.This, 
                                   this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public MetaHierarchy(String name,PersistentNamedEntity This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((String)name,(PersistentNamedEntity)This,id);        
    }
    
    static public long getTypeId() {
        return 121;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public PersistentMetaHierarchy getThis() throws PersistenceException {
        if(this.This == null){
            PersistentMetaHierarchy result = new MetaHierarchyProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentMetaHierarchy)this.This;
    }
    
    public void accept(model.visitor.NamedEntityVisitor visitor) throws PersistenceException {
        visitor.handleMetaHierarchy(this);
    }
    public <R> R accept(model.visitor.NamedEntityReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMetaHierarchy(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.NamedEntityExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMetaHierarchy(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.NamedEntityReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMetaHierarchy(this);
    }
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMetaHierarchy(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMetaHierarchy(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMetaHierarchy(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMetaHierarchy(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public MetaAssociationSearchList inverseGetHierarchies() 
				throws PersistenceException{
        MetaAssociationSearchList result = null;
		if (result == null) result = ConnectionHandler.getTheConnectionHandler().theMetaAssociationFacade
							.inverseGetHierarchies(this.getId(), this.getClassId());
		return result;
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
        this.setThis((PersistentMetaHierarchy)This);
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
