package persistence;

import model.visitor.*;
import model.*;


/* Additional import section end */

public interface UnitManagerCommand extends  Command {
    

    public void accept(UnitManagerCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(UnitManagerCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(UnitManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(UnitManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

