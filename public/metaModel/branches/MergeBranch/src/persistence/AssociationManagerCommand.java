package persistence;

import model.visitor.*;
import model.*;


/* Additional import section end */

public interface AssociationManagerCommand extends  Command {
    

    public void accept(AssociationManagerCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(AssociationManagerCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AssociationManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AssociationManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

