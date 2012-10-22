
package model;

import persistence.*;


/* Additional import section end */

public abstract class Rolle extends PersistentObject implements PersistentRolle{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentRolle getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theRolleFacade.getClass(objectId);
        return (PersistentRolle)PersistentProxi.createProxi(objectId, classId);
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot rolleFuer = (AbstractPersistentRoot)this.getRolleFuer();
            if (rolleFuer != null) {
                result.put("rolleFuer", rolleFuer.createProxiInformation());
                if(depth > 1) {
                    rolleFuer.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && rolleFuer.hasEssentialFields())rolleFuer.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public abstract Rolle provideCopy() throws PersistenceException;
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentAkteur rolleFuer;
    protected PersistentRolle This;
    
    public Rolle(PersistentAkteur rolleFuer,PersistentRolle This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.rolleFuer = rolleFuer;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 112;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public PersistentAkteur getRolleFuer() throws PersistenceException {
        return this.rolleFuer;
    }
    public void setRolleFuer(PersistentAkteur newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.rolleFuer)) return;
        if(getThis().getRolleFuer() != null)throw new PersistenceException("Final field rolleFuer in type Rolle has been set already!",0);
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.rolleFuer = (PersistentAkteur)PersistentProxi.createProxi(objectId, classId);
        ConnectionHandler.getTheConnectionHandler().theRolleFacade.rolleFuerSet(this.getId(), newValue);
    }
    protected void setThis(PersistentRolle newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentRolle)PersistentProxi.createProxi(objectId, classId);
        ConnectionHandler.getTheConnectionHandler().theRolleFacade.ThisSet(this.getId(), newValue);
    }
    public abstract PersistentRolle getThis() throws PersistenceException ;
    
    
    
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
        this.setThis((PersistentRolle)This);
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
