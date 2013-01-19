package persistence;

import model.visitor.*;
import model.*;


/* Additional import section end */

public interface OperationManagerCommand extends  Command {
    

    public void accept(OperationManagerCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(OperationManagerCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(OperationManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(OperationManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

