
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
import model.visitor.ObservationManagerCommandExceptionVisitor;
import model.visitor.ObservationManagerCommandReturnExceptionVisitor;
import model.visitor.ObservationManagerCommandReturnVisitor;
import model.visitor.ObservationManagerCommandVisitor;
import persistence.ConnectionHandler;
import persistence.Invoker;
import persistence.PersistenceException;
import persistence.PersistentCommonDate;
import persistence.PersistentCreateObservationCommand;
import persistence.PersistentMEnumValue;
import persistence.PersistentMObject;
import persistence.PersistentMObservationType;
import persistence.PersistentObject;
import persistence.PersistentObservationManager;
import persistence.PersistentProxi;


/* Additional import section end */

public class CreateObservationCommand extends PersistentObject implements PersistentCreateObservationCommand{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentCreateObservationCommand getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theCreateObservationCommandFacade.getClass(objectId);
        return (PersistentCreateObservationCommand)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentCreateObservationCommand createCreateObservationCommand(String name,java.sql.Date createDate,java.sql.Date commitDate) throws PersistenceException{
        return createCreateObservationCommand(name,createDate,commitDate,false);
    }
    
    public static PersistentCreateObservationCommand createCreateObservationCommand(String name,java.sql.Date createDate,java.sql.Date commitDate,boolean delayed$Persistence) throws PersistenceException {
        if (name == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentCreateObservationCommand result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theCreateObservationCommandFacade
                .newDelayedCreateObservationCommand(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theCreateObservationCommandFacade
                .newCreateObservationCommand(name,-1);
        }
        result.setMyCommonDate(CommonDate.createCommonDate(createDate, createDate));
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return true;
    }
    protected String name;
    protected PersistentMObservationType theType;
    protected PersistentMObject theObsObject;
    protected PersistentMEnumValue enumValue;
    protected Invoker invoker;
    protected PersistentObservationManager commandReceiver;
    protected PersistentCommonDate myCommonDate;
    
    private model.UserException commandException = null;
    
    public CreateObservationCommand(String name,PersistentMObservationType theType,PersistentMObject theObsObject,PersistentMEnumValue enumValue,Invoker invoker,PersistentObservationManager commandReceiver,PersistentCommonDate myCommonDate,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.name = name;
        this.theType = theType;
        this.theObsObject = theObsObject;
        this.enumValue = enumValue;
        this.invoker = invoker;
        this.commandReceiver = commandReceiver;
        this.myCommonDate = myCommonDate;        
    }
    
    static public long getTypeId() {
        return 353;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 353) ConnectionHandler.getTheConnectionHandler().theCreateObservationCommandFacade
            .newCreateObservationCommand(name,this.getId());
        super.store();
        if(this.getTheType() != null){
            this.getTheType().store();
            ConnectionHandler.getTheConnectionHandler().theCreateObservationCommandFacade.theTypeSet(this.getId(), getTheType());
        }
        if(this.getTheObsObject() != null){
            this.getTheObsObject().store();
            ConnectionHandler.getTheConnectionHandler().theCreateObservationCommandFacade.theObsObjectSet(this.getId(), getTheObsObject());
        }
        if(this.getEnumValue() != null){
            this.getEnumValue().store();
            ConnectionHandler.getTheConnectionHandler().theCreateObservationCommandFacade.enumValueSet(this.getId(), getEnumValue());
        }
        if(this.getInvoker() != null){
            this.getInvoker().store();
            ConnectionHandler.getTheConnectionHandler().theCreateObservationCommandFacade.invokerSet(this.getId(), getInvoker());
        }
        if(this.getCommandReceiver() != null){
            this.getCommandReceiver().store();
            ConnectionHandler.getTheConnectionHandler().theCreateObservationCommandFacade.commandReceiverSet(this.getId(), getCommandReceiver());
        }
        if(this.getMyCommonDate() != null){
            this.getMyCommonDate().store();
            ConnectionHandler.getTheConnectionHandler().theCreateObservationCommandFacade.myCommonDateSet(this.getId(), getMyCommonDate());
        }
        
    }
    
    public String getName() throws PersistenceException {
        return this.name;
    }
    public void setName(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theCreateObservationCommandFacade.nameSet(this.getId(), newValue);
        this.name = newValue;
    }
    public PersistentMObservationType getTheType() throws PersistenceException {
        return this.theType;
    }
    public void setTheType(PersistentMObservationType newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.theType)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.theType = (PersistentMObservationType)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theCreateObservationCommandFacade.theTypeSet(this.getId(), newValue);
        }
    }
    public PersistentMObject getTheObsObject() throws PersistenceException {
        return this.theObsObject;
    }
    public void setTheObsObject(PersistentMObject newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.theObsObject)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.theObsObject = (PersistentMObject)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theCreateObservationCommandFacade.theObsObjectSet(this.getId(), newValue);
        }
    }
    public PersistentMEnumValue getEnumValue() throws PersistenceException {
        return this.enumValue;
    }
    public void setEnumValue(PersistentMEnumValue newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.enumValue)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.enumValue = (PersistentMEnumValue)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theCreateObservationCommandFacade.enumValueSet(this.getId(), newValue);
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
            ConnectionHandler.getTheConnectionHandler().theCreateObservationCommandFacade.invokerSet(this.getId(), newValue);
        }
    }
    public PersistentObservationManager getCommandReceiver() throws PersistenceException {
        return this.commandReceiver;
    }
    public void setCommandReceiver(PersistentObservationManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.commandReceiver)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.commandReceiver = (PersistentObservationManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theCreateObservationCommandFacade.commandReceiverSet(this.getId(), newValue);
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
            ConnectionHandler.getTheConnectionHandler().theCreateObservationCommandFacade.myCommonDateSet(this.getId(), newValue);
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
        visitor.handleCreateObservationCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateObservationCommand(this);
    }
    public <E extends UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateObservationCommand(this);
    }
    public <R, E extends UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateObservationCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCreateObservationCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateObservationCommand(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateObservationCommand(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateObservationCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateObservationCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateObservationCommand(this);
    }
    public <E extends UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateObservationCommand(this);
    }
    public <R, E extends UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateObservationCommand(this);
    }
    public void accept(ObservationManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateObservationCommand(this);
    }
    public <R> R accept(ObservationManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateObservationCommand(this);
    }
    public <E extends UserException>  void accept(ObservationManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateObservationCommand(this);
    }
    public <R, E extends UserException> R accept(ObservationManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateObservationCommand(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getTheType() != null) return 1;
        if (this.getTheObsObject() != null) return 1;
        if (this.getEnumValue() != null) return 1;
        if (this.getCommandReceiver() != null) return 1;
        return 0;
    }
    
    
    public void checkException() 
				throws UserException, PersistenceException{
        if (this.commandException != null) throw this.commandException;
    }
    public void execute() 
				throws PersistenceException{
        this.getCommandReceiver().createObservation(this.getName(), this.getTheType(), this.getTheObsObject(), this.getEnumValue());
		
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return this.getInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        this.invoker.handleException(this, exception);
    }
    public void sendResult() 
				throws PersistenceException{
        this.invoker.handleResult(this);
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
