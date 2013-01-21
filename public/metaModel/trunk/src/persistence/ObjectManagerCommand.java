package persistence;

import model.visitor.*;
import model.*;


/* Additional import section end */

public interface ObjectManagerCommand extends  Command {
    

    public void accept(ObjectManagerCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(ObjectManagerCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(ObjectManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(ObjectManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

