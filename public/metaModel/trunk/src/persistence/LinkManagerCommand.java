package persistence;

import model.visitor.*;
import model.*;


/* Additional import section end */

public interface LinkManagerCommand extends  Command {
    

    public void accept(LinkManagerCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(LinkManagerCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(LinkManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(LinkManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

