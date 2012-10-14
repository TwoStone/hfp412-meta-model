
package model;

import persistence.*;


/* Additional import section end */

public class ErrorDisplay extends PersistentObject implements PersistentErrorDisplay{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentErrorDisplay getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theErrorDisplayFacade.getClass(objectId);
        return (PersistentErrorDisplay)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentErrorDisplay createErrorDisplay(String message) throws PersistenceException {
        PersistentErrorDisplay result = ConnectionHandler.getTheConnectionHandler().theErrorDisplayFacade
            .newErrorDisplay();
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("message", message);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentErrorDisplay createErrorDisplay(String message,PersistentErrorDisplay This) throws PersistenceException {
        PersistentErrorDisplay result = ConnectionHandler.getTheConnectionHandler().theErrorDisplayFacade
            .newErrorDisplay();
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("message", message);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("message", this.getMessage());
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public ErrorDisplay provideCopy() throws PersistenceException{
        ErrorDisplay result = this;
        result = new ErrorDisplay(this.getId());
        result.message = this.message;
        result.This = this.This;
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected String message;
    protected PersistentErrorDisplay This;
    
    public ErrorDisplay(long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);        
    }
    
    static public long getTypeId() {
        return -101;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public String getMessage() throws PersistenceException {
        return this.message;
    }
    public void setMessage(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        this.message = newValue;
    }
    protected void setThis(PersistentErrorDisplay newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentErrorDisplay)PersistentProxi.createProxi(objectId, classId);
    }
    public PersistentErrorDisplay getThis() throws PersistenceException {
        if(this.This == null){
            PersistentErrorDisplay result = new ErrorDisplayProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentErrorDisplay)this.This;
    }
    
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleErrorDisplay(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleErrorDisplay(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleErrorDisplay(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleErrorDisplay(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        
    }
    public void copyingPrivateUserAttributes(Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public void initialize(Anything This, java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentErrorDisplay)This);
		if(this.equals(This)){
			this.setMessage((String)final$$Fields.get("message"));
		}
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        
    }

    /* Start of protected part that is not overridden by persistence generator */
    public String toString(){
		 return this.message;
	}
    /* End of protected part that is not overridden by persistence generator */
    
}
