
package model;

import persistence.*;


/* Additional import section end */

public class JuristicPerson extends model.Actor implements PersistentJuristicPerson{
    
    
    public static PersistentJuristicPerson createJuristicPerson(String name) throws PersistenceException {
        PersistentJuristicPerson result = ConnectionHandler.getTheConnectionHandler().theJuristicPersonFacade
            .newJuristicPerson(name);
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("name", name);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentJuristicPerson createJuristicPerson(String name,PersistentJuristicPerson This) throws PersistenceException {
        PersistentJuristicPerson result = ConnectionHandler.getTheConnectionHandler().theJuristicPersonFacade
            .newJuristicPerson(name);
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
    
    public JuristicPerson provideCopy() throws PersistenceException{
        JuristicPerson result = this;
        result = new JuristicPerson(this.name, 
                                    this.This, 
                                    this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public JuristicPerson(String name,PersistentActor This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((String)name,(PersistentActor)This,id);        
    }
    
    static public long getTypeId() {
        return 125;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public PersistentJuristicPerson getThis() throws PersistenceException {
        if(this.This == null){
            PersistentJuristicPerson result = new JuristicPersonProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentJuristicPerson)this.This;
    }
    
    public void accept(model.visitor.ActorVisitor visitor) throws PersistenceException {
        visitor.handleJuristicPerson(this);
    }
    public <R> R accept(model.visitor.ActorReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleJuristicPerson(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.ActorExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleJuristicPerson(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.ActorReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleJuristicPerson(this);
    }
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleJuristicPerson(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleJuristicPerson(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleJuristicPerson(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleJuristicPerson(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + this.getMyRoles().getLength());
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
        this.setThis((PersistentJuristicPerson)This);
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
