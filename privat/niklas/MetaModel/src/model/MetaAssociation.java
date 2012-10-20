
package model;

import persistence.*;


/* Additional import section end */

public class MetaAssociation extends model.NamedEntity implements PersistentMetaAssociation{
    
    
    public static PersistentMetaAssociation createMetaAssociation(String name,PersistentAbstractMetaType fromType,PersistentAbstractMetaType toType) throws PersistenceException {
        PersistentMetaAssociation result = ConnectionHandler.getTheConnectionHandler().theMetaAssociationFacade
            .newMetaAssociation(name);
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("name", name);
        final$$Fields.put("fromType", fromType);
        final$$Fields.put("toType", toType);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentMetaAssociation createMetaAssociation(String name,PersistentAbstractMetaType fromType,PersistentAbstractMetaType toType,PersistentMetaAssociation This) throws PersistenceException {
        PersistentMetaAssociation result = ConnectionHandler.getTheConnectionHandler().theMetaAssociationFacade
            .newMetaAssociation(name);
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("name", name);
        final$$Fields.put("fromType", fromType);
        final$$Fields.put("toType", toType);
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
                result.put("fromType", fromType.createProxiInformation());
                if(depth > 1) {
                    fromType.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && fromType.hasEssentialFields())fromType.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot toType = (AbstractPersistentRoot)this.getToType();
            if (toType != null) {
                result.put("toType", toType.createProxiInformation());
                if(depth > 1) {
                    toType.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && toType.hasEssentialFields())toType.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            result.put("hierarchies", this.getHierarchies().getVector(allResults, depth, essentialLevel, forGUI, tdObserver));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public MetaAssociation provideCopy() throws PersistenceException{
        MetaAssociation result = this;
        result = new MetaAssociation(this.name, 
                                     this.This, 
                                     this.fromType, 
                                     this.toType, 
                                     this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentAbstractMetaType fromType;
    protected PersistentAbstractMetaType toType;
    protected MetaAssociation_HierarchiesProxi hierarchies;
    
    public MetaAssociation(String name,PersistentNamedEntity This,PersistentAbstractMetaType fromType,PersistentAbstractMetaType toType,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((String)name,(PersistentNamedEntity)This,id);
        this.fromType = fromType;
        this.toType = toType;
        this.hierarchies = new MetaAssociation_HierarchiesProxi(this);        
    }
    
    static public long getTypeId() {
        return 126;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public PersistentAbstractMetaType getFromType() throws PersistenceException {
        return this.fromType;
    }
    public void setFromType(PersistentAbstractMetaType newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.fromType)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.fromType = (PersistentAbstractMetaType)PersistentProxi.createProxi(objectId, classId);
        ConnectionHandler.getTheConnectionHandler().theMetaAssociationFacade.fromTypeSet(this.getId(), newValue);
    }
    public PersistentAbstractMetaType getToType() throws PersistenceException {
        return this.toType;
    }
    public void setToType(PersistentAbstractMetaType newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.toType)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.toType = (PersistentAbstractMetaType)PersistentProxi.createProxi(objectId, classId);
        ConnectionHandler.getTheConnectionHandler().theMetaAssociationFacade.toTypeSet(this.getId(), newValue);
    }
    public MetaAssociation_HierarchiesProxi getHierarchies() throws PersistenceException {
        return this.hierarchies;
    }
    public PersistentMetaAssociation getThis() throws PersistenceException {
        if(this.This == null){
            PersistentMetaAssociation result = new MetaAssociationProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentMetaAssociation)this.This;
    }
    
    public void accept(model.visitor.NamedEntityVisitor visitor) throws PersistenceException {
        visitor.handleMetaAssociation(this);
    }
    public <R> R accept(model.visitor.NamedEntityReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMetaAssociation(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.NamedEntityExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMetaAssociation(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.NamedEntityReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMetaAssociation(this);
    }
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMetaAssociation(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMetaAssociation(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMetaAssociation(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMetaAssociation(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + (this.getFromType() == null ? 0 : 1)
            + (this.getToType() == null ? 0 : 1)
            + this.getHierarchies().getLength());
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
        this.setThis((PersistentMetaAssociation)This);
		if(this.equals(This)){
			this.setName((String)final$$Fields.get("name"));
			this.setFromType((PersistentAbstractMetaType)final$$Fields.get("fromType"));
			this.setToType((PersistentAbstractMetaType)final$$Fields.get("toType"));
		}
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
