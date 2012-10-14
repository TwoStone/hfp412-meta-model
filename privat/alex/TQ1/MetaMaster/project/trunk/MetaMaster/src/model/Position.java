
package model;

import persistence.*;


/* Additional import section end */

public class Position extends PersistentObject implements PersistentPosition{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentPosition getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().thePositionFacade.getClass(objectId);
        return (PersistentPosition)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentPosition createPosition(long amount,PersistentProduct relateTo) throws PersistenceException {
        PersistentPosition result = ConnectionHandler.getTheConnectionHandler().thePositionFacade
            .newPosition(amount);
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("amount", amount);
        final$$Fields.put("relateTo", relateTo);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        if(result.getThis().getRelateTo() == null)throw new PersistenceException("Field relateTo in type Position has not been initialized!",0);
        return result;
    }
    
    public static PersistentPosition createPosition(long amount,PersistentProduct relateTo,PersistentPosition This) throws PersistenceException {
        PersistentPosition result = ConnectionHandler.getTheConnectionHandler().thePositionFacade
            .newPosition(amount);
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("amount", amount);
        final$$Fields.put("relateTo", relateTo);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("amount", new Long(this.getAmount()).toString());
            AbstractPersistentRoot relateTo = (AbstractPersistentRoot)this.getRelateTo();
            if (relateTo != null) {
                result.put("relateTo", relateTo.createProxiInformation());
                if(depth > 1) {
                    relateTo.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && relateTo.hasEssentialFields())relateTo.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public Position provideCopy() throws PersistenceException{
        Position result = this;
        result = new Position(this.amount, 
                              this.relateTo, 
                              this.This, 
                              this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected long amount;
    protected PersistentProduct relateTo;
    protected PersistentPosition This;
    
    public Position(long amount,PersistentProduct relateTo,PersistentPosition This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.amount = amount;
        this.relateTo = relateTo;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 124;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public long getAmount() throws PersistenceException {
        return this.amount;
    }
    public void setAmount(long newValue) throws PersistenceException {
        ConnectionHandler.getTheConnectionHandler().thePositionFacade.amountSet(this.getId(), newValue);
        this.amount = newValue;
    }
    public PersistentProduct getRelateTo() throws PersistenceException {
        return this.relateTo;
    }
    public void setRelateTo(PersistentProduct newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.relateTo)) return;
        if(getThis().getRelateTo() != null)throw new PersistenceException("Final field relateTo in type Position has been set already!",0);
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.relateTo = (PersistentProduct)PersistentProxi.createProxi(objectId, classId);
        ConnectionHandler.getTheConnectionHandler().thePositionFacade.relateToSet(this.getId(), newValue);
    }
    protected void setThis(PersistentPosition newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentPosition)PersistentProxi.createProxi(objectId, classId);
        ConnectionHandler.getTheConnectionHandler().thePositionFacade.ThisSet(this.getId(), newValue);
    }
    public PersistentPosition getThis() throws PersistenceException {
        if(this.This == null){
            PersistentPosition result = new PositionProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentPosition)this.This;
    }
    
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handlePosition(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handlePosition(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handlePosition(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handlePosition(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + (this.getRelateTo() == null ? 0 : 1));
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    public void copyingPrivateUserAttributes(Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public void initialize(Anything This, java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentPosition)This);
		if(this.equals(This)){
			this.setAmount((Long)final$$Fields.get("amount"));
			this.setRelateTo((PersistentProduct)final$$Fields.get("relateTo"));
		}
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
