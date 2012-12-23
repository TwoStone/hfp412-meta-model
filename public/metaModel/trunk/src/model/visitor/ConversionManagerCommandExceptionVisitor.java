
package model.visitor;
import model.UserException;
import persistence.*;

public interface ConversionManagerCommandExceptionVisitor<E extends UserException> {
    
    public void handleCreateConversionCommand(PersistentCreateConversionCommand createConversionCommand) throws PersistenceException, E;
    
}
