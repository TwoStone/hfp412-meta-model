
package model;

import persistence.*;


/* Additional import section end */

public class MetaAssociation extends model.NamedEntity implements PersistentMetaAssociation{
    
    
    public static PersistentMetaAssociation createMetaAssociation(String name,PersistentAbstractMetaType source,PersistentAbstractMetaType target) throws PersistenceException {
        PersistentMetaAssociation result = ConnectionHandler.getTheConnectionHandler().theMetaAssociationFacade
            .newMetaAssociation(name);
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("name", name);
        final$$Fields.put("source", source);
        final$$Fields.put("target", target);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentMetaAssociation createMetaAssociation(String name,PersistentAbstractMetaType source,PersistentAbstractMetaType target,PersistentMetaAssociation This) throws PersistenceException {
        PersistentMetaAssociation result = ConnectionHandler.getTheConnectionHandler().theMetaAssociationFacade
            .newMetaAssociation(name);
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("name", name);
        final$$Fields.put("source", source);
        final$$Fields.put("target", target);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot source = (AbstractPersistentRoot)this.getSource();
            if (source != null) {
                result.put("source", source.createProxiInformation());
                if(depth > 1) {
                    source.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && source.hasEssentialFields())source.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot target = (AbstractPersistentRoot)this.getTarget();
            if (target != null) {
                result.put("target", target.createProxiInformation());
                if(depth > 1) {
                    target.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && target.hasEssentialFields())target.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
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
                                     this.source, 
                                     this.target, 
                                     this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentAbstractMetaType source;
    protected PersistentAbstractMetaType target;
    protected MetaAssociation_HierarchiesProxi hierarchies;
    
    public MetaAssociation(String name,PersistentNamedEntity This,PersistentAbstractMetaType source,PersistentAbstractMetaType target,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((String)name,(PersistentNamedEntity)This,id);
        this.source = source;
        this.target = target;
        this.hierarchies = new MetaAssociation_HierarchiesProxi(this);        
    }
    
    static public long getTypeId() {
        return 126;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public PersistentAbstractMetaType getSource() throws PersistenceException {
        return this.source;
    }
    public void setSource(PersistentAbstractMetaType newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.source)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.source = (PersistentAbstractMetaType)PersistentProxi.createProxi(objectId, classId);
        ConnectionHandler.getTheConnectionHandler().theMetaAssociationFacade.sourceSet(this.getId(), newValue);
    }
    public PersistentAbstractMetaType getTarget() throws PersistenceException {
        return this.target;
    }
    public void setTarget(PersistentAbstractMetaType newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.target)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.target = (PersistentAbstractMetaType)PersistentProxi.createProxi(objectId, classId);
        ConnectionHandler.getTheConnectionHandler().theMetaAssociationFacade.targetSet(this.getId(), newValue);
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
            + (this.getSource() == null ? 0 : 1)
            + (this.getTarget() == null ? 0 : 1)
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
			this.setSource((PersistentAbstractMetaType)final$$Fields.get("source"));
			this.setTarget((PersistentAbstractMetaType)final$$Fields.get("target"));
		}
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
