package persistence;

import model.visitor.*;
import model.*;


/* Additional import section end */

public interface UnitTypeManagerCommand extends  Command {
    

    public void accept(UnitTypeManagerCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(UnitTypeManagerCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(UnitTypeManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(UnitTypeManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

