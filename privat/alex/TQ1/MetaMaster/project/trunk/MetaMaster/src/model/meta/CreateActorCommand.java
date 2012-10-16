
package model.meta;

import persistence.*;
import model.*;


/* Additional import section end */

public class CreateActorCommand extends PersistentObject implements PersistentCreateActorCommand{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentCreateActorCommand getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theCreateActorCommandFacade.getClass(objectId);
        return (PersistentCreateActorCommand)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentCreateActorCommand createCreateActorCommand(String name,java.sql.Date createDate,java.sql.Date commitDate) throws PersistenceException {
        if (name == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentCreateActorCommand result = ConnectionHandler.getTheConnectionHandler().theCreateActorCommandFacade
            .newCreateActorCommand(name);
        result.setMyCommonDate(CommonDate.createCommonDate(createDate, createDate));
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return true;
    }
    protected String name;
    protected Invoker invoker;
    protected PersistentActorManager commandReceiver;
    protected PersistentCommonDate myCommonDate;
    
    private model.UserException commandException = null;
    
    public CreateActorCommand(String name,Invoker invoker,PersistentActorManager commandReceiver,PersistentCommonDate myCommonDate,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.name = name;
        this.invoker = invoker;
        this.commandReceiver = commandReceiver;
        this.myCommonDate = myCommonDate;        
    }
    
    static public long getTypeId() {
        return 118;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public String getName() throws PersistenceException {
        return this.name;
    }
    public void setName(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        ConnectionHandler.getTheConnectionHandler().theCreateActorCommandFacade.nameSet(this.getId(), newValue);
        this.name = newValue;
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
        ConnectionHandler.getTheConnectionHandler().theCreateActorCommandFacade.invokerSet(this.getId(), newValue);
    }
    public PersistentActorManager getCommandReceiver() throws PersistenceException {
        return this.commandReceiver;
    }
    public void setCommandReceiver(PersistentActorManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.commandReceiver)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.commandReceiver = (PersistentActorManager)PersistentProxi.createProxi(objectId, classId);
        ConnectionHandler.getTheConnectionHandler().theCreateActorCommandFacade.commandReceiverSet(this.getId(), newValue);
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
        ConnectionHandler.getTheConnectionHandler().theCreateActorCommandFacade.myCommonDateSet(this.getId(), newValue);
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
    
    public void accept(model.visitor.CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleCreateActorCommand(this);
    }
    public <R> R accept(model.visitor.CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateActorCommand(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateActorCommand(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateActorCommand(this);
    }
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCreateActorCommand(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateActorCommand(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateActorCommand(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateActorCommand(this);
    }
    public void accept(model.visitor.CommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateActorCommand(this);
    }
    public <R> R accept(model.visitor.CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateActorCommand(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateActorCommand(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateActorCommand(this);
    }
    public void accept(model.visitor.ActorManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateActorCommand(this);
    }
    public <R> R accept(model.visitor.ActorManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateActorCommand(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.ActorManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateActorCommand(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.ActorManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateActorCommand(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + (this.getCommandReceiver() == null ? 0 : 1));
    }
    
    
    public void execute() 
				throws PersistenceException{
        try{
			this.getCommandReceiver().createActor(this.getName());
		}
		catch(model.DoubleDefinition e){
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
