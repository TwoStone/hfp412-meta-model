
package model.visitor;
import model.UserException;
import persistence.*;

public interface ConversionManagerCommandReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleCreateConversionCommand(PersistentCreateConversionCommand createConversionCommand) throws PersistenceException, E;
    
}
