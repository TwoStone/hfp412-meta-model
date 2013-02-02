
package model.meta;

import model.UserException;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.CommandExceptionVisitor;
import model.visitor.CommandReturnExceptionVisitor;
import model.visitor.CommandReturnVisitor;
import model.visitor.CommandVisitor;
import model.visitor.CommonDateExceptionVisitor;
import model.visitor.CommonDateReturnExceptionVisitor;
import model.visitor.CommonDateReturnVisitor;
import model.visitor.CommonDateVisitor;
import model.visitor.TypeManagerCommandExceptionVisitor;
import model.visitor.TypeManagerCommandReturnExceptionVisitor;
import model.visitor.TypeManagerCommandReturnVisitor;
import model.visitor.TypeManagerCommandVisitor;
import persistence.ConnectionHandler;
import persistence.Invoker;
import persistence.PersistenceException;
import persistence.PersistentCommonDate;
import persistence.PersistentCreateAtomicSubTypeCommand;
import persistence.PersistentMAtomicType;
import persistence.PersistentMBoolean;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.PersistentTypeManager;


/* Additional import section end */

public class CreateAtomicSubTypeCommand extends PersistentObject implements PersistentCreateAtomicSubTypeCommand{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentCreateAtomicSubTypeCommand getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theCreateAtomicSubTypeCommandFacade.getClass(objectId);
        return (PersistentCreateAtomicSubTypeCommand)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentCreateAtomicSubTypeCommand createCreateAtomicSubTypeCommand(String name,java.sql.Date createDate,java.sql.Date commitDate) throws PersistenceException{
        return createCreateAtomicSubTypeCommand(name,createDate,commitDate,false);
    }
    
    public static PersistentCreateAtomicSubTypeCommand createCreateAtomicSubTypeCommand(String name,java.sql.Date createDate,java.sql.Date commitDate,boolean delayed$Persistence) throws PersistenceException {
        if (name == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentCreateAtomicSubTypeCommand result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theCreateAtomicSubTypeCommandFacade
                .newDelayedCreateAtomicSubTypeCommand(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theCreateAtomicSubTypeCommandFacade
                .newCreateAtomicSubTypeCommand(name,-1);
        }
        result.setMyCommonDate(CommonDate.createCommonDate(createDate, createDate));
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return true;
    }
    protected PersistentMAtomicType superType;
    protected String name;
    protected PersistentMBoolean singletonType;
    protected PersistentMBoolean abstractType;
    protected Invoker invoker;
    protected PersistentTypeManager commandReceiver;
    protected PersistentMAtomicType commandResult;
    protected PersistentCommonDate myCommonDate;
    
    private model.UserException commandException = null;
    
    public CreateAtomicSubTypeCommand(PersistentMAtomicType superType,String name,PersistentMBoolean singletonType,PersistentMBoolean abstractType,Invoker invoker,PersistentTypeManager commandReceiver,PersistentMAtomicType commandResult,PersistentCommonDate myCommonDate,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.superType = superType;
        this.name = name;
        this.singletonType = singletonType;
        this.abstractType = abstractType;
        this.invoker = invoker;
        this.commandReceiver = commandReceiver;
        this.commandResult = commandResult;
        this.myCommonDate = myCommonDate;        
    }
    
    static public long getTypeId() {
        return 157;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 157) ConnectionHandler.getTheConnectionHandler().theCreateAtomicSubTypeCommandFacade
            .newCreateAtomicSubTypeCommand(name,this.getId());
        super.store();
        if(this.getSuperType() != null){
            this.getSuperType().store();
            ConnectionHandler.getTheConnectionHandler().theCreateAtomicSubTypeCommandFacade.superTypeSet(this.getId(), getSuperType());
        }
        if(this.getSingletonType() != null){
            this.getSingletonType().store();
            ConnectionHandler.getTheConnectionHandler().theCreateAtomicSubTypeCommandFacade.singletonTypeSet(this.getId(), getSingletonType());
        }
        if(this.getAbstractType() != null){
            this.getAbstractType().store();
            ConnectionHandler.getTheConnectionHandler().theCreateAtomicSubTypeCommandFacade.abstractTypeSet(this.getId(), getAbstractType());
        }
        if(this.getInvoker() != null){
            this.getInvoker().store();
            ConnectionHandler.getTheConnectionHandler().theCreateAtomicSubTypeCommandFacade.invokerSet(this.getId(), getInvoker());
        }
        if(this.getCommandReceiver() != null){
            this.getCommandReceiver().store();
            ConnectionHandler.getTheConnectionHandler().theCreateAtomicSubTypeCommandFacade.commandReceiverSet(this.getId(), getCommandReceiver());
        }
        if(this.getCommandResult() != null){
            this.getCommandResult().store();
            ConnectionHandler.getTheConnectionHandler().theCreateAtomicSubTypeCommandFacade.commandResultSet(this.getId(), getCommandResult());
        }
        if(this.getMyCommonDate() != null){
            this.getMyCommonDate().store();
            ConnectionHandler.getTheConnectionHandler().theCreateAtomicSubTypeCommandFacade.myCommonDateSet(this.getId(), getMyCommonDate());
        }
        
    }
    
    public PersistentMAtomicType getSuperType() throws PersistenceException {
        return this.superType;
    }
    public void setSuperType(PersistentMAtomicType newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.superType)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.superType = (PersistentMAtomicType)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theCreateAtomicSubTypeCommandFacade.superTypeSet(this.getId(), newValue);
        }
    }
    public String getName() throws PersistenceException {
        return this.name;
    }
    public void setName(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theCreateAtomicSubTypeCommandFacade.nameSet(this.getId(), newValue);
        this.name = newValue;
    }
    public PersistentMBoolean getSingletonType() throws PersistenceException {
        return this.singletonType;
    }
    public void setSingletonType(PersistentMBoolean newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.singletonType)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.singletonType = (PersistentMBoolean)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theCreateAtomicSubTypeCommandFacade.singletonTypeSet(this.getId(), newValue);
        }
    }
    public PersistentMBoolean getAbstractType() throws PersistenceException {
        return this.abstractType;
    }
    public void setAbstractType(PersistentMBoolean newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.abstractType)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.abstractType = (PersistentMBoolean)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theCreateAtomicSubTypeCommandFacade.abstractTypeSet(this.getId(), newValue);
        }
    }
    public Invoker getInvoker() throws PersistenceException {
        return this.invoker;
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.invoker)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.invoker = (Invoker)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theCreateAtomicSubTypeCommandFacade.invokerSet(this.getId(), newValue);
        }
    }
    public PersistentTypeManager getCommandReceiver() throws PersistenceException {
        return this.commandReceiver;
    }
    public void setCommandReceiver(PersistentTypeManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.commandReceiver)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.commandReceiver = (PersistentTypeManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theCreateAtomicSubTypeCommandFacade.commandReceiverSet(this.getId(), newValue);
        }
    }
    public PersistentMAtomicType getCommandResult() throws PersistenceException {
        return this.commandResult;
    }
    public void setCommandResult(PersistentMAtomicType newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.commandResult)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.commandResult = (PersistentMAtomicType)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theCreateAtomicSubTypeCommandFacade.commandResultSet(this.getId(), newValue);
        }
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return this.myCommonDate;
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.myCommonDate)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theCreateAtomicSubTypeCommandFacade.myCommonDateSet(this.getId(), newValue);
        }
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return this.getMyCommonDate().getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        this.getMyCommonDate().setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return this.getMyCommonDate().getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        this.getMyCommonDate().setCommitDate(newValue);
    }
    public void delete$Me() throws PersistenceException{
        super.delete$Me();
        this.getMyCommonDate().delete$Me();
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleCreateAtomicSubTypeCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateAtomicSubTypeCommand(this);
    }
    public <E extends UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateAtomicSubTypeCommand(this);
    }
    public <R, E extends UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateAtomicSubTypeCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCreateAtomicSubTypeCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateAtomicSubTypeCommand(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateAtomicSubTypeCommand(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateAtomicSubTypeCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateAtomicSubTypeCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateAtomicSubTypeCommand(this);
    }
    public <E extends UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateAtomicSubTypeCommand(this);
    }
    public <R, E extends UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateAtomicSubTypeCommand(this);
    }
    public void accept(TypeManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateAtomicSubTypeCommand(this);
    }
    public <R> R accept(TypeManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateAtomicSubTypeCommand(this);
    }
    public <E extends UserException>  void accept(TypeManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateAtomicSubTypeCommand(this);
    }
    public <R, E extends UserException> R accept(TypeManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateAtomicSubTypeCommand(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + (this.getSuperType() == null ? 0 : 1)
            + (this.getSingletonType() == null ? 0 : 1)
            + (this.getAbstractType() == null ? 0 : 1)
            + (this.getCommandReceiver() == null ? 0 : 1)
            + (this.getCommandResult() == null ? 0 : 1));
    }
    
    
    public void execute() 
				throws PersistenceException{
        try{
			this.setCommandResult(this.getCommandReceiver().createAtomicSubType(this.getSuperType(), this.getName(), this.getSingletonType(), this.getAbstractType()));
		}
		catch(model.ConsistencyException e){
			this.commandException = e;
		}
    }
    public void checkException() 
				throws UserException, PersistenceException{
        if (this.commandException != null) throw this.commandException;
    }
    public void sendResult() 
				throws PersistenceException{
        this.invoker.handleResult(this);
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return this.getInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        this.invoker.handleException(this, exception);
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
