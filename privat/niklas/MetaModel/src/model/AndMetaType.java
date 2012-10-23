
package model;

import persistence.AndMetaTypeProxi;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.PersistenceException;
import persistence.PersistentAbstractMetaType;
import persistence.PersistentAndMetaType;
import persistence.TDObserver;


/* Additional import section end */

public class AndMetaType extends model.ComposedMetaType implements PersistentAndMetaType{
    
    
    public static PersistentAndMetaType createAndMetaType() throws PersistenceException {
        PersistentAndMetaType result = ConnectionHandler.getTheConnectionHandler().theAndMetaTypeFacade
            .newAndMetaType();
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentAndMetaType createAndMetaType(PersistentAndMetaType This) throws PersistenceException {
        PersistentAndMetaType result = ConnectionHandler.getTheConnectionHandler().theAndMetaTypeFacade
            .newAndMetaType();
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
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
    
    public AndMetaType provideCopy() throws PersistenceException{
        AndMetaType result = this;
        result = new AndMetaType(this.This, 
                                 this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public AndMetaType(PersistentAbstractMetaType This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentAbstractMetaType)This,id);        
    }
    
    static public long getTypeId() {
        return 118;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public PersistentAndMetaType getThis() throws PersistenceException {
        if(this.This == null){
            PersistentAndMetaType result = new AndMetaTypeProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentAndMetaType)this.This;
    }
    
    public void accept(model.visitor.ComposedMetaTypeVisitor visitor) throws PersistenceException {
        visitor.handleAndMetaType(this);
    }
    public <R> R accept(model.visitor.ComposedMetaTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAndMetaType(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.ComposedMetaTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAndMetaType(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.ComposedMetaTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAndMetaType(this);
    }
    public void accept(model.visitor.AbstractMetaTypeVisitor visitor) throws PersistenceException {
        visitor.handleAndMetaType(this);
    }
    public <R> R accept(model.visitor.AbstractMetaTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAndMetaType(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AbstractMetaTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAndMetaType(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AbstractMetaTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAndMetaType(this);
    }
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAndMetaType(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAndMetaType(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAndMetaType(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAndMetaType(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + this.getComponents().getLength()
            + (this.getDisjunctiveNormalform() == null ? 0 : 1));
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
        this.setThis((PersistentAndMetaType)This);
		if(this.equals(This)){
		}
    }
    public void initializeOnCreation() 
				throws PersistenceException{
		//TODO: implement method: initializeOnCreation

	}

    /* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */
    
}
