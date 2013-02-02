
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
import model.visitor.OperationManagerCommandExceptionVisitor;
import model.visitor.OperationManagerCommandReturnExceptionVisitor;
import model.visitor.OperationManagerCommandReturnVisitor;
import model.visitor.OperationManagerCommandVisitor;
import persistence.ConnectionHandler;
import persistence.CreateOperationCommand_FpProxi;
import persistence.Invoker;
import persistence.PersistenceException;
import persistence.PersistentCommonDate;
import persistence.PersistentCreateOperationCommand;
import persistence.PersistentMType;
import persistence.PersistentObject;
import persistence.PersistentOperationManager;
import persistence.PersistentProxi;


/* Additional import section end */

public class CreateOperationCommand extends PersistentObject implements PersistentCreateOperationCommand{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentCreateOperationCommand getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theCreateOperationCommandFacade.getClass(objectId);
        return (PersistentCreateOperationCommand)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentCreateOperationCommand createCreateOperationCommand(String name,java.sql.Date createDate,java.sql.Date commitDate) throws PersistenceException{
        return createCreateOperationCommand(name,createDate,commitDate,false);
    }
    
    public static PersistentCreateOperationCommand createCreateOperationCommand(String name,java.sql.Date createDate,java.sql.Date commitDate,boolean delayed$Persistence) throws PersistenceException {
        if (name == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentCreateOperationCommand result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theCreateOperationCommandFacade
                .newDelayedCreateOperationCommand(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theCreateOperationCommandFacade
                .newCreateOperationCommand(name,-1);
        }
        result.setMyCommonDate(CommonDate.createCommonDate(createDate, createDate));
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return true;
    }
    protected PersistentMType source;
    protected PersistentMType target;
    protected String name;
    protected CreateOperationCommand_FpProxi fp;
    protected Invoker invoker;
    protected PersistentOperationManager commandReceiver;
    protected PersistentCommonDate myCommonDate;
    
    private model.UserException commandException = null;
    
    public CreateOperationCommand(PersistentMType source,PersistentMType target,String name,Invoker invoker,PersistentOperationManager commandReceiver,PersistentCommonDate myCommonDate,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.source = source;
        this.target = target;
        this.name = name;
        this.fp = new CreateOperationCommand_FpProxi(this);
        this.invoker = invoker;
        this.commandReceiver = commandReceiver;
        this.myCommonDate = myCommonDate;        
    }
    
    static public long getTypeId() {
        return 178;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 178) ConnectionHandler.getTheConnectionHandler().theCreateOperationCommandFacade
            .newCreateOperationCommand(name,this.getId());
        super.store();
        if(this.getSource() != null){
            this.getSource().store();
            ConnectionHandler.getTheConnectionHandler().theCreateOperationCommandFacade.sourceSet(this.getId(), getSource());
        }
        if(this.getTarget() != null){
            this.getTarget().store();
            ConnectionHandler.getTheConnectionHandler().theCreateOperationCommandFacade.targetSet(this.getId(), getTarget());
        }
        this.getFp().store();
        if(this.getInvoker() != null){
            this.getInvoker().store();
            ConnectionHandler.getTheConnectionHandler().theCreateOperationCommandFacade.invokerSet(this.getId(), getInvoker());
        }
        if(this.getCommandReceiver() != null){
            this.getCommandReceiver().store();
            ConnectionHandler.getTheConnectionHandler().theCreateOperationCommandFacade.commandReceiverSet(this.getId(), getCommandReceiver());
        }
        if(this.getMyCommonDate() != null){
            this.getMyCommonDate().store();
            ConnectionHandler.getTheConnectionHandler().theCreateOperationCommandFacade.myCommonDateSet(this.getId(), getMyCommonDate());
        }
        
    }
    
    public PersistentMType getSource() throws PersistenceException {
        return this.source;
    }
    public void setSource(PersistentMType newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.source)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.source = (PersistentMType)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theCreateOperationCommandFacade.sourceSet(this.getId(), newValue);
        }
    }
    public PersistentMType getTarget() throws PersistenceException {
        return this.target;
    }
    public void setTarget(PersistentMType newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.target)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.target = (PersistentMType)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theCreateOperationCommandFacade.targetSet(this.getId(), newValue);
        }
    }
    public String getName() throws PersistenceException {
        return this.name;
    }
    public void setName(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theCreateOperationCommandFacade.nameSet(this.getId(), newValue);
        this.name = newValue;
    }
    public CreateOperationCommand_FpProxi getFp() throws PersistenceException {
        return this.fp;
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
            ConnectionHandler.getTheConnectionHandler().theCreateOperationCommandFacade.invokerSet(this.getId(), newValue);
        }
    }
    public PersistentOperationManager getCommandReceiver() throws PersistenceException {
        return this.commandReceiver;
    }
    public void setCommandReceiver(PersistentOperationManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.commandReceiver)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.commandReceiver = (PersistentOperationManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theCreateOperationCommandFacade.commandReceiverSet(this.getId(), newValue);
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
            ConnectionHandler.getTheConnectionHandler().theCreateOperationCommandFacade.myCommonDateSet(this.getId(), newValue);
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
        visitor.handleCreateOperationCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateOperationCommand(this);
    }
    public <E extends UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateOperationCommand(this);
    }
    public <R, E extends UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateOperationCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCreateOperationCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateOperationCommand(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateOperationCommand(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateOperationCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateOperationCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateOperationCommand(this);
    }
    public <E extends UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateOperationCommand(this);
    }
    public <R, E extends UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateOperationCommand(this);
    }
    public void accept(OperationManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateOperationCommand(this);
    }
    public <R> R accept(OperationManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateOperationCommand(this);
    }
    public <E extends UserException>  void accept(OperationManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateOperationCommand(this);
    }
    public <R, E extends UserException> R accept(OperationManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateOperationCommand(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + (this.getSource() == null ? 0 : 1)
            + (this.getTarget() == null ? 0 : 1)
            + this.getFp().getLength()
            + (this.getCommandReceiver() == null ? 0 : 1));
    }
    
    
    public void execute() 
				throws PersistenceException{
        try{
			this.getCommandReceiver().createOperation(this.getSource(), this.getTarget(), this.getName(), this.getFp().getList());
		}
		catch(model.DoubleDefinitionException e){
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
