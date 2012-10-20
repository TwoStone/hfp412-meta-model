
package model;

import persistence.*;


/* Additional import section end */

public class Akteur extends PersistentObject implements PersistentAkteur{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentAkteur getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theAkteurFacade.getClass(objectId);
        return (PersistentAkteur)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentAkteur createAkteur(String name) throws PersistenceException {
        if (name == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentAkteur result = ConnectionHandler.getTheConnectionHandler().theAkteurFacade
            .newAkteur(name);
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("name", name);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentAkteur createAkteur(String name,PersistentAkteur This) throws PersistenceException {
        if (name == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentAkteur result = ConnectionHandler.getTheConnectionHandler().theAkteurFacade
            .newAkteur(name);
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
            result.put("name", this.getName());
            result.put("meineRollen", this.getMeineRollen(tdObserver).getVector(allResults, (depth > 1 ? depth : depth + 1), essentialLevel, forGUI, tdObserver));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public static AkteurSearchList getAkteurByName(String index) throws PersistenceException{
        return ConnectionHandler.getTheConnectionHandler().theAkteurFacade
            .getAkteurByName(index);
    }
    
    public Akteur provideCopy() throws PersistenceException{
        Akteur result = this;
        result = new Akteur(this.name, 
                            this.This, 
                            this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected String name;
    protected PersistentAkteur This;
    
    public Akteur(String name,PersistentAkteur This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.name = name;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 111;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public String getName() throws PersistenceException {
        return this.name;
    }
    public void setName(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        ConnectionHandler.getTheConnectionHandler().theAkteurFacade.nameSet(this.getId(), newValue);
        this.name = newValue;
    }
    protected void setThis(PersistentAkteur newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentAkteur)PersistentProxi.createProxi(objectId, classId);
        ConnectionHandler.getTheConnectionHandler().theAkteurFacade.ThisSet(this.getId(), newValue);
    }
    public PersistentAkteur getThis() throws PersistenceException {
        if(this.This == null){
            PersistentAkteur result = new AkteurProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentAkteur)this.This;
    }
    
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAkteur(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAkteur(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAkteur(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAkteur(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + this.getMeineRollen().getLength());
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentAkteur)This);
		if(this.equals(This)){
			this.setName((String)final$$Fields.get("name"));
		}
    }
    public RolleSearchList getMeineRollen(final TDObserver observer) 
				throws PersistenceException{
        RolleSearchList result = getThis().getMeineRollen();
		observer.updateTransientDerived(getThis(), "meineRollen", result);
		return result;
    }
    public void initializeOnCreation() 
				throws PersistenceException{
    }
    public void addRole(final String rollenName) 
				throws PersistenceException{
    	//TODO 1: new concept
    }
    public RolleSearchList getMeineRollen() 
				throws PersistenceException{
        RolleSearchList result = null;
		if (result == null) result = ConnectionHandler.getTheConnectionHandler().theRolleFacade
							.inverseGetRolleFuer(this.getId(), this.getClassId());
		return result;
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
