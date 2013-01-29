
package model.meta;

import persistence.*;
import model.*;
import model.visitor.*;


/* Additional import section end */

public class CreateInstanceCommand extends PersistentObject implements PersistentCreateInstanceCommand{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentCreateInstanceCommand getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theCreateInstanceCommandFacade.getClass(objectId);
        return (PersistentCreateInstanceCommand)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentCreateInstanceCommand createCreateInstanceCommand(String name,java.sql.Date createDate,java.sql.Date commitDate) throws PersistenceException{
        return createCreateInstanceCommand(name,createDate,commitDate,false);
    }
    
    public static PersistentCreateInstanceCommand createCreateInstanceCommand(String name,java.sql.Date createDate,java.sql.Date commitDate,boolean delayed$Persistence) throws PersistenceException {
        if (name == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentCreateInstanceCommand result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theCreateInstanceCommandFacade
                .newDelayedCreateInstanceCommand(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theCreateInstanceCommandFacade
                .newCreateInstanceCommand(name,-1);
        }
        result.setMyCommonDate(CommonDate.createCommonDate(createDate, createDate));
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return true;
    }
    protected String name;
    protected PersistentNameScheme scheme;
    protected Invoker invoker;
    protected PersistentNameSchemeInstaceManager commandReceiver;
    protected PersistentNameSchemeInstance commandResult;
    protected PersistentCommonDate myCommonDate;
    
    private model.UserException commandException = null;
    
    public CreateInstanceCommand(String name,PersistentNameScheme scheme,Invoker invoker,PersistentNameSchemeInstaceManager commandReceiver,PersistentNameSchemeInstance commandResult,PersistentCommonDate myCommonDate,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.name = name;
        this.scheme = scheme;
        this.invoker = invoker;
        this.commandReceiver = commandReceiver;
        this.commandResult = commandResult;
        this.myCommonDate = myCommonDate;        
    }
    
    static public long getTypeId() {
        return 245;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 245) ConnectionHandler.getTheConnectionHandler().theCreateInstanceCommandFacade
            .newCreateInstanceCommand(name,this.getId());
        super.store();
        if(this.getScheme() != null){
            this.getScheme().store();
            ConnectionHandler.getTheConnectionHandler().theCreateInstanceCommandFacade.schemeSet(this.getId(), getScheme());
        }
        if(this.getInvoker() != null){
            this.getInvoker().store();
            ConnectionHandler.getTheConnectionHandler().theCreateInstanceCommandFacade.invokerSet(this.getId(), getInvoker());
        }
        if(this.getCommandReceiver() != null){
            this.getCommandReceiver().store();
            ConnectionHandler.getTheConnectionHandler().theCreateInstanceCommandFacade.commandReceiverSet(this.getId(), getCommandReceiver());
        }
        if(this.getCommandResult() != null){
            this.getCommandResult().store();
            ConnectionHandler.getTheConnectionHandler().theCreateInstanceCommandFacade.commandResultSet(this.getId(), getCommandResult());
        }
        if(this.getMyCommonDate() != null){
            this.getMyCommonDate().store();
            ConnectionHandler.getTheConnectionHandler().theCreateInstanceCommandFacade.myCommonDateSet(this.getId(), getMyCommonDate());
        }
        
    }
    
    public String getName() throws PersistenceException {
        return this.name;
    }
    public void setName(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theCreateInstanceCommandFacade.nameSet(this.getId(), newValue);
        this.name = newValue;
    }
    public PersistentNameScheme getScheme() throws PersistenceException {
        return this.scheme;
    }
    public void setScheme(PersistentNameScheme newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.scheme)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.scheme = (PersistentNameScheme)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theCreateInstanceCommandFacade.schemeSet(this.getId(), newValue);
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
            ConnectionHandler.getTheConnectionHandler().theCreateInstanceCommandFacade.invokerSet(this.getId(), newValue);
        }
    }
    public PersistentNameSchemeInstaceManager getCommandReceiver() throws PersistenceException {
        return this.commandReceiver;
    }
    public void setCommandReceiver(PersistentNameSchemeInstaceManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.commandReceiver)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.commandReceiver = (PersistentNameSchemeInstaceManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theCreateInstanceCommandFacade.commandReceiverSet(this.getId(), newValue);
        }
    }
    public PersistentNameSchemeInstance getCommandResult() throws PersistenceException {
        return this.commandResult;
    }
    public void setCommandResult(PersistentNameSchemeInstance newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.commandResult)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.commandResult = (PersistentNameSchemeInstance)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theCreateInstanceCommandFacade.commandResultSet(this.getId(), newValue);
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
            ConnectionHandler.getTheConnectionHandler().theCreateInstanceCommandFacade.myCommonDateSet(this.getId(), newValue);
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
        visitor.handleCreateInstanceCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateInstanceCommand(this);
    }
    public <E extends UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateInstanceCommand(this);
    }
    public <R, E extends UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateInstanceCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCreateInstanceCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateInstanceCommand(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateInstanceCommand(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateInstanceCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateInstanceCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateInstanceCommand(this);
    }
    public <E extends UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateInstanceCommand(this);
    }
    public <R, E extends UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateInstanceCommand(this);
    }
    public void accept(NameSchemeInstaceManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateInstanceCommand(this);
    }
    public <R> R accept(NameSchemeInstaceManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateInstanceCommand(this);
    }
    public <E extends UserException>  void accept(NameSchemeInstaceManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateInstanceCommand(this);
    }
    public <R, E extends UserException> R accept(NameSchemeInstaceManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateInstanceCommand(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + (this.getScheme() == null ? 0 : 1)
            + (this.getCommandReceiver() == null ? 0 : 1)
            + (this.getCommandResult() == null ? 0 : 1));
    }
    
    
    public void execute() 
				throws PersistenceException{
        try{
			this.setCommandResult(this.getCommandReceiver().createInstance(this.getName(), this.getScheme()));
		}
		catch(model.PatternNotMatchException e){
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
