package model;

import model.basic.MBoolean;
import model.basic.MFalse;
import model.basic.MTrue;
import model.measurement.Measurement;
import model.meta.StringFACTORY;
import model.quantity.FractionManager;
import model.quantity.QuantityManager;
import model.quantity.Unit;
import model.quantity.UnitType;
import model.quantity.UnitTypeManager;
import model.typeSystem.AspectManager;
import model.typeSystem.TypeManager;
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
import persistence.ActualParameterSearchList;
import persistence.Anything;
import persistence.Command;
import persistence.ConnectionHandler;
import persistence.FormalParameterSearchList;
import persistence.MAtomicTypeSearchList;
import persistence.MTypeSearchList;
import persistence.PersistenceException;
import persistence.PersistentAbsQuantity;
import persistence.PersistentAbsUnit;
import persistence.PersistentAbsUnitType;
import persistence.PersistentAccount;
import persistence.PersistentAccountManager;
import persistence.PersistentAccountTypeManager;
import persistence.PersistentAspectManager;
import persistence.PersistentAssociation;
import persistence.PersistentAssociationManager;
import persistence.PersistentCompUnitType;
import persistence.PersistentFormalParameter;
import persistence.PersistentFractionManager;
import persistence.PersistentHierarchy;
import persistence.PersistentLink;
import persistence.PersistentLinkManager;
import persistence.PersistentMAccountType;
import persistence.PersistentMAspect;
import persistence.PersistentMAtomicType;
import persistence.PersistentMBoolean;
import persistence.PersistentMMeasurementType;
import persistence.PersistentMObject;
import persistence.PersistentMType;
import persistence.PersistentMeasurementTypeManager;
import persistence.PersistentMessage;
import persistence.PersistentMessageManager;
import persistence.PersistentName;
import persistence.PersistentNameScheme;
import persistence.PersistentNameSchemeManager;
import persistence.PersistentObject;
import persistence.PersistentObjectManager;
import persistence.PersistentOperation;
import persistence.PersistentOperationManager;
import persistence.PersistentProxi;
import persistence.PersistentQuantity;
import persistence.PersistentQuantityManager;
import persistence.PersistentServer;
import persistence.PersistentTypeManager;
import persistence.PersistentUnit;
import persistence.PersistentUnitType;
import persistence.PersistentUnitTypeManager;
import persistence.ServerProxi;
import persistence.ServerSearchList;
import persistence.Server_ErrorsProxi;
import persistence.TDObserver;

import common.Fraction;

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
            AbstractPersistentRoot objectManager = (AbstractPersistentRoot)this.getObjectManager(tdObserver);
            if (objectManager != null) {
                result.put("objectManager", objectManager.createProxiInformation(false));
                if(depth > 1) {
                    objectManager.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && objectManager.hasEssentialFields())objectManager.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot nameSchemeManager = (AbstractPersistentRoot)this.getNameSchemeManager(tdObserver);
            if (nameSchemeManager != null) {
                result.put("nameSchemeManager", nameSchemeManager.createProxiInformation(false));
                if(depth > 1) {
                    nameSchemeManager.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && nameSchemeManager.hasEssentialFields())nameSchemeManager.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
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
            AbstractPersistentRoot operationManager = (AbstractPersistentRoot)this.getOperationManager(tdObserver);
            if (operationManager != null) {
                result.put("operationManager", operationManager.createProxiInformation(false));
                if(depth > 1) {
                    operationManager.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && operationManager.hasEssentialFields())operationManager.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot messageManager = (AbstractPersistentRoot)this.getMessageManager(tdObserver);
            if (messageManager != null) {
                result.put("messageManager", messageManager.createProxiInformation(false));
                if(depth > 1) {
                    messageManager.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && messageManager.hasEssentialFields())messageManager.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot linkManager = (AbstractPersistentRoot)this.getLinkManager(tdObserver);
            if (linkManager != null) {
                result.put("linkManager", linkManager.createProxiInformation(false));
                if(depth > 1) {
                    linkManager.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && linkManager.hasEssentialFields())linkManager.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
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
        return -112;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == -112) ConnectionHandler.getTheConnectionHandler().theServerFacade
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
            + (this.getFractionManager() == null ? 0 : 1)
            + (this.getMeasurementTypeManager() == null ? 0 : 1)
            + (this.getAccountTypeManager() == null ? 0 : 1)
            + (this.getAccountManager() == null ? 0 : 1)
            + (this.getObjectManager() == null ? 0 : 1)
            + (this.getNameSchemeManager() == null ? 0 : 1)
            + (this.getAssociationManager() == null ? 0 : 1)
            + (this.getOperationManager() == null ? 0 : 1)
            + (this.getMessageManager() == null ? 0 : 1)
            + (this.getLinkManager() == null ? 0 : 1));
    }
    
    
    public PersistentObjectManager getObjectManager() 
				throws PersistenceException{
		return model.typeSystem.ObjectManager.getTheObjectManager();
	}
    public void signalChanged(final boolean signal) 
				throws PersistenceException{
        this.changed = signal;
    }
    public void createHierarchy(final PersistentAssociationManager manager, final PersistentAssociation a, final String name) 
				throws PersistenceException{
        //TODO: implement method: createHierarchy
        
    }
    public PersistentNameSchemeManager getNameSchemeManager(final TDObserver observer) 
				throws PersistenceException{
        PersistentNameSchemeManager result = getThis().getNameSchemeManager();
		observer.updateTransientDerived(getThis(), "nameSchemeManager", result);
		return result;
    }
    public void createEntry(final PersistentAccount account, final PersistentMObject object, final PersistentMMeasurementType measurementType, final PersistentQuantity quantity) 
				throws model.ConsistencyException, PersistenceException{
        //TODO: implement method: createEntry
        
    }
    public PersistentLinkManager getLinkManager() 
				throws PersistenceException{
		return model.messageOrLink.LinkManager.getTheLinkManager();
	}
    public PersistentAccountTypeManager getAccountTypeManager(final TDObserver observer) 
				throws PersistenceException{
        PersistentAccountTypeManager result = getThis().getAccountTypeManager();
		observer.updateTransientDerived(getThis(), "accountTypeManager", result);
		return result;
    }
    public PersistentNameSchemeManager getNameSchemeManager() 
				throws PersistenceException{
		return model.naming.NameSchemeManager.getTheNameSchemeManager();
	}
    public void createHierarchy(final PersistentAssociation a, final String name) 
				throws PersistenceException{
        //TODO: implement method: createHierarchy
        
    }
    public void handleResult(final Command command) 
				throws PersistenceException{
		new Thread(new Runnable() {
			@Override
			public void /* INTERNAL */run() {
				try {
					try {
						command.checkException();
						// Handle result!
						signalChanged(true);
					} catch (model.UserException e) {
						model.UserExceptionToDisplayVisitor visitor = new model.UserExceptionToDisplayVisitor();
						e.accept(visitor);
						getErrors().add(visitor.getResult());
						signalChanged(true);
					}
				} catch (PersistenceException e) {
					// Handle fatal exception!
				}
			}
		}).start();
	}
    public PersistentUnitTypeManager getUnitTypeManager() 
				throws PersistenceException{
		return UnitTypeManager.getTheUnitTypeManager();
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
    public void createCompUnitType(final PersistentUnitTypeManager manager, final String name) 
				throws PersistenceException{
        //TODO: implement method: createCompUnitType
        
    }
    public PersistentAbsQuantity mul(final PersistentAbsQuantity factor1, final PersistentAbsQuantity factor2) 
				throws model.NotComputableException, PersistenceException{
        //TODO: implement method: mul
        try{
            throw new java.lang.UnsupportedOperationException("Method \"mul\" not implemented yet.");
        } catch (java.lang.UnsupportedOperationException uoe){
            uoe.printStackTrace();
            throw uoe;
        }
    }
    public void createLink(final PersistentLinkManager link, final PersistentAssociation type, final PersistentMObject source, final PersistentMObject target) 
				throws PersistenceException{
        //TODO: implement method: createLink
        
    }
    public PersistentFractionManager getFractionManager(final TDObserver observer) 
				throws PersistenceException{
        PersistentFractionManager result = getThis().getFractionManager();
		observer.updateTransientDerived(getThis(), "fractionManager", result);
		return result;
    }
    public void addFp(final PersistentOperation op, final PersistentFormalParameter fp) 
				throws PersistenceException{
        //TODO: implement method: addFp
        
    }
    public void addToHierarchy(final PersistentAssociation association, final PersistentHierarchy theHierarchy) 
				throws PersistenceException{
        //TODO: implement method: addToHierarchy
        
    }
    public PersistentMeasurementTypeManager getMeasurementTypeManager(final TDObserver observer) 
				throws PersistenceException{
        PersistentMeasurementTypeManager result = getThis().getMeasurementTypeManager();
		observer.updateTransientDerived(getThis(), "measurementTypeManager", result);
		return result;
    }
    public void createFp(final PersistentOperationManager operationManager, final String name, final PersistentMType ofType) 
				throws PersistenceException{
        //TODO: implement method: createFp
        
    }
    public void createCompUnit(final PersistentCompUnitType compUnitType, final String name) 
				throws PersistenceException{
        //TODO: implement method: createCompUnit
        
    }
    public void convert(final PersistentQuantity quantity, final PersistentAbsUnit unit) 
				throws PersistenceException{
        //TODO: implement method: convert
        
    }
    public void createStaticMessage(final PersistentMessageManager manager, final PersistentOperation type, final String name, final PersistentMObject target, final ActualParameterSearchList ap) 
				throws PersistenceException{
        //TODO: implement method: createStaticMessage
        
    }
    public PersistentAccountManager getAccountManager(final TDObserver observer) 
				throws PersistenceException{
        PersistentAccountManager result = getThis().getAccountManager();
		observer.updateTransientDerived(getThis(), "accountManager", result);
		return result;
    }
    public void replaceType(final PersistentMObject object, final PersistentMAtomicType oldType, final PersistentMAtomicType newType) 
				throws PersistenceException{
        //TODO: implement method: replaceType
        
    }
    public PersistentTypeManager getTypeManager(final TDObserver observer) 
				throws PersistenceException{
        PersistentTypeManager result = getThis().getTypeManager();
		observer.updateTransientDerived(getThis(), "typeManager", result);
		return result;
    }
    public void createAtomicSubType(final PersistentMAtomicType superType, final String typeName, final String singletonType, final String abstractType) 
				throws PersistenceException{
        //TODO: implement method: createAtomicSubType
        
    }
    public PersistentAbsQuantity div(final PersistentAbsQuantity dividend, final PersistentAbsQuantity divisor) 
				throws model.NotComputableException, PersistenceException{
        //TODO: implement method: div
        try{
            throw new java.lang.UnsupportedOperationException("Method \"div\" not implemented yet.");
        } catch (java.lang.UnsupportedOperationException uoe){
            uoe.printStackTrace();
            throw uoe;
        }
    }
    public void createMeasurementType(final PersistentMeasurementTypeManager measurementTypeManager, final String name, final PersistentMType type, final PersistentUnitType unitType) 
				throws PersistenceException{
        //TODO: implement method: createMeasurementType
        
    }
    public void removeUnitType(final PersistentAbsUnitType type) 
				throws PersistenceException{
        //TODO: implement method: removeUnitType
        
    }
    public void addSubAccountType(final PersistentMAccountType parent, final PersistentMAccountType child) 
				throws model.CycleException, PersistenceException{
        //TODO: implement method: addSubAccountType
        
    }
    public PersistentQuantityManager getQuantityManager() 
				throws PersistenceException{
		return QuantityManager.getTheQuantityManager();
	}
    public void removeOperation(final PersistentOperation op) 
				throws PersistenceException{
        //TODO: implement method: removeOperation
        
    }
    public void createMessage(final PersistentMessageManager manager, final PersistentOperation type, final PersistentMObject source, final PersistentMObject target, final ActualParameterSearchList ap) 
				throws PersistenceException{
        //TODO: implement method: createMessage
        
    }
    public void addAssociation(final PersistentHierarchy h, final PersistentAssociation a) 
				throws PersistenceException{
        //TODO: implement method: addAssociation
        
    }
    public PersistentOperationManager getOperationManager() 
				throws PersistenceException{
		return model.abstractOperation.OperationManager.getTheOperationManager();
	}
    public void createProductType(final MTypeSearchList containees) 
				throws PersistenceException{
        //TODO: implement method: createProductType
        
    }
    public void createConstant(final PersistentOperationManager operationManager, final String name, final PersistentMType target) 
				throws PersistenceException{
        //TODO: implement method: createConstant
        
    }
    public void removeLink(final PersistentLink link) 
				throws PersistenceException{
        //TODO: implement method: removeLink
        
    }
    public void disconnected() 
				throws PersistenceException{
	}
    public void createLink(final PersistentMObject source, final PersistentAssociation type, final PersistentMObject target) 
				throws PersistenceException{
        //TODO: implement method: createLink
        
    }
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException{
		new Thread(new Runnable() {
			@Override
			public/* INTERNAL */void run() {
				// Handle exception!
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
    public void addType(final PersistentMObject object, final PersistentMAtomicType newType) 
				throws PersistenceException{
        //TODO: implement method: addType
        
    }
    public void createNameScheme(final PersistentNameSchemeManager manager, final String schemeName, final String regExp, final String isIterable) 
				throws PersistenceException{
        //TODO: implement method: createNameScheme
        
    }
    public void removeFpFromOp(final PersistentOperation operation, final PersistentFormalParameter fp) 
				throws PersistenceException{
        //TODO: implement method: removeFpFromOp
        
    }
    public PersistentOperationManager getOperationManager(final TDObserver observer) 
				throws PersistenceException{
        PersistentOperationManager result = getThis().getOperationManager();
		observer.updateTransientDerived(getThis(), "operationManager", result);
		return result;
    }
    public PersistentTypeManager getTypeManager() 
				throws PersistenceException{
		return TypeManager.getTheTypeManager();
	}
    public PersistentAccountTypeManager getAccountTypeManager() 
				throws PersistenceException{
		return model.measurement.AccountTypeManager.getTheAccountTypeManager();
	}
    public void removeMessage(final PersistentMessage m) 
				throws PersistenceException{
        //TODO: implement method: removeMessage
        
    }
    public void createAssociation(final PersistentAssociationManager manager, final PersistentMType source, final PersistentMType target, final String name) 
				throws PersistenceException{
        //TODO: implement method: createAssociation
        
    }
    public void createSumType(final MTypeSearchList containees) 
				throws PersistenceException{
        //TODO: implement method: createSumType
        
    }
    public void removeFromHierarchy(final PersistentHierarchy h, final PersistentAssociation a) 
				throws PersistenceException{
        //TODO: implement method: removeFromHierarchy
        
    }
    public void createVoidOperation(final PersistentOperationManager operationManager, final PersistentMType source, final String name, final FormalParameterSearchList fp) 
				throws PersistenceException{
        //TODO: implement method: createVoidOperation
        
    }
    public void connected(final String user) 
				throws PersistenceException{
        //TODO: implement method: connected
        
    }
    public void createOperation(final PersistentMType source, final PersistentMType target, final String name, final FormalParameterSearchList fp) 
				throws PersistenceException{
        //TODO: implement method: createOperation
        
    }
    public void createVoidOperation(final PersistentMType source, final String name, final FormalParameterSearchList fp) 
				throws PersistenceException{
        //TODO: implement method: createVoidOperation
        
    }
    public PersistentAssociationManager getAssociationManager() 
				throws PersistenceException{
		return model.abstractOperation.AssociationManager.getTheAssociationManager();
	}
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public void createUnitType(final PersistentUnitTypeManager manager, final String name) 
				throws PersistenceException{
        //TODO: implement method: createUnitType
        
    }
    public void createAccountType(final PersistentAccountTypeManager accountTypeManager, final String name, final PersistentMType type, final PersistentUnitType unitType) 
				throws PersistenceException{
        //TODO: implement method: createAccountType
        
    }
    public void createQuantity(final PersistentQuantityManager manager, final PersistentAbsUnit unit, final common.Fraction f) 
				throws PersistenceException{
        //TODO: implement method: createQuantity
        
    }
    public void removeUnit(final PersistentAbsUnit unit) 
				throws PersistenceException{
        //TODO: implement method: removeUnit
        
    }
    public PersistentMessageManager getMessageManager() 
				throws PersistenceException{
		return model.messageOrLink.MessageManager.getTheMessageManager();
	}
    public PersistentMessageManager getMessageManager(final TDObserver observer) 
				throws PersistenceException{
        PersistentMessageManager result = getThis().getMessageManager();
		observer.updateTransientDerived(getThis(), "messageManager", result);
		return result;
    }
    public void createMessage(final PersistentMObject source, final PersistentOperation type, final PersistentMObject target, final ActualParameterSearchList ap) 
				throws PersistenceException{
        //TODO: implement method: createMessage
        
    }
    public void convertToDefault(final PersistentQuantity quantity) 
				throws PersistenceException{
        //TODO: implement method: convertToDefault
        
    }
    public void initializeOnCreation() 
				throws PersistenceException{

		try {
			final String weightUnitTypeText = "Gewicht";
			final String kilogramText = "kg";

			getThis().getUnitTypeManager().createUnitType(weightUnitTypeText);
			getThis().getUnitTypeManager().createUnitType("Währung");
			getThis().getUnitTypeManager().createUnitType("Strecke");
			getThis().getUnitTypeManager().createUnitType("Zeit");

			PersistentAbsUnitType weight = UnitType.getAbsUnitTypeByName(weightUnitTypeText).iterator().next();
			getThis().getUnitTypeManager().createUnit(kilogramText, (PersistentUnitType) weight);

			PersistentAbsUnit kilogram = Unit.getAbsUnitByName(kilogramText).iterator().next();
			getThis().getQuantityManager().createQuantity(kilogram, Fraction.parse("10/1"));
			getThis().getQuantityManager().createQuantity(kilogram, Fraction.parse("2/1"));

		} catch (DoubleDefinitionException e1) {
			System.err.println("Fehler bei der Initialisierung des Servers!");
		}

		try {
			PersistentMAspect aspect1 = getThis().getAspectManager().createAspect("Aspekt1");
			PersistentMAtomicType a = getThis().getTypeManager().createAtomicRootType(aspect1, "A",
					MFalse.getTheMFalse(), MFalse.getTheMFalse());
			PersistentMAtomicType b = getThis().getTypeManager().createAtomicRootType(aspect1, "B",
					MFalse.getTheMFalse(), MFalse.getTheMFalse());

			PersistentMAtomicType c = getThis().getTypeManager().createAtomicSubType(a, "C", MFalse.getTheMFalse(),
					MFalse.getTheMFalse());
			PersistentMAspect aspect2 = getThis().getAspectManager().createAspect("Aspekt2");

			PersistentMAspect genderAspect = getThis().getAspectManager().createAspect("Geschlecht");

			getThis().getTypeManager().createAtomicRootType(genderAspect, "m??nnlich", MTrue.getTheMTrue(),
					MFalse.getTheMFalse());
			getThis().getTypeManager().createAtomicRootType(genderAspect, "weiblich", MTrue.getTheMTrue(),
					MFalse.getTheMFalse());

			MTypeSearchList addends = new MTypeSearchList();
			addends.add(a);
			addends.add(b);

			// TODO getThis().getTypeManager().createSumType(addends);
			// TODO TEST Das sollte jetzt eigentlich nicht gehen!
			// TODO getThis().getTypeManager().createProductType(addends);

		} catch (ConsistencyException e) {
			System.err.println("Fehler bei der Initialisierung des Servers!");
		}

	}
    public void removeAssociation(final PersistentAssociation a) 
				throws PersistenceException{
        //TODO: implement method: removeAssociation
        
    }
    public void addReference(final PersistentAbsUnit unit, final String name, final PersistentUnit referenceUnit, final long exponent) 
				throws PersistenceException{
        //TODO: implement method: addReference
        
    }
    public void removeFp(final PersistentFormalParameter fp) 
				throws PersistenceException{
        //TODO: implement method: removeFp
        
    }
    public PersistentAssociationManager getAssociationManager(final TDObserver observer) 
				throws PersistenceException{
        PersistentAssociationManager result = getThis().getAssociationManager();
		observer.updateTransientDerived(getThis(), "associationManager", result);
		return result;
    }
    public void removeType(final PersistentMObject object, final PersistentMAtomicType oldType) 
				throws PersistenceException{
        //TODO: implement method: removeType
        
    }
    public PersistentAspectManager getAspectManager() 
				throws PersistenceException{
		return AspectManager.getTheAspectManager();
	}
    public void createMObject(final PersistentMAtomicType type, final MAtomicTypeSearchList otherTypes) 
				throws PersistenceException{
        //TODO: implement method: createMObject
        
    }
    public void assignNameScheme(final PersistentMAtomicType type, final PersistentNameScheme scheme) 
				throws PersistenceException{
        //TODO: implement method: assignNameScheme
        
    }
    public void setDefaultUnit(final PersistentUnitType type, final PersistentUnit defaultUnit) 
				throws PersistenceException{
        //TODO: implement method: setDefaultUnit
        
    }
    public void createUnit(final PersistentUnitType type, final String name) 
				throws PersistenceException{
        //TODO: implement method: createUnit
        
    }
    public void createAtomicRootType(final PersistentMAspect aspect, final String typeName, final String singletonType, final String abstractType) 
				throws PersistenceException{
        //TODO: implement method: createAtomicRootType
        
    }
    public void addSubAccount(final PersistentAccount parent, final PersistentAccount child) 
				throws model.CycleException, PersistenceException{
        //TODO: implement method: addSubAccount
        
    }
    public PersistentAbsQuantity add(final PersistentAbsQuantity summand1, final PersistentAbsQuantity summand2) 
				throws model.NotComputableException, PersistenceException{
        //TODO: implement method: add
        try{
            throw new java.lang.UnsupportedOperationException("Method \"add\" not implemented yet.");
        } catch (java.lang.UnsupportedOperationException uoe){
            uoe.printStackTrace();
            throw uoe;
        }
    }
    public PersistentFractionManager getFractionManager() 
				throws PersistenceException{
		return FractionManager.getTheFractionManager();
	}
    public void createAspect(final PersistentAspectManager aspectManager, final String name) 
				throws PersistenceException{
        //TODO: implement method: createAspect
        
    }
    public boolean hasChanged() 
				throws PersistenceException{
		boolean result = this.changed;
		this.changed = false;
		return result;
	}
    public void createVoidMessage(final PersistentMObject source, final PersistentOperation type, final ActualParameterSearchList ap) 
				throws PersistenceException{
        //TODO: implement method: createVoidMessage
        
    }
    public PersistentMeasurementTypeManager getMeasurementTypeManager() 
				throws PersistenceException{
		return model.measurement.MeasurementTypeManager.getTheMeasurementTypeManager();
	}
    public void createAccount(final PersistentAccountManager accountManager, final String name, final PersistentMAccountType type, final PersistentMObject object) 
				throws PersistenceException{
        //TODO: implement method: createAccount
        
    }
    public PersistentLinkManager getLinkManager(final TDObserver observer) 
				throws PersistenceException{
        PersistentLinkManager result = getThis().getLinkManager();
		observer.updateTransientDerived(getThis(), "linkManager", result);
		return result;
    }
    public PersistentAccountManager getAccountManager() 
				throws PersistenceException{
		return model.measurement.AccountManager.getTheAccountManager();
	}
    public void createVoidMessage(final PersistentMessageManager manager, final PersistentOperation type, final PersistentMObject source, final ActualParameterSearchList ap) 
				throws PersistenceException{
        //TODO: implement method: createVoidMessage
        
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
	}
    public PersistentQuantityManager getQuantityManager(final TDObserver observer) 
				throws PersistenceException{
        PersistentQuantityManager result = getThis().getQuantityManager();
		observer.updateTransientDerived(getThis(), "quantityManager", result);
		return result;
    }
    public void createStaticOp(final PersistentOperationManager operationManager, final String name, final PersistentMType target, final FormalParameterSearchList fp) 
				throws PersistenceException{
        //TODO: implement method: createStaticOp
        
    }
    public void setConversion(final PersistentUnit unit, final common.Fraction factor, final common.Fraction constant) 
				throws PersistenceException{
        //TODO: implement method: setConversion
        
    }
    public void createOperation(final PersistentOperationManager operationManager, final PersistentMType source, final PersistentMType target, final String name, final FormalParameterSearchList fp) 
				throws PersistenceException{
        //TODO: implement method: createOperation
        
    }
    public void addReferenceType(final PersistentAbsUnitType unitType, final String name, final PersistentUnitType referenceUnitType, final long exponent) 
				throws PersistenceException{
        //TODO: implement method: addReferenceType
        
    }
    public void createConst(final PersistentMessageManager manager, final PersistentOperation type, final String name, final PersistentMObject target) 
				throws PersistenceException{
        //TODO: implement method: createConst
        
    }
    public PersistentObjectManager getObjectManager(final TDObserver observer) 
				throws PersistenceException{
        PersistentObjectManager result = getThis().getObjectManager();
		observer.updateTransientDerived(getThis(), "objectManager", result);
		return result;
    }
    public PersistentAbsQuantity sub(final PersistentAbsQuantity minuend, final PersistentAbsQuantity subtrahend) 
				throws model.NotComputableException, PersistenceException{
        //TODO: implement method: sub
        try{
            throw new java.lang.UnsupportedOperationException("Method \"sub\" not implemented yet.");
        } catch (java.lang.UnsupportedOperationException uoe){
            uoe.printStackTrace();
            throw uoe;
        }
    }
    public void assignName(final PersistentMObject object, final PersistentName scheme, final String name) 
				throws PersistenceException{
        //TODO: implement method: assignName
        
    }
    public void assignType(final PersistentNameScheme scheme, final PersistentMAtomicType type) 
				throws PersistenceException{
        //TODO: implement method: assignType
        
    }

    /* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */
    
}
