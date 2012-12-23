
package model.quantity;

import model.AlreadyFinalizedException;
import model.MFalse;
import model.MTrue;
import model.UserException;
import model.visitor.AbsUnitExceptionVisitor;
import model.visitor.AbsUnitReturnExceptionVisitor;
import model.visitor.AbsUnitReturnVisitor;
import model.visitor.AbsUnitVisitor;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.MBooleanExceptionVisitor;
import persistence.AbstractPersistentRoot;
import persistence.Anything;
import persistence.CompUnitProxi;
import persistence.CompUnit_RefsProxi;
import persistence.ConnectionHandler;
import persistence.PersistenceException;
import persistence.PersistentAbsUnit;
import persistence.PersistentAbsUnitType;
import persistence.PersistentCompUnit;
import persistence.PersistentMBoolean;
import persistence.PersistentMFalse;
import persistence.PersistentMTrue;
import persistence.PersistentProxi;
import persistence.TDObserver;


/* Additional import section end */

public class CompUnit extends model.quantity.AbsUnit implements PersistentCompUnit{
    
    
    public static PersistentCompUnit createCompUnit(PersistentAbsUnitType type,String name) throws PersistenceException{
        return createCompUnit(type,name,false);
    }
    
    public static PersistentCompUnit createCompUnit(PersistentAbsUnitType type,String name,boolean delayed$Persistence) throws PersistenceException {
        PersistentCompUnit result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theCompUnitFacade
                .newDelayedCompUnit(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theCompUnitFacade
                .newCompUnit(name,-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("type", type);
        final$$Fields.put("name", name);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentCompUnit createCompUnit(PersistentAbsUnitType type,String name,boolean delayed$Persistence,PersistentCompUnit This) throws PersistenceException {
        PersistentCompUnit result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theCompUnitFacade
                .newDelayedCompUnit(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theCompUnitFacade
                .newCompUnit(name,-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("type", type);
        final$$Fields.put("name", name);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("refs", this.getRefs().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false));
            AbstractPersistentRoot isFinal = (AbstractPersistentRoot)this.getIsFinal();
            if (isFinal != null) {
                result.put("isFinal", isFinal.createProxiInformation(false));
                if(depth > 1) {
                    isFinal.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && isFinal.hasEssentialFields())isFinal.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public CompUnit provideCopy() throws PersistenceException{
        CompUnit result = this;
        result = new CompUnit(this.type, 
                              this.name, 
                              this.This, 
                              this.isFinal, 
                              this.getId());
        result.refs = this.refs.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected CompUnit_RefsProxi refs;
    protected PersistentMBoolean isFinal;
    
    public CompUnit(PersistentAbsUnitType type,String name,PersistentAbsUnit This,PersistentMBoolean isFinal,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentAbsUnitType)type,(String)name,(PersistentAbsUnit)This,id);
        this.refs = new CompUnit_RefsProxi(this);
        this.isFinal = isFinal;        
    }
    
    static public long getTypeId() {
        return 162;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 162) ConnectionHandler.getTheConnectionHandler().theCompUnitFacade
            .newCompUnit(name,this.getId());
        super.store();
        this.getRefs().store();
        if(this.getIsFinal() != null){
            this.getIsFinal().store();
            ConnectionHandler.getTheConnectionHandler().theCompUnitFacade.isFinalSet(this.getId(), getIsFinal());
        }
        
    }
    
    public CompUnit_RefsProxi getRefs() throws PersistenceException {
        return this.refs;
    }
    public PersistentMBoolean getIsFinal() throws PersistenceException {
        return this.isFinal;
    }
    public void setIsFinal(PersistentMBoolean newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.isFinal)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.isFinal = (PersistentMBoolean)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theCompUnitFacade.isFinalSet(this.getId(), newValue);
        }
    }
    public PersistentCompUnit getThis() throws PersistenceException {
        if(this.This == null){
            PersistentCompUnit result = new CompUnitProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentCompUnit)this.This;
    }
    
    public void accept(AbsUnitVisitor visitor) throws PersistenceException {
        visitor.handleCompUnit(this);
    }
    public <R> R accept(AbsUnitReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompUnit(this);
    }
    public <E extends UserException>  void accept(AbsUnitExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompUnit(this);
    }
    public <R, E extends UserException> R accept(AbsUnitReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompUnit(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCompUnit(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompUnit(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompUnit(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompUnit(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + this.getRefs().getLength());
    }
    
    
    public PersistentMBoolean isFinal() 
				throws PersistenceException{
        return getThis().getIsFinal();
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
        this.setThis((PersistentCompUnit)This);
		if(this.equals(This)){
			this.setType((PersistentAbsUnitType)final$$Fields.get("type"));
			this.setName((String)final$$Fields.get("name"));
		}
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        getThis().setIsFinal(MFalse.getTheMFalse());
        
    }
    public void checkExponents() 
				throws model.ExponentMatchingException, PersistenceException{
        //TODO: implement method: checkExponents
        
    }
    public void finishModeling() 
				throws model.AlreadyFinalizedException, model.ExponentMatchingException, PersistenceException{
    	getThis().isFinal().accept(new MBooleanExceptionVisitor<AlreadyFinalizedException>() {

			@Override
			public void handleMFalse(PersistentMFalse booleanFalse)
					throws PersistenceException, AlreadyFinalizedException {
			}

			@Override
			public void handleMTrue(PersistentMTrue booleanTrue)
					throws PersistenceException, AlreadyFinalizedException {
				throw new AlreadyFinalizedException(constants.ExceptionConstants.ALREADY_FINAL_CU);
			}

			@Override
			public void handleMBoolean(PersistentMBoolean mBoolean) throws PersistenceException, AlreadyFinalizedException {
				// TODO Auto-generated method stub
			}

		});
    	
    	getThis().checkExponents();
    	getThis().setIsFinal(MTrue.getTheMTrue()); 
    	
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
