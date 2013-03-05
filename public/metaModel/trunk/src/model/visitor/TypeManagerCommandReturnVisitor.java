
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentChangeAbstractCommand;
import persistence.PersistentCreateAtomicRootTypeCommand;
import persistence.PersistentCreateAtomicSubTypeCommand;
import persistence.PersistentCreateTypeConjunctionCommand;
import persistence.PersistentCreateTypeDisjunctionCommand;

public interface TypeManagerCommandReturnVisitor<R> {
    
    public R handleCreateTypeDisjunctionCommand(PersistentCreateTypeDisjunctionCommand createTypeDisjunctionCommand) throws PersistenceException;
    public R handleCreateTypeConjunctionCommand(PersistentCreateTypeConjunctionCommand createTypeConjunctionCommand) throws PersistenceException;
    public R handleCreateAtomicSubTypeCommand(PersistentCreateAtomicSubTypeCommand createAtomicSubTypeCommand) throws PersistenceException;
    public R handleChangeAbstractCommand(PersistentChangeAbstractCommand changeAbstractCommand) throws PersistenceException;
    public R handleCreateAtomicRootTypeCommand(PersistentCreateAtomicRootTypeCommand createAtomicRootTypeCommand) throws PersistenceException;
    
}
