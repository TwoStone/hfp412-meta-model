
package model;

import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.AbstractPersistentRoot;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.ConversionProxi;
import persistence.PersistenceException;
import persistence.PersistentConversion;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.PersistentUnit;
import persistence.TDObserver;


/* Additional import section end */

public class Conversion extends PersistentObject implements PersistentConversion{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentConversion getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theConversionFacade.getClass(objectId);
        return (PersistentConversion)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentConversion createConversion(PersistentUnit source,PersistentUnit target,common.Fraction factor,common.Fraction constant) throws PersistenceException{
        return createConversion(source,target,factor,constant,false);
    }
    
    public static PersistentConversion createConversion(PersistentUnit source,PersistentUnit target,common.Fraction factor,common.Fraction constant,boolean delayed$Persistence) throws PersistenceException {
        PersistentConversion result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theConversionFacade
                .newDelayedConversion(factor,constant);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theConversionFacade
                .newConversion(factor,constant,-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("source", source);
        final$$Fields.put("target", target);
        final$$Fields.put("factor", factor);
        final$$Fields.put("constant", constant);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentConversion createConversion(PersistentUnit source,PersistentUnit target,common.Fraction factor,common.Fraction constant,boolean delayed$Persistence,PersistentConversion This) throws PersistenceException {
        PersistentConversion result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theConversionFacade
                .newDelayedConversion(factor,constant);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theConversionFacade
                .newConversion(factor,constant,-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("source", source);
        final$$Fields.put("target", target);
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
            AbstractPersistentRoot source = this.getSource();
            if (source != null) {
                result.put("source", source.createProxiInformation(false));
                if(depth > 1) {
                    source.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && source.hasEssentialFields())source.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot target = this.getTarget();
            if (target != null) {
                result.put("target", target.createProxiInformation(false));
                if(depth > 1) {
                    target.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && target.hasEssentialFields())target.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            result.put("factor", this.getFactor().toString());
            result.put("constant", this.getConstant().toString());
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    @Override
	public Conversion provideCopy() throws PersistenceException{
        Conversion result = this;
        result = new Conversion(this.source, 
                                this.target, 
                                this.factor, 
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
    protected PersistentUnit source;
    protected PersistentUnit target;
    protected common.Fraction factor;
    protected common.Fraction constant;
    protected PersistentConversion This;
    
    public Conversion(PersistentUnit source,PersistentUnit target,common.Fraction factor,common.Fraction constant,PersistentConversion This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.source = source;
        this.target = target;
        this.factor = factor;
        this.constant = constant;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 116;
    }
    
    @Override
	public long getClassId() {
        return getTypeId();
    }
    
    @Override
	public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 116) ConnectionHandler.getTheConnectionHandler().theConversionFacade
            .newConversion(factor,constant,this.getId());
        super.store();
        if(this.getSource() != null){
            this.getSource().store();
            ConnectionHandler.getTheConnectionHandler().theConversionFacade.sourceSet(this.getId(), getSource());
        }
        if(this.getTarget() != null){
            this.getTarget().store();
            ConnectionHandler.getTheConnectionHandler().theConversionFacade.targetSet(this.getId(), getTarget());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theConversionFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    @Override
	public PersistentUnit getSource() throws PersistenceException {
        return this.source;
    }
    @Override
	public void setSource(PersistentUnit newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.source)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.source = (PersistentUnit)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theConversionFacade.sourceSet(this.getId(), newValue);
        }
    }
    @Override
	public PersistentUnit getTarget() throws PersistenceException {
        return this.target;
    }
    @Override
	public void setTarget(PersistentUnit newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.target)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.target = (PersistentUnit)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theConversionFacade.targetSet(this.getId(), newValue);
        }
    }
    @Override
	public common.Fraction getFactor() throws PersistenceException {
        return this.factor;
    }
    @Override
	public void setFactor(common.Fraction newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theConversionFacade.factorSet(this.getId(), newValue);
        this.factor = newValue;
    }
    @Override
	public common.Fraction getConstant() throws PersistenceException {
        return this.constant;
    }
    @Override
	public void setConstant(common.Fraction newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theConversionFacade.constantSet(this.getId(), newValue);
        this.constant = newValue;
    }
    protected void setThis(PersistentConversion newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentConversion)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theConversionFacade.ThisSet(this.getId(), newValue);
        }
    }
    @Override
	public PersistentConversion getThis() throws PersistenceException {
        if(this.This == null){
            PersistentConversion result = new ConversionProxi(this.getId());
            result.getTheObject();
            return result;
        }return this.This;
    }
    
    @Override
	public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleConversion(this);
    }
    @Override
	public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleConversion(this);
    }
    @Override
	public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleConversion(this);
    }
    @Override
	public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleConversion(this);
    }
    @Override
	public int getLeafInfo() throws PersistenceException{
        return 0 
            + (this.getSource() == null ? 0 : 1)
            + (this.getTarget() == null ? 0 : 1);
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
	public common.Fraction convert() 
				throws PersistenceException{
        //TODO: implement method: convert
    	//y=a*x+b
    	//result = amount * this.factor + this.constant
        try{
            throw new java.lang.UnsupportedOperationException("Method \"convert\" not implemented yet.");
        } catch (java.lang.UnsupportedOperationException uoe){
            uoe.printStackTrace();
            throw uoe;
        }
    }
    @Override
	public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentConversion)This);
		if(this.equals(This)){
			this.setSource((PersistentUnit)final$$Fields.get("source"));
			this.setTarget((PersistentUnit)final$$Fields.get("target"));
			this.setFactor((common.Fraction)final$$Fields.get("factor"));
			this.setConstant((common.Fraction)final$$Fields.get("constant"));
		}
    }
    @Override
	public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
