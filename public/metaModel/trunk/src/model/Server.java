
package model;

import model.quantity.ConversionManager;
import model.quantity.FractionManager;
import model.quantity.QuantityManager;
import model.quantity.UnitType;
import model.quantity.UnitTypeManager;
import model.typeSystem.AspectManager;
import model.typeSystem.TypeManager;
import model.visitor.AbsUnitTypeVisitor;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.InvokerExceptionVisitor;
import model.visitor.InvokerReturnExceptionVisitor;
import model.visitor.InvokerReturnVisitor;
import model.visitor.InvokerVisitor;
import model.visitor.RemoteExceptionVisitor;
import model.visitor.RemoteReturnExceptionVisitor;
import model.visitor.RemoteReturnVisitor;
import model.visitor.RemoteVisitor;
import persistence.AbstractPersistentRoot;
import persistence.Anything;
import persistence.Command;
import persistence.ConnectionHandler;
import persistence.PersistenceException;
import persistence.PersistentAbsUnit;
import persistence.PersistentAbsUnitType;
import persistence.PersistentAccountManager;
import persistence.PersistentAccountTypeManager;
import persistence.PersistentAspectManager;
import persistence.PersistentAssociationManager;
import persistence.PersistentCompUnitType;
import persistence.PersistentConversionManager;
import persistence.PersistentFractionManager;
import persistence.PersistentInstanceObject;
import persistence.PersistentMAHierarchy;
import persistence.PersistentMAccountType;
import persistence.PersistentMAspect;
import persistence.PersistentMAssociation;
import persistence.PersistentMAtomicType;
import persistence.PersistentMBoolean;
import persistence.PersistentMType;
import persistence.PersistentMeasurementTypeManager;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.PersistentQuantityManager;
import persistence.PersistentServer;
import persistence.PersistentTypeManager;
import persistence.PersistentUnitType;
import persistence.PersistentUnitTypeManager;
import persistence.ServerProxi;
import persistence.ServerSearchList;
import persistence.Server_ErrorsProxi;
import persistence.TDObserver;


/* Additional import section end */

public class Server extends PersistentObject implements PersistentServer{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentServer getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theServerFacade.getClass(objectId);
        return (PersistentServer)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentServer createServer(String password,String user,long hackCount,java.sql.Timestamp hackDelay) throws PersistenceException{
        return createServer(password,user,hackCount,hackDelay,false);
    }
    
    public static PersistentServer createServer(String password,String user,long hackCount,java.sql.Timestamp hackDelay,boolean delayed$Persistence) throws PersistenceException {
        if (password == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if (user == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentServer result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theServerFacade
                .newDelayedServer(password,user,hackCount,hackDelay);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theServerFacade
                .newServer(password,user,hackCount,hackDelay,-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("password", password);
        final$$Fields.put("user", user);
        final$$Fields.put("hackCount", hackCount);
        final$$Fields.put("hackDelay", hackDelay);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentServer createServer(String password,String user,long hackCount,java.sql.Timestamp hackDelay,boolean delayed$Persistence,PersistentServer This) throws PersistenceException {
        if (password == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if (user == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentServer result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theServerFacade
                .newDelayedServer(password,user,hackCount,hackDelay);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theServerFacade
                .newServer(password,user,hackCount,hackDelay,-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("password", password);
        final$$Fields.put("user", user);
        final$$Fields.put("hackCount", hackCount);
        final$$Fields.put("hackDelay", hackDelay);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot aspectManager = (AbstractPersistentRoot)this.getAspectManager(tdObserver);
            if (aspectManager != null) {
                result.put("aspectManager", aspectManager.createProxiInformation(false));
                if(depth > 1) {
                    aspectManager.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && aspectManager.hasEssentialFields())aspectManager.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot typeManager = (AbstractPersistentRoot)this.getTypeManager(tdObserver);
            if (typeManager != null) {
                result.put("typeManager", typeManager.createProxiInformation(false));
                if(depth > 1) {
                    typeManager.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && typeManager.hasEssentialFields())typeManager.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot quantityManager = (AbstractPersistentRoot)this.getQuantityManager(tdObserver);
            if (quantityManager != null) {
                result.put("quantityManager", quantityManager.createProxiInformation(false));
                if(depth > 1) {
                    quantityManager.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && quantityManager.hasEssentialFields())quantityManager.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot unitTypeManager = (AbstractPersistentRoot)this.getUnitTypeManager(tdObserver);
            if (unitTypeManager != null) {
                result.put("unitTypeManager", unitTypeManager.createProxiInformation(false));
                if(depth > 1) {
                    unitTypeManager.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && unitTypeManager.hasEssentialFields())unitTypeManager.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot conversionManager = (AbstractPersistentRoot)this.getConversionManager(tdObserver);
            if (conversionManager != null) {
                result.put("conversionManager", conversionManager.createProxiInformation(false));
                if(depth > 1) {
                    conversionManager.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && conversionManager.hasEssentialFields())conversionManager.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot fractionManager = (AbstractPersistentRoot)this.getFractionManager(tdObserver);
            if (fractionManager != null) {
                result.put("fractionManager", fractionManager.createProxiInformation(false));
                if(depth > 1) {
                    fractionManager.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && fractionManager.hasEssentialFields())fractionManager.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot measurementTypeManager = (AbstractPersistentRoot)this.getMeasurementTypeManager(tdObserver);
            if (measurementTypeManager != null) {
                result.put("measurementTypeManager", measurementTypeManager.createProxiInformation(false));
                if(depth > 1) {
                    measurementTypeManager.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && measurementTypeManager.hasEssentialFields())measurementTypeManager.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot accountTypeManager = (AbstractPersistentRoot)this.getAccountTypeManager(tdObserver);
            if (accountTypeManager != null) {
                result.put("accountTypeManager", accountTypeManager.createProxiInformation(false));
                if(depth > 1) {
                    accountTypeManager.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && accountTypeManager.hasEssentialFields())accountTypeManager.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot accountManager = (AbstractPersistentRoot)this.getAccountManager(tdObserver);
            if (accountManager != null) {
                result.put("accountManager", accountManager.createProxiInformation(false));
                if(depth > 1) {
                    accountManager.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && accountManager.hasEssentialFields())accountManager.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot associationManager = (AbstractPersistentRoot)this.getAssociationManager(tdObserver);
            if (associationManager != null) {
                result.put("associationManager", associationManager.createProxiInformation(false));
                if(depth > 1) {
                    associationManager.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && associationManager.hasEssentialFields())associationManager.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            result.put("errors", this.getErrors().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false));
            result.put("user", this.getUser());
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public static ServerSearchList getServerByUser(String user) throws PersistenceException{
        return ConnectionHandler.getTheConnectionHandler().theServerFacade
            .getServerByUser(user);
    }
    
    public Server provideCopy() throws PersistenceException{
        Server result = this;
        result = new Server(this.This, 
                            this.password, 
                            this.user, 
                            this.hackCount, 
                            this.hackDelay, 
                            this.getId());
        result.errors = this.errors.copy(result);
        result.errors = this.errors.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistenceException exception = null;
    protected model.UserException userException = null;
    protected boolean changed = false;
    
    protected PersistentServer This;
    protected Server_ErrorsProxi errors;
    protected String password;
    protected String user;
    protected long hackCount;
    protected java.sql.Timestamp hackDelay;
    
    public Server(PersistentServer This,String password,String user,long hackCount,java.sql.Timestamp hackDelay,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        if (This != null && !(this.equals(This))) this.This = This;
        this.errors = new Server_ErrorsProxi(this);
        this.password = password;
        this.user = user;
        this.hackCount = hackCount;
        this.hackDelay = hackDelay;        
    }
    
    static public long getTypeId() {
        return -105;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == -105) ConnectionHandler.getTheConnectionHandler().theServerFacade
            .newServer(password,user,hackCount,hackDelay,this.getId());
        super.store();
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theServerFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    protected void setThis(PersistentServer newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentServer)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theServerFacade.ThisSet(this.getId(), newValue);
        }
    }
    public Server_ErrorsProxi getErrors() throws PersistenceException {
        return this.errors;
    }
    public String getPassword() throws PersistenceException {
        return this.password;
    }
    public void setPassword(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theServerFacade.passwordSet(this.getId(), newValue);
        this.password = newValue;
    }
    public String getUser() throws PersistenceException {
        return this.user;
    }
    public void setUser(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theServerFacade.userSet(this.getId(), newValue);
        this.user = newValue;
    }
    public long getHackCount() throws PersistenceException {
        return this.hackCount;
    }
    public void setHackCount(long newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theServerFacade.hackCountSet(this.getId(), newValue);
        this.hackCount = newValue;
    }
    public java.sql.Timestamp getHackDelay() throws PersistenceException {
        return this.hackDelay;
    }
    public void setHackDelay(java.sql.Timestamp newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theServerFacade.hackDelaySet(this.getId(), newValue);
        this.hackDelay = newValue;
    }
    public PersistentServer getThis() throws PersistenceException {
        if(this.This == null){
            PersistentServer result = new ServerProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentServer)this.This;
    }
    
    public void accept(InvokerVisitor visitor) throws PersistenceException {
        visitor.handleServer(this);
    }
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleServer(this);
    }
    public <E extends UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleServer(this);
    }
    public <R, E extends UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleServer(this);
    }
    public void accept(RemoteVisitor visitor) throws PersistenceException {
        visitor.handleServer(this);
    }
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleServer(this);
    }
    public <E extends UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleServer(this);
    }
    public <R, E extends UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleServer(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleServer(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleServer(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleServer(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleServer(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + (this.getAspectManager() == null ? 0 : 1)
            + (this.getTypeManager() == null ? 0 : 1)
            + (this.getQuantityManager() == null ? 0 : 1)
            + (this.getUnitTypeManager() == null ? 0 : 1)
            + (this.getConversionManager() == null ? 0 : 1)
            + (this.getFractionManager() == null ? 0 : 1)
            + (this.getMeasurementTypeManager() == null ? 0 : 1)
            + (this.getAccountTypeManager() == null ? 0 : 1)
            + (this.getAccountManager() == null ? 0 : 1)
            + (this.getAssociationManager() == null ? 0 : 1));
    }
    
    
    public PersistentAccountTypeManager getAccountTypeManager() 
				throws PersistenceException{
        return model.measurement.AccountTypeManager.getTheAccountTypeManager();
    }
    public PersistentMeasurementTypeManager getMeasurementTypeManager(final TDObserver observer) 
				throws PersistenceException{
        PersistentMeasurementTypeManager result = getThis().getMeasurementTypeManager();
		observer.updateTransientDerived(getThis(), "measurementTypeManager", result);
		return result;
    }
    public PersistentTypeManager getTypeManager() 
				throws PersistenceException{
        return TypeManager.getTheTypeManager();
    }
    public void signalChanged(final boolean signal) 
				throws PersistenceException{
        this.changed = signal;
    }
    public void createAssociationFrom(final PersistentMType source, final String name, final PersistentMType target) 
				throws PersistenceException{
        //TODO: implement method: createAssociationFrom
    }
    public void createAssociationTo(final PersistentMType target, final String name, final PersistentMType source) 
				throws PersistenceException{
        //TODO: implement method: createAssociationTo
    }
    public void connected(final String user) 
				throws PersistenceException{
    }
    public PersistentFractionManager getFractionManager() 
				throws PersistenceException{
        return FractionManager.getTheFractionManager();
    }
    public void createAspect(final PersistentAspectManager aspectManager, final String name) 
				throws PersistenceException{
    	aspectManager.createAspect(name, this.getThis());
    }
    public void addReferenceType(final PersistentCompUnitType compUnitType, final PersistentUnitType unitType, final long exponent) 
				throws PersistenceException{
    	getThis().getUnitTypeManager().addReferenceType(compUnitType, unitType, exponent, getThis());        
    }
    public boolean hasChanged() 
				throws PersistenceException{
        boolean result = this.changed;
		this.changed = false;
		return result;
    }
    public PersistentAccountManager getAccountManager(final TDObserver observer) 
				throws PersistenceException{
        PersistentAccountManager result = getThis().getAccountManager();
		observer.updateTransientDerived(getThis(), "accountManager", result);
		return result;
    }
    public void createHierarchy(final String name) 
				throws PersistenceException{
    	getAssociationManager().createHierarchy(name, getThis());
    }
    public PersistentTypeManager getTypeManager(final TDObserver observer) 
				throws PersistenceException{
        PersistentTypeManager result = getThis().getTypeManager();
		observer.updateTransientDerived(getThis(), "typeManager", result);
		return result;
    }
    public PersistentAssociationManager getAssociationManager() 
				throws PersistenceException{
        return model.AssociationManager.getTheAssociationManager();
    }
    public PersistentAccountTypeManager getAccountTypeManager(final TDObserver observer) 
				throws PersistenceException{
        PersistentAccountTypeManager result = getThis().getAccountTypeManager();
		observer.updateTransientDerived(getThis(), "accountTypeManager", result);
		return result;
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
    }
    public PersistentMeasurementTypeManager getMeasurementTypeManager() 
				throws PersistenceException{
        return model.measurement.MeasurementTypeManager.getTheMeasurementTypeManager();
    }
    public void createUnitType(final PersistentUnitTypeManager unitTypeManager, final String name) 
				throws PersistenceException{
    	this.getThis().getUnitTypeManager().createUnitType(name, getThis());        
    }
    public void createMeasurementType(final PersistentMeasurementTypeManager measurementTypeManager, final String name, final PersistentMType type, final PersistentUnitType unitType) 
				throws PersistenceException{
    	measurementTypeManager.createMeasurementType(name, type, unitType, this.getThis());
    }
    public void createAccountType(final PersistentAccountTypeManager accountTypeManager, final String name, final PersistentMType type, final PersistentUnitType unitType) 
				throws PersistenceException{
    	accountTypeManager.createAccountType(name, type, unitType, this.getThis());
    }
    public void createAccount(final PersistentAccountManager accountManager, final String name, final PersistentMAccountType type, final PersistentInstanceObject object) 
				throws PersistenceException{
    	accountManager.createAccount(name, type, object, this.getThis());
    }
    public void createAtomicRootType(final PersistentMAspect aspect, final String typeName, final PersistentMBoolean singletonType, final PersistentMBoolean abstractType) 
				throws PersistenceException{
    	getThis().getTypeManager().createAtomicRootType(aspect, typeName, singletonType, abstractType, getThis());
    }
    public PersistentAccountManager getAccountManager() 
				throws PersistenceException{
        return model.measurement.AccountManager.getTheAccountManager();
    }
    public void createAssociation(final PersistentAssociationManager manager, final String name, final PersistentMType source, final PersistentMType target) 
				throws PersistenceException{
        //TODO: implement method: createAssociation
    }
    public void handleResult(final Command command) 
				throws PersistenceException{
        new Thread(new Runnable(){
			public void  /*INTERNAL*/  run() {
				try {
					try {
						command.checkException();
						//Handle result!
						signalChanged(true);
					} catch (model.UserException e) {
						model.UserExceptionToDisplayVisitor visitor = new model.UserExceptionToDisplayVisitor();
						e.accept(visitor);
						getErrors().add(visitor.getResult());
						signalChanged(true);
					}
				} catch (PersistenceException e) {
					//Handle fatal exception!
				}
			}
		}).start();
    }
    public PersistentUnitTypeManager getUnitTypeManager() 
				throws PersistenceException{
        return UnitTypeManager.getTheUnitTypeManager();
    }
    public PersistentQuantityManager getQuantityManager() 
				throws PersistenceException{
        return QuantityManager.getTheQuantityManager();
    }
    public void addToHierarchy(final PersistentMAssociation association, final PersistentMAHierarchy theHierarchy) 
				throws PersistenceException{
        //TODO: implement method: addToHierarchy
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
    }
    public PersistentAspectManager getAspectManager(final TDObserver observer) 
				throws PersistenceException{
        PersistentAspectManager result = getThis().getAspectManager();
		observer.updateTransientDerived(getThis(), "aspectManager", result);
		return result;
    }
    public PersistentUnitTypeManager getUnitTypeManager(final TDObserver observer) 
				throws PersistenceException{
        PersistentUnitTypeManager result = getThis().getUnitTypeManager();
		observer.updateTransientDerived(getThis(), "unitTypeManager", result);
		return result;
    }
    public PersistentQuantityManager getQuantityManager(final TDObserver observer) 
				throws PersistenceException{
        PersistentQuantityManager result = getThis().getQuantityManager();
		observer.updateTransientDerived(getThis(), "quantityManager", result);
		return result;
    }
    public void createQuantity(final PersistentAbsUnit unit, final common.Fraction f) 
				throws PersistenceException{
      getThis().getQuantityManager().createQuantity(unit, f, getThis());
    }
    public void createCompUnitType(final PersistentUnitTypeManager unitTypeManager, final String name) 
				throws PersistenceException{
    	getThis().getUnitTypeManager().createCompUnitType(name, getThis());        
    }
    public void addAssociations(final PersistentMAHierarchy theHierarchy, final PersistentMAssociation association) 
				throws PersistenceException{
        //TODO: implement method: addAssociations
    }
    public void initializeOnCreation() 
				throws PersistenceException{
    	getThis().getUnitTypeManager().getUnitTypes().add(UnitType.createUnitType("Gewicht"));
    	getThis().getUnitTypeManager().getUnitTypes().add(UnitType.createUnitType("Strecke"));
    	getThis().getUnitTypeManager().getUnitTypes().add(UnitType.createUnitType("Währung"));
        getThis().getUnitTypeManager().getUnitTypes().add(UnitType.createUnitType("Zeit"));
    }
    public void disconnected() 
				throws PersistenceException{
    }
    public PersistentAssociationManager getAssociationManager(final TDObserver observer) 
				throws PersistenceException{
        PersistentAssociationManager result = getThis().getAssociationManager();
		observer.updateTransientDerived(getThis(), "associationManager", result);
		return result;
    }
    public PersistentFractionManager getFractionManager(final TDObserver observer) 
				throws PersistenceException{
        PersistentFractionManager result = getThis().getFractionManager();
		observer.updateTransientDerived(getThis(), "fractionManager", result);
		return result;
    }
    public void finishModeling(final PersistentCompUnitType compUnitType) 
				throws PersistenceException{
    	getThis().getUnitTypeManager().finishModeling(compUnitType, getThis());        
    }
    public PersistentAspectManager getAspectManager() 
				throws PersistenceException{
        return AspectManager.getTheAspectManager();
    }
    public PersistentConversionManager getConversionManager() 
				throws PersistenceException{
        return ConversionManager.getTheConversionManager();
    }
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException{
        new Thread(new Runnable(){
			public /*INTERNAL*/ void run() {
				//Handle exception!
			}
		}).start();
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentServer)This);
		if(this.equals(This)){
			this.setPassword((String)final$$Fields.get("password"));
			this.setUser((String)final$$Fields.get("user"));
			this.setHackCount((Long)final$$Fields.get("hackCount"));
			this.setHackDelay((java.sql.Timestamp)final$$Fields.get("hackDelay"));
		}
    }
    public void createUnit(final PersistentAbsUnitType type, final String name) 
				throws PersistenceException{
    	
    	type.accept(new AbsUnitTypeVisitor() {
    		
    		@Override
    		public void handleUnitType(PersistentUnitType unitType)
    				throws PersistenceException {
    			getThis().getUnitTypeManager().createUnit(name, unitType, getThis());
    		}
    		
    		@Override
    		public void handleCompUnitType(PersistentCompUnitType compUnitType)
    				throws PersistenceException {
    			getThis().getUnitTypeManager().createCompUnit(name, compUnitType, getThis());		
    		}
    	});                
    }
    public void createAtomicSubType(final PersistentMAtomicType superType, final String typeName, final PersistentMBoolean singletonType, final PersistentMBoolean abstractType) 
				throws PersistenceException{
        getThis().getTypeManager().createAtomicSubType(superType, typeName, singletonType, abstractType, getThis());
        
    }
    public PersistentConversionManager getConversionManager(final TDObserver observer) 
				throws PersistenceException{
        PersistentConversionManager result = getThis().getConversionManager();
		observer.updateTransientDerived(getThis(), "conversionManager", result);
		return result;
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
