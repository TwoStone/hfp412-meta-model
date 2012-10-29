package persistence;

import model.visitor.*;
import model.*;


/* Additional import section end */

public interface AspectManagerCommand extends  Command {
    

    public void accept(AspectManagerCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(AspectManagerCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AspectManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AspectManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

