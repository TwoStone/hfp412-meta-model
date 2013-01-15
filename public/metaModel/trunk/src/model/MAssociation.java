
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class MAssociation extends PersistentObject implements PersistentMAssociation{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentMAssociation getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theMAssociationFacade.getClass(objectId);
        return (PersistentMAssociation)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentMAssociation createMAssociation(String name,MType source,MType target) throws PersistenceException{
        return createMAssociation(name,source,target,false);
    }
    
    public static PersistentMAssociation createMAssociation(String name,MType source,MType target,boolean delayed$Persistence) throws PersistenceException {
        if (name == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentMAssociation result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMAssociationFacade
                .newDelayedMAssociation(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMAssociationFacade
                .newMAssociation(name,-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("name", name);
        final$$Fields.put("source", source);
        final$$Fields.put("target", target);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentMAssociation createMAssociation(String name,MType source,MType target,boolean delayed$Persistence,PersistentMAssociation This) throws PersistenceException {
        if (name == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentMAssociation result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMAssociationFacade
                .newDelayedMAssociation(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMAssociationFacade
                .newMAssociation(name,-1);
        }
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
            result.put("name", this.getName());
            AbstractPersistentRoot source = (AbstractPersistentRoot)this.getSource();
            if (source != null) {
                result.put("source", source.createProxiInformation(false));
                if(depth > 1) {
                    source.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && source.hasEssentialFields())source.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot target = (AbstractPersistentRoot)this.getTarget();
            if (target != null) {
                result.put("target", target.createProxiInformation(false));
                if(depth > 1) {
                    target.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && target.hasEssentialFields())target.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            result.put("hierarchies", this.getHierarchies().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public MAssociation provideCopy() throws PersistenceException{
        MAssociation result = this;
        result = new MAssociation(this.name, 
                                  this.source, 
                                  this.target, 
                                  this.This, 
                                  this.getId());
        result.hierarchies = this.hierarchies.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected String name;
    protected MType source;
    protected MType target;
    protected MAssociation_HierarchiesProxi hierarchies;
    protected PersistentMAssociation This;
    
    public MAssociation(String name,MType source,MType target,PersistentMAssociation This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.name = name;
        this.source = source;
        this.target = target;
        this.hierarchies = new MAssociation_HierarchiesProxi(this);
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 143;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 143) ConnectionHandler.getTheConnectionHandler().theMAssociationFacade
            .newMAssociation(name,this.getId());
        super.store();
        if(this.getSource() != null){
            this.getSource().store();
            ConnectionHandler.getTheConnectionHandler().theMAssociationFacade.sourceSet(this.getId(), getSource());
        }
        if(this.getTarget() != null){
            this.getTarget().store();
            ConnectionHandler.getTheConnectionHandler().theMAssociationFacade.targetSet(this.getId(), getTarget());
        }
        this.getHierarchies().store();
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theMAssociationFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public String getName() throws PersistenceException {
        return this.name;
    }
    public void setName(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theMAssociationFacade.nameSet(this.getId(), newValue);
        this.name = newValue;
    }
    public MType getSource() throws PersistenceException {
        return this.source;
    }
    public void setSource(MType newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.source)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.source = (MType)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theMAssociationFacade.sourceSet(this.getId(), newValue);
        }
    }
    public MType getTarget() throws PersistenceException {
        return this.target;
    }
    public void setTarget(MType newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.target)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.target = (MType)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theMAssociationFacade.targetSet(this.getId(), newValue);
        }
    }
    public MAssociation_HierarchiesProxi getHierarchies() throws PersistenceException {
        return this.hierarchies;
    }
    protected void setThis(PersistentMAssociation newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentMAssociation)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theMAssociationFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentMAssociation getThis() throws PersistenceException {
        if(this.This == null){
            PersistentMAssociation result = new MAssociationProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentMAssociation)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMAssociation(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMAssociation(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMAssociation(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMAssociation(this);
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
        this.setThis((PersistentMAssociation)This);
		if(this.equals(This)){
			this.setName((String)final$$Fields.get("name"));
			this.setSource((MType)final$$Fields.get("source"));
			this.setTarget((MType)final$$Fields.get("target"));
		}
    }
    public PersistentMBoolean isObservation() 
				throws PersistenceException{
        //TODO: implement method: isObservation
        try{
            throw new java.lang.UnsupportedOperationException("Method \"isObservation\" not implemented yet.");
        } catch (java.lang.UnsupportedOperationException uoe){
            uoe.printStackTrace();
            throw uoe;
        }
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
