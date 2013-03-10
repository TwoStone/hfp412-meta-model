package model.abstractOperation;

import model.UserException;
import model.visitor.AbsOperationExceptionVisitor;
import model.visitor.AbsOperationReturnExceptionVisitor;
import model.visitor.AbsOperationReturnVisitor;
import model.visitor.AbsOperationVisitor;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.Anything;
import persistence.AssociationProxi;
import persistence.Association_HierarchiesProxi;
import persistence.ConnectionHandler;
import persistence.LinkSearchList;
import persistence.PersistenceException;
import persistence.PersistentAbsOperation;
import persistence.PersistentAssociation;
import persistence.PersistentMType;
import persistence.TDObserver;

/* Additional import section end */

public class Association extends model.abstractOperation.AbsOperation implements PersistentAssociation{
    
    
    public static PersistentAssociation createAssociation(String name,PersistentMType source,PersistentMType target) throws PersistenceException{
        return createAssociation(name,source,target,false);
    }
    
    public static PersistentAssociation createAssociation(String name,PersistentMType source,PersistentMType target,boolean delayed$Persistence) throws PersistenceException {
        PersistentAssociation result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAssociationFacade
                .newDelayedAssociation(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAssociationFacade
                .newAssociation(name,-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("name", name);
        final$$Fields.put("source", source);
        final$$Fields.put("target", target);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentAssociation createAssociation(String name,PersistentMType source,PersistentMType target,boolean delayed$Persistence,PersistentAssociation This) throws PersistenceException {
        PersistentAssociation result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAssociationFacade
                .newDelayedAssociation(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAssociationFacade
                .newAssociation(name,-1);
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
            result.put("hierarchies", this.getHierarchies().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public Association provideCopy() throws PersistenceException{
        Association result = this;
        result = new Association(this.name, 
                                 this.source, 
                                 this.target, 
                                 this.This, 
                                 this.getId());
        result.parameters = this.parameters.copy(result);
        result.hierarchies = this.hierarchies.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected Association_HierarchiesProxi hierarchies;
    
    public Association(String name,PersistentMType source,PersistentMType target,PersistentAbsOperation This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((String)name,(PersistentMType)source,(PersistentMType)target,(PersistentAbsOperation)This,id);
        this.hierarchies = new Association_HierarchiesProxi(this);        
    }
    
    static public long getTypeId() {
        return 117;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 117) ConnectionHandler.getTheConnectionHandler().theAssociationFacade
            .newAssociation(name,this.getId());
        super.store();
        this.getHierarchies().store();
        
    }
    
    public Association_HierarchiesProxi getHierarchies() throws PersistenceException {
        return this.hierarchies;
    }
    public PersistentAssociation getThis() throws PersistenceException {
        if(this.This == null){
            PersistentAssociation result = new AssociationProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentAssociation)this.This;
    }
    
    public void accept(AbsOperationVisitor visitor) throws PersistenceException {
        visitor.handleAssociation(this);
    }
    public <R> R accept(AbsOperationReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAssociation(this);
    }
    public <E extends UserException>  void accept(AbsOperationExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAssociation(this);
    }
    public <R, E extends UserException> R accept(AbsOperationReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAssociation(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAssociation(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAssociation(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAssociation(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAssociation(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getSource() != null) return 1;
        if (this.getTarget() != null) return 1;
        if (this.getParameters().getLength() > 0) return 1;
        if (this.getHierarchies().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
	}
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
	}
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentAssociation)This);
		if(this.equals(This)){
			this.setName((String)final$$Fields.get("name"));
			this.setSource((PersistentMType)final$$Fields.get("source"));
			this.setTarget((PersistentMType)final$$Fields.get("target"));
		}
    }
    public LinkSearchList inverseGetType() 
				throws PersistenceException{
        LinkSearchList result = null;
		if (result == null) result = ConnectionHandler.getTheConnectionHandler().theLinkFacade
							.inverseGetType(this.getId(), this.getClassId());
		return result;
    }
    public void initializeOnCreation() 
				throws PersistenceException{
	}

    /* Start of protected part that is not overridden by persistence generator */
    
    
    

	
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
