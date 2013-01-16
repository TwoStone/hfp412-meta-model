package persistence;

import model.visitor.*;
import model.*;


/* Additional import section end */

public interface MeasurementTypeManagerCommand extends  Command {
    

    public void accept(MeasurementTypeManagerCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(MeasurementTypeManagerCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(MeasurementTypeManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(MeasurementTypeManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

