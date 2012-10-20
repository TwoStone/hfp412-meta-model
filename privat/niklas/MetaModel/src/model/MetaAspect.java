
package model;

import persistence.*;


/* Additional import section end */

public class MetaAspect extends model.NamedEntity implements PersistentMetaAspect{
    
    
    public static PersistentMetaAspect createMetaAspect(String name) throws PersistenceException {
        PersistentMetaAspect result = ConnectionHandler.getTheConnectionHandler().theMetaAspectFacade
            .newMetaAspect(name);
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("name", name);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentMetaAspect createMetaAspect(String name,PersistentMetaAspect This) throws PersistenceException {
        PersistentMetaAspect result = ConnectionHandler.getTheConnectionHandler().theMetaAspectFacade
            .newMetaAspect(name);
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
            result.put("types", this.getTypes(tdObserver).getVector(allResults, (depth > 1 ? depth : depth + 1), essentialLevel, forGUI, tdObserver));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public MetaAspect provideCopy() throws PersistenceException{
        MetaAspect result = this;
        result = new MetaAspect(this.name, 
                                this.This, 
                                this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public MetaAspect(String name,PersistentNamedEntity This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((String)name,(PersistentNamedEntity)This,id);        
    }
    
    static public long getTypeId() {
        return 119;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public PersistentMetaAspect getThis() throws PersistenceException {
        if(this.This == null){
            PersistentMetaAspect result = new MetaAspectProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentMetaAspect)this.This;
    }
    
    public void accept(model.visitor.NamedEntityVisitor visitor) throws PersistenceException {
        visitor.handleMetaAspect(this);
    }
    public <R> R accept(model.visitor.NamedEntityReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMetaAspect(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.NamedEntityExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMetaAspect(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.NamedEntityReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMetaAspect(this);
    }
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMetaAspect(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMetaAspect(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMetaAspect(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMetaAspect(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + this.getTypes().getLength());
    }
    
    
    public MetaTypeSearchList getTypes(final TDObserver observer) 
				throws PersistenceException{
        MetaTypeSearchList result = getThis().getTypes();
		observer.updateTransientDerived(getThis(), "types", result);
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
    public MetaTypeSearchList getTypes() 
				throws PersistenceException{
        //TODO: implement method: getTypes
        throw new java.lang.UnsupportedOperationException("Method \"getTypes\" not implemented yet.");
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentMetaAspect)This);
		if(this.equals(This)){
			this.setName((String)final$$Fields.get("name"));
		}
    }
    public MetaTypeSearchList inverseGetMyAspect() 
				throws PersistenceException{
        MetaTypeSearchList result = null;
		if (result == null) result = ConnectionHandler.getTheConnectionHandler().theMetaTypeFacade
							.inverseGetMyAspect(this.getId(), this.getClassId());
		return result;
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
