package persistence;

import model.visitor.*;
import model.*;


/* Additional import section end */

public interface AccountTypeManagerCommand extends  Command {
    

    public void accept(AccountTypeManagerCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(AccountTypeManagerCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AccountTypeManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AccountTypeManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

