
package model.visitor;

import persistence.*;

public interface UnitTypeManagerCommandReturnVisitor<R> {
    
    public R handleCreateUnitTypeCommand(PersistentCreateUnitTypeCommand createUnitTypeCommand) throws PersistenceException;
    public R handleRemoveUnitTypeCommand(PersistentRemoveUnitTypeCommand removeUnitTypeCommand) throws PersistenceException;
    public R handleCreateUnitCommand(PersistentCreateUnitCommand createUnitCommand) throws PersistenceException;
    public R handleSetConversionCommand(PersistentSetConversionCommand setConversionCommand) throws PersistenceException;
    public R handleAddReferenceCommand(PersistentAddReferenceCommand addReferenceCommand) throws PersistenceException;
    public R handleSetDefaultUnitCommand(PersistentSetDefaultUnitCommand setDefaultUnitCommand) throws PersistenceException;
    public R handleCreateCompUnitCommand(PersistentCreateCompUnitCommand createCompUnitCommand) throws PersistenceException;
    public R handleCreateCompUnitTypeCommand(PersistentCreateCompUnitTypeCommand createCompUnitTypeCommand) throws PersistenceException;
    public R handleRemoveUnitCommand(PersistentRemoveUnitCommand removeUnitCommand) throws PersistenceException;
    public R handleAddReferenceTypeCommand(PersistentAddReferenceTypeCommand addReferenceTypeCommand) throws PersistenceException;
    
}