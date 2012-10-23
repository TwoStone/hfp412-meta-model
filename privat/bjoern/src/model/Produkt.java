
package model;

import persistence.*;


/* Additional import section end */

public class Produkt extends PersistentObject implements PersistentProdukt{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentProdukt getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theProduktFacade.getClass(objectId);
        return (PersistentProdukt)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentProdukt createProdukt() throws PersistenceException {
        PersistentProdukt result = ConnectionHandler.getTheConnectionHandler().theProduktFacade
            .newProdukt("");
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentProdukt createProdukt(PersistentProdukt This) throws PersistenceException {
        PersistentProdukt result = ConnectionHandler.getTheConnectionHandler().theProduktFacade
            .newProdukt("");
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("name", this.getName());
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public Produkt provideCopy() throws PersistenceException{
        Produkt result = this;
        result = new Produkt(this.name, 
                             this.This, 
                             this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected String name;
    protected PersistentProdukt This;
    
    public Produkt(String name,PersistentProdukt This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.name = name;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 125;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public String getName() throws PersistenceException {
        return this.name;
    }
    public void setName(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        ConnectionHandler.getTheConnectionHandler().theProduktFacade.nameSet(this.getId(), newValue);
        this.name = newValue;
    }
    protected void setThis(PersistentProdukt newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentProdukt)PersistentProxi.createProxi(objectId, classId);
        ConnectionHandler.getTheConnectionHandler().theProduktFacade.ThisSet(this.getId(), newValue);
    }
    public PersistentProdukt getThis() throws PersistenceException {
        if(this.This == null){
            PersistentProdukt result = new ProduktProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentProdukt)this.This;
    }
    
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleProdukt(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleProdukt(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleProdukt(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleProdukt(this);
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
        this.setThis((PersistentProdukt)This);
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