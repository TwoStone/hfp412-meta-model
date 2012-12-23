package persistence;

import model.visitor.*;
import model.*;


/* Additional import section end */

public interface ConversionManagerCommand extends  Command {
    

    public void accept(ConversionManagerCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(ConversionManagerCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(ConversionManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(ConversionManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

