
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
import model.visitor.MeasurementTypeManagerCommandExceptionVisitor;
import model.visitor.MeasurementTypeManagerCommandReturnExceptionVisitor;
import model.visitor.MeasurementTypeManagerCommandReturnVisitor;
import model.visitor.MeasurementTypeManagerCommandVisitor;
import persistence.ConnectionHandler;
import persistence.Invoker;
import persistence.PersistenceException;
import persistence.PersistentCommonDate;
import persistence.PersistentCreateMeasurementTypeCommand;
import persistence.PersistentMType;
import persistence.PersistentMeasurementTypeManager;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.PersistentUnitType;


/* Additional import section end */

public class CreateMeasurementTypeCommand extends PersistentObject implements PersistentCreateMeasurementTypeCommand{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentCreateMeasurementTypeCommand getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theCreateMeasurementTypeCommandFacade.getClass(objectId);
        return (PersistentCreateMeasurementTypeCommand)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentCreateMeasurementTypeCommand createCreateMeasurementTypeCommand(String name,java.sql.Date createDate,java.sql.Date commitDate) throws PersistenceException{
        return createCreateMeasurementTypeCommand(name,createDate,commitDate,false);
    }
    
    public static PersistentCreateMeasurementTypeCommand createCreateMeasurementTypeCommand(String name,java.sql.Date createDate,java.sql.Date commitDate,boolean delayed$Persistence) throws PersistenceException {
        if (name == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentCreateMeasurementTypeCommand result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theCreateMeasurementTypeCommandFacade
                .newDelayedCreateMeasurementTypeCommand(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theCreateMeasurementTypeCommandFacade
                .newCreateMeasurementTypeCommand(name,-1);
        }
        result.setMyCommonDate(CommonDate.createCommonDate(createDate, createDate));
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return true;
    }
    protected String name;
    protected PersistentMType type;
    protected PersistentUnitType unitType;
    protected Invoker invoker;
    protected PersistentMeasurementTypeManager commandReceiver;
    protected PersistentCommonDate myCommonDate;
    
    private model.UserException commandException = null;
    
    public CreateMeasurementTypeCommand(String name,PersistentMType type,PersistentUnitType unitType,Invoker invoker,PersistentMeasurementTypeManager commandReceiver,PersistentCommonDate myCommonDate,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.name = name;
        this.type = type;
        this.unitType = unitType;
        this.invoker = invoker;
        this.commandReceiver = commandReceiver;
        this.myCommonDate = myCommonDate;        
    }
    
    static public long getTypeId() {
        return 125;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 125) ConnectionHandler.getTheConnectionHandler().theCreateMeasurementTypeCommandFacade
            .newCreateMeasurementTypeCommand(name,this.getId());
        super.store();
        if(this.getType() != null){
            this.getType().store();
            ConnectionHandler.getTheConnectionHandler().theCreateMeasurementTypeCommandFacade.typeSet(this.getId(), getType());
        }
        if(this.getUnitType() != null){
            this.getUnitType().store();
            ConnectionHandler.getTheConnectionHandler().theCreateMeasurementTypeCommandFacade.unitTypeSet(this.getId(), getUnitType());
        }
        if(this.getInvoker() != null){
            this.getInvoker().store();
            ConnectionHandler.getTheConnectionHandler().theCreateMeasurementTypeCommandFacade.invokerSet(this.getId(), getInvoker());
        }
        if(this.getCommandReceiver() != null){
            this.getCommandReceiver().store();
            ConnectionHandler.getTheConnectionHandler().theCreateMeasurementTypeCommandFacade.commandReceiverSet(this.getId(), getCommandReceiver());
        }
        if(this.getMyCommonDate() != null){
            this.getMyCommonDate().store();
            ConnectionHandler.getTheConnectionHandler().theCreateMeasurementTypeCommandFacade.myCommonDateSet(this.getId(), getMyCommonDate());
        }
        
    }
    
    public String getName() throws PersistenceException {
        return this.name;
    }
    public void setName(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theCreateMeasurementTypeCommandFacade.nameSet(this.getId(), newValue);
        this.name = newValue;
    }
    public PersistentMType getType() throws PersistenceException {
        return this.type;
    }
    public void setType(PersistentMType newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.type)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.type = (PersistentMType)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theCreateMeasurementTypeCommandFacade.typeSet(this.getId(), newValue);
        }
    }
    public PersistentUnitType getUnitType() throws PersistenceException {
        return this.unitType;
    }
    public void setUnitType(PersistentUnitType newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.unitType)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.unitType = (PersistentUnitType)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theCreateMeasurementTypeCommandFacade.unitTypeSet(this.getId(), newValue);
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
            ConnectionHandler.getTheConnectionHandler().theCreateMeasurementTypeCommandFacade.invokerSet(this.getId(), newValue);
        }
    }
    public PersistentMeasurementTypeManager getCommandReceiver() throws PersistenceException {
        return this.commandReceiver;
    }
    public void setCommandReceiver(PersistentMeasurementTypeManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.commandReceiver)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.commandReceiver = (PersistentMeasurementTypeManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theCreateMeasurementTypeCommandFacade.commandReceiverSet(this.getId(), newValue);
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
            ConnectionHandler.getTheConnectionHandler().theCreateMeasurementTypeCommandFacade.myCommonDateSet(this.getId(), newValue);
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
        visitor.handleCreateMeasurementTypeCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateMeasurementTypeCommand(this);
    }
    public <E extends UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateMeasurementTypeCommand(this);
    }
    public <R, E extends UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateMeasurementTypeCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCreateMeasurementTypeCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateMeasurementTypeCommand(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateMeasurementTypeCommand(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateMeasurementTypeCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateMeasurementTypeCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateMeasurementTypeCommand(this);
    }
    public <E extends UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateMeasurementTypeCommand(this);
    }
    public <R, E extends UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateMeasurementTypeCommand(this);
    }
    public void accept(MeasurementTypeManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateMeasurementTypeCommand(this);
    }
    public <R> R accept(MeasurementTypeManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateMeasurementTypeCommand(this);
    }
    public <E extends UserException>  void accept(MeasurementTypeManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateMeasurementTypeCommand(this);
    }
    public <R, E extends UserException> R accept(MeasurementTypeManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateMeasurementTypeCommand(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + (this.getType() == null ? 0 : 1)
            + (this.getUnitType() == null ? 0 : 1)
            + (this.getCommandReceiver() == null ? 0 : 1));
    }
    
    
    public void execute() 
				throws PersistenceException{
        this.getCommandReceiver().createMeasurementType(this.getName(), this.getType(), this.getUnitType());
		
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
