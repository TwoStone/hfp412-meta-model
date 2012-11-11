package persistence;

import model.visitor.*;
import model.*;


/* Additional import section end */

public interface TypeManagerCommand extends  Command {
    

    public void accept(TypeManagerCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(TypeManagerCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(TypeManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(TypeManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

