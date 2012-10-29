
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class Conversion extends PersistentObject implements PersistentConversion{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentConversion getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theConversionFacade.getClass(objectId);
        return (PersistentConversion)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentConversion createConversion() throws PersistenceException {
        PersistentConversion result = ConnectionHandler.getTheConnectionHandler().theConversionFacade
            .newConversion(common.Fraction.Null,common.Fraction.Null);
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentConversion createConversion(PersistentConversion This) throws PersistenceException {
        PersistentConversion result = ConnectionHandler.getTheConnectionHandler().theConversionFacade
            .newConversion(common.Fraction.Null,common.Fraction.Null);
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot source = (AbstractPersistentRoot)this.getSource();
            if (source != null) {
                result.put("source", source.createProxiInformation(false));
                if(depth > 1) {
                    source.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && source.hasEssentialFields())source.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot target = (AbstractPersistentRoot)this.getTarget();
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
            AbstractPersistentRoot f = (AbstractPersistentRoot)this.getF();
            if (f != null) {
                result.put("f", f.createProxiInformation(false));
                if(depth > 1) {
                    f.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && f.hasEssentialFields())f.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public Conversion provideCopy() throws PersistenceException{
        Conversion result = this;
        result = new Conversion(this.source, 
                                this.target, 
                                this.factor, 
                                this.constant, 
                                this.f, 
                                this.This, 
                                this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentUnit source;
    protected PersistentUnit target;
    protected common.Fraction factor;
    protected common.Fraction constant;
    protected PersistentFunction f;
    protected PersistentConversion This;
    
    public Conversion(PersistentUnit source,PersistentUnit target,common.Fraction factor,common.Fraction constant,PersistentFunction f,PersistentConversion This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.source = source;
        this.target = target;
        this.factor = factor;
        this.constant = constant;
        this.f = f;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 116;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public PersistentUnit getSource() throws PersistenceException {
        return this.source;
    }
    public void setSource(PersistentUnit newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.source)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.source = (PersistentUnit)PersistentProxi.createProxi(objectId, classId);
        ConnectionHandler.getTheConnectionHandler().theConversionFacade.sourceSet(this.getId(), newValue);
    }
    public PersistentUnit getTarget() throws PersistenceException {
        return this.target;
    }
    public void setTarget(PersistentUnit newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.target)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.target = (PersistentUnit)PersistentProxi.createProxi(objectId, classId);
        ConnectionHandler.getTheConnectionHandler().theConversionFacade.targetSet(this.getId(), newValue);
    }
    public common.Fraction getFactor() throws PersistenceException {
        return this.factor;
    }
    public void setFactor(common.Fraction newValue) throws PersistenceException {
        ConnectionHandler.getTheConnectionHandler().theConversionFacade.factorSet(this.getId(), newValue);
        this.factor = newValue;
    }
    public common.Fraction getConstant() throws PersistenceException {
        return this.constant;
    }
    public void setConstant(common.Fraction newValue) throws PersistenceException {
        ConnectionHandler.getTheConnectionHandler().theConversionFacade.constantSet(this.getId(), newValue);
        this.constant = newValue;
    }
    public PersistentFunction getF() throws PersistenceException {
        return this.f;
    }
    public void setF(PersistentFunction newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.f)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.f = (PersistentFunction)PersistentProxi.createProxi(objectId, classId);
        ConnectionHandler.getTheConnectionHandler().theConversionFacade.fSet(this.getId(), newValue);
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
        ConnectionHandler.getTheConnectionHandler().theConversionFacade.ThisSet(this.getId(), newValue);
    }
    public PersistentConversion getThis() throws PersistenceException {
        if(this.This == null){
            PersistentConversion result = new ConversionProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentConversion)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleConversion(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleConversion(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleConversion(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleConversion(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + (this.getSource() == null ? 0 : 1)
            + (this.getTarget() == null ? 0 : 1)
            + (this.getF() == null ? 0 : 1));
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
        this.setThis((PersistentConversion)This);
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
