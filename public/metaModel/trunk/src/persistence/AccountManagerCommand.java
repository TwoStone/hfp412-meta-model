package persistence;

import model.visitor.*;
import model.*;


/* Additional import section end */

public interface AccountManagerCommand extends  Command {
    

    public void accept(AccountManagerCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(AccountManagerCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AccountManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AccountManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

