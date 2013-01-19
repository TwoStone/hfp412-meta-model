package persistence;

import model.visitor.*;
import model.*;


/* Additional import section end */

public interface MessageManagerCommand extends  Command {
    

    public void accept(MessageManagerCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(MessageManagerCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(MessageManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(MessageManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

