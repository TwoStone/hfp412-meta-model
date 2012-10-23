
package model;

import persistence.*;


/* Additional import section end */

public class Kunde extends model.Rolle implements PersistentKunde{
    
    
    public static PersistentKunde createKunde(PersistentAkteur rolleFuer) throws PersistenceException {
        PersistentKunde result = ConnectionHandler.getTheConnectionHandler().theKundeFacade
            .newKunde();
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("rolleFuer", rolleFuer);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentKunde createKunde(PersistentAkteur rolleFuer,PersistentKunde This) throws PersistenceException {
        PersistentKunde result = ConnectionHandler.getTheConnectionHandler().theKundeFacade
            .newKunde();
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("rolleFuer", rolleFuer);
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
    
    public Kunde provideCopy() throws PersistenceException{
        Kunde result = this;
        result = new Kunde(this.rolleFuer, 
                           this.This, 
                           this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public Kunde(PersistentAkteur rolleFuer,PersistentRolle This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentAkteur)rolleFuer,(PersistentRolle)This,id);        
    }
    
    static public long getTypeId() {
        return 122;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public PersistentKunde getThis() throws PersistenceException {
        if(this.This == null){
            PersistentKunde result = new KundeProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentKunde)this.This;
    }
    
    public void accept(model.visitor.RolleVisitor visitor) throws PersistenceException {
        visitor.handleKunde(this);
    }
    public <R> R accept(model.visitor.RolleReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleKunde(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.RolleExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleKunde(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.RolleReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleKunde(this);
    }
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleKunde(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleKunde(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleKunde(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleKunde(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
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
        this.setThis((PersistentKunde)This);
		if(this.equals(This)){
			this.setRolleFuer((PersistentAkteur)final$$Fields.get("rolleFuer"));
		}
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}