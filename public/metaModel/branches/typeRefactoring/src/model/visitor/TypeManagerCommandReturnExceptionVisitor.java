
package model.visitor;
import model.UserException;
import persistence.*;

public interface TypeManagerCommandReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleCreateProductTypeCommand(PersistentCreateProductTypeCommand createProductTypeCommand) throws PersistenceException, E;
    public R handleCreateAtomicSubTypeCommand(PersistentCreateAtomicSubTypeCommand createAtomicSubTypeCommand) throws PersistenceException, E;
    public R handleCreateAtomicRootTypeCommand(PersistentCreateAtomicRootTypeCommand createAtomicRootTypeCommand) throws PersistenceException, E;
    public R handleCreateSumTypeCommand(PersistentCreateSumTypeCommand createSumTypeCommand) throws PersistenceException, E;
    
}
