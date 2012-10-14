
package view.visitor;

import view.*;

public interface ActorReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleJuristicPerson(JuristicPersonView juristicPerson) throws ModelException, E;
    public R handleNaturalPerson(NaturalPersonView naturalPerson) throws ModelException, E;
    
}
