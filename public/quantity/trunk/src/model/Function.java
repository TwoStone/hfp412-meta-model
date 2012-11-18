
package model;

import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.FunctionProxi;
import persistence.PersistenceException;
import persistence.PersistentFunction;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.TDObserver;

import common.Fraction;


/* Additional import section end */

public class Function extends PersistentObject implements PersistentFunction{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentFunction getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theFunctionFacade.getClass(objectId);
        return (PersistentFunction)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentFunction createFunction(common.Fraction factor,common.Fraction constant) throws PersistenceException{
        return createFunction(factor,constant,false);
    }
    
    public static PersistentFunction createFunction(common.Fraction factor,common.Fraction constant,boolean delayed$Persistence) throws PersistenceException {
        PersistentFunction result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theFunctionFacade
                .newDelayedFunction(factor,constant);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theFunctionFacade
                .newFunction(factor,constant,-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("factor", factor);
        final$$Fields.put("constant", constant);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentFunction createFunction(common.Fraction factor,common.Fraction constant,boolean delayed$Persistence,PersistentFunction This) throws PersistenceException {
        PersistentFunction result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theFunctionFacade
                .newDelayedFunction(factor,constant);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theFunctionFacade
                .newFunction(factor,constant,-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("factor", factor);
        final$$Fields.put("constant", constant);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    @Override
	public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("factor", this.getFactor().toString());
            result.put("constant", this.getConstant().toString());
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    @Override
	public Function provideCopy() throws PersistenceException{
        Function result = this;
        result = new Function(this.factor, 
                              this.constant, 
                              this.This, 
                              this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    @Override
	public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected common.Fraction factor;
    protected common.Fraction constant;
    protected PersistentFunction This;
    
    public Function(common.Fraction factor,common.Fraction constant,PersistentFunction This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.factor = factor;
        this.constant = constant;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 144;
    }
    
    @Override
	public long getClassId() {
        return getTypeId();
    }
    
    @Override
	public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 144) ConnectionHandler.getTheConnectionHandler().theFunctionFacade
            .newFunction(factor,constant,this.getId());
        super.store();
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theFunctionFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    @Override
	public common.Fraction getFactor() throws PersistenceException {
        return this.factor;
    }
    @Override
	public void setFactor(common.Fraction newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theFunctionFacade.factorSet(this.getId(), newValue);
        this.factor = newValue;
    }
    @Override
	public common.Fraction getConstant() throws PersistenceException {
        return this.constant;
    }
    @Override
	public void setConstant(common.Fraction newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theFunctionFacade.constantSet(this.getId(), newValue);
        this.constant = newValue;
    }
    protected void setThis(PersistentFunction newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentFunction)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theFunctionFacade.ThisSet(this.getId(), newValue);
        }
    }
    @Override
	public PersistentFunction getThis() throws PersistenceException {
        if(this.This == null){
            PersistentFunction result = new FunctionProxi(this.getId());
            result.getTheObject();
            return result;
        }return this.This;
    }
    
    @Override
	public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleFunction(this);
    }
    @Override
	public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleFunction(this);
    }
    @Override
	public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleFunction(this);
    }
    @Override
	public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleFunction(this);
    }
    @Override
	public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    @Override
	public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    @Override
	public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    @Override
	public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentFunction)This);
		if(this.equals(This)){
			this.setFactor((common.Fraction)final$$Fields.get("factor"));
			this.setConstant((common.Fraction)final$$Fields.get("constant"));
		}
    }
    @Override
	public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }
    @Override
	public common.Fraction executeInverse(final common.Fraction amount) 
				throws PersistenceException{
        //TODO: implement method: executeInverse
        try{
            throw new java.lang.UnsupportedOperationException("Method \"executeInverse\" not implemented yet.");
        } catch (java.lang.UnsupportedOperationException uoe){
            uoe.printStackTrace();
            throw uoe;
        }
    }
    
    /**
     * y(x):=a*x+b
     */
    @Override
    public common.Fraction execute(final common.Fraction amount) throws PersistenceException{
    	Fraction result = null;
		try {
			result = amount.mul(this.factor).add(this.constant);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
