
package model.visitor;

import persistence.*;

public abstract class CommonDateStandardVisitor implements CommonDateVisitor {
    
    public void handleCreateConversionCommand(PersistentCreateConversionCommand createConversionCommand) throws PersistenceException{
        this.standardHandling(createConversionCommand);
    }
    public void handleCreateUnitCommand(PersistentCreateUnitCommand createUnitCommand) throws PersistenceException{
        this.standardHandling(createUnitCommand);
    }
    public void handleAddDefaultUnitCommand(PersistentAddDefaultUnitCommand addDefaultUnitCommand) throws PersistenceException{
        this.standardHandling(addDefaultUnitCommand);
    }
    public void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException{
        this.standardHandling(commonDate);
    }
    public void handleCreateQuantityCommand(PersistentCreateQuantityCommand createQuantityCommand) throws PersistenceException{
        this.standardHandling(createQuantityCommand);
    }
    public void handleCreateUnitTypeCommand(PersistentCreateUnitTypeCommand createUnitTypeCommand) throws PersistenceException{
        this.standardHandling(createUnitTypeCommand);
    }
    protected abstract void standardHandling(PersistentCommonDate commonDate) throws PersistenceException;
}
