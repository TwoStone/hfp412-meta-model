package persistence;

import model.visitor.*;
import model.*;


/* Additional import section end */

public interface QuantityManagerCommand extends  Command {
    

    public void accept(QuantityManagerCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(QuantityManagerCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(QuantityManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(QuantityManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

