
package model;

import persistence.*;


/* Additional import section end */

public class MetaType extends model.AbstractMetaType implements PersistentMetaType{
    
    
    public static PersistentMetaType createMetaType(PersistentMetaAspect myAspect,String name) throws PersistenceException {
        PersistentMetaType result = ConnectionHandler.getTheConnectionHandler().theMetaTypeFacade
            .newMetaType();
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("myAspect", myAspect);
        final$$Fields.put("name", name);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentMetaType createMetaType(PersistentMetaAspect myAspect,String name,PersistentMetaType This) throws PersistenceException {
        PersistentMetaType result = ConnectionHandler.getTheConnectionHandler().theMetaTypeFacade
            .newMetaType();
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("myAspect", myAspect);
        final$$Fields.put("name", name);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("subtypes", this.getSubtypes().getVector(allResults, depth, essentialLevel, forGUI, tdObserver));
            AbstractPersistentRoot myAspect = (AbstractPersistentRoot)this.getMyAspect();
            if (myAspect != null) {
                result.put("myAspect", myAspect.createProxiInformation());
                if(depth > 1) {
                    myAspect.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && myAspect.hasEssentialFields())myAspect.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot myCONCNamedEntity = (AbstractPersistentRoot)this.getMyCONCNamedEntity();
            if (myCONCNamedEntity != null) {
                result.put("myCONCNamedEntity", myCONCNamedEntity.createProxiInformation());
                if(depth > 1) {
                    myCONCNamedEntity.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    myCONCNamedEntity.toHashtable(allResults, depth, essentialLevel + 1, forGUI, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public MetaType provideCopy() throws PersistenceException{
        MetaType result = this;
        result = new MetaType(this.This, 
                              this.myAspect, 
                              this.myCONCNamedEntity, 
                              this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return true;
    }
    protected MetaType_SubtypesProxi subtypes;
    protected PersistentMetaAspect myAspect;
    protected PersistentNamedEntity myCONCNamedEntity;
    
    public MetaType(PersistentAbstractMetaType This,PersistentMetaAspect myAspect,PersistentNamedEntity myCONCNamedEntity,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentAbstractMetaType)This,id);
        this.subtypes = new MetaType_SubtypesProxi(this);
        this.myAspect = myAspect;
        this.myCONCNamedEntity = myCONCNamedEntity;        
    }
    
    static public long getTypeId() {
        return 122;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public MetaType_SubtypesProxi getSubtypes() throws PersistenceException {
        return this.subtypes;
    }
    public PersistentMetaAspect getMyAspect() throws PersistenceException {
        return this.myAspect;
    }
    public void setMyAspect(PersistentMetaAspect newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.myAspect)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.myAspect = (PersistentMetaAspect)PersistentProxi.createProxi(objectId, classId);
        ConnectionHandler.getTheConnectionHandler().theMetaTypeFacade.myAspectSet(this.getId(), newValue);
    }
    public PersistentNamedEntity getMyCONCNamedEntity() throws PersistenceException {
        return this.myCONCNamedEntity;
    }
    public void setMyCONCNamedEntity(PersistentNamedEntity newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.myCONCNamedEntity)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.myCONCNamedEntity = (PersistentNamedEntity)PersistentProxi.createProxi(objectId, classId);
        ConnectionHandler.getTheConnectionHandler().theMetaTypeFacade.myCONCNamedEntitySet(this.getId(), newValue);
    }
    public PersistentMetaType getThis() throws PersistenceException {
        if(this.This == null){
            PersistentMetaType result = new MetaTypeProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentMetaType)this.This;
    }
    public String getName() throws PersistenceException {
        return this.getMyCONCNamedEntity().getName();
    }
    public void setName(String newValue) throws PersistenceException {
        this.getMyCONCNamedEntity().setName(newValue);
    }
    public void delete$Me() throws PersistenceException{
        super.delete$Me();
        this.getMyCONCNamedEntity().delete$Me();
    }
    
    public void accept(model.visitor.AbstractMetaTypeVisitor visitor) throws PersistenceException {
        visitor.handleMetaType(this);
    }
    public <R> R accept(model.visitor.AbstractMetaTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMetaType(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AbstractMetaTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMetaType(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AbstractMetaTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMetaType(this);
    }
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMetaType(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMetaType(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMetaType(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMetaType(this);
    }
    public void accept(model.visitor.NamedEntityVisitor visitor) throws PersistenceException {
        visitor.handleMetaType(this);
    }
    public <R> R accept(model.visitor.NamedEntityReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMetaType(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.NamedEntityExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMetaType(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.NamedEntityReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMetaType(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + this.getSubtypes().getLength()
            + (this.getMyAspect() == null ? 0 : 1));
    }
    
    
    public MetaTypeSearchList inverseGetSubtypes() 
				throws PersistenceException{
        MetaTypeSearchList result = null;
		if (result == null) result = ConnectionHandler.getTheConnectionHandler().theMetaTypeFacade
							.inverseGetSubtypes(this.getId(), this.getClassId());
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
        this.setThis((PersistentMetaType)This);
		if(this.equals(This)){
			PersistentCONCNamedEntity myCONCNamedEntity = model.CONCNamedEntity.createCONCNamedEntity("", (PersistentMetaType)This);
			this.setMyCONCNamedEntity(myCONCNamedEntity);
			this.setMyAspect((PersistentMetaAspect)final$$Fields.get("myAspect"));
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
